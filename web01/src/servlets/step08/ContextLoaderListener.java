package servlets.step08;

import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

//   
public class ContextLoaderListener implements ServletContextListener {
  static Logger logger = Logger.getLogger(ContextLoaderListener.class);
  
  @Override
  public void contextInitialized(ServletContextEvent event) {
    logger.debug("contextInitialized 호출됨...");
    try {
      ServletContext ctx = event.getServletContext();
      
      String resource = "servlets/step08/mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      SqlSessionFactory sqlSessionFactory = 
          new SqlSessionFactoryBuilder().build(inputStream);
      ctx.setAttribute("sqlSessionFactory","sqlSessionFactory");
      
      //ScoreDao scoreDao = new ScoreDao();
      //scoreDao.setSqlSessionFactory(sqlSessionFactory);
     
      logger.debug(ctx.getRealPath("/WEB-INF/classes/servlet/step08"));
      String classPath = 
    		  ctx.getRealPath("/WEB-INF/classes/servlet/step08");
      
      File pgControllerDir = new File (pageControllerPath);
      String [] classnames =classDir.list (new FilteNamefilter(){
    	
    	
    	@Override
    	public boolean accept (File dir, String name){
    	  if (name.endsWith(".class")) return true;
    	  else return false;
      }
      });
      String [] classnames = getClassNames (classDir);
      
      prepareObjects(classnames);
      
      
      
      
      
      Class <?> Class clazz = null;
      Component compAnno = null;
      PageController pageController =null;
      
      for (String classname : classnames){
   	  clazz = loadClass(classname);
      compAnno = getCompA}
      
      compAnno = (Component) clazz.getAnnotation(Component.class);
      if (compAnno!= null){
    	  logger.debug("value=" + compAnno.value());
    	  
    	  instance = createInstance(clazz);
    	  
    	  injectDependancy(instance, ctz);
    	  
    	  
    	  clazz.newInstance();
    	  
      }
 
     ctx.setArrtibute(compAnno.value());
            
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  provate void prepareDependan
  
 private void prepareObjects ( String [] classnames ) throws Exception{
	 Class clazz = null;
	 Object instance = null;
	 Component compAnno = null;
	 
	 
	 for ( String classname : classnames) {
		 clazz = loadClass(classname);
		 instance = createInstance (clazz);
		 compAnno = getComponentAnnotation (clazz);
		 ctx.setAttribute(compAnno.value(), instance);
	 }
 }
 private  void injectDependancy (Object instance){
	 Method[] methods = instance.getClass().getMethods();
	 for (Method method : methods){
		 if ( method.getName().startsWith("set"))
		 && method.getParameterCount()==1){
			dependancy = finDependancy
			method.getparameters())
			
		 if (def)
		 }
	 }
	 
 }
 
 private Object findDependancyFromServletContext(Class<?> clazz){
	 Enumeration<String> instanceNames = ctx.getAttributeNames();
	 Object instance = null;
	 
	 String instanceName  = null;
	 while (instanceNames.hasMoreElements()){
		 instanceName = instanceNames.nextElement();
		 instance = ctx.getAttribute (instanceName);
		 if (instance != null && instanceof class ){
			 return instance;
			 
		 }
		 
		 
	 }
 }
 
private Class loadClass(Class<?> clazz) throws InstantiationException,
	IllegalAccessException {
	object clazz<?> clazz  = Class.forName ("servlets.step08."+
      classname.substring(0,classname.indexOf('.')));
   		logger.debug("==>" + clazz.getName());
	    return clazz;
}
  
  @Override
  public void contextDestroyed(ServletContextEvent event) {
    logger.debug("contextDestroyed 호출됨...");
  }
}












