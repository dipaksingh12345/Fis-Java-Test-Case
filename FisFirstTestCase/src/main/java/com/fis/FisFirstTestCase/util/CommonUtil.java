package com.fis.FisFirstTestCase.util;

public class CommonUtil {
	
	 public static boolean isNullOrEmpty(String val) {
	        return val == null || val.trim().isEmpty();
	    }

	    public static boolean isValidEmail(String email) {
	        return email != null && email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
	    }

}
