package controller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DBUtilController {

	public static void main(String[] args) {
		SimpleDateFormat d =  new SimpleDateFormat("HH:mm:ss.SSS");  
		System.out.println(d.format(new Date()));
		
	}
}
