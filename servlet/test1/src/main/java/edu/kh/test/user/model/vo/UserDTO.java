package edu.kh.test.user.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
	private int user_no;
	private String user_id; 
	private String user_name;
	private int user_age;
}
