package Application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Application.Entity.Image;

public interface ImageRepository extends JpaRepository<Image, Long>{

}


