package northbound_capital;

import java.util.Arrays;
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

	@Test
	public void queryOneStockInfo() {
		String code = "000333";
		QueryAndViewer queryAndViewer = new QueryAndViewer(repository, null, code + " 北向资金情况");
		List<StockData> stockDataList = queryAndViewer.queryOneStockInfo(code);
		stockDataList.forEach(System.out::println);
	}


	@Test
	public void viewMyOptionalStockTest() throws InterruptedException {
		List<String> codes = MyOptionalStock.getCodes();
		viewThisStocks(codes, "我的自选股");
	}

	@Test
	public void viewNewEnergyVehicleStockTest() throws InterruptedException {
		List<String> codes = NewEnergyVehicleStock.getCodes();
		viewThisStocks(codes, "新能源汽车");
	}

	@Test
	public void viewSemiconductorStockTest() throws InterruptedException {
		List<String> codes = SemiconductorStock.getCodes();
		viewThisStocks(codes, "半导体");
	}

	@Test
	public void viewNewbornBabyStockTest() throws InterruptedException {
		List<String> codes = NewbornBabyStock.getCodes();
		viewThisStocks(codes, "新生儿");
	}

	private void viewThisStocks(List<String> codes, String title) throws InterruptedException {
		QueryAndViewer myOptionView = new QueryAndViewer(repository, codes, title);
		myOptionView.view();
//		Thread.sleep(1000 * 60 * 5);
	}

	@Test
	public void proportionOfPositiveFlowTest() throws InterruptedException {
		int top = 5;
		List<StockCount> stockCountList = repository.positiveInflowDaysTop(top);
		System.out.println(Arrays.toString(stockCountList.toArray()));
		List<String> codes = stockCountList.stream().map(StockCount::getCode)
				.collect(Collectors.toList());
		viewThisStocks(codes, "正流向天数 Top" + top);
	}

	@Test
	public void totalInflowTopTest() throws InterruptedException {
		int top = 5;
		List<StockSum> stockSumList = repository.totalInflowTop(top);
		stockSumList.forEach(System.out::println);
		List<String> codes = stockSumList.stream().map(StockSum::getCode)
				.collect(Collectors.toList());
		viewThisStocks(codes, "总流入资金 Top" + top);
	}

	@Test
	public void daysAndTotalComprehensiveTest() throws InterruptedException {
		int top = 10;
		List<StockSum> stockSumList = repository.totalInflowTop(top);
		List<StockCount> stockCountList = repository.positiveInflowDaysTop(top);
		List<String> sumCode = stockSumList.stream().map(StockSum::getCode)
				.collect(Collectors.toList());
		List<String> countCode = stockCountList.stream().map(StockCount::getCode)
				.collect(Collectors.toList());
		sumCode.retainAll(countCode);
		viewThisStocks(sumCode, "正流向天数 & 总流入资金");
	}
}