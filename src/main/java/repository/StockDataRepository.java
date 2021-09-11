package repository;

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
		JpaSpecificationExecutor<StockData> , CrudRepository<StockData, Long> {

	@Query(value = "select * from stock_data where SECURITY_CODE = ?1", nativeQuery = true)
	List<StockData> findBySECURITY_CODE(String code);

	@Query(value = "select max(trade_date) from stock_data", nativeQuery = true)
	Date findLastDate();
}
