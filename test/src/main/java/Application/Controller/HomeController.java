package Application.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Application.Model.Image;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Home(Model model) {
		List<Image> images = new ArrayList<Image>();
		for(int i = 1; i < 3; i++) {
			images.add(new Image("../../img/" + i + ".jpg", "imagen " + i, "esta es la imagen " + i));
		}
		model.addAttribute("images", images);
		
		return "views/home";
	}
}
