package northbound_capital.stocks;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.core.annotation.Order;

/**
 * 新生儿 行业
 */
@AllArgsConstructor
@Getter
@Order(3)
public enum NewbornBabyStock {

	美吉姆("002621"),
	戴维医疗("300314"),
	金发拉比("002762"),
	爱婴室("603214"),
	中顺洁柔("002511"),

	;

	private final String code;

	public static List<String> getCodes() {
		return Arrays.stream(NewbornBabyStock.values())
				.map(NewbornBabyStock::getCode)
				.collect(Collectors.toList());
	}
}
