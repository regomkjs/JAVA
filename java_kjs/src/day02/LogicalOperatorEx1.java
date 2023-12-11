package day02;

public class LogicalOperatorEx1 {
	
	// 논리 연산자 예제
	public static void main(String[] args) {
		/* && : ~하고, ~이고
		 * A && B : A와 B에는 참/거짓을 판별할 수 있는 식 또는 변수
		 * 성적이 90미만이고, 80이상이면 B , 성적이 85 => true
		 *  진리표
		 * A && B
		 * T && T => T (둘다 참일 때 참)
		 * T && F => F
		 * F && T => F
		 * F && F => F
		 */
		
		/* || : ~이거나, ~하거나
		 * A || B 
		 *  진리표
		 * T || T => T (둘중 하나라도 참이면 참)
		 * T || F => T 
		 * F || T => T
		 * F || F => F 
		 */
		
		/* ! : ~ 아닌, 반대
		 * !A
		 *  F => T
		 *  T => F
		 */
		
		
		int score = 90; // 성적
		
		// 성적이 올바른지 확인. 올바른 성적은 0 이상 이고 100 이하
		System.out.println(score + "점은 올바른 성적이 인가? " + (score >= 0 && score <= 100));
		// 성적이 올바르지 않은지 확인. 올바르지 않은 성적은 0 미만 이거나 100 초과
		System.out.println(score + "점은 올바른 성적이 아닌가? " + (score < 0 || score > 100));
		System.out.println(score + "점은 올바른 성적이 아닌가? " + !(score >= 0 && score <= 100));
		
		
	}

}
