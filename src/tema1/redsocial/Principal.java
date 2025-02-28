package tema1.redsocial;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		ArrayList<User> users = new ArrayList<User>();
		for (int i = 0; i < 100; i++) {
			User nuevo = new User("user"+i);
			users.add(nuevo);
		}
		System.out.println(users);
	}

}
