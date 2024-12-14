package com.study.sBoard.dto
;
import lombok.Data;
/*	lombok의 어노테이션
 *	@Data
 * 	-> @Getter, @Setter, @RequiredArgsConstructor(생성자), @ToString, @EqualsAndHashCode을 한꺼번에 설정
 * 		: 해당 메소드가 자동생성 된다.
 */
@Data
public class SimpleBoardDto {
	private int id;
	private String writer;
	private String title;
	private String content;
	
}
