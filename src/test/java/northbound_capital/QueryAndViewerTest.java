package northbound_capital;

import java.util.Arrays;
import java.util.List;
import model.StockData;
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
	public void viewTest() throws InterruptedException {
		queryAndViewer.pack();
		UIUtils.centerFrameOnScreen(queryAndViewer);
		queryAndViewer.setVisible(true);
//		Thread.sleep(1000 * 60 * 5);
	}
}