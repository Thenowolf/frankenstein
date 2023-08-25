package cz.denislokaj.frankenstein.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cz.denislokaj.frankenstein.data.entity.UserEntity;
import cz.denislokaj.frankenstein.data.entity.UserTask;

@Repository
public interface UserTaskRepository extends JpaRepository<UserTask, Long> {

}
