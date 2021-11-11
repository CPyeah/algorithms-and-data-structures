package northbound_capital;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import northbound_capital.stocks.MyOptionalStock;
import northbound_capital.stocks.NewEnergyVehicleStock;
import northbound_capital.stocks.NewbornBabyStock;
import northbound_capital.stocks.SemiconductorStock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import repository.StockDataRepository;
import repository.StockDataRepository.StockCount;
import repository.StockDataRepository.StockSum;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
public class QueryAndViewerTest {

	@Autowired
	private StockDataRepository repository;

	static String beginTime = "2021-08-01";

	@Test
	public void queryOneStockInfo() throws InterruptedException {
		String code = "002105";
		viewThisStocks(Collections.singletonList(code), code + " 北向资金情况", beginTime);
	}

	/**
	 * 我的自选股
	 *
	 * @throws InterruptedException
	 * @see MyOptionalStock
	 */
	@Test
	public void viewMyOptionalStockTest() throws InterruptedException {
		List<String> codes = MyOptionalStock.getCodes();
		viewThisStocks(codes, "我的自选股", beginTime);
	}

	/**
	 * 新能源汽车
	 *
	 * @throws InterruptedException
	 * @see NewEnergyVehicleStock
	 */
	@Test
	public void viewNewEnergyVehicleStockTest() throws InterruptedException {
		String beginTime = "2021-09-01";
		List<String> codes = NewEnergyVehicleStock.getCodes();
		viewThisStocks(codes, "新能源汽车", beginTime);
	}

	/**
	 * 半导体
	 *
	 * @throws InterruptedException
	 * @see SemiconductorStock
	 */
	@Test
	public void viewSemiconductorStockTest() throws InterruptedException {
//		String beginTime = "2021-09-01";
		List<String> codes = SemiconductorStock.getCodes();
		viewThisStocks(codes, "半导体", beginTime);
	}

	/**
	 * 新生儿
	 *
	 * @throws InterruptedException
	 * @see NewbornBabyStock
	 */
	@Test
	public void viewNewbornBabyStockTest() throws InterruptedException {
		List<String> codes = NewbornBabyStock.getCodes();
		viewThisStocks(codes, "新生儿", beginTime);
	}

	private void viewThisStocks(List<String> codes, String title, String beginTime)
			throws InterruptedException {
		QueryAndViewer myOptionView = new QueryAndViewer(repository, codes, title, beginTime);
		myOptionView.view();
		Thread.sleep(1000 * 60 * 5);
	}

	/**
	 * 正流向天数 Top
	 *
	 * @throws InterruptedException e
	 */
	@Test
	public void proportionOfPositiveFlowTest() throws InterruptedException {
		int top = 5;
		List<StockCount> stockCountList = repository.positiveInflowDaysTop(top, beginTime);
		System.out.println(Arrays.toString(stockCountList.toArray()));
		List<String> codes = stockCountList.stream().map(StockCount::getCode)
				.collect(Collectors.toList());
		viewThisStocks(codes, "正流向天数 Top" + top, beginTime);
	}

	/**
	 * 低于指定股票价格的 正流向天数 Top
	 *
	 * @throws InterruptedException e
	 */
	@Test
	public void positiveInflowDaysTopLimitPriceTest() throws InterruptedException {
		int top = 5;
		List<StockCount> stockCountList = repository
				.positiveInflowDaysTopLimitPrice(top, beginTime, new BigDecimal("40"));
		System.out.println(Arrays.toString(stockCountList.toArray()));
		List<String> codes = stockCountList.stream().map(StockCount::getCode)
				.collect(Collectors.toList());
		viewThisStocks(codes, "正流向天数 Top" + top, beginTime);
	}

	/**
	 * 总流入资金 Top
	 *
	 * @throws InterruptedException e
	 */
	@Test
	public void totalInflowTopTest() throws InterruptedException {
		int top = 5;
		List<StockSum> stockSumList = repository.totalInflowTop(top, beginTime);
		stockSumList.forEach(System.out::println);
		List<String> codes = stockSumList.stream().map(StockSum::getCode)
				.collect(Collectors.toList());
		viewThisStocks(codes, "总流入资金 Top" + top, beginTime);
	}

	/**
	 * 低于指定股票价格的 总流入资金 Top
	 *
	 * @throws InterruptedException e
	 */
	@Test
	public void totalInflowTopLimitPriceTest() throws InterruptedException {
		int top = 5;
		List<StockSum> stockSumList = repository
				.totalInflowTopLimitPrice(top, beginTime, new BigDecimal("20"));
		stockSumList.forEach(System.out::println);
		List<String> codes = stockSumList.stream().map(StockSum::getCode)
				.collect(Collectors.toList());
		viewThisStocks(codes, "总流入资金 Top" + top, beginTime);
	}

	@Test
	public void daysAndTotalComprehensiveTest() throws InterruptedException {
		int top = 15;
		List<StockSum> stockSumList = repository.totalInflowTop(top, beginTime);
		List<StockCount> stockCountList = repository.positiveInflowDaysTop(top, beginTime);
		System.out.println(stockSumList);
		System.out.println(stockCountList);
		List<String> sumCode = stockSumList.stream().map(StockSum::getCode)
				.collect(Collectors.toList());
		List<String> countCode = stockCountList.stream().map(StockCount::getCode)
				.collect(Collectors.toList());
		sumCode.retainAll(countCode);
		System.out.println(sumCode);
		viewThisStocks(sumCode, "正流向天数 & 总流入资金", beginTime);
	}
}