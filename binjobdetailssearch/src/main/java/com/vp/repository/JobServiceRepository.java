package com.vp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vp.model.Jobdetails;

public interface JobServiceRepository extends JpaRepository<Jobdetails, Long>{

	@Query("select j from Jobdetails j where j.jobskills=:jobskills")
	List <Jobdetails>getJobsByJobskills(@Param("jobskills") String jobskills1);
	
	@Query("select j from Jobdetails j where j.jobname=:jobname")
	List <Jobdetails>getJobsByJobname(@Param("jobname") String jobname1);

	@Query("select j from Jobdetails j where j.companyname=:companyname")
	List <Jobdetails>getJobsByCompanyname(@Param("companyname") String companyname1);
	
	@Query("select j from Jobdetails j where j.salary=:salary")
	List <Jobdetails>getJobsBySalary(@Param("salary") String salary1);
	
	/*@Query("select * from Jobdetails where 'para' IN(jobskills,jobname,companyname,salary)")
	List <Jobdetails> findJobsByPara(@Param("para") String para1);*/
}

