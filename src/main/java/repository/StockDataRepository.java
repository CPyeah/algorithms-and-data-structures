package repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import model.StockData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockDataRepository extends JpaRepository<StockData, Long>,
		JpaSpecificationExecutor<StockData>, CrudRepository<StockData, Long> {

	@Query(value = "select * from stock_data where SECURITY_CODE = ?1", nativeQuery = true)
	List<StockData> findBySECURITY_CODE(String code);

	@Query(value = "select * from stock_data where SECURITY_CODE = ?1 and TRADE_DATE > ?2", nativeQuery = true)
	List<StockData> findByCodeBeforeTime(String code, String beginTime);

	@Query(value = "select max(trade_date) from stock_data", nativeQuery = true)
	Date findLastDate();

	@Query(value = "select SECURITY_CODE as code, count(*) as count from "
			+ " stock_data where ADD_MARKET_CAP > 0 and TRADE_DATE > ?2 "
			+ "group by SECURITY_CODE order by count desc limit ?1", nativeQuery = true)
	List<StockCount> positiveInflowDaysTop(int top, String beginTime);

	@Query(value = "select SECURITY_CODE as code, sum(ADD_MARKET_CAP) as sum from "
			+ " stock_data where TRADE_DATE > ?2 "
			+ "group by SECURITY_CODE order by sum desc limit ?1", nativeQuery = true)
	List<StockSum> totalInflowTop(int top, String beginTime);

	interface StockCount {
		String getCode();
		String getCount();
	}
	interface StockSum {
		String getCode();
		BigDecimal getSum();
	}
}
