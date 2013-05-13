package cn.edu.dhu.score.analyze.model;

/**
 * table user!
 * 
 */
public class KaasUser {

	/*private String address;
	private String email;
	private String region;*/
	private String userId;// primary key
	private String userName;

	/*public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public String getRegion() {
		return region;
	}*/

	public String getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}
/*
	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRegion(String region) {
		this.region = region;
	}*/

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
