package northbound_capital.stocks;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.core.annotation.Order;

/**
 * 新能源汽车
 */
@Order(1)
@AllArgsConstructor
@Getter
public enum NewEnergyVehicleStock {

	赣锋锂业("002460"),
	天齐锂业("002466"),
	宁德时代("300750"),
	比亚迪("002594"),
	通威股份("600438"),
	隆基股份("601012"),
	国机汽车("600335"),
	盛新锂能("002240"),


	;

	private final String code;

	public static List<String> getCodes() {
		return Arrays.stream(NewEnergyVehicleStock.values())
				.map(NewEnergyVehicleStock::getCode)
				.collect(Collectors.toList());
	}


}
