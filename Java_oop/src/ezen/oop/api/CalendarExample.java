package ezen.oop.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarExample {

	public static void main(String[] args) throws ParseException {

		Calendar calendar = Calendar.getInstance();
//		System.out.println(calendar);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		int hh = calendar.get(Calendar.HOUR);
		int mm = calendar.get(Calendar.MINUTE);
		int ss = calendar.get(Calendar.SECOND);

		System.out.println(year);
		System.out.println(month);
		System.out.println(dayOfMonth);
		System.out.println(hh);
		System.out.println(mm);
		System.out.println(ss);

		calendar.set(Calendar.YEAR, 1987);
		calendar.set(Calendar.MONTH, 3 - 1);
		calendar.set(Calendar.DAY_OF_MONTH, 13);

		StringBuilder sb = new StringBuilder();
		sb.append(calendar.get(Calendar.YEAR)).append("년").append(Calendar.MONTH).append("월")
				.append(Calendar.DAY_OF_MONTH).append("일").append(Calendar.HOUR).append("시")
				.append((Calendar.MINUTE) + 1).append("분").append(Calendar.SECOND).append("초");
		System.out.println(sb.toString());

//		long ms = calendar.getTimeInMillis();
//		System.out.println(ms);

//		Date date = new Date(ms);
		Date date = calendar.getTime();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy년 MM월 dd일 hh시 mm분 ss초 aaa");
		System.out.println(simpleDateFormat.format(date));

		int w = calendar.get(Calendar.DAY_OF_WEEK);
		switch (w) {
		case Calendar.SUNDAY:
			System.out.println("일요일");
			break;
		case Calendar.MONDAY:
			System.out.println("월요일");
			break;
		case Calendar.TUESDAY:
			System.out.println("화요일");
			break;
		case Calendar.WEDNESDAY:
			System.out.println("수요일");
			break;
		case Calendar.THURSDAY:
			System.out.println("목요일");
			break;
		case Calendar.FRIDAY:
			System.out.println("금요일");
			break;
		case Calendar.SATURDAY:
			System.out.println("토요일");
			break;
		default:
		}

//		String aa = "19870313";
//		SimpleDateFormat std = new SimpleDateFormat("yyyyMMdd");
//		Date date1 = std.parse(aa);
//
//		System.out.println(date1.getTime());
//		
//		String bb = "20230517";
//		SimpleDateFormat edd = new SimpleDateFormat("yyyyMMdd");
//		Date date2 = edd.parse(bb);
//
//		System.out.println(date2.getTime());
//		
//		long cc = date2.getTime()-date1.getTime();
//		System.out.println(cc);
//		
//		int result = (int) (cc / 1000) / (24*60*60);
//		System.out.println(result);


		System.out.println("----------------과제---------------");

		//		gerWorksDay 메소드 호출
		int result = getWorksDay("19870313", "20230517");
		System.out.println("근무일수 : "+result+" 일");

	}

//	특정날짜부터 특정날짜의 근무일 수

	public static int getWorksDay(String startDate, String endDate) throws ParseException {
		String aa = startDate;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date1 = sdf.parse(aa);

		String bb = endDate;
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		Date date2 = sdf1.parse(bb);

		long cc = date2.getTime() - date1.getTime();
		int result = (int) (cc / 1000) / (24 * 60 * 60);

		return result;
	}
}
