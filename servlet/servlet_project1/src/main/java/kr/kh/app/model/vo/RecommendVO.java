package kr.kh.app.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RecommendVO {
	private int re_num; 
	private String re_me_id; 
	private int re_bo_num; 
	private int re_state;
	
	public RecommendVO (String re_me_id, int re_bo_num , int re_state) {
		this.re_me_id = re_me_id;
		this.re_bo_num = re_bo_num;
		this.re_state = re_state;
	}
}
