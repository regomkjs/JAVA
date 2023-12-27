package day13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

public class DateEx1 {

	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		System.out.println(date);
		
		// Date => String
		/* 화면에 보여줄 시간 패턴을 문자열로 지정 */
		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		String str = format.format(date);
		System.out.println(str);
		
		// String => Date
		Date date2 = format.parse(str);
		System.err.println(date2);
		
		Board board = new Board("제목","내용", new Date());
		System.out.println(board);
		Board board2 = new Board("제목2","내용2", null);
		board2.setRegDate("2023-12-27 18:00:00");
		System.out.println(board2);
	}

}
@AllArgsConstructor
@Data
class Board{
	String title , contents;
	Date regDate;
	
	public void setRegDate(String str) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			regDate = format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}