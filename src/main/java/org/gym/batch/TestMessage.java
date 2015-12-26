package org.gym.batch;

public class TestMessage {
	public static void main(String[] args) {
		SMS sms = new SMS160by2();
		sms.login("9920068896", "rjayesh198k");
		System.out.println(sms.isAuthenticated());
		try {
		    sms.send("7506365905", "hisdsdsdd!");
		} catch (NotAuthenticatedException ex) {
		    ex.printStackTrace();
		}
	}
}
