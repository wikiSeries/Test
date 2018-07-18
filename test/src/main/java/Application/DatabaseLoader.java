package Application;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Application.Service.ImageService;

@Component
public class DatabaseLoader {
	
	@Autowired
	private ImageService imageS;
	
	@PostConstruct
	private void initDatabase() {
		
		Long id = imageS.saveImage("Imagen 1", "Descripcion de imagen 1", "static/img/1.jpg");
		Long id2 = imageS.saveImage("Imagen 2", "Descripcion de imagen 2","static/img/2.jpg");

	}
}
