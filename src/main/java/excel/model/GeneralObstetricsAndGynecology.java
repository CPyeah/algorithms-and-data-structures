package excel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 妇产科一般情况
 */
@Data
@NoArgsConstructor
public class GeneralObstetricsAndGynecology {

	@ExcelProperty(index = 0)
	private String code;

	@ExcelProperty(index = 1)
	private String name;

	@ExcelProperty(index = 2)
	private String year;

	@ExcelProperty(index = 3)
	private String month;

	/**
	 * 门诊病人数
	 */
	@ExcelProperty(index = 4)
	private String numberOfOutpatients;

	/**
	 * 出院病人数
	 */
	@ExcelProperty(index = 5)
	private String numberOfDischargedPatients;

	/**
	 * 出院者平均住院日
	 */
	@ExcelProperty(index = 6)
	private String averageLengthOfStayForDischargedPatients;

	/**
	 * 术前平均住院日
	 */
	@ExcelProperty(index = 7)
	private String averageLengthOfStayBeforeSurgery;

	/**
	 * 住院病人手术人数
	 */
	@ExcelProperty(index = 8)
	private String numberOfHospitalizedPatientsUndergoingOperations;

	/**
	 * 手术前后诊断符合率
	 */
	@ExcelProperty(index = 9)
	private String preAndPostOperativeDiagnosisCoincidenceRate;

	/**
	 * 门诊病人抗生素使用率
	 */
	@ExcelProperty(index = 10)
	private String antibioticUseRateInOutpatients;

	/**
	 * 住院病人抗生素使用率
	 */
	@ExcelProperty(index = 11)
	private String antibioticUseRateOfInpatients;

	/**
	 * I类切口抗生素使用率
	 */
	@ExcelProperty(index = 12)
	private String classIIncisionAntibioticUsageRate;

	/**
	 * 平均门诊人次费用
	 */
	@ExcelProperty(index = 13)
	private String averageOutpatientVisitCost;

	/**
	 * 出院者平均医疗费用
	 */
	@ExcelProperty(index = 14)
	private String averageMedicalExpensesOfDischargedPatients;

	/**
	 * 住院危重症抢救成功率
	 */
	@ExcelProperty(index = 15)
	private String theSuccessRateOfHospitalizedCriticallyIllRescue;

	/**
	 * 四级手术占有比
	 */
	@ExcelProperty(index = 16)
	private String occupationRatioOfGrade4Surgery;


}
