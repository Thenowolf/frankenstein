package cz.denislokaj.frankenstein;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cz.denislokaj.frankenstein.common.dto.UserEntityI;
import cz.denislokaj.frankenstein.common.enums.UserRole;
import cz.denislokaj.frankenstein.data.entity.UserEntity;
import cz.denislokaj.frankenstein.service.UserService;

@SpringBootApplication
public class FrankensteinApplication {
	@Autowired
	private static UserService users;
	
	public static void main(String[] args) {
		SpringApplication.run(FrankensteinApplication.class, args);
		/*UserEntityI userA = new UserEntity();
		userA.setName("Denis");
		userA.setPassword("nejlepsiHeslo");
		userA.setRole(UserRole.ADMINISTRATOR);
		users.save(userA);*/
	}

}
