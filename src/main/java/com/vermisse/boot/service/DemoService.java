package com.vermisse.boot.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import com.vermisse.boot.dao.*;

@Service
public class DemoService {
	
	@Autowired
	private DemoMapper mapper;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Map<String, Object>> getUser(){
		return mapper.getUser();
	}
}