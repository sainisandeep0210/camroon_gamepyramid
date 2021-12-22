package gen;

import java.net.URL;
import java.util.Properties;

import org.apache.jasper.tagplugins.jstl.core.Url;

public class Configurator {
	
	private Properties props = null;
	
	public Configurator() {
		init();
	}

	public static class SingletonHolder
	{
		private static final Configurator configurator = new Configurator();
	}
	
	public static Configurator getInstance()
	{
		return SingletonHolder.configurator;
	}
	 private void init()
	    {
	    	 loadProps();
	     }
	 
	 public String getProperty(String _key)
	 {
		 try 
		 {
			 return props.getProperty(_key);
			 
		 }
		 
		 catch (Exception e)
		 {
			System.out.println("There is no entry in property file for key "+ _key + " and " + e.getMessage());
			return null;
		 }
		 
	 }
	 
	 public void loadProps()
	 {
		 try {
			 props = new Properties();
			 ClassLoader loader = Thread.currentThread().getContextClassLoader();
			 URL url = loader.getResource("getQueries.properties");
			 props.load(url.openStream());
		 }
		 catch (Exception e) {
	            e.printStackTrace();
	            return;
	        }
		 
	 }
	 
}
