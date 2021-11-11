package excel;

import static excel.model.Hospital.不知道_需要手动看;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import excel.listener.ChildbirthListener;
import excel.listener.GeneralObstetricsAndGynecologyListener;
import excel.listener.InterruptionOfBVirusListener;
import excel.listener.UterineFibroidsListener;
import excel.model.AllInfo;
import excel.model.Childbirth;
import excel.model.GeneralObstetricsAndGynecology;
import excel.model.Hospital;
import excel.model.InterruptionOfBVirus;
import excel.model.UterineFibroids;
import excel.model.export.Table1;
import excel.model.export.Table2;
import excel.model.export.Table3;
import excel.util.Utils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;

public class ExcelParser {

	public static final String month = "9";

	public static void main(String[] args) {
		String basePath = "src/main/resources/excels/" + month + "/";
		File excels = new File(basePath);
		String[] list = excels.list();

		assert list != null;
		System.out.println("正在执行" + month + "月份的统计 ---->");
		System.out.println("解析的文件数量是： " + list.length);
		Arrays.stream(list).forEach(System.out::println);

		List<AllInfo> allInfos = Arrays.stream(list)
				.map(e -> readFile(basePath + e))
				.collect(Collectors.toList());
		merge2HospitalUnit(allInfos);
		fillHospitalName(allInfos);
		List<AllInfo> sorted = sortAndFillBlank(allInfos);
		print(sorted);
		long count = sorted.stream().filter(s -> StringUtils.isNotBlank(s.getFileName())).count();
		System.out.println("table files has " + count);
		exportExcel(sorted);
	}

	private static void merge2HospitalUnit(List<AllInfo> allInfos) {
	}

	private static void print(List<AllInfo> sorted) {
		sorted.stream()
				.map(i -> i.getHospital().getOrder() + "  " + i.getHospital().name() + "   " + i
						.getFileName())
				.forEach(System.out::println);
	}

	private static List<AllInfo> sortAndFillBlank(List<AllInfo> allInfos) {
		Map<Hospital, AllInfo> mapping = allInfos.stream()
				.collect(Collectors.toMap(AllInfo::getHospital, Function.identity(), (i1, i2) -> {
					if (i1.getHospital().getSimilar() > i2.getHospital().getSimilar()) {
						i2.setHospital(不知道_需要手动看);
						return i1;
					} else {
						i1.setHospital(不知道_需要手动看);
						return i2;
					}
				}));
		List<AllInfo> sortedList = Arrays.stream(Hospital.values())
				.map(hospital -> mapping.getOrDefault(hospital, AllInfo.getEmpty(hospital)))
				.collect(Collectors.toList());
		List<String> collect = sortedList.stream().map(AllInfo::getFileName)
				.filter(StringUtils::isNotBlank)
				.collect(Collectors.toList());
		List<AllInfo> except = allInfos.stream().filter(i -> !collect.contains(i.getFileName()))
				.collect(Collectors.toList());
		sortedList.addAll(except);
		return sortedList;
	}

	private static void sanxiangAndhuguan(List<AllInfo> allInfos) {
		List<AllInfo> two = allInfos.stream().filter(info ->
				info.getFileName().contains("三香") || info.getFileName().contains("浒关"))
				.collect(Collectors.toList());
	}

	private static void fillHospitalName(List<AllInfo> allInfos) {
		allInfos.forEach(info -> {
			if (StringUtils.isBlank(info.getHospitalName())) {
				info.setHospitalName(getHospitalNameByFileName(info.getFileName()));
			}
//			Hospital hospital = getMostSimilarHospital(info.getHospitalName());
			Hospital hospital = Hospital.findByName(info.getHospitalName());
			if (hospital.equals(不知道_需要手动看)) {
				hospital = Hospital.findByName(info.getFileName());
//				hospital = getMostSimilarHospital(info.getFileName());
			}
			info.setHospital(hospital);
		});
	}

	public static Hospital getMostSimilarHospital(String hospitalName) {
		float most = 0;
		Hospital hospital = 不知道_需要手动看;
		for (Hospital h : Hospital.values()) {
			float similarityRatio = Utils.getSimilarityRatio(h.getSimpleName(), hospitalName);
//			System.out.println(h.name() + ":" + hospitalName + "-->" + similarityRatio);
			if (similarityRatio > 70 && similarityRatio > most) {
				most = similarityRatio;
				hospital = h;
				hospital.setSimilar(similarityRatio);
			}
		}
		return hospital;
	}

	private static String getHospitalNameByFileName(String fileName) {
		int yuan = fileName.indexOf("院");
		if (yuan > 0) {
			return fileName.substring(0, yuan + 1);
		} else {
			int yi = fileName.indexOf("医");
			if (yi > 0) {
				return fileName.substring(0, yi + 1);
			}
		}
		return fileName;
	}

	private static void exportExcel(List<AllInfo> allInfos) {
		List<Table1> table1List = getTable1List(allInfos);
		List<Table2> table2List = getTable2List(allInfos);
		List<Table3> table3List = getTable3List(allInfos);

		table1List = removeThePercentSig(table1List, Table1.class);
		table2List = removeThePercentSig(table2List, Table2.class);
		table3List = removeThePercentSig(table3List, Table3.class);

		String fileName = "src/main/resources/export/table_" + month + ".xlsx";
		ExcelWriter excelWriter = null;
		try {
			// 这里 指定文件
			excelWriter = EasyExcel.write(fileName).build();
			writeTable1ToExcel(excelWriter, table1List);
			writeTable2ToExcel(excelWriter, table2List);
			writeTable3ToExcel(excelWriter, table3List);
		} finally {
			// 千万别忘记finish 会帮忙关闭流
			if (excelWriter != null) {
				excelWriter.finish();
			}
		}
	}

	private static <T> List<T> removeThePercentSig(List<T> tableList, Class<T> tableClass) {
		return tableList.stream().map(table -> {
			JSONObject jsonObject = (JSONObject) JSON.toJSON(table);
			String jsonString = jsonObject.toJSONString();
			jsonString = jsonString.replaceAll("%", "");

			return JSONObject.parseObject(jsonString, tableClass);
		}).collect(Collectors.toList());
	}

	private static List<Table3> getTable3List(List<AllInfo> allInfos) {
		List<Table3> table3s = new ArrayList<>();
		allInfos.forEach(allInfo -> {
			String fileName = allInfo.getFileName();
			allInfo.getInterruptionOfBVirusList().forEach(v -> {
				Table3 table3 = Table3.of(v, allInfo.getHospital(), fileName);
				table3s.add(table3);
			});
		});
		return table3s.stream()
				.filter(table3 -> StringUtils.isNotBlank(table3.getTwoAndAHalfScreeningRate()))
				.filter((table3 -> table3.getMonth().contains(month)))
				.sorted(Comparator.comparing(t -> Integer.parseInt(t.getOrder())))
				.collect(Collectors.toList());
	}

	private static List<Table2> getTable2List(List<AllInfo> allInfos) {
		List<Table2> table2s = new ArrayList<>();
		allInfos.forEach(allInfo -> {
			String fileName = allInfo.getFileName();
			allInfo.getChildbirthList().forEach(childbirth -> {
				Table2 table2 = Table2.of(childbirth, allInfo.getHospital(), fileName);
				table2s.add(table2);
			});
		});
		return table2s.stream()
				.filter(table2 -> StringUtils
						.isNotBlank(table2.getTotalNumberOfDeliveriesAfter28Weeks()))
				.filter((table2 -> table2.getMonth().contains(month)))
				.sorted(Comparator.comparing(t -> Integer.parseInt(t.getOrder())))
				.collect(Collectors.toList());
	}

	private static void writeTable1ToExcel(ExcelWriter excelWriter, List<Table1> dataList) {
		// 每次都要创建writeSheet 这里注意必须指定sheetNo 而且sheetName必须不一样。这里注意DemoData.class 可以每次都变，我这里为了方便 所以用的同一个class 实际上可以一直变
		WriteSheet writeSheet = EasyExcel.writerSheet(0, "表1-妇产科一般情况").head(Table1.class).build();
		// 分页去数据库查询数据 这里可以去数据库查询每一页的数据
		excelWriter.write(dataList, writeSheet);
	}

	private static void writeTable2ToExcel(ExcelWriter excelWriter, List<Table2> dataList) {
		// 每次都要创建writeSheet 这里注意必须指定sheetNo 而且sheetName必须不一样。这里注意DemoData.class 可以每次都变，我这里为了方便 所以用的同一个class 实际上可以一直变
		WriteSheet writeSheet = EasyExcel.writerSheet(1, "表2-分娩情况").head(Table2.class).build();
		// 分页去数据库查询数据 这里可以去数据库查询每一页的数据
		excelWriter.write(dataList, writeSheet);
	}

	private static void writeTable3ToExcel(ExcelWriter excelWriter, List<Table3> dataList) {
		// 每次都要创建writeSheet 这里注意必须指定sheetNo 而且sheetName必须不一样。这里注意DemoData.class 可以每次都变，我这里为了方便 所以用的同一个class 实际上可以一直变
		WriteSheet writeSheet = EasyExcel.writerSheet(2, "表3-乙肝病毒母婴传播阻断情况").head(Table3.class)
				.build();
		// 分页去数据库查询数据 这里可以去数据库查询每一页的数据
		excelWriter.write(dataList, writeSheet);
	}

	private static List<Table1> getTable1List(List<AllInfo> allInfos) {
		ArrayList<Table1> table1s = new ArrayList<>();
		allInfos.forEach(allInfo -> {
			String fileName = allInfo.getFileName();
			allInfo.getGeneralObstetricsAndGynecologyList().forEach(g -> {
				Table1 t = Table1.of(g, allInfo.getHospital(), fileName);
				table1s.add(t);
			});
		});
		return table1s.stream()
				.filter(t -> StringUtils.isNotBlank(t.getNumberOfOutpatients()))
				.filter(t -> StringUtils.isNotBlank(t.getMonth()))
				.filter((t -> t.getMonth().contains(month)))
				.sorted(Comparator.comparing(t -> Integer.parseInt(t.getOrder())))
				.collect(Collectors.toList());
	}

	private static AllInfo readFile(String file) {
		List<GeneralObstetricsAndGynecology> generalObstetricsAndGynecologyList = getGeneralObstetricsAndGynecologyList(
				file);

		List<Childbirth> childbirthList = getChildbirthList(file);

		List<UterineFibroids> uterineFibroidsList = getUterineFibroidsList(file);

		List<InterruptionOfBVirus> interruptionOfBVirusList = getInterruptionOfBVirusList(file);

		return AllInfo.builder()
				.fileName(new File(file).getName())
				.generalObstetricsAndGynecologyList(
						generalObstetricsAndGynecologyList)    //	妇产科一般情况
				.childbirthList(childbirthList)    //	分娩情况
				.uterineFibroidsList(uterineFibroidsList)    //	子宫肌瘤情况
				.interruptionOfBVirusList(interruptionOfBVirusList)    //	乙肝病毒母婴传播阻断情况
				.build();
	}

	private static List<InterruptionOfBVirus> getInterruptionOfBVirusList(String file) {
		return EasyExcel
				.read(file, InterruptionOfBVirus.class,
						new InterruptionOfBVirusListener())
				.sheet(3).headRowNumber(2).doReadSync();
	}

	private static List<UterineFibroids> getUterineFibroidsList(String file) {
		return EasyExcel
				.read(file, UterineFibroids.class,
						new UterineFibroidsListener())
				.sheet(2).headRowNumber(2).doReadSync();
	}

	private static List<GeneralObstetricsAndGynecology> getGeneralObstetricsAndGynecologyList(
			String file) {
		return EasyExcel
				.read(file, GeneralObstetricsAndGynecology.class,
						new GeneralObstetricsAndGynecologyListener())
				.sheet(0).headRowNumber(2).doReadSync();
	}

	private static List<Childbirth> getChildbirthList(String file) {
		return EasyExcel
				.read(file, Childbirth.class,
						new ChildbirthListener())
				.sheet(1).headRowNumber(2).doReadSync();
	}

}
