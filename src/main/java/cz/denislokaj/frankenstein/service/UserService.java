package cz.denislokaj.frankenstein.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cz.denislokaj.frankenstein.common.dto.UserEntityI;
import cz.denislokaj.frankenstein.common.dto.UserSecurity;
import cz.denislokaj.frankenstein.data.dao.UserRepository;
import cz.denislokaj.frankenstein.data.entity.UserEntity;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	UserRepository repo;
	
	public List<UserEntityI> fetchUserList()
    {
        return List.copyOf(repo.findAll());
    }
	
	public void save(UserEntityI user) {
		repo.save((UserEntity) user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return new UserSecurity(repo.findByName(username));
	}
}
