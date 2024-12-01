package com.study.sBoard.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.study.sBoard.dto.SimpleBoardDto;

@Repository
public class SimpleBoardDao implements ISimpleBoardDao{
	
	@Autowired
	JdbcTemplate template;
	
	@Override
	public List<SimpleBoardDto> listDao() {
		System.out.println("listDao()");
		
		String query = "select * from simpleBoard order by id desc";
		
		List<SimpleBoardDto> dtos = template.query(
					query, new BeanPropertyRowMapper<SimpleBoardDto>(SimpleBoardDto.class)
				);
		return dtos;
	}
	
	@Override
	public SimpleBoardDto viewDao(String id) {
		System.out.println("viewDao()");
		
		String query = "select * from simpleBoard where id = " + id;
		SimpleBoardDto dto = template.queryForObject(
					query, new BeanPropertyRowMapper<SimpleBoardDto>(SimpleBoardDto.class)
				);
		return dto;
	}
	
	@Override
	public int writeDao(String writer, String title, String content) {
		System.out.println("writeDao()");
		
		String query = "insert into simpleBoard (id, writer, title, content) " +
				"values (simpleBoard_seq.nextval, ?, ?, ?)";
		
		return template.update(query, writer, title, content);		
	}
	
	
	@Override
	public int deleteDao(String id) {
		System.out.println("deleteDao()");
		
		String query = "delete from simpleBoard where id = ?";
		return template.update(query, Integer.parseInt(id));
	};

}
