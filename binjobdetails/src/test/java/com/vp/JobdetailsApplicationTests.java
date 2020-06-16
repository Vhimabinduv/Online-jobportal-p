package com.vp;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.vp.model.Jobdetails;

import com.vp.repository.JobRepository;

import com.vp.service.JobServiceImpl;



@RunWith(SpringRunner.class)
@SpringBootTest
class JobdetailsApplicationTests {
	
	 @MockBean
	 JobRepository jobRepository;
	
	@Autowired
	JobServiceImpl jService;
	
	
	
	//test to get all jobs
	@Test
	public void  testgetJobdetails()
	{
		when(jobRepository.findAll()).thenReturn(Stream.of(new Jobdetails(113,"Assistantmanager","Python","cognizant","5LPA")).collect(Collectors.toList()));
	
		assertEquals(1,jService. getAllJobdetails().size());
	}
	
	///test to save user
	@Test
	public void saveJobToDBTest()
	{
		Jobdetails job=new Jobdetails(116,"juniordeveloper","Python","cognizant","5LPA");
        when(jobRepository.save(job)).thenReturn(job);
		
	}
	
	
}
