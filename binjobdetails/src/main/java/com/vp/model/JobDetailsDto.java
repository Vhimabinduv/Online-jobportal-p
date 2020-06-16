package com.vp.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class JobDetailsDto implements Serializable {

	private static final long serialVersionUID =5049730970690887263L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Jobid;
	@NotBlank(message="add a jobname")
	private String jobname;
	@NotEmpty(message="jobskills cannot be empty")
	private String jobskills;
	 @NotNull(message = "Name of company must not be empty")
	private String companyname;
	 @NotNull(message = "salary must not be empty")
	private String salary;
	
//getter ans setter methods
	 public int getJobid() 
	 {
		return Jobid;
	}
	 
	public void setJobid(int jobid)
	{
		Jobid = jobid;
	}
	
	public String getJobname()
	{
		return jobname;
	}
	
	public void setJobname(String jobname)
	{
		this.jobname = jobname;
	}
	
	public String getJobskills()
	{
		return jobskills;
	}
	
	public void setJobskills(String jobskills)
	{
		this.jobskills = jobskills;
	}
	
	public String getCompanyname()
	{
		return companyname;
	}
	
	public void setCompanyname(String companyname)
	{
		this.companyname = companyname;
	}
	
	public String getSalary() 
	{
		return salary;
	}
	
	public void setSalary(String salary) 
	{
		this.salary = salary;
	}
	
}
