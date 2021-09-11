package northbound_capital;

import java.util.Arrays;
import java.util.List;
import model.StockData;
import northbound_capital.stocks.MyOptionalStock;
import northbound_capital.stocks.NewEnergyVehicleStock;
import northbound_capital.stocks.NewbornBabyStock;
import northbound_capital.stocks.SemiconductorStock;
import org.jfree.chart.ui.UIUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import repository.StockDataRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
public class QueryAndViewerTest {

	@Autowired
	private StockDataRepository repository;

	private QueryAndViewer queryAndViewer;

	@Before
	public void setUp() {
		queryAndViewer = new QueryAndViewer(repository, Arrays.asList("601899", ""));
	}

	@Test
	public void queryOneStockInfo() {
		List<StockData> stockDataList = queryAndViewer.queryOneStockInfo("600905");
		stockDataList.forEach(System.out::println);
	}

	@Test
	public void viewMyOptionalStockTest() throws InterruptedException {
		List<String> codes = MyOptionalStock.getCodes();
		viewThisStocks(codes);
	}

	@Test
	public void viewNewEnergyVehicleStockTest() throws InterruptedException {
		List<String> codes = NewEnergyVehicleStock.getCodes();
		viewThisStocks(codes);
	}

	@Test
	public void viewSemiconductorStockTest() throws InterruptedException {
		List<String> codes = SemiconductorStock.getCodes();
		viewThisStocks(codes);
	}

	@Test
	public void viewNewbornBabyStockTest() throws InterruptedException {
		List<String> codes = NewbornBabyStock.getCodes();
		viewThisStocks(codes);
	}

	private void viewThisStocks(List<String> codes) throws InterruptedException {
		QueryAndViewer myOptionView = new QueryAndViewer(repository, codes);
		myOptionView.setCodes(codes);
		myOptionView.pack();
		UIUtils.centerFrameOnScreen(myOptionView);
		myOptionView.setVisible(true);
//		Thread.sleep(1000 * 60 * 5);
	}
}