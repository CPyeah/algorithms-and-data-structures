package excel;

import java.time.LocalDate;
import java.time.Period;
import org.junit.Test;

public class DatePeriodTest {

	@Test
	public void test1() {
		LocalDate first = LocalDate.of(2019, 10, 13);
//		LocalDate today = LocalDate.now();
		LocalDate today = LocalDate.of(2022, 2, 14);
		Period duration = Period.between(first, today);
		int days = duration.getDays()+1;
		System.out.println(days);
		int days2 = Math.toIntExact(first.toEpochDay() - today.toEpochDay());
		System.out.println(days2);
	}

	@Test
	public void test2() {
		LocalDate first = LocalDate.of(2019, 10, 13);
		System.out.println(first.plusDays(1000));
	}

	@Test
	public void test3() {
		LocalDate first = LocalDate.of(2019, 7, 13);
		int p = 1000;
		System.out.println(first.plusDays(p-1));
	}

}
