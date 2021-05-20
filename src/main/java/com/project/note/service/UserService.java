package com.project.note.service;

import java.util.List;

import com.project.note.model.User;
import com.project.note.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void create(User user) {
		userRepository.save(user);
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}
}
