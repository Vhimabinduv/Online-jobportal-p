package com.vp.service;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.vp.exception.JobNotFoundException;
import com.vp.model.JobDetailsDto;
import com.vp.model.Jobdetails;

public interface IJobService {

	public List<Jobdetails> getAllJobdetails();
	//public void saveJob(Jobdetails jobdetails);
	//public boolean updatejobdetails(Jobdetails jobdetails);
	public String deletejob(Integer Jobid) throws JobNotFoundException;
	public String updateJob(Integer jobid, Jobdetails jobdetails);
	
	public JobDetailsDto createJob(JobDetailsDto job);

}

