package exam.annotation.step01;

import java.lang.annotation.Retention;
//인터페이스입니다.~~~ 자동으로 자바가 구현해준다.
/*
 * 애노테이션 정의
 * =>컴파일러나 JVM에게 전달할 특별한 정보 
 * =>문법 형태는 자바 인터페이스와 유사
 * =>내부 선언은 메서드 선언과 유사하지만 멤버는 속성이름처럼 작성한다.
 * @intertace 애노테이션이름{}
 * 
 * 
 * => 내부 선언은 매서드 선언과 유사 -> 멤버의 이름 속성 이름처럼 작성한다.
 * 타입이름 ();
 * 타입이름() default 기본값;

 * 애노테이션 유지 정책
 * => SOURCE : 컴파일 때만 참조함(컴파일후 제거됨.일반주석과 동) .class파일에는 없음.
 *  예 ) @Override => 컴파일할 때만 참조. 컴파일 후에 버린다.
 * => CLASS : 컴파일러가 참조하는 주석으로 .class파일에 존재함.
 * => RUNTIME : JVM이 참조(사용) .class파일에 존재함.
 *  예 ) @Deprecated => JVM이 창조하는 주석.
 *     /** 은 자바doc주석이다.
 *     이 주석은 자바 문서를 만들때 사용한다.
 *     
 */
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Component {

 String name(); // 필수 입력 항목
 int count(); // 필수 입력 항목
 String type() default "general";// 선택입력항목
 String[] url(); // 필수 입력 항목... default 값아니면 필수입력?..

 
	
}
