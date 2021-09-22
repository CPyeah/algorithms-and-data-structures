package northbound_capital;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import model.StockData;
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

	String beginTime = null;

	@Test
	public void queryOneStockInfo() throws InterruptedException {
		String beginTime = "2021-09-01";
		String code = "000333";
		QueryAndViewer queryAndViewer = new QueryAndViewer(repository,
				Collections.singletonList(code), code + " 北向资金情况", beginTime);
		List<StockData> stockDataList = queryAndViewer.queryOneStockInfo(code);
		stockDataList.forEach(System.out::println);
		queryAndViewer.view();
		Thread.sleep(1000 * 60 * 5);
	}


	@Test
	public void viewMyOptionalStockTest() throws InterruptedException {
		String beginTime = "2021-09-01";
		List<String> codes = MyOptionalStock.getCodes();
		viewThisStocks(codes, "我的自选股", null);
	}

	@Test
	public void viewNewEnergyVehicleStockTest() throws InterruptedException {
		String beginTime = "2021-09-01";
		List<String> codes = NewEnergyVehicleStock.getCodes();
		viewThisStocks(codes, "新能源汽车", null);
	}

	@Test
	public void viewSemiconductorStockTest() throws InterruptedException {
		String beginTime = "2021-09-01";
		List<String> codes = SemiconductorStock.getCodes();
		viewThisStocks(codes, "半导体", null);
	}

	@Test
	public void viewNewbornBabyStockTest() throws InterruptedException {
		List<String> codes = NewbornBabyStock.getCodes();
		viewThisStocks(codes, "新生儿", null);
	}

	private void viewThisStocks(List<String> codes, String title, String beginTime) throws InterruptedException {
		QueryAndViewer myOptionView = new QueryAndViewer(repository, codes, title, beginTime);
		myOptionView.view();
//		Thread.sleep(1000 * 60 * 5);
	}

	@Test
	public void proportionOfPositiveFlowTest() throws InterruptedException {
		int top = 5;
		String beginTime = "2021-08-15";
		List<StockCount> stockCountList = repository.positiveInflowDaysTop(top, beginTime);
		System.out.println(Arrays.toString(stockCountList.toArray()));
		List<String> codes = stockCountList.stream().map(StockCount::getCode)
				.collect(Collectors.toList());
		viewThisStocks(codes, "正流向天数 Top" + top, beginTime);
	}

	@Test
	public void totalInflowTopTest() throws InterruptedException {
		int top = 5;
		String beginTime = "2021-09-01";
		List<StockSum> stockSumList = repository.totalInflowTop(top, beginTime);
		stockSumList.forEach(System.out::println);
		List<String> codes = stockSumList.stream().map(StockSum::getCode)
				.collect(Collectors.toList());
		viewThisStocks(codes, "总流入资金 Top" + top, beginTime);
	}

	@Test
	public void daysAndTotalComprehensiveTest() throws InterruptedException {
		int top = 15;
		String beginTime = "2021-08-15";
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