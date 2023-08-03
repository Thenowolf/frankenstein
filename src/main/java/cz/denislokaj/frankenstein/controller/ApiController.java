package cz.denislokaj.frankenstein.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import cz.denislokaj.frankenstein.common.dto.UserEntityI;
import cz.denislokaj.frankenstein.common.enums.UserRole;
import cz.denislokaj.frankenstein.data.entity.UserEntity;
import cz.denislokaj.frankenstein.service.UserService;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ApiController {
	
	@Autowired
	UserService users;

	@RequestMapping(value = "/user/all", method = RequestMethod.GET)
	public ResponseEntity<List<UserEntityI>> getUsers() {
		//users.fetchUserList().
		return new ResponseEntity<>(users.fetchUserList(), HttpStatus.OK);
		//return "Ahoj";
	}
	
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public ResponseEntity<String> test(){
		UserEntityI userA = new UserEntity();
		userA.setName("Denis");
		userA.setPassword(new BCryptPasswordEncoder().encode("demo"));
		userA.setRole(UserRole.ADMINISTRATOR);
		users.save(userA);
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}
}
