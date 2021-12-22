package gen;

import static gen.Configurator.getInstance;

public class test {
	
	public static void main(String[] args) {
	
		Configurator configurator = getInstance();
		Configurator conf=new Configurator();
		System.out.println(conf.hashCode()+ "  " + configurator.hashCode());
	}
	
	

}

