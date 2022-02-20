package com.study.springboot.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository // @Repository 어노테이션으로 빈 등록. DB관련 처리 용도
public class MyUserDAO {

	@Autowired // 자동주입 어노테이션. jdbcTemplate변수에(変数に) oracle driver load, DB connect, connection pool
	private JdbcTemplate jdbcTemplate;
	// @AutowiredからjdbcTemplateまではDB使用するために必要なcode（위의 2줄은 DB사용을 위해 쓴 코드）
	
	public List<MyUserDTO> list(){
		String query = "select * from myuser";
		List<MyUserDTO> list = jdbcTemplate.query(
				query, new BeanPropertyRowMapper<MyUserDTO>(
						MyUserDTO.class));
		// sql queryの結果でDTO objectを受けて全体をlist dataにする。
		/* sql query의 결과를 ResultSet의 Row마다 DTO 객체로 받아
			전체를 리스트 데이터로 만든다.
		*/
		
		/* for(UserDTO my : list){
		  		System.out.println(my);
		 */
		 
		return list;
	}
}
