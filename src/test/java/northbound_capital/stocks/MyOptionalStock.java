package northbound_capital.stocks;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.core.annotation.Order;

/**
 * 自选股
 */
@AllArgsConstructor
@Getter
@Order(0)
public enum MyOptionalStock {

	顺丰快递("002352"),
	格力电器("000651"),
	美的电器("000333"),
	中国银行("601988"),
	中芯国际("688981"),
	黄山旅游("600054"),
	恒顺醋业("600305"),
	;

	private final String code;

	public static List<String> getCodes() {
		return Arrays.stream(MyOptionalStock.values())
				.map(MyOptionalStock::getCode)
				.collect(Collectors.toList());
	}

}
