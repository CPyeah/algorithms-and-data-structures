package northbound_capital;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JPanel;
import lombok.Setter;
import model.StockData;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.chart.ui.UIUtils;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import repository.StockDataRepository;

public class QueryAndViewer extends ApplicationFrame {

	StockDataRepository repository;

	String title;

	@Setter
	List<String> codes;

	String beginTime;

	QueryAndViewer(StockDataRepository repository, List<String> codes, String title,
			String beginTime) {
		super("Northbound_Capital");
		this.repository = repository;
		this.codes = codes;
		this.title = title;
		this.beginTime = beginTime;
	}


	public void view() {
		ChartPanel chartPanel = (ChartPanel) createDemoPanel();
		chartPanel.setPreferredSize(new java.awt.Dimension(1224, 720));
		setContentPane(chartPanel);
		pack();
		UIUtils.centerFrameOnScreen(this);
		this.setVisible(true);

	}

	/**
	 * Creates a chart.
	 *
	 * @param dataset a dataset.
	 * @return A chart.
	 */
	private JFreeChart createChart(XYDataset dataset) {

		JFreeChart chart = ChartFactory.createTimeSeriesChart(
				title,  // title
				"日期",             // x-axis label
				"今日增持市值（万）",   // y-axis label
				dataset);

		chart.setBackgroundPaint(Color.WHITE);

		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.LIGHT_GRAY);
		plot.setDomainGridlinePaint(Color.WHITE);
		plot.setRangeGridlinePaint(Color.WHITE);
		plot.setAxisOffset(new RectangleInsets(1.0, 1.0, 1.0, 1.0));
		plot.setDomainCrosshairVisible(true);
		plot.setRangeCrosshairVisible(true);

		XYItemRenderer r = plot.getRenderer();
		if (r instanceof XYLineAndShapeRenderer) {
			XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
			renderer.setDefaultShapesVisible(true);
			renderer.setDefaultShapesFilled(true);
			renderer.setDrawSeriesLineAsPath(true);
		}

		DateAxis axis = (DateAxis) plot.getDomainAxis();
		axis.setDateFormatOverride(new SimpleDateFormat("yyyy-MM-dd"));

		return chart;

	}

	/**
	 * Creates a panel for the demo (used by SuperDemo.java).
	 *
	 * @return A panel.
	 */
	public JPanel createDemoPanel() {
		JFreeChart chart = createChart(createDataset());
		ChartPanel panel = new ChartPanel(chart, false);
		panel.setFillZoomRectangle(true);
		panel.setMouseWheelEnabled(true);
		return panel;
	}

	/**
	 * Creates a dataset, consisting of two series of monthly data.
	 *
	 * @return The dataset.
	 */
	private XYDataset createDataset() {

		TimeSeriesCollection dataset = new TimeSeriesCollection();
		setStockData(dataset);
		return dataset;

	}

	private void setStockData(TimeSeriesCollection dataset) {
		codes.forEach(code -> {
			if (StringUtils.isBlank(code)) {
				return;
			}
			List<StockData> stockDataList;
			if (StringUtils.isBlank(beginTime)) {
				 stockDataList = repository.findBySECURITY_CODE(code);
			} else {
				stockDataList = repository.findByCodeBeforeTime(code, beginTime);
			}
			if (CollectionUtils.isNotEmpty(stockDataList)) {
				TimeSeries s = new TimeSeries(stockDataList.get(0).getSECURITY_NAME());
				stockDataList.forEach(stockData -> {
					s.addOrUpdate(new Day(stockData.getTRADE_DATE()), stockData.getADD_MARKET_CAP());
				});
				dataset.addSeries(s);
			}
		});
	}


	List<StockData> queryOneStockInfo(String code) {
		return repository.findBySECURITY_CODE(code);
	}

}
