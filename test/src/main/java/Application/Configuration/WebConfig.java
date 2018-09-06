package Application.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import Application.Controller.HomeController;
import Application.Controller.LoginController;
import Application.Service.ImageService;
import Application.Service.UserService;

@Configuration
public class WebConfig {
	@Bean
	public HomeController homeController() {
	    return new HomeController();
	}
	
	@Bean
	public LoginController loginController() {
	    return new LoginController();
	}
	
	@Bean
	public ImageService imageService() {
		return new ImageService();
	}
	
	@Bean
	public UserService userService() {
		return new UserService();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}
