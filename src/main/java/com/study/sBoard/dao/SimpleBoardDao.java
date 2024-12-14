package com.study.sBoard.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.study.sBoard.dto.SimpleBoardDto;
/*	@Repository 어노테이션
 * 	스테레오 타입(stereo type) : 빈 등록하고 사용할때 개발자가 내부적으로 의미파악을 하기 쉽게 하려고 사용하는 별칭
 * 	"이 클래스를 빈으로 등록하는데 DB관련 처리 용도로 사용하겠다."는 추가적인 의미 부여(스프링 내부에선 그냥 빈 등록)
 */
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
