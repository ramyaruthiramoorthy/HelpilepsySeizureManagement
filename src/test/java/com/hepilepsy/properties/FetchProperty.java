package com.hepilepsy.properties;
import java.io.IOException;
import java.util.ResourceBundle;

/***
 * Class FetchProperty retrieves values from property file.
 * 
 * @author Ramya
 *
 */
public class FetchProperty {

	public String getUrl(String propertyKey) throws IOException {
		return ResourceBundle.getBundle("url").getString(propertyKey);
	}

	public String getCredential(String propertyKey) throws IOException {
		return ResourceBundle.getBundle("credentials").getString(propertyKey);
	}
	public String getMessage(String propertyKey) throws IOException {
		return ResourceBundle.getBundle("message").getString(propertyKey);
	}
}
