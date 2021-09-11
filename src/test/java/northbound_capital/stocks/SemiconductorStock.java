package northbound_capital.stocks;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.core.annotation.Order;

/**
 * 半导体
 */
@AllArgsConstructor
@Getter
@Order(2)
public enum SemiconductorStock {

	中芯国际("688981"),
	兆易创新("603986"),
	中微公司("688012"),
	有研新材("600206"),
	韦尔股份("603501"),
	紫光股份("000938"),

	;

	private final String code;

	public static List<String> getCodes() {
		return Arrays.stream(SemiconductorStock.values())
				.map(SemiconductorStock::getCode)
				.collect(Collectors.toList());
	}
}
