package Application.Controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Application.Model.Image;
import Application.Service.ImageService;

@Controller
public class HomeController {

	@Autowired
	private ImageService imageS;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Home(Model model) throws UnsupportedEncodingException {

		List <Application.Entity.Image> imagesEntity = imageS.getAllImages();
		List<Image> imagesModel = new ArrayList<Image>();
		
		for(Application.Entity.Image image : imagesEntity) {
			byte [] encodeBase64 = Base64.encodeBase64(image.getBytes());
			String base64Encoded = new String(encodeBase64, "UTF-8");
			String url = String.format("data:image/jpg;base64,%s", base64Encoded);
			imagesModel.add(new Image(url, image.getTitle(), image.getDescription())); 
		}
		
		model.addAttribute("images", imagesModel);
		return "views/home";
	}
}
