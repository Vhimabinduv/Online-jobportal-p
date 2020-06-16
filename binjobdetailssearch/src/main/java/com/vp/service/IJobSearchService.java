package com.vp.service;

import java.util.List;

import com.vp.model.Jobdetails;

public interface IJobSearchService {
List <Jobdetails> findSortedJobs(String paramForSorted);
	
	List <Jobdetails>getJobsByJobskills( String jobskills1);
	
	List <Jobdetails>getJobsByJobname( String jobname1);
	
	List <Jobdetails>getJobsByCompanyname( String companyname1);
	
	List <Jobdetails>getJobsBySalary( String salary1);

	List<Jobdetails> findPaginated(int pageNo, int pageSize);
	
	
}
