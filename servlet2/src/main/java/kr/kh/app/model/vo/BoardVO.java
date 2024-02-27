package kr.kh.app.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardVO {
	int bo_num;
	int bo_co_num;
	String bo_me_id; 
	String bo_title; 
	String bo_content;
	int bo_view; 
	int bo_report_count;
	CommunityVO community;
	public BoardVO( String bo_title,String bo_content, int bo_co_num,String bo_me_id) {
		this.bo_co_num = bo_co_num;
		this.bo_me_id = bo_me_id;
		this.bo_title = bo_title;
		this.bo_content = bo_content;
	}
	
}
