package com.vp.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.vp.exception.JobsRecordNotFoundException;
import com.vp.model.Jobdetails;
import com.vp.repository.JobServiceRepository;
import com.vp.specification.JobSpecificationWithJobCredentials;

@Service
@Transactional
public class JobSearchServiceImpl implements IJobSearchService{
	@Autowired
	JobServiceRepository jobServiceRepository;
	//sort
	public List <Jobdetails> findSortedJobs(String paramForSorted){
		return (List<Jobdetails>)jobServiceRepository.findAll(Sort.by(paramForSorted));
	}
	

//	public List <Jobdetails>getJobsByJobskills(String jobskills1)
//	{
//		return (List<Jobdetails>)jobServiceRepository.getJobsByJobskills(jobskills1);
//	}
//	
//	
//	public List <Jobdetails>getJobsByJobname(String jobname1)
//	{
//		return (List<Jobdetails>)jobServiceRepository.getJobsByJobname(jobname1);
//	}
//	
//	
//	public List <Jobdetails>getJobsByCompanyname(String companyname1)
//	{
//		return (List<Jobdetails>)jobServiceRepository.getJobsByCompanyname(companyname1);
//	}
//	
//	
//	public List <Jobdetails>getJobsBySalary(String salary1)
//	{
//		return (List<Jobdetails>)jobServiceRepository.getJobsBySalary(salary1);
//	}

//pagination
	
	@Override
	public List<Jobdetails> findPaginated(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		
		Pageable paging =PageRequest.of(pageNo, pageSize);
		Page<Jobdetails> pagedResult =jobServiceRepository.findAll(paging);
		return pagedResult.toList();
	}
	
	//Dynamic Search using specifications
	
	@Override
	public List<Jobdetails> getJobsByEachCategory(String jobname, String jobskills, String companyname, String salary,
			int pageno, int size) {
		// TODO Auto-generated method stub
		Pageable page=PageRequest.of(pageno, size, Sort.by("jobid").ascending());
		
		Page<Jobdetails> pageForJobDetails=jobServiceRepository.findAll(Specification.where(new JobSpecificationWithJobCredentials(jobname,jobskills,companyname,salary)),page);
		List<Jobdetails> listOfJobsReturned=new ArrayList<>();
		listOfJobsReturned=pageForJobDetails.toList();
		if(listOfJobsReturned.isEmpty()) {
			throw new JobsRecordNotFoundException();
		}
		else {
			return listOfJobsReturned;
		}
	}
	
}
