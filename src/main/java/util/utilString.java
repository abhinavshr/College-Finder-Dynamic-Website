package util;


public class utilString {
	// Start: DB Connection
		public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
		public static final String LOCALHOST_URL = "jdbc:mysql://localhost:3306/college_finder";
		public static final String LOCALHOST_USERNAME = "root";
		public static final String LOCALHOST_PASSWORD = "";
		
		public static final String IMAGE_ROOT_PATH = "D:\\New folder\\collegefinder\\src\\main\\webapp\\resources\\images";
		public static final String IMAGE_PATH = IMAGE_ROOT_PATH;
		public static final String IMAGE_PATH_COLLEGE = IMAGE_ROOT_PATH + "\\college\\";
		public static final String IMAGE_PATH_USER = IMAGE_ROOT_PATH + "\\user\\";
		// End: DB Connection
		
		// Start: Queries
		public static final String register_user_query = "INSERT INTO `user`(`First_name`, `Last_name`, `User_Name`, `User_Email`, `Password`, `Image`, `Role`) "
				+ "VALUES (?,?,?,?,?,?,?)";
		public static final String check_login = "SELECT * FROM user WHERE user_name = ?";
		
		public static final String register_add_query = "INSERT INTO `colleges`(`College_Name`, `College_Location`, `College_District`, `Years`, `Graduation_Rate`, `Average_Fee`, `College_Website`, `College_Contact`, `College_Phone`, `College_Mail`, `Program`, `photo`)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?, ?)";
		
		public static final String register_update_query = "UPDATE `colleges` SET `College_Name`= ?,`College_Location`= ?,`College_District`= ?,`Years`= ?,`Graduation_Rate`= ?,`Average_Fee`= ?,`College_Website`= ?,`College_Contact`= ?,`College_Phone`= ?,`College_Mail`= ?,`Program`= ?,`photo`= ? WHERE `College_Id`= ?";
		
		public static final String delete_query = "DELETE FROM `colleges` WHERE `College_Id` = ?";
		
		public static final String REGISTER_REVIEW = "INSERT INTO `review`(`Full_Name`, `Rating`, `Review`) VALUES (?,?,?)";
		
		public static final String REGISTER_CONTACT_US = "INSERT INTO `contactus`(`Name`, `Email`, `Phone`, `Message`) VALUES (?,?,?,?)";
		// End: Queries
		
		// Start: Parameter names
		public static final String UNAME = "username";
		public static final String FNAME = "First_name";
		public static final String LNAME = "Last_name";
		public static final String USER_NAME = "User_Name";
		public static final String UEMAIL = "User_Email";
		public static final String UPASS = "Password";
		public static final String REPASS = "retypePassword";
		public static final String USER = "user";
		public static final String JSESSIONID = "JSESSIONID";
		// End: Parameter names
		
		// Start: Servlet Route
		public static final String LOGIN_URL = "/login";
		public static final String REGISTER_URL = "/register";
		public static final String LOGOUT_URL = "/logout";
		public static final String ADD_URL = "/add";
		public static final String UPDATE_URL = "/update";
		public static final String DELETE_URL = "/delete";
		// End: Servlet Route
		
		// Register Page Messages
		public static final String Sucessfully_Register = "Successfully Registered!";
		public static final String Error_Register_Data = "Please correct the form data.";
		
		// Other Messages
		public static final String Error_Server = "An unexpected server error occurred.";
		public static final String MESSAGE_SUCCESS_DELETE = "Successfully Deleted!";
		public static final String MESSAGE_ERROR_DELETE = "Cannot delete the user!";

		public static final String Sucess_Message = "successMessage";
		public static final String Error_Message = "errorMessage";
		// End: Validation Messages
		
		// Start: JSP Route
		public static final String Login_URL = "/pages/login.jsp";
		public static final String Register_URL = "/pages/register.jsp";
		public static final String PAGE_URL_FOOTER = "pages/footer.jsp";
		public static final String PAGE_URL_HEADER = "pages/header.jsp";
		public static final String URL_LOGIN = "/login.jsp";
		public static final String Index_URL = "/index.jsp";
		public static final String ADD = "/pages/add.jsp";
		public static final String PANEL = "/pages/panel.jsp";
		public static final String UPDATE = "/pages/update.jsp";
		public static final String REVIEW = "/pages/review.jsp";
		public static final String CONTACT_US = "/pages/contactus.jsp";
		public static final String WELCOME = "/pages/welcome.jsp";
		
		// End: JSP Route
		
		// Login Page Messages
		public static final String Login_Success = "Successfully LoggedIn!";
		public static final String Error_Login = "Either username or password is not correct!";
		public static final String Create_Account_Error = "Account for this username is not registered! Please create a new account.";
		
		// Other Messages
		public static final String Server_Error = "An unexpected server error occurred.";

		public static final String DELETE= "deleteId";
		public static final String USER_LIST = "studentLists";

		public static final String MODIFY_USER = "/modifyUser";

}
