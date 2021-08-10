package excel.model.export;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import excel.model.Childbirth;
import excel.model.Hospital;
import lombok.Data;

/**
 * 分娩情况
 */
@Data
public class Table2 {


	@ExcelProperty("序号")
	private String order;

	@ColumnWidth(20)
	@ExcelProperty("医院名称")
	private String hospitalName;

	@ColumnWidth(60)
	@ExcelProperty("文件名称")
	private String fileName;

	@ExcelProperty("月份")
	private String month;

	@ExcelProperty("孕28周后分娩总数")
	private String totalNumberOfDeliveriesAfter28Weeks;

	@ExcelProperty("剖宫产率")
	private String cesareanSectionRate;

	@ExcelProperty("会阴侧切率")
	private String perineumLateralCuttingRate;

	@ExcelProperty("会阴Ⅲ裂伤率")
	private String perineumⅢLacerationRate;

	@ExcelProperty("新生儿窒息率")
	private String neonatalAsphyxiaRate;

	@ExcelProperty("新生儿产伤率")
	private String neonatalBirthInjuryRate;

	@ExcelProperty("产后出血（≥500ml）率")
	private String postpartumHemorrhage500MlRate;

	@ExcelProperty("产后出血（≥1000ml）率")
	private String postpartumHemorrhage1000MlRate;

	@ExcelProperty("子宫切除数")
	private String numberOfHysterectomy;

	@ExcelProperty("出院者平均费用")
	private String averageCostOfDischargedPatients;

	public static Table2 of(Childbirth childbirth, Hospital hospital, String fileName) {
		Table2 table2 = new Table2();
		table2.setHospitalName(hospital.name());
		table2.setOrder(String.valueOf(hospital.getOrder()));
		table2.setFileName(fileName);
		table2.setMonth(childbirth.getMonth());
		table2.setTotalNumberOfDeliveriesAfter28Weeks(
				childbirth.getTotalNumberOfDeliveriesAfter28Weeks());
		table2.setCesareanSectionRate(childbirth.getCesareanSectionRate());
		table2.setPerineumLateralCuttingRate(childbirth.getPerineumLateralCuttingRate());
		table2.setPerineumⅢLacerationRate(childbirth.getPerineumⅢLacerationRate());
		table2.setNeonatalAsphyxiaRate(childbirth.getNeonatalAsphyxiaRate());
		table2.setNeonatalBirthInjuryRate(childbirth.getNeonatalBirthInjuryRate());
		table2.setPostpartumHemorrhage500MlRate(childbirth.getPostpartumHemorrhage500MlRate());
		table2.setPostpartumHemorrhage1000MlRate(childbirth.getPostpartumHemorrhage1000MlRate());
		table2.setNumberOfHysterectomy(childbirth.getNumberOfHysterectomy());
		table2.setAverageCostOfDischargedPatients(childbirth.getAverageCostOfDischargedPatients());
		return table2;
	}
}
