package Application.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Application.Controller.HomeController;
import Application.Service.ImageService;

@Configuration
public class WebConfig {
	@Bean
	public HomeController homeController() {
	    return new HomeController();
	}
	
	@Bean
	public ImageService imageService() {
		return new ImageService();
	}
}
