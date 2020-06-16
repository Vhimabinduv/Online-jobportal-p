package com.vp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vp.model.Jobdetails;
import com.vp.repository.JobServiceRepository;

@Service
@Transactional
public class JobSearchServiceImpl implements IJobSearchService{
	@Autowired
	JobServiceRepository jobServiceRepository;
	
	public List <Jobdetails> findSortedJobs(String paramForSorted){
		return (List<Jobdetails>)jobServiceRepository.findAll(Sort.by(paramForSorted));
	}
	

	public List <Jobdetails>getJobsByJobskills(String jobskills1)
	{
		return (List<Jobdetails>)jobServiceRepository.getJobsByJobskills(jobskills1);
	}
	
	
	public List <Jobdetails>getJobsByJobname(String jobname1)
	{
		return (List<Jobdetails>)jobServiceRepository.getJobsByJobname(jobname1);
	}
	
	
	public List <Jobdetails>getJobsByCompanyname(String companyname1)
	{
		return (List<Jobdetails>)jobServiceRepository.getJobsByCompanyname(companyname1);
	}
	
	
	public List <Jobdetails>getJobsBySalary(String salary1)
	{
		return (List<Jobdetails>)jobServiceRepository.getJobsBySalary(salary1);
	}


	@Override
	public List<Jobdetails> findPaginated(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		
		Pageable paging =PageRequest.of(pageNo, pageSize);
		Page<Jobdetails> pagedResult =jobServiceRepository.findAll(paging);
		return pagedResult.toList();
	}
	
	
	
}
