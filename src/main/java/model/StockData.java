package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "stock_data", indexes = {
		@Index(name = "stock_code_date_index", columnList = "security_code,trade_date"),
		@Index(name = "trade_date_index", columnList = "trade_date")
})
public class StockData {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String SECUCODE;

	@Column
	private Date EFFECTIVE_DATE;

	@Column
	private double CLOSE_PRICE;

	@Column
	private String INDUSTRY_CODE;

	@Column
	private double FREECAP;

	/**
	 * 股票代码
	 */
	@Column
	private String SECURITY_CODE;
	@Column
	private String AREA_CODE;
	@Column
	private double HOLD_MARKETCAP_BEFORECHG;
	@Column
	private String INDUSTRY_CODE_NEW;
	@Column
	private double FREE_SHARES_RATIO;

	/**
	 * 概念
	 */
	@Column
	private String CONCEPT_NAME;
	@Column
	private double FREECAP_RATIO_CHG;
	@Column
	private double A_SHARES_RATIO;
	@Column
	private String INTERVAL_TYPE;
	@Column
	private double HOLD_MARKET_CAP;
	@Column
	private String SECURITY_INNER_CODE;

	/**
	 * 所属行业
	 */
	@Column
	private String INDUSTRY_NAME;
	@Column
	private double TOTAL_MARKET_CAP;
	@Column
	private String AREA_NAME;
	@Column
	private double HOLD_SHARES_RATIO;
	@Column
	private String MUTUAL_TYPE;
	@Column
	private String ORIG_INDUSTRY_CODE;
	@Column
	private int PARTICIPANT_NUM;

	/**
	 * 今日增持 市值（万）
	 */
	@Column
	private double ADD_MARKET_CAP;

	/**
	 * 股票名称
	 */
	@Column
	private String SECURITY_NAME;
	@Column
	private double HOLD_SHARES;
	@Column
	private double TOTAL_MARKETCAP_HOLD_RATIO;
	@Column
	private double HOLD_MARKETCAP_CHG5;
	@Column
	private String ORIG_AREA_CODE;
	@Column(columnDefinition = " varchar(1024)")
	private String CONCEPT_CODE;
	@Column
	private double HOLD_MARKETCAP_CHG1;
	@Column
	private double ADD_SHARES_AMP;
	@Column
	private String ORG_CODE;
	@Column
	private double HOLD_MARKETCAP_CHG10;
	@Column
	private double CHANGE_RATE;
	@Column
	private String AREA_CODE_NEW;

	/**
	 * 行情时间
	 */
	@Column
	private Date TRADE_DATE;
	@Column
	private double ADD_SHARES_REPAIR;
	@Column
	private double TOTAL_RATIO_CHG;
	@Column
	private double HOLD_SHARES_BEFORECHG;
	@Column
	private double FREECAP_HOLD_RATIO;
	@Column
	private double TOTAL_SHARES_RATIO;


	@Column
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public String toString() {
		return "StockData{" +
				SECURITY_CODE +
				", " + SECURITY_NAME +
				", " + ADD_MARKET_CAP + "万" +
				", " + sdf.format(TRADE_DATE) +
				'}';
	}


}
