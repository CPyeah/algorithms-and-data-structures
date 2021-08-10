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
				.getMostSimilarHospital("2021 (南京市高淳人民院");
		System.out.println(mostSimilarHospital.name());
	}
}