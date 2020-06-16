package com.vp.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;


import com.vp.model.User;
import com.vp.repository.Userrepository;
@Service
@Transactional
public class Userservice implements IUserservice{
@Autowired
	Userrepository userrepository;
	
public List<User> getAllUser(){
	return (List<User>) userrepository.findAll();
}


public void saveUser(User user) {
	userrepository.save(user);
}






}
