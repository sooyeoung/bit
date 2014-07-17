package servlets.step08;

import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.lang.reflect.Method;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;


public class ContextLoaderListener01 implements ServletContextListener {
	static Logger logger= Logger.getLogger(ContextLoaderListener01.class);
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		logger.debug("contextInitialized 호출됨...");
		try{
			ServletContext ctx = event.getServletContext();
			
			String resource = "servlets/step08/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
	        SqlSessionFactory sqlSesstionFactory = 
	        		new SqlSessionFactoryBuilder().build(inputStream);
	        
	       ScoreDao scoreDao = new ScoreDao();
	       scoreDao.setSqlSessionFactory(sqlSessionFactory);
		/*페이지 컨트롤러를 ServletContext에 보관함
		 * => servlets 패키지에서 @Component 애노테이션이 들어 있는 클래스를 찾아 인스턴스를 생성하라.!
		 * => 생성된 인스턴스는 ServaletContext에 보관하라
		 * 1. 웹 애플리케이션의 클래스 경로를 알아낸다.
		 * => 웹 애플리케이션이 배치된 폴더 /WEB-INF/classes
		 * => 예 ...../..metadata/.plugins/org.eclipse.wst.server.core.tmp0/wtpwebapps/web01/WEB-INF/classes*/
	       logger.debug(ctx.getRealPath("/WEB-INF/classes/servlets/step08"));
	       String pageControllerPath = ctx.getRealPath("/WEB-INF/classes/servlets/step08");
	       
	       //2. File 객체를 사용하여 해당 servlets/step08 폴더에 들어 있는 클래스 이름을 알아낸다.
	     File pageControllerDir = new File(pageControllerPath);  
	       String[] files = pageControllerDir.list(new FilenameFilter(){
	    	   @Override
	    	   public boolean accept (File dir, String name){
	    		   if (name.eadsWith(".class")) return true;
	    		   else return false;   
	    	   }
	       });
	       //3. 클래스 이름으로 클래스를 로딩한다.
	       //=> servlets.step08 패키지에 소속된 클래스를 로딩한다.
	       Class clazz = null;
	       Component compAnno = null;
	       PageController pageContriller = null;
	       Method method = null;
	       
	       for (String filename : files){
	    	   clazz = Class.forName("servlets.step08."+
	                filename.substring (0,filename.indexOf('.')));
	    	   logger.debug ("==>" + clazz.getName());
	    	   
	    	   //4. 클래스 정보 객체로부터 Component 애노테이션 정보를 추출한다.
	    	   compAnno = (Component)clazz.getAnnotation(Component.class);
	    	   
	    	   //5. 만약 Component 애노테이션이 있다면 해당 클래스의 인스턴스를 생성한다.
	    	   if (compAnno!=null) {
	    		   logger.debug("    value=" + compAnno.value());
	    		   
	    		   pageController = (PageController)clazz.newInstance();
	    		   logger.debug ("      " + clazz.getSimpleName() + "인스턴스 생성됨");
	    		   
	    		   //6. 그리고 의존 객체를 주입한다.
	    		   method = clazz.getMethod("setScoreDao", ScoreDao.class);
	    		   logger.debug("    setScoreDao() 메서드 정보 꺼내기");
	    		   
	    		   method.invoke(pageController, scoreDao);
	    		   logger.debug("      setScoreDao() 호출");
	    		   
	    		   //7. ServaletContext에 보관한다.
	    		   ctx.setAttribute(compAnno.value(), pageController);
	    		   logger.debug("        "+ clazz.getSimpleName()+ "인스턴스를 ServletContext 보관.");
	    	   }
	    	}
		
		} catch ( Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		logger.debug("contextDestroyed 호출됨.....");
	}

	
	
	
	



}
