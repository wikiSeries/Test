package Application.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import Application.Entity.Image;
import Application.Repository.ImageRepository;


public class ImageService{
	
	@Autowired
	private ImageRepository imageR;

	public Long saveImage(String title, String description, String path) {
		try {
			ClassPathResource imgFile = new ClassPathResource(path);
			byte [] imgFileBytes = new byte[(int) imgFile.contentLength()];
			imgFile.getInputStream().read(imgFileBytes);
			Image image = new Image(title, description, imgFileBytes);
			System.out.println(imageR.count());
			imageR.save(image);
			return image.getId();
			
			
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
	
	public List<Image> getAllImages(){
		return imageR.findAll();
	}
}
