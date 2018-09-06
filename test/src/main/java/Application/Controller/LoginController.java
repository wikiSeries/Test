package Application.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Application.Entity.User;
import Application.Service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userS;
	
	@RequestMapping(value= {"/", "/login"}, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("views/login");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView getRegistration() {
		User user = new User();

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("views/registration");

		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView registerNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userS.getUserByUsername(user.getUsername());
		if (userExists != null) {
			bindingResult.rejectValue("username", "error.username",
					"There is already a user registered with the username provided");
		}

		modelAndView.setViewName("views/registration");
		boolean hasError = bindingResult.hasErrors();
		if (hasError) {
			userS.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered succesfully");
			modelAndView.addObject("user", new User());
		}

		return modelAndView;
	}
	
}
