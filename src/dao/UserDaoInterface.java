package dao;

interface UserDaoInterface{
	
	int SignUp(User user);
	boolean LoginUser(User user);
}