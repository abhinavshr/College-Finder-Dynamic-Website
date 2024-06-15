package controllerr.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.encryptionPassword;
import model.modelLogin;
import util.utilString;
import model.registerModel;
import model.modelAdd;
import model.modelAdmin;
import model.modelDelete;
import model.modelHome;
import model.modelReview;
import model.modelContactUs;



public class connectdb {
	public Connection getConnection() throws SQLException, ClassNotFoundException{
		Class.forName(utilString.DRIVER_NAME);
		return DriverManager.getConnection(
				utilString.LOCALHOST_URL, 
				"root", 
				"");
	}
	
	public int registerModel(registerModel register) {
	    try (Connection con = getConnection()) {
	        PreparedStatement stt = con.prepareStatement(utilString.register_user_query);
	        stt.setString(1, register.getFirstname());
	        stt.setString(2, register.getLastname());
	        stt.setString(3, register.getUserName());
	        stt.setString(4, register.getUserEmail());
	        stt.setString(5, encryptionPassword.encrypt(register.getUserName(), register.getPassword()));
	        stt.setString(6, register.getimageUrlFromPart());
	        stt.setString(7, "User");

	        int rowsAffected = stt.executeUpdate();

	        if (rowsAffected > 0) {
	            return 1; // Registration successful
	        } else {
	            return 0; // Registration failed
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();  
	        return -1; 
	    }
	}

	
	public int loginInfo(modelLogin Modellogin) {
	    try {
	        PreparedStatement st = getConnection().prepareStatement(utilString.check_login);

	        st.setString(1, Modellogin.getUserName());

	        ResultSet result = st.executeQuery();

	        if (result.next()) {
	            // Get the username
	            String user = result.getString(utilString.USER_NAME);

	            // Get the password
	            String encryptedPwd = result.getString(utilString.UPASS);

	            try {
	                String decryptedPwd = encryptionPassword.decrypt(encryptedPwd, user);
	                // Check if the username and password
	                if (user.equals(Modellogin.getUserName())
	                        && decryptedPwd != null
	                        && decryptedPwd.equals(Modellogin.getPassword())) {
	                    return 1;
	                } else {
	                    return 0;
	                }
	            } catch (Exception ex) {
	                ex.printStackTrace();
	                return -3;
	            }
	        } else {
	            return -1;
	        }

	    // Catch SQLException and ClassNotFoundException if they occur
	    } catch (SQLException | ClassNotFoundException ex) {
	        ex.printStackTrace();
	        return -2;
	    }
	}
	
	public int modelAdd(modelAdd add) {
	    try (Connection conn = getConnection()) {
	        PreparedStatement statement = conn.prepareStatement(utilString.register_add_query);
	        statement.setString(1, add.getCollegeName());
	        statement.setString(2, add.getCollegeLocation());
	        statement.setString(3, add.getCollegeDistrict());
	        statement.setString(4, add.getYears());
	        statement.setString(5, add.getGraduationRate());
	        statement.setString(6, add.getAverageFee());
	        statement.setString(7, add.getCollegeWebsite());
	        statement.setString(8, add.getCollegeContact());
	        statement.setString(9, add.getCollegePhone());
	        statement.setString(10, add.getCollegeMail());
	        statement.setString(11, add.getProgarm());
	        statement.setString(12, add.getimageFromPart());

	        int affectedRows = statement.executeUpdate();

	        if (affectedRows > 0) {
	            return 1; // Registration successful
	        } else {
	            return 0; // Registration failed
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();  
	        e.getMessage();
	        return -1; 
	    }
	}

	
	public int modelDelete(modelDelete delete) {
	    try (Connection conn = getConnection()) {
	        PreparedStatement statement = conn.prepareStatement(utilString.register_update_query);
	        statement.setInt(0, delete.getCollegeId());
	        int affectedRows = statement.executeUpdate();

	        if (affectedRows >= 1) {
	            return 1; // Deletion successful
	        } else {
	            return 0; // Deletion failed
	        }
	    }
	    catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();  
	        e.getMessage();
	        return -1; 
	    }
	}
	
	public int deleteUserInfo(String username) {
		try (Connection con = getConnection()) {
			PreparedStatement st = con.prepareStatement(utilString.delete_query);
			st.setString(1, username);
			return st.executeUpdate();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return -1;
		}
	}
	

	public ArrayList<modelAdmin> getDataFromDatabase() throws ClassNotFoundException {
	    ArrayList<modelAdmin> dataList = new ArrayList<>();
	    String query = "SELECT * FROM colleges";

	    try (Connection con = getConnection();
	         PreparedStatement stmt = con.prepareStatement(query);
	         ResultSet rs = stmt.executeQuery()) {

	        while (rs.next()) {
	            modelAdmin data = new modelAdmin();
	            data.setCollegeId(rs.getString("College_Id"));
	            data.setCollegeName(rs.getString("College_Name"));
	            data.setCollegeLocation(rs.getString("College_Location"));
	            data.setCollegeDistrict(rs.getString("College_District"));
	            data.setYears(rs.getString("Years"));
	            data.setGraduationRate(rs.getString("Graduation_Rate"));
	            data.setAverageFee(rs.getString("Average_Fee"));
	            data.setCollegeWebsite(rs.getString("College_Website"));
	            data.setCollegeContact(rs.getString("College_Contact"));
	            data.setCollegePhone(rs.getString("College_Phone"));
	            data.setCollegeMail(rs.getString("College_Mail"));
	            data.setProgarm(rs.getString("Program"));
	            data.setImageFromPart(rs.getString("photo"));

	            dataList.add(data);
	        }

	    } catch (SQLException e) {
	        // Use a logger instead of printing the stack trace to the console.
	        e.printStackTrace();
	    }

	    return dataList;
	}
	
	public int deleteCollege(String collegeId) {
		try (Connection con = getConnection()) {
			PreparedStatement st = con.prepareStatement(utilString.delete_query);
			st.setString(1, collegeId);
			return st.executeUpdate();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return -1;
		}
	}
	
	public ArrayList<modelHome> getDatabaseData() throws ClassNotFoundException {
	    ArrayList<modelHome> dataList = new ArrayList<>();
	    String query = "SELECT * FROM colleges";

	    try (Connection con = getConnection();
	         PreparedStatement stmt = con.prepareStatement(query);
	         ResultSet rs = stmt.executeQuery()) {

	        while (rs.next()) {
	            modelHome data = new modelHome();
	            data.setCollegeId(rs.getString("College_Id"));
	            data.setCollegeName(rs.getString("College_Name"));
	            data.setCollegeLocation(rs.getString("College_Location"));
	            data.setCollegeDistrict(rs.getString("College_District"));
	            data.setYears(rs.getString("Years"));
	            data.setGraduationRate(rs.getString("Graduation_Rate"));
	            data.setAverageFee(rs.getString("Average_Fee"));
	            data.setCollegeWebsite(rs.getString("College_Website"));
	            data.setCollegeContact(rs.getString("College_Contact"));
	            data.setCollegePhone(rs.getString("College_Phone"));
	            data.setCollegeMail(rs.getString("College_Mail"));
	            data.setProgram(rs.getString("Program"));
	            data.setImageFromPart(rs.getString("photo"));

	            dataList.add(data);
	        }

	    } catch (SQLException e) {
	        // Use a logger instead of printing the stack trace to the console.
	        e.printStackTrace();
	    }

	    return dataList;
	}
	
	public int modelReview(modelReview regi) {
	    try (Connection con = getConnection()) {
	        PreparedStatement stt = con.prepareStatement(utilString.REGISTER_REVIEW);
	        stt.setString(1, regi.getFullName());
	        stt.setString(2, regi.getRating());
	        stt.setString(3, regi.getReview());

	        int rowsAffected = stt.executeUpdate();

	        if (rowsAffected > 0) {
	            return 1; // Registration successful
	        } else {
	            return 0; // Registration failed
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();  
	        return -1; 
	    }
	}
	
	public int modelContactUs(modelContactUs regii) {
	    try (Connection con = getConnection()) {
	        PreparedStatement stt = con.prepareStatement(utilString.REGISTER_CONTACT_US);
	        stt.setString(1, regii.getName());
	        stt.setString(2, regii.getEmail());
	        stt.setString(3, regii.getPhone());
	        stt.setString(4, regii.getMessage());

	        int rowsAffected = stt.executeUpdate();

	        if (rowsAffected > 0) {
	            return 1; // Registration successful
	        } else {
	            return 0; // Registration failed
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();  
	        return -1; 
	    }
	}
	public int adminOrNot(String userName) {
	    try (Connection conn = getConnection();
	         PreparedStatement st = conn.prepareStatement("SELECT Role FROM user WHERE User_Name = ?")) {
	        st.setString(1, userName);
	        ResultSet rs = st.executeQuery();
	        if (rs.next()) {
	            // User name match in the database
	            String thisRole = rs.getString("Role"); 
	            if (thisRole != null && thisRole.equalsIgnoreCase("admin")) {
	                return 1;
	            } else {
	                return 0;
	            }
	        } else {
	            // No matching record found
	            return -2;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (ClassNotFoundException ex) {
	        ex.printStackTrace();
	    }
	    return -1;
	}

}
