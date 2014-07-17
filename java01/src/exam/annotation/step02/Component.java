package exam.annotation.step02;

public @interface Component {

	
	String [] value ();
	String [] url ();
	String [] url () default ("ok")
	
}
