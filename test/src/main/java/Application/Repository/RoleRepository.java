package Application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Application.Entity.Role;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Long>{
	
	public Role findByType(String type);
	
}
