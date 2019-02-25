package com.java.mybatis.dao;

import java.util.ArrayList;

import com.java.mybatis.dto.ContentDto;

public interface IDao {
	
	public ArrayList<ContentDto> listDao();
	public void writeDao(String mWriter, String mContrent);
	public ContentDao view (String strID);
	public void deleteDao(String dId);

}
