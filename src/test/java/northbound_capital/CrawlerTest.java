package northbound_capital;

import java.util.Arrays;
import java.util.List;
import model.StockData;
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
public class CrawlerTest {

	@Autowired
	private StockDataRepository repository;

	@Test
	public void crawling() {
		Crawler crawler = new Crawler();
		crawler.crawling();
	}

	@Test
	public void testJPA() {
		List<StockData> all = repository.findAll();
		System.out.println(Arrays.toString(all.toArray()));
	}
}