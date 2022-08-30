package org.comit.course.dao;

import java.util.ArrayList;
import java.util.List;

import org.comit.course.bean.User;
import org.comit.course.util.Util;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	List<User> users;
	
	UserDao() {
		this.users = new ArrayList<>();
	
		this.users.add(new User(1, "Fredrick", "Krumm", "FKRUMM", "123", Util.parseDate("1992-02-14"), "A"));
		this.users.add(new User(2, "Jaymie", "Dunning", "JDUNNING", "123", Util.parseDate("1994-08-04"), "A"));
		this.users.add(new User(3, "Kristy", "Rayford", "KRAYFORD", "123", Util.parseDate("1995-04-12"), "A"));
		this.users.add(new User(4, "Faye", "Redington", "FREDINGTON", "123", Util.parseDate("1996-12-08"), "A"));
		this.users.add(new User(5, "Bobbye", "Stinebaugh", "BSTINEBAUGH", "123", Util.parseDate("2000-02-05"), "A"));
	
	}

	List<User> listUser() {
		
		return users;
		
	}
	
	User findUser(int idUser) {
		User user = new User();
		user.setIdUser(idUser);
		
		int index = this.users.indexOf(user);
		
		if (index >= 0) {
			user = this.users.get(index);
		}
		
		return user;
	}
	
	synchronized void createUser(User user) {
		int max = 0;
		
		for (User u: users) {
			if(u.getIdUser() > max) {
				max = user.getIdUser();
			}
		}
		
		user.setIdUser(++max);
		user.setStatus("A");
		
		this.users.add(user);
	}
	
	void modifyUser(User user) {
		
		int index = this.users.indexOf(user);
		
		if (index >= 0) {
			users.set(index, user);
		}
		
	}
	
	void deleteUser(int idUser) {
		this.users.removeIf(u -> u.getIdUser() == idUser);
	}
	
}
