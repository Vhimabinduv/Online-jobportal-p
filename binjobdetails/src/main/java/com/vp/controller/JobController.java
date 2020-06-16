package com.vp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vp.exception.JobNotFoundException;
import com.vp.model.JobDetailsDto;
import com.vp.model.Jobdetails;
import com.vp.service.IJobService;



@RestController
@RequestMapping("/security")
public class JobController {
	@Autowired
	IJobService jobServiceInterface;
	
	//get all jobs
	
	@GetMapping("/jobs") 
	public List<Jobdetails> getJobdetails(){
		return jobServiceInterface.getAllJobdetails();
	}
	
	// add a job
	@PostMapping("/addjob")
	public void insertJob(@Valid @RequestBody JobDetailsDto job)
	{
		jobServiceInterface.createJob(job);
	}
	
	//delete job by id
	
	@RequestMapping(value = "/delete/{Jobid}", method = RequestMethod.DELETE)
	public HttpStatus deleteJob(@PathVariable Integer Jobid) 
	{
		jobServiceInterface.deletejob(Jobid);
		return HttpStatus.NO_CONTENT;
	}
	
	
	//update user by id
	
	@PutMapping("/update/{Jobid}")
	public ResponseEntity updateJob(@RequestBody Jobdetails jobdetails,@PathVariable Integer Jobid) 
	{
		jobServiceInterface.updateJob(Jobid,jobdetails);
		return new ResponseEntity<>( jobServiceInterface.updateJob(Jobid,jobdetails),HttpStatus.OK);
		
	}
	
	
	
}
	




/*	// update

@RequestMapping(value = "/addjobs", method = RequestMethod.PUT)
public HttpStatus updateJobdetails(@RequestBody Jobdetails jobdetails)
{
	return jobServiceInterface.updatejobdetails(jobdetails)  ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;

}*/
/*@PostMapping("/addjobs")
public void insertJobdetails(@Valid @RequestBody Jobdetails jobdetails) {
	jobServiceInterface.saveJob(jobdetails);
}*/

/*@PutMapping(value="/users{/id}")
public UserDemo updateUser(@RequestBody UserDemo userdemo,@PathVariable (value="id")long userId) {
UserDemo existingUser=	this.userrepository.findById(userId)
	.orElseThrow(()-> new UserNotFoundException("user not found with id:" +userId) );
existingUser.setFirstName(userdemo.getFirstName());
existingUser.setLastName(userdemo.getLastName());
existingUser.setEmail(userdemo.getEmail());
return this.userrepository.save(existingUser);
}*/