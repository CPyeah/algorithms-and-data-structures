package repository;

import model.StockData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StockDataRepository extends JpaRepository<StockData, Long>,
		JpaSpecificationExecutor<StockData> {

}
