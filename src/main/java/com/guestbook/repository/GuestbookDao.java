package com.guestbook.repository;

/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;*/
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.guestbook.vo.GuestbookVo;

@Repository
public class GuestbookDao {

	@Autowired
	private SqlSession sqlSession;
	
	public int delete(GuestbookVo vo) {
		return sqlSession.delete("guestbook.delete",vo);

	}
	
	
	public int insert(GuestbookVo vo) {
		return sqlSession.insert("guestbook.insert", vo);
													//여기 vo controller에서 옴

	}

	public List<GuestbookVo> getList() {
		/*List<GuestbookVo> list=sqlSession.selectList("guestbook.getList");
		return list;*/								//book.xml에있는 커리문을가져와.네임스페이스랑 아이디 적어줌
		return sqlSession.selectList("guestbook.getList2");
	}

}
