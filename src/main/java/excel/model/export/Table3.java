package excel.model.export;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import excel.model.Hospital;
import excel.model.InterruptionOfBVirus;
import lombok.Data;

/**
 * 乙肝病毒母婴传播阻断情况
 */
@Data
public class Table3 {


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

	@ExcelProperty("孕期乙型肝炎血清学标志（乙肝两对半）筛查率")
	private String twoAndAHalfScreeningRate;

	@ExcelProperty("孕妇HBsAg阳性率")
	private String positiveRate;

	@ExcelProperty("HBsAg阴性产妇的新生儿首针乙肝疫苗及时接种率%（出生后24小时内")
	private String firstDoseOfHepatitisBVaccineCoverage;

	@ExcelProperty("HBsAg阳性产妇的足月新生儿出生后12小时内HBIG使用率%")
	private String neonatalHBIGUsageRate;

	@ExcelProperty("HBsAg阳性产妇的早产儿出生后12小时内HBIG使用率%")
	private String hbigUsageRateInPrematureInfants;

	@ExcelProperty("HBsAg阳性产妇的足月新生儿出生后12小时内乙肝疫苗接种率%")
	private String newbornHepatitisBVaccinationRate;

	@ExcelProperty("HBsAg阳性产妇的早产儿出生后12小时内乙肝疫苗接种率%")
	private String hepatitisBVaccinationRateForPrematureInfants;

	@ExcelProperty("HBsAg阳性产妇的新生儿母乳喂养率%")
	private String newbornBreastfeedingRate;

	@ExcelProperty("新生儿出院时第2针和第3针乙肝疫苗接种告知率%")
	private String hepatitisBVaccinationNotificationRate;

	@ExcelProperty("HBsAg阳性产妇的新生儿出院时7～12月龄检测乙肝血清学标志（两对半）告知率%")
	private String twoAndAHalfNotificationRate;

	@ExcelProperty("HBsAg阳性孕妇孕期重型肝炎发生率%")
	private String incidenceOfSevereHepatitis;


	public static Table3 of(InterruptionOfBVirus v, Hospital hospital, String fileName) {
		Table3 table3 = new Table3();
		table3.setHospitalName(hospital.name());
		table3.setOrder(String.valueOf(hospital.getOrder()));
		table3.setFileName(fileName);
		table3.setMonth(v.getMonth());
		table3.setTwoAndAHalfScreeningRate(v.getTwoAndAHalfScreeningRate());
		table3.setPositiveRate(v.getPositiveRate());
		table3.setFirstDoseOfHepatitisBVaccineCoverage(v.getFirstDoseOfHepatitisBVaccineCoverage());
		table3.setNeonatalHBIGUsageRate(v.getNeonatalHBIGUsageRate());
		table3.setHbigUsageRateInPrematureInfants(v.getHbigUsageRateInPrematureInfants());
		table3.setNewbornHepatitisBVaccinationRate(v.getNewbornHepatitisBVaccinationRate());
		table3.setHepatitisBVaccinationRateForPrematureInfants(
				v.getHepatitisBVaccinationRateForPrematureInfants());
		table3.setNewbornBreastfeedingRate(v.getNewbornBreastfeedingRate());
		table3.setHepatitisBVaccinationNotificationRate(
				v.getHepatitisBVaccinationNotificationRate());
		table3.setTwoAndAHalfNotificationRate(v.getTwoAndAHalfNotificationRate());
		table3.setIncidenceOfSevereHepatitis(v.getIncidenceOfSevereHepatitis());
		return table3;
	}
}
