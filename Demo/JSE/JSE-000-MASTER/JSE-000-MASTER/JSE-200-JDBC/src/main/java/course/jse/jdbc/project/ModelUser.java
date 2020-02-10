package course.jse.jdbc.project;

import lombok.Data;

@Data
public class ModelUser {
	private int id;
	private String fname;
	private String lname;
	private String username;
	private String password;
	private String email;
	private String role;
}
