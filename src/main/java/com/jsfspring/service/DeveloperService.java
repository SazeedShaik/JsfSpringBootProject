package com.jsfspring.service;
import java.util.List;

import com.jsfspring.pojo.Developer;

public interface DeveloperService {
	Developer saveDeveloper(Developer developer);
	List<Developer> fetchAllDeveloper();
}