package Application;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Application.Entity.User;
import Application.Service.ImageService;
import Application.Service.UserService;

@Component
public class DatabaseLoader {
	@Autowired
	private UserService userS;
	
	@Autowired
	private ImageService imageS;
	
	@PostConstruct
	private void initDatabase() {
		
		User user = new User();
		user.setName("Aaron");
		user.setSurname("Velasco Lopez");
		user.setEmail("arn94x@hotmail.com");
		user.setUsername("arnadmin");
		user.setPassword("arnadmin123");
		
		Long idU = userS.saveUser(user);
		
		Long id = imageS.saveImage("Imagen 1", "Descripcion de imagen 1", "static/img/1.jpg");
		Long id2 = imageS.saveImage("Imagen 2", "Descripcion de imagen 2","static/img/2.jpg");

	}
}
