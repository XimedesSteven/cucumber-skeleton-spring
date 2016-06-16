package com.ximedes.rest.model;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

	@Select("SELECT * FROM users WHERE id = #{userId}")
	User getUser(@Param("userId") int userId);

	@Insert("INSERT INTO users (name, email) VALUES (#{name}, #{email})")
	void saveUser(@Param("name") String name, @Param("email") String email);
}
