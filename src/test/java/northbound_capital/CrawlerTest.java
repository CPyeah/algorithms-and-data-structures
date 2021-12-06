package northbound_capital;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import model.StockData;
import org.junit.Ignore;
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
@Ignore
public class CrawlerTest {

	@Autowired
	private StockDataRepository repository;

	@Test
	public void crawling() {
		Crawler crawler = new Crawler(repository);
		crawler.crawling();
	}

	@Test
	public void selectOneStock() {
		List<StockData> stockDataList = repository.findBySECURITY_CODE("000048");
		stockDataList.forEach(System.out::println);

	}

	@Test
	public void testJPA() {
		List<StockData> all = repository.findAll();
		System.out.println(Arrays.toString(all.toArray()));
	}

	@Test
	public void testFindLastDate() {
		Date lastDate = repository.findLastDate();
		System.out.println(lastDate);
	}

	@Test
	public void addTest() {
		StockData sd = new StockData();
		sd.setSECURITY_CODE("000111");
		sd.setTRADE_DATE(new Date());
		repository.save(sd);
	}

}