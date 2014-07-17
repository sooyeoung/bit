package exam.annotation.step01;

import java.lang.annotation.Annotation;

/*애노테이션 정보 추출
 * => 클래스 파일에 들어 있는 애노테이션 정보 가져오기
 * 
 * 
 * 
 */
public class Test02 {
	public static void main(String[] args) {
		
	}
	
	//1. 클래스를 로딩( 인스턴스 생성,Class.forName(), 스태틱변수 또는 매서드 사용 ) 
	Class clazz = Class.forName("exam.annotation.step01.MyClass");
	
	//2. 클래스 정보에서 애노테이션 추출한다.
	// => getAnnotation ( 애노테이션 타입 정보)
	// => 애노테이션 타입 정보 ? Class.forName
	/*방법1.
	Class.annoTypeInfo = Class.forName ("exam.annotation.step01.Component");
	Component compAnno = (Component)clazz.getAnnotation(annoTypeInfo);
	*/
	
	
	/*방법 2*/
	Component compAnno = (Component)clazz.getAnnotation(Component.class);
	// forname 호출 대신에 component class라고 해줘도
	//파일이름아니니까 헷갈리지 않도록! 참조변수이다.. component.class!!
	
	
	
	
	//3.
	Component compAnno = null;
	for(Annotation anno : annos){ 
			System.out.println("=>" + anno);
			if ( anno instanceof Component){
				compAnno = (Component) anno;
				System.out.println ("name=" + compAnno.name());
				System.out.println ("count=" + compAnno.count());
				System.out.println ("type=" + compAnno.type());
				System.out.println ("url=" + compAnno.url());
	}
	}
}

}