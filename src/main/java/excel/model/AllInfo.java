package excel.model;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
@Builder
public class AllInfo {

	String fileName;

	String hospitalName;

	Hospital hospital;

	/**
	 * 妇产科一般情况
	 */
	private List<GeneralObstetricsAndGynecology> generalObstetricsAndGynecologyList;

	/**
	 * 分娩情况
	 */
	private List<Childbirth> childbirthList;

	/**
	 * 子宫肌瘤情况
	 */
	private List<UterineFibroids> uterineFibroidsList;

	/**
	 * 乙肝病毒母婴传播阻断情况
	 */
	private List<InterruptionOfBVirus> interruptionOfBVirusList;

	public static AllInfo getEmpty(Hospital hospital) {
		return AllInfo.builder()
				.fileName("")
				.hospitalName(hospital.name())
				.hospital(hospital)
				.generalObstetricsAndGynecologyList(Collections.emptyList())    //	妇产科一般情况
				.childbirthList(Collections.emptyList())    //	分娩情况
				.uterineFibroidsList(Collections.emptyList())    //	子宫肌瘤情况
				.interruptionOfBVirusList(Collections.emptyList())    //	乙肝病毒母婴传播阻断情况
				.build();
	}

	public String getHospitalName() {
		if (StringUtils.isNotBlank(this.hospitalName)) {
			return hospitalName;
		}
		Optional<GeneralObstetricsAndGynecology> first = generalObstetricsAndGynecologyList
				.stream()
				.filter(g -> StringUtils.isNotBlank(g.getName()))
				.findFirst();
		first.ifPresent(
				generalObstetricsAndGynecology -> this.hospitalName = generalObstetricsAndGynecology
						.getName());
		return hospitalName;
	}
}
