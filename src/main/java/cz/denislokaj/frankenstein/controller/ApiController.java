package cz.denislokaj.frankenstein.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import cz.denislokaj.frankenstein.common.dto.UserEntityI;
import cz.denislokaj.frankenstein.common.dto.UserTaskI;
import cz.denislokaj.frankenstein.common.enums.UserRole;
import cz.denislokaj.frankenstein.data.entity.UserEntity;
import cz.denislokaj.frankenstein.service.UserService;
import cz.denislokaj.frankenstein.service.UserTaskService;

import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api")
public class ApiController {
	
	@Autowired
	UserService userService;
	@Autowired
	UserTaskService taskService;

	@RequestMapping(value = "/user/all", method = RequestMethod.GET)
	public ResponseEntity<List<UserEntityI>> getUsers() {
		//users.fetchUserList().
		return new ResponseEntity<>(userService.fetchUserList(), HttpStatus.OK);
		//return "Ahoj";
	}
	
	@RequestMapping(value = "/user/signup", method = RequestMethod.POST)
	public ResponseEntity createUser(@RequestBody UserEntity userA) {
		//users.fetchUserList().
		userService.save(userA);
		return new ResponseEntity<>(HttpStatus.OK);
		//return "Ahoj";
	}
	
	@RequestMapping(value = "/task/add", method = RequestMethod.POST)
	public ResponseEntity createTask(@RequestBody UserTaskI task) {
		//users.fetchUserList().
		taskService.save(task);
		return new ResponseEntity<>(HttpStatus.OK);
		//return "Ahoj";
	}
	
	@RequestMapping(value = "/task/{id}", method = RequestMethod.POST)
	public ResponseEntity getTask(@PathVariable Long id) {
		//users.fetchUserList().
		//taskService.find(id);
		//taskService.save(task);
		return new ResponseEntity<>(taskService.find(id), HttpStatus.OK);
		//return "Ahoj";
	}
	
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public ResponseEntity<String> test(){
		UserEntityI userA = new UserEntity();
		userA.setName("Denis");
		userA.setPassword(new BCryptPasswordEncoder().encode("demo"));
		userA.setRole(UserRole.ADMINISTRATOR);
		userService.save(userA);
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}
}
