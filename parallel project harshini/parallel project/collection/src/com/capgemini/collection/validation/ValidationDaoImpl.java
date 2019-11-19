package com.capgemini.collection.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationDaoImpl implements ValidationDao {

Pattern pattern = null;
Matcher matcher = null;

public boolean validationEmail(String emailid) {
	pattern = Pattern.compile("\\w+\\@\\w+\\.\\w+");
	matcher = pattern.matcher(emailid);
	if (matcher.matches()) {
		return true;
	}
	return false;
}
public boolean validationPassword(String password) {
	pattern = Pattern.compile("\\w{6,8}");
	matcher = pattern.matcher(password);
	if (matcher.matches()) {
		return true;
	}
	return false;

}
public boolean validationMobileNo(String mobileNo) {

	pattern = Pattern.compile("\\d{10}");
	matcher = pattern.matcher(mobileNo);
	if(matcher.matches()) {
		return true;
	}
	return false;
}
public boolean validationProductCategory(String productCategory) {

	pattern = Pattern.compile("\\w+");
	matcher = pattern.matcher(productCategory);
	if(matcher.matches()) {
		return true;
	}
	return false;
}
public boolean validationProductName(String productName) {

	pattern = Pattern.compile("\\w+");
	matcher = pattern.matcher(productName);
	if(matcher.matches()) {
		return true;
	}
	return false;
}

}
