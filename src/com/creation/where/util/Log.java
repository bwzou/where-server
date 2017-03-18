package com.creation.where.util;

import java.util.logging.Level;
import java.util.logging.Logger;



public class Log {
	
	public static Logger log=Logger.getLogger("ssg");
	
	public static void w(String str){
		log.log(Level.WARNING, str);
	}
	
	public static void i(String str){
		log.log(Level.INFO, str);
	}

}
