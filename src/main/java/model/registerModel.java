package model;

import java.io.File;

import javax.servlet.http.Part;

import util.utilString;

public class registerModel {
	
	private String Firstname;
	private String Lastname;
	private String UserName;
	private String UserEmail;
	private String Password;
	private String imageUrlFromPart;
	
	
	public registerModel(String Firstname, String Lastname, String UserName, String UserEmail, String Password, Part Image) {
		super();
		this.Firstname = Firstname;
		this.Lastname = Lastname;
		this.UserName = UserName;
		this.UserEmail = UserEmail;
		this.Password = Password;
		this.imageUrlFromPart = getImageUrl(Image);
	}
	
	public String getimageUrlFromPart() {
		return imageUrlFromPart;
	}


	public String getFirstname() {
		return Firstname;
	}
	public void setFirstname(String Firstname) {
		this.Firstname = Firstname;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String Lastname) {
		this.Lastname = Lastname;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String UserName) {
		this.UserName = UserName;
	}
	public String getUserEmail() {
		return UserEmail;
	}
	public void setUserEmail(String UserEmail) {
		this.UserEmail = UserEmail;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String Password) {
		this.Password = Password;
	}
	public void setImageUrlFromPart(Part part) {
		this.imageUrlFromPart = getImageUrl(part);
	}
	
	public void setImageUrlFromDB(String imageUrl) {
		this.imageUrlFromPart = imageUrl;
	}
	
	private String getImageUrl(Part part) {
		String savePath = utilString.IMAGE_ROOT_PATH;
		File fileSaveDir = new File(savePath);
		String imageUrlFromPart = null;
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				imageUrlFromPart = s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		if (imageUrlFromPart == null || imageUrlFromPart.isEmpty()) {
			imageUrlFromPart = "profile.png";
		}
		return imageUrlFromPart;
	}

}
