package excel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * 分娩情况
 */
@Data
public class Childbirth {

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
	 * 孕28周后分娩总数
	 */
	@ExcelProperty(index =4)
	private String totalNumberOfDeliveriesAfter28Weeks;

	/**
	 * 剖宫产率
	 */
	@ExcelProperty(index =5)
	private String cesareanSectionRate;

	/**
	 * 会阴侧切率
	 */
	@ExcelProperty(index =6)
	private String perineumLateralCuttingRate;

	/**
	 * 会阴Ⅲ裂伤率
	 */
	@ExcelProperty(index =7)
	private String perineumⅢLacerationRate;

	/**
	 * 新生儿窒息率
	 */
	@ExcelProperty(index =8)
	private String neonatalAsphyxiaRate;

	/**
	 * 新生儿产伤率
	 */
	@ExcelProperty(index =9)
	private String neonatalBirthInjuryRate;

	/**
	 * 产后出血（≥500ml）率
	 */
	@ExcelProperty(index =10)
	private String postpartumHemorrhage500MlRate;

	/**
	 * 产后出血（≥1000ml）率
	 */
	@ExcelProperty(index =11)
	private String postpartumHemorrhage1000MlRate;

	/**
	 * 子宫切除数
	 */
	@ExcelProperty(index =12)
	private String numberOfHysterectomy;

	/**
	 * 出院者平均费用
	 */
	@ExcelProperty(index =13)
	private String averageCostOfDischargedPatients;
}
