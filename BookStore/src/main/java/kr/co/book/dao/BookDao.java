package kr.co.book.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.book.vo.BookVo;
import kr.co.book.vo.CustomerVo;

@Repository("BookDao")
public class BookDao {
	@Autowired
	private SqlSessionTemplate sql;

	public List<BookVo> list() {
		List<BookVo> list = sql.selectList("book.selects");
		return list;
	}

	public void register(BookVo book) {
		sql.insert("book.insert", book);

	}

	public void modify(BookVo book) {
		sql.update("book.update", book);

	}

	public void delete(int bookId) {
		sql.delete("book.delete", bookId);

	}


	public BookVo find(int bookId) {
		BookVo find = sql.selectOne("book.select",bookId);
		return find;
	}

}
