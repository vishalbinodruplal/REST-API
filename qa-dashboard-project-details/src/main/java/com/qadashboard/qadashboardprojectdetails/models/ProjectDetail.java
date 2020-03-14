package com.qadashboard.qadashboardprojectdetails.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
 * Extend AuditModel to this call to implement the JPA Auditing
 */
@Entity
@Table(name = "projectdetails")
public class ProjectDetail {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotNull
    @Lob
    @Column(name = "project_name")
    private String projectName;
	
	@NotNull
    @Lob
    @Column(name = "release_time")
    private String releaseTime;
	
	@NotNull
    @Lob
    @Column(name = "resource_name")
    private String resourceName;
	
	@NotNull
    @Lob
    @Column(name = "testing_type")
    private String testingType;
	
	@NotNull
    @Column(name = "total_failed")
    private Long totalFailed;
	
	@NotNull
    @Column(name = "total_passed")
    private Long totalPassed;
	
	@NotNull
    @Column(name = "total_skipped")
    private Long totalSkipped;
	
	@NotNull
    @Column(name = "total_testcase")
    private Long totalTestcase;
	
	
	/*
    @NotNull
    @Lob
    private String text;*/

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "business_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Business business;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public String getReleaseTime() {
		return releaseTime;
	}


	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}


	public String getResourceName() {
		return resourceName;
	}


	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}


	public String getTestingType() {
		return testingType;
	}


	public void setTestingType(String testingType) {
		this.testingType = testingType;
	}


	public Long getTotalFailed() {
		return totalFailed;
	}


	public void setTotalFailed(Long totalFailed) {
		this.totalFailed = totalFailed;
	}


	public Long getTotalPassed() {
		return totalPassed;
	}


	public void setTotalPassed(Long totalPassed) {
		this.totalPassed = totalPassed;
	}


	public Long getTotalSkipped() {
		return totalSkipped;
	}


	public void setTotalSkipped(Long totalSkipped) {
		this.totalSkipped = totalSkipped;
	}


	public Long getTotalTestcase() {
		return totalTestcase;
	}


	public void setTotalTestcase(Long totalTestcase) {
		this.totalTestcase = totalTestcase;
	}


	public Business getBusiness() {
		return business;
	}


	public void setBusiness(Business business) {
		this.business = business;
	}
    
	/*public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}*/
    
    // Getters and Setters (Omitted for brevity)
    
}