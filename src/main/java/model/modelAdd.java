package model;

import java.io.File;

import javax.servlet.http.Part;

import util.utilString;

public class modelAdd {

	private String CollegeName;
	private String CollegeLocation;
	private String CollegeDistrict;
	private String Years;
	private String GraduationRate;
	private String AverageFee;
	private String CollegeWebsite;
	private String CollegeContact;
	private String CollegePhone;
	private String CollegeMail;
	private String Progarm;
	private String imageFromPart;

	public modelAdd(String collegeName, String collegeLocation, String collegeDistrict, String years,
			String graduationRate, String averageFee, String collegeWebsite, String collegeContact, String collegePhone,
			String collegeMail, String program, Part photos) {
		super();
		this.CollegeName = collegeName;
		this.CollegeLocation = collegeLocation;
		this.CollegeDistrict = collegeDistrict;
		this.Years = years;
		this.GraduationRate = graduationRate;
		this.AverageFee = averageFee;
		this.CollegeWebsite = collegeWebsite;
		this.CollegeContact = collegeContact;
		this.CollegePhone = collegePhone;
		this.CollegeMail = collegeMail;
		this.Progarm = program;
		this.imageFromPart = getPhotos(photos);
	}

	public String getProgarm() {
		return Progarm;
	}

	public void setProgarm(String progarm) {
		Progarm = progarm;
	}

	public String getYears() {
		return Years;
	}

	public void setYears(String years) {
		Years = years;
	}

	public String getGraduationRate() {
		return GraduationRate;
	}

	public void setGraduationRate(String graduationRate) {
		GraduationRate = graduationRate;
	}

	public String getAverageFee() {
		return AverageFee;
	}

	public void setAverageFee(String averageFee) {
		AverageFee = averageFee;
	}

	public String getCollegeName() {
		return CollegeName;
	}

	public void setCollegeName(String collegeName) {
		CollegeName = collegeName;
	}

	public String getCollegeLocation() {
		return CollegeLocation;
	}

	public void setCollegeLocation(String collegeLocation) {
		CollegeLocation = collegeLocation;
	}

	public String getCollegeDistrict() {
		return CollegeDistrict;
	}

	public void setCollegeDistrict(String collegeDistrict) {
		CollegeDistrict = collegeDistrict;
	}

	public String getCollegeWebsite() {
		return CollegeWebsite;
	}

	public void setCollegeWebsite(String collegeWebsite) {
		CollegeWebsite = collegeWebsite;
	}

	public String getCollegeContact() {
		return CollegeContact;
	}

	public void setCollegeContact(String collegeContact) {
		CollegeContact = collegeContact;
	}

	public String getCollegePhone() {
		return CollegePhone;
	}

	public void setCollegePhone(String collegePhone) {
		CollegePhone = collegePhone;
	}

	public String getCollegeMail() {
		return CollegeMail;
	}

	public void setCollegeMail(String collegeMail) {
		CollegeMail = collegeMail;
	}

	public String getimageFromPart() {
		return imageFromPart;
	}

	public void setimageFromPart(Part part) {
		this.imageFromPart = getPhotos(part);
	}

	public void setImageFromDB(String imageUrl) {
		this.imageFromPart = imageUrl;
	}

	private String getPhotos(Part part) {
		String savePath = utilString.IMAGE_ROOT_PATH;
		File fileSaveDir = new File(savePath);
		String imageFromPart = null;
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				imageFromPart = s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		if (imageFromPart == null || imageFromPart.isEmpty()) {
			imageFromPart = "profile.png";
		}
		return imageFromPart;
	}

}
