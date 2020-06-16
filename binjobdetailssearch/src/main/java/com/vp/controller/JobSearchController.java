package com.vp.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vp.exception.JobsRecordNotFoundException;
import com.vp.model.Jobdetails;
import com.vp.service.IJobSearchService;


@RestController
public class JobSearchController {
	
	Logger log = LoggerFactory.getLogger(JobSearchController.class);

	@Autowired
	IJobSearchService iJobSearchService;
	
	@GetMapping("getallsortedjobs/{sortedParam}")
	public List<Jobdetails> getAllSortedJobs(@PathVariable String sortedParam){
		log.info("all jobdetails are retrieved");
		 return iJobSearchService.findSortedJobs(sortedParam);
		
	}

//dynamic search
	@GetMapping(value = { "/getJobsByEachModified/{request1}" })
	public List<Jobdetails> getJobsByCategories2(
			@PathVariable(value = "request1", required = false) String request) {
		List<Jobdetails> listOfJobs = new ArrayList<Jobdetails>();
		
		if(listOfJobs.isEmpty()) {
			if(!request.isEmpty()) {
				listOfJobs=iJobSearchService.getJobsByJobskills(request);
				
				if(listOfJobs.isEmpty()) {
					listOfJobs=iJobSearchService.getJobsByCompanyname(request);
					if(listOfJobs.isEmpty()) {
						listOfJobs=iJobSearchService.getJobsByJobname(request);
						if(listOfJobs.isEmpty()) {
							listOfJobs=iJobSearchService.getJobsBySalary(request);
							if(listOfJobs.isEmpty()) {
								throw new JobsRecordNotFoundException();
							}
							else {
								log.info("all job details based on salary are retrieved");
								return listOfJobs;
							}
						}
						else {
							log.info("all job details based on jobname are retrieved");
							return listOfJobs;
						}
						
					}
					else {
						log.info("all job details based on companyname are retrieved");
						return listOfJobs;
					}
				}
				else {
					log.info("all job details based on jobskills are retrieved");
					return listOfJobs;
				}
			}
		}
		if (listOfJobs.isEmpty()) {
			throw new JobsRecordNotFoundException();
		}
		return listOfJobs;
	}

	
	
	//pagination
	@GetMapping("/getalljobdetails/{pageNo}/{pageSize}")
	public List<Jobdetails> getPaginated(@PathVariable int pageNo,@PathVariable int pageSize){
		return iJobSearchService.findPaginated(pageNo,pageSize);
	}
	
	
	
	
	
	
	/*@GetMapping("getalljobsbyjobskills/{jobskills}")
	public List<Jobdetails> getJobsByJobskills(@PathVariable String jobskills){
		 List<Jobdetails> jobDetails= iJobSearchService.getJobsByJobskills(jobskills);
		 if(jobDetails.isEmpty()) {
			  throw new JobsRecordNotFoundException();
		  }
		  return jobDetails;
			
		
	}
	
	@GetMapping("getalljobsbyjobname/{jobname}")
	public List<Jobdetails> getJobsByJobname(@PathVariable String jobname){
		// return iJobSearchService.getJobsByJobname(jobname);
		List<Jobdetails> jobDetails=	iJobSearchService.getJobsByJobname(jobname);
		  if(jobDetails.isEmpty()) {
			  throw new JobsRecordNotFoundException();
		  }
		  return jobDetails;
		
	}
	
	@GetMapping("getalljobsbycompanyname/{companyname}")
	public List<Jobdetails> getJobsByCompanyname(@PathVariable String companyname){
		// return iJobSearchService.getJobsByCompanyname(companyname);
		List<Jobdetails> jobDetails=	iJobSearchService.getJobsByCompanyname(companyname);
		  if(jobDetails.isEmpty()) {
			  throw new JobsRecordNotFoundException();
		  }
		  return jobDetails;
		
		
	}
	@GetMapping("getalljobsbysalary/{salary}")
	public List<Jobdetails> getJobsBySalary(@PathVariable String salary){
		// return iJobSearchService.getJobsBySalary(salary);
		List<Jobdetails> jobDetails=	iJobSearchService.getJobsBySalary(salary);
		  if(jobDetails.isEmpty()) {
			  throw new JobsRecordNotFoundException();
		  }
		  return jobDetails;
		
	}
	
	*/
	}


