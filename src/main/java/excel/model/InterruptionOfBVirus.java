package excel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * 乙肝病毒母婴传播阻断情况
 */
@Data
public class InterruptionOfBVirus {

	/**
	 * 年度
	 */
	@ExcelProperty(index =2)
	private String year;

	/**
	 * 月份
	 */
	@ExcelProperty(index =3)
	private String month;

	/**
	 * 孕期乙型肝炎血清学标志（乙肝两对半）筛查率
	 */
	@ExcelProperty(index =4)
	private String twoAndAHalfScreeningRate;

	/**
	 * 孕妇HBsAg阳性率
	 */
	@ExcelProperty(index =5)
	private String positiveRate;

	/**
	 * HBsAg阴性产妇的新生儿首针乙肝疫苗及时接种率%（出生后24小时内
	 */
	@ExcelProperty(index =6)
	private String firstDoseOfHepatitisBVaccineCoverage;

	/**
	 * HBsAg阳性产妇的足月新生儿出生后12小时内HBIG使用率%
	 */
	@ExcelProperty(index =7)
	private String neonatalHBIGUsageRate;

	/**
	 * HBsAg阳性产妇的早产儿出生后12小时内HBIG使用率%
	 */
	@ExcelProperty(index =8)
	private String hbigUsageRateInPrematureInfants;

	/**
	 * HBsAg阳性产妇的足月新生儿出生后12小时内乙肝疫苗接种率%
	 */
	@ExcelProperty(index =9)
	private String newbornHepatitisBVaccinationRate;

	/**
	 * HBsAg阳性产妇的早产儿出生后12小时内乙肝疫苗接种率%
	 */
	@ExcelProperty(index =10)
	private String hepatitisBVaccinationRateForPrematureInfants;

	/**
	 * HBsAg阳性产妇的新生儿母乳喂养率%
	 */
	@ExcelProperty(index =11)
	private String newbornBreastfeedingRate;

	/**
	 * 新生儿出院时第2针和第3针乙肝疫苗接种告知率%
	 */
	@ExcelProperty(index =12)
	private String hepatitisBVaccinationNotificationRate;

	/**
	 * HBsAg阳性产妇的新生儿出院时7～12月龄检测乙肝血清学标志（两对半）告知率%
	 */
	@ExcelProperty(index =13)
	private String twoAndAHalfNotificationRate;

	/**
	 * HBsAg阳性孕妇孕期重型肝炎发生率%
	 */
	@ExcelProperty(index =14)
	private String incidenceOfSevereHepatitis;


}
