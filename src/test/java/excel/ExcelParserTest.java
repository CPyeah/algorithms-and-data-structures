package excel;

import excel.model.Hospital;
import junit.framework.TestCase;
import org.junit.Before;

public class ExcelParserTest extends TestCase {

	ExcelParser excelParser;

	@Before
	public void before() {
		excelParser = new ExcelParser();
	}

	public void testGetMostSimilarHospital() {
		Hospital mostSimilarHospital = excelParser
				.getMostSimilarHospital("高淳县人民医院");
		System.out.println(mostSimilarHospital.name());
	}
}