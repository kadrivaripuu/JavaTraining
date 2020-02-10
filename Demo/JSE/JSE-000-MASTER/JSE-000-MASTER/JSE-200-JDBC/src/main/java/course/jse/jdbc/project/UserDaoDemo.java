package course.jse.jdbc.project;

public class UserDaoDemo {

	public static void main(String[] args) {

			ServiceUser serviceUser = new ServiceUser();
			
			ModelUser mockUser = new ModelUser();
			
			mockUser.setFname("Test");
			mockUser.setLname("Test");
			mockUser.setUsername("test");
			mockUser.setPassword("tere");
			mockUser.setEmail("test@test.com");
			mockUser.setRole("tester");
					
			serviceUser.saveUser(mockUser);
			
			serviceUser.deleteUser(1);
			
			ModelUser foundById = serviceUser.findUser(1);
			
			System.out.println("(FindId) Cd values: "+ foundById.toString());
			
		
			
	}

}
