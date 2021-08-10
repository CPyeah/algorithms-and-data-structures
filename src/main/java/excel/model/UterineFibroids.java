package excel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * 子宫肌瘤情况
 */
@Data
public class UterineFibroids {

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
	 * 出院病人数
	 */
	@ExcelProperty(index =4)
	private String numberOfDischargedPatients;
	/**
	 * 手术病人数
	 */
	@ExcelProperty(index =5)
	private String numberOfSurgicalPatients;
	/**
	 * 平均住院日
	 */
	@ExcelProperty(index =6)
	private String averageLengthOfStay;
	/**
	 * 术前平均住院日
	 */
	@ExcelProperty(index =7)
	private String averageLengthOfStayBeforeSurgery;
	/**
	 * 术前1小时预防用抗生素率
	 */
	@ExcelProperty(index =8)
	private String rateofProphylacticAntibioticsOneHourBeforeSurgery;
	/**
	 * 术中加用抗菌药物的合理率
	 */
	@ExcelProperty(index =9)
	private String reasonableRateOfAddingAntibacterialDrugsDuringOperation;
	/**
	 * 手术并发症发生率
	 */
	@ExcelProperty(index =10)
	private String surgicalComplicationRate;
	/**
	 * 出院者平均医疗费用
	 */
	@ExcelProperty(index =11)
	private String averageMedicalExpensesOfDischargedPatients;
	/**
	 * 术后子宫肌瘤的健康教育普及率
	 */
	@ExcelProperty(index =12)
	private String popularizationRateOfHealthEducationForPostoperativeUterineFibroids;
	/**
	 * 腹腔镜下子宫全切术率
	 */
	@ExcelProperty(index =13)
	private String laparoscopicTotalHysterectomyRate;
	/**
	 * 腹腔镜下子宫次全切除术率
	 */
	@ExcelProperty(index =14)
	private String laparoscopicSubtotalHysterectomyRate;
	/**
	 * 腹腔镜下子宫肌瘤剔除术率
	 */
	@ExcelProperty(index =15)
	private String rateOfLaparoscopicMyomectomy;
	/**
	 * 开腹手术子宫全切除术率
	 */
	@ExcelProperty(index =16)
	private String totalHysterectomyRateOfOpenSurgery;
	/**
	 * 开腹手术子宫次全切除术率
	 */
	@ExcelProperty(index =17)
	private String openSurgeryRateOfSubtotalHysterectomy;
	/**
	 * 开腹手术子宫肌瘤剔除术率
	 */
	@ExcelProperty(index =18)
	private String openSurgeryRateOfMyomectomy;
	/**
	 * 经阴道手术子宫切除术率
	 */
	@ExcelProperty(index =19)
	private String transvaginalHysterectomyRate;
	/**
	 * 经阴道手术子宫肌瘤剔除术率
	 */
	@ExcelProperty(index =20)
	private String transvaginalSurgeryUterineFibroidsRemovalRate;
	/**
	 * 经阴道手术宫腔镜粘膜下肌瘤切除术率
	 */
	@ExcelProperty(index =21)
	private String theRateOfHysteroscopicSubmucosalMyomectomyInTransvaginalSurgery;


}
