package kr.co.book.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookVo {
	
	private int bookId;
	private String bookName;
	private String publisher;
	private int price;
	

}
