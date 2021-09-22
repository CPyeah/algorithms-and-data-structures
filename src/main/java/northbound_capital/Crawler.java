package northbound_capital;

import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import lombok.NoArgsConstructor;
import model.StockData;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import repository.StockDataRepository;

@NoArgsConstructor
public class Crawler {
	StockDataRepository repository;

	Crawler(StockDataRepository repository) {
		this.repository = repository;
	}

	String url = "http://datacenter-web.eastmoney.com/api/data/v1/get?"
			+ "callback=jQuery112305161251472939605_1631166897189"
			+ "&sortColumns=ADD_MARKET_CAP&sortTypes=-1"
			+ "&pageSize={PAGE_SIZE}&pageNumber={PAGE_NO}"
			+ "&reportName=RPT_MUTUAL_STOCK_NORTHSTA&columns=ALL&source=WEB"
			+ "&client=WEB"
			+ "&filter=(TRADE_DATE%3D%27{QUERY_DATE}%27)(INTERVAL_TYPE%3D%221%22)";

	public void crawling() {
		// get times
		LocalDate[] times = getCrawlingTime();
		// loop query day by day
		LocalDate queryDate = times[0];
		while (queryDate.compareTo(times[1]) < 0) {
			queryOneDayData(queryDate);
			queryDate = queryDate.plusDays(1);
		}
	}


	private void queryOneDayData(LocalDate queryDate) {
		String dateString = queryDate.toString();
		int pageNo = 1, pageSize = 50;
		List<StockData> stockDataList;
		try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
			do {
				stockDataList = queryByHttp(dateString, pageNo, pageSize, httpclient);
				batchSaveToDB(stockDataList, queryDate);
				pageNo++;
			} while (CollectionUtils.isNotEmpty(stockDataList));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void batchSaveToDB(List<StockData> stockDataList, LocalDate queryDate) {
		if (CollectionUtils.isEmpty(stockDataList)) {
			return;
		}
		repository.save(stockDataList);
	}

	private List<StockData> queryByHttp(String dateString, int pageNo, int pageSize,
			CloseableHttpClient httpclient) {
		String httpUrl = fillParams(dateString, pageNo, pageSize);
		HttpGet httpget = new HttpGet(httpUrl);
		//3.执行get请求并返回结果
		try (CloseableHttpResponse response = httpclient.execute(httpget)) {
			if (response.getStatusLine().getStatusCode() == 200) {
				//请求体内容
				String content = EntityUtils
						.toString(response.getEntity(), "UTF-8");
				System.out.println(content);
				return parse2StockData(content);
			} else {
				System.out.println(httpUrl + response.getStatusLine().getReasonPhrase());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	private List<StockData> parse2StockData(String content) {
		int b = content.indexOf("[");
		int e = content.indexOf("]") + 1;
		if (b < 0 || e < 1) {
			return null;
		}
		String newString = content.substring(b, e);
		return JSONObject.parseArray(newString, StockData.class);
	}

	private String fillParams(String dateString, int pageNo, int pageSize) {
		return url.replace("{QUERY_DATE}", dateString)
				.replace("{PAGE_NO}", String.valueOf(pageNo))
				.replace("{PAGE_SIZE}", String.valueOf(pageSize));
	}

	private LocalDate[] getCrawlingTime() {
		Date begin = repository.findLastDate();
		if (begin == null) {
			begin = DateUtils.addMonths(new Date(), -3);
		}
		begin = DateUtils.addDays(begin, 1);
		LocalDate b = begin.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return new LocalDate[]{b, LocalDate.now()};
	}

}
