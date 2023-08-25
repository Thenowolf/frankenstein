package cz.denislokaj.frankenstein.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.denislokaj.frankenstein.common.dto.UserTaskI;
import cz.denislokaj.frankenstein.data.dao.UserTaskRepository;
import cz.denislokaj.frankenstein.data.entity.UserTask;

@Service
public class UserTaskService {

	@Autowired
	UserTaskRepository repo;
	
	public List<UserTaskI> fetchUserList()
    {
        return List.copyOf(repo.findAll());
    }
	
	public Optional<? extends UserTaskI> find(Long id) {
		return (Optional<? extends UserTaskI>) repo.findById(id);
	}
	
	public void save(UserTaskI task) {
		repo.save((UserTask) task);
	}
}
