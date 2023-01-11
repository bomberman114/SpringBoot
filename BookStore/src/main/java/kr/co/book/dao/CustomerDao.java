package kr.co.book.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.book.vo.CustomerVo;

@Repository("CustomerDao")
public class CustomerDao {
	@Autowired
	private SqlSessionTemplate sql;

	public List<CustomerVo> cuslist() {
		List<CustomerVo> cuslist = sql.selectList("user.selects");
		return cuslist;
	}

	public void cusregister(CustomerVo vo) {
		sql.insert("user.insert", vo);

	}

	public void cusmodify(CustomerVo vo) {
		sql.update("user.update", vo);

	}

	public void cusdelte(int custId) {
		sql.delete("user.delete", custId);

	}

	public CustomerVo find(int custId) {
		CustomerVo find = sql.selectOne("user.select", custId);
		return find;
	}

}
