package com.project.note.service;

import java.util.List;

import com.project.note.model.Category;
import com.project.note.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public void create(Category category) {
		categoryRepository.save(category);
	}

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}
}
