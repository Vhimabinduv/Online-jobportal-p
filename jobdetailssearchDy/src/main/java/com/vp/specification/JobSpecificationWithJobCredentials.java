package com.vp.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.vp.model.Jobdetails;



public class JobSpecificationWithJobCredentials implements Specification<Jobdetails> {

	private static final long serialVersionUID = 1L;
	private String jobname;
	private String jobskills;
	private String companyname;
	private String salary;

	public JobSpecificationWithJobCredentials(String jobname, String jobskills, String companyname, String salary) {
		super();
		this.jobname = jobname;
		this.jobskills = jobskills;
		this.companyname = companyname;
		this.salary = salary;
	}

	@Override
	public Predicate toPredicate(Root<Jobdetails> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		if (jobskills == null && jobname == null && companyname == null) {
			return criteriaBuilder.equal(root.get("salary"), this.salary);
		} else if (jobskills == null && jobname == null && salary == null) {
			return criteriaBuilder.equal(root.get("companyname"), this.companyname);
		} else if (jobskills == null && companyname == null && salary == null) {
			return criteriaBuilder.equal(root.get("jobname"), this.jobname);
		} else if (companyname == null && jobname == null && salary == null) {
			return criteriaBuilder.equal(root.get("jobskills"), this.jobskills);
		} else if (jobskills == null && jobname == null) {
			return criteriaBuilder.and(criteriaBuilder.equal(root.get("companyname"), this.companyname),
					criteriaBuilder.equal(root.get("salary"), this.salary));
		} else if (jobskills == null && companyname == null) {
			return criteriaBuilder.and(criteriaBuilder.equal(root.get("jobname"), this.jobname),
					criteriaBuilder.equal(root.get("salary"), this.salary));
		} else if (jobskills == null && salary == null) {
			return criteriaBuilder.and(criteriaBuilder.equal(root.get("jobname"), this.jobname),
					criteriaBuilder.equal(root.get("companyname"), this.companyname));
		} else if (jobname == null && salary == null) {
			return criteriaBuilder.and(criteriaBuilder.equal(root.get("jobskills"), this.jobskills),
					criteriaBuilder.equal(root.get("companyname"), this.companyname));
		} else if (jobname == null && companyname == null) {
			return criteriaBuilder.and(criteriaBuilder.equal(root.get("jobskills"), this.jobskills),
					criteriaBuilder.equal(root.get("salary"), this.salary));
		} else if (salary == null && companyname == null) {
			return criteriaBuilder.and(criteriaBuilder.equal(root.get("jobskills"), this.jobskills),
					criteriaBuilder.equal(root.get("jobname"), this.jobname));
		} else if (jobskills == null) {
			return criteriaBuilder.and(
					criteriaBuilder.and(criteriaBuilder.equal(root.get("jobname"), this.jobname),
							criteriaBuilder.equal(root.get("companyname"), this.companyname)),
					criteriaBuilder.equal(root.get("salary"), this.salary));
		} else if (jobname == null) {
			return criteriaBuilder.and(
					criteriaBuilder.and(criteriaBuilder.equal(root.get("jobskills"), this.jobskills),
							criteriaBuilder.equal(root.get("companyname"), this.companyname)),
					criteriaBuilder.equal(root.get("salary"), this.salary));
		} else if (companyname == null) {
			return criteriaBuilder.and(
					criteriaBuilder.and(criteriaBuilder.equal(root.get("jobname"), this.jobname),
							criteriaBuilder.equal(root.get("jobskills"), this.jobskills)),
					criteriaBuilder.equal(root.get("salary"), this.salary));
		} else if (salary == null) {
			return criteriaBuilder.and(
					criteriaBuilder.and(criteriaBuilder.equal(root.get("jobname"), this.jobname),
							criteriaBuilder.equal(root.get("companyname"), this.companyname)),
					criteriaBuilder.equal(root.get("jobskills"), this.jobskills));
		} else if (jobskills == null && jobname == null && companyname == null && salary == null) {
			return criteriaBuilder.or(
					criteriaBuilder.or(criteriaBuilder.equal(root.get("jobskills"), this.jobskills),
							criteriaBuilder.equal(root.get("jobname"), this.jobname)),
					criteriaBuilder.or(criteriaBuilder.equal(root.get("companyname"), this.companyname),
							criteriaBuilder.equal(root.get("salary"), this.salary)));
		}

		return criteriaBuilder.and(
				criteriaBuilder.and(criteriaBuilder.equal(root.get("jobname"), this.jobname),
						criteriaBuilder.equal(root.get("companyname"), this.companyname)),
				criteriaBuilder.and(criteriaBuilder.equal(root.get("salary"), this.salary),
						criteriaBuilder.equal(root.get("jobskills"), this.jobskills)));
	}

}


