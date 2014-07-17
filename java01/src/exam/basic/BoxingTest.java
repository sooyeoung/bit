package exam.basic;
/* Auto Boxing
 * => 상황에 따라 자바 기본 타입을 상황에 따라 wrapper 객체로 자동 변환하는 것.
 * => warapper 객체를 자바 기본 타입으로 자동 변환하는 것.
 * => 상황에 따라 wrapper 객체를 자바 기본 타입으로 자동 변환하는것.=> Unboxing
 * 
 * wrapper 클래스란?
 * => 자바 기본 데이터를 클래스로 다룰 수 있도록 제공하는 
 * => int -> java.lang.Iteger라는 클래스 존재
 * => byte -> java.lang.byte라는 클래스 존재
 * => long -> java.lang.long라는 클래스 존재
 * => double -> java.lang.double라는 클래스 존재
 * => float -> java.lang.float라는 클래스 존재
 * => boolean -> java.lang.boolean라는 클래스 존재
 * => char -> java.lang.char라는 클래스 존재
 * => short -> java.lang.short라는 클래스 존재
 */
public class BoxingTest {

	public static void main(String[] args) {
		int i = 10;
		Integer obj1 =i; // => new Integer(i) => boxing
		
		Integer obj2 =new Integer(20); // => new Integer(i) => boxing
		int i2 = obj2; // => obj2.intValue() => new Integer(i)=> boxing
		
		Object obj3 = i;// => new Integer(i) => boxing
		
	}

}
