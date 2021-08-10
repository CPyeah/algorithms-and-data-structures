package excel.model.export;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import excel.model.GeneralObstetricsAndGynecology;
import excel.model.Hospital;
import lombok.Data;

/**
 * 表1-妇产科一般情况
 */
@Data
public class Table1 {


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

	@ExcelProperty("门诊病人数")
	private String numberOfOutpatients;

	@ExcelProperty("出院病人数")
	private String numberOfDischargedPatients;

	@ExcelProperty("出院者平均住院日")
	private String averageLengthOfStayForDischargedPatients;

	@ExcelProperty("术前平均住院日")
	private String averageLengthOfStayBeforeSurgery;

	@ExcelProperty("住院病人手术人数")
	private String numberOfHospitalizedPatientsUndergoingOperations;

	@ExcelProperty("手术前后诊断符合率")
	private String preAndPostOperativeDiagnosisCoincidenceRate;

	@ExcelProperty("门诊病人抗生素使用率")
	private String antibioticUseRateInOutpatients;

	@ExcelProperty("住院病人抗生素使用率")
	private String antibioticUseRateOfInpatients;

	@ExcelProperty("I类切口抗生素使用率")
	private String classIIncisionAntibioticUsageRate;

	@ExcelProperty("平均门诊人次费用")
	private String averageOutpatientVisitCost;

	@ExcelProperty("出院者平均医疗费用")
	private String averageMedicalExpensesOfDischargedPatients;

	@ExcelProperty("住院危重症抢救成功率")
	private String theSuccessRateOfHospitalizedCriticallyIllRescue;

	@ExcelProperty("四级手术占有比")
	private String occupationRatioOfGrade4Surgery;

	public static Table1 of(GeneralObstetricsAndGynecology generalObstetricsAndGynecology,
			Hospital hospital, String fileName) {
		Table1 table1 = new Table1();
		table1.setFileName(fileName);
		table1.setHospitalName(hospital.name());
		table1.setOrder(String.valueOf(hospital.getOrder()));
		table1.setMonth(generalObstetricsAndGynecology.getMonth());
		table1.setNumberOfOutpatients(generalObstetricsAndGynecology.getNumberOfOutpatients());
		table1.setNumberOfDischargedPatients(
				generalObstetricsAndGynecology.getNumberOfDischargedPatients());
		table1.setAverageLengthOfStayForDischargedPatients(
				generalObstetricsAndGynecology.getAverageLengthOfStayForDischargedPatients());
		table1.setAverageLengthOfStayBeforeSurgery(
				generalObstetricsAndGynecology.getAverageLengthOfStayBeforeSurgery());
		table1.setNumberOfHospitalizedPatientsUndergoingOperations(generalObstetricsAndGynecology
				.getNumberOfHospitalizedPatientsUndergoingOperations());
		table1.setPreAndPostOperativeDiagnosisCoincidenceRate(
				generalObstetricsAndGynecology.getPreAndPostOperativeDiagnosisCoincidenceRate());
		table1.setAntibioticUseRateInOutpatients(
				generalObstetricsAndGynecology.getAntibioticUseRateInOutpatients());
		table1.setAntibioticUseRateOfInpatients(
				generalObstetricsAndGynecology.getAntibioticUseRateOfInpatients());
		table1.setClassIIncisionAntibioticUsageRate(
				generalObstetricsAndGynecology.getClassIIncisionAntibioticUsageRate());
		table1.setAverageOutpatientVisitCost(
				generalObstetricsAndGynecology.getAverageOutpatientVisitCost());
		table1.setAverageMedicalExpensesOfDischargedPatients(
				generalObstetricsAndGynecology.getAverageMedicalExpensesOfDischargedPatients());
		table1.setTheSuccessRateOfHospitalizedCriticallyIllRescue(generalObstetricsAndGynecology
				.getTheSuccessRateOfHospitalizedCriticallyIllRescue());
		table1.setOccupationRatioOfGrade4Surgery(
				generalObstetricsAndGynecology.getOccupationRatioOfGrade4Surgery());
		return table1;
	}
}
