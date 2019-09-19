package exampledao.dao;

import java.util.Date;
import java.util.List;

import exampledao.models.UserData;

public interface UserDao {

	UserData getUserById(int userId);

	boolean createUser(String username, String password, String email, String birthday, int roleId);

	boolean deleteUser(int userId);

	boolean updateUser(int userId, String username, String password, String email, String birthday, int roleId);

	List<UserData> getAllUsers();

}
