package edu.kh.test.user.model.dao;

import org.apache.ibatis.annotations.Param;

import edu.kh.test.user.model.vo.UserDTO;

public interface UserDAO {

	UserDTO selectUser(@Param("user_no")int userNum);

}
