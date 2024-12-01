package com.study.sBoard.dao;

import java.util.List;

import com.study.sBoard.dto.SimpleBoardDto;

public interface ISimpleBoardDao {
	
	public List<SimpleBoardDto> listDao();
	public SimpleBoardDto viewDao(String id);
	public int writeDao(String writer, String title, String content);
	public int deleteDao(String id);
}
