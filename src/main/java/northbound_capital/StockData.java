package northbound_capital;

import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.Data;

@Data
public class StockData {

	private String SECUCODE;
	private Date EFFECTIVE_DATE;
	private double CLOSE_PRICE;
	private String INDUSTRY_CODE;
	private double FREECAP;

	/**
	 * 股票代码
	 */
	private String SECURITY_CODE;
	private String AREA_CODE;
	private double HOLD_MARKETCAP_BEFORECHG;
	private String INDUSTRY_CODE_NEW;
	private double FREE_SHARES_RATIO;

	/**
	 * 概念
	 */
	private String CONCEPT_NAME;
	private double FREECAP_RATIO_CHG;
	private double A_SHARES_RATIO;
	private String INTERVAL_TYPE;
	private double HOLD_MARKET_CAP;
	private String SECURITY_INNER_CODE;

	/**
	 * 所属行业
	 */
	private String INDUSTRY_NAME;
	private double TOTAL_MARKET_CAP;
	private String AREA_NAME;
	private double HOLD_SHARES_RATIO;
	private String MUTUAL_TYPE;
	private String ORIG_INDUSTRY_CODE;
	private int PARTICIPANT_NUM;

	/**
	 * 今日增持 市值（万）
	 */
	private double ADD_MARKET_CAP;

	/**
	 * 股票名称
	 */
	private String SECURITY_NAME;
	private double HOLD_SHARES;
	private double TOTAL_MARKETCAP_HOLD_RATIO;
	private double HOLD_MARKETCAP_CHG5;
	private String ORIG_AREA_CODE;
	private String CONCEPT_CODE;
	private double HOLD_MARKETCAP_CHG1;
	private double ADD_SHARES_AMP;
	private String ORG_CODE;
	private double HOLD_MARKETCAP_CHG10;
	private double CHANGE_RATE;
	private String AREA_CODE_NEW;

	/**
	 * 行情时间
	 */
	private Date TRADE_DATE;
	private double ADD_SHARES_REPAIR;
	private double TOTAL_RATIO_CHG;
	private double HOLD_SHARES_BEFORECHG;
	private double FREECAP_HOLD_RATIO;
	private double TOTAL_SHARES_RATIO;


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
