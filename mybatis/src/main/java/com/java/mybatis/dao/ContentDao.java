package com.java.mybatis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.java.mybatis.dto.ContentDto;

public class ContentDao implements IDao {
	
	private static final Class<ContentDto> ContentDto = null;
	JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	public public ContentDao() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ArrayList<ContentDto> listDao(){
		String query = "select * from board order by mId desc";
		ArrayList<ContentDto>dtos =(ArrayList<ContentDto>) template.query(query, new BeanPropertyRowMapper<ContentDto>(ContentDto));
		return dtos;
		
	}

	@Override
	public void writeDao(final String mWriter, final String mContrent) {
		System.out.println("writeDao()");
		
		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String query = " insert into board (mId,mWriter,mContent)values(board_seq.nextval,?,?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, mWriter);
				pstmt.setString(2, mContrent); 
				return pstmt;
			}
		});
		

	}

	@Override
	public ContentDao view(String strID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteDao(String dId) {
		// TODO Auto-generated method stub

	}

}
