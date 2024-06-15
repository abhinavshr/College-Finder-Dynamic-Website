package model;

public class modelAdmin {
	
	private String collegeId;
	private String collegeName;
	private String collegeLocation;
	private String collegeDistrict;
	private String years;
	private String graduationRate;
	private String averageFee;
	private String collegeWebsite;
	private String collegeContact;
	private String collegePhone;
	private String collegeMail;
	private String progarm;
	private String imageFromPart;
	
	public modelAdmin(String collegeId, String collegeName, String collegeLocation, String collegeDistrict,
			String years, String graduationRate, String averageFee, String collegeWebsite, String collegeContact,
			String collegePhone, String collegeMail, String progarm, String imageFromPart) {
		super();
		this.collegeId = collegeId;
		this.collegeName = collegeName;
		this.collegeLocation = collegeLocation;
		this.collegeDistrict = collegeDistrict;
		this.years = years;
		this.graduationRate = graduationRate;
		this.averageFee = averageFee;
		this.collegeWebsite = collegeWebsite;
		this.collegeContact = collegeContact;
		this.collegePhone = collegePhone;
		this.collegeMail = collegeMail;
		this.progarm = progarm;
		this.imageFromPart = imageFromPart;
	}

	public modelAdmin() {
		// TODO Auto-generated constructor stub
	}

	public String getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getCollegeLocation() {
		return collegeLocation;
	}

	public void setCollegeLocation(String collegeLocation) {
		this.collegeLocation = collegeLocation;
	}

	public String getCollegeDistrict() {
		return collegeDistrict;
	}

	public void setCollegeDistrict(String collegeDistrict) {
		this.collegeDistrict = collegeDistrict;
	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	public String getGraduationRate() {
		return graduationRate;
	}

	public void setGraduationRate(String graduationRate) {
		this.graduationRate = graduationRate;
	}

	public String getAverageFee() {
		return averageFee;
	}

	public void setAverageFee(String averageFee) {
		this.averageFee = averageFee;
	}

	public String getCollegeWebsite() {
		return collegeWebsite;
	}

	public void setCollegeWebsite(String collegeWebsite) {
		this.collegeWebsite = collegeWebsite;
	}

	public String getCollegeContact() {
		return collegeContact;
	}

	public void setCollegeContact(String collegeContact) {
		this.collegeContact = collegeContact;
	}

	public String getCollegePhone() {
		return collegePhone;
	}

	public void setCollegePhone(String collegePhone) {
		this.collegePhone = collegePhone;
	}

	public String getCollegeMail() {
		return collegeMail;
	}

	public void setCollegeMail(String collegeMail) {
		this.collegeMail = collegeMail;
	}

	public String getProgarm() {
		return progarm;
	}

	public void setProgarm(String progarm) {
		this.progarm = progarm;
	}

	public String getImageFromPart() {
		return imageFromPart;
	}

	public void setImageFromPart(String imageFromPart) {
		this.imageFromPart = imageFromPart;
	}
	
}
