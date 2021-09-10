package excel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.exception.ExcelDataConvertException;
import excel.model.InterruptionOfBVirus;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 模板的读取类
 *
 * @author Jiaju Zhuang
 */
public class InterruptionOfBVirusListener extends
		AnalysisEventListener<InterruptionOfBVirus> {

	/**
	 * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
	 */
	private static final int BATCH_COUNT = 500;
	List<InterruptionOfBVirus> list = new ArrayList<InterruptionOfBVirus>();

	@Override
	public void invoke(InterruptionOfBVirus data, AnalysisContext context) {
//		System.out.println("解析到一条数据:"+ data.toString());
		list.add(data);
		if (list.size() >= BATCH_COUNT) {
			saveData();
			list.clear();
		}
	}

	/**
	 * 这里会一行行的返回头
	 *
	 * @param headMap
	 * @param context
	 */
	@Override
	public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
//		System.out.println("解析到一条头数据:"+ JSON.toJSONString(headMap));
	}

	@Override
	public void doAfterAllAnalysed(AnalysisContext context) {
		saveData();
//		System.out.println("所有数据解析完成！");
	}

	/**
	 * 加上存储数据库
	 */
	private void saveData() {
//		System.out.println("存储数据库成功！");
	}

	/**
	 * 在转换异常 获取其他异常下会调用本接口。抛出异常则停止读取。如果这里不抛出异常则 继续读取下一行。
	 *
	 * @param exception
	 * @param context
	 * @throws Exception
	 */
	@Override
	public void onException(Exception exception, AnalysisContext context) {
		// 如果是某一个单元格的转换异常 能获取到具体行号
		// 如果要获取头的信息 配合invokeHeadMap使用
		if (exception instanceof ExcelDataConvertException) {

		}
	}
}
