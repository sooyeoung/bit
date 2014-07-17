package exam.annotation.step02;

/* 기본 사용*/
//베열 값 설정 : 값을 한개 줄때, 중괄호 생략 가능 !
// @Component(value = "my1")
//배열값 설정 : 값을 여러 개 줄때 , 중괄호 생략 불가능 !
//@Component (value={"my1","my2","my3"})
/*value 속성값을 설정할때 속성명을 생략할 수 있다.
/*배열 타입은 값을 한개 줄 수도 있고, 여러개 줄 수도 있다.*/
//@Componenet ("my1") 
//@Componenet({"my1,my2,my3"})

/*두 개 이상의 속성을 설정할 때는 value 이름 생략 불가*/
//@Component(value ="my1", url ="url1")
@Component(value ="my1", url ="url1")
public class MyClass {

	
	
	
	
}
