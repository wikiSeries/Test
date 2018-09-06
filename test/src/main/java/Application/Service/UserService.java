package Application.Service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import Application.Entity.Role;
import Application.Entity.User;
import Application.Repository.RoleRepository;
import Application.Repository.UserRepository;

public class UserService {
	
	@Autowired
	private UserRepository userR;
	
	@Autowired
	private RoleRepository roleR;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public User getUserByUsername(String username) {
		return userR.findByUsername(username);
	}
	
	public Long saveUser(User user) {
		user.setActive(true);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Role role = roleR.findByType("BASIC");
		if(role == null) {
			role = createBasicRole();
		}
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		user.setRoles(roles);
		userR.save(user);

		return user.getId();
	}
	
	private Role createBasicRole() {
		Role role = new Role();
		role.setType("BASIC");
		
		return role;
	}
}
