package com.vp;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.vp.model.User;
import com.vp.repository.Userrepository;
import com.vp.service.Userservice;


@SpringBootTest
@RunWith(SpringRunner.class)
class CsuserloginApplicationTests {

	@MockBean
	Userrepository userRepository;
	
	@Autowired
	Userservice uService;
	
	
	
	//test to get all users
	@Test
	public void  testgetUsers()
	{
		when(userRepository.findAll()).thenReturn(Stream.of(new User(113L,"Susmitha","Pass1234","susmitha@gmail.com","user")
				,new User(223L,"Bindu","Pass12345","bindu@gmail.com","admin")).collect(Collectors.toList()));
	
		assertEquals(2,uService. getAllUser().size());
	}
	
	//test to save user
	@Test
	public void saveUserToDBTest()
	{
		User user=new User(114L,"Aruna","Pass12345","aruna@gmail.com","user");
        when(userRepository.save(user)).thenReturn(user);
		
	}
	
	
	
	
}

