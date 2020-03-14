package com.qadashboard.qadashboardprojectdetails.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
 * Extend AuditModel to this call to implement the JPA Auditing
 */
@Entity
@Table(name = "business")
public class Business {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;*/
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Id
	@Size(max = 100)
    @Column(name = "portfolio_name")
	private String portfolioName;

/*    @NotNull
    @Size(max = 100)
    @Column(unique = true)
    private String title;

    @NotNull
    @Size(max = 250)
    private String description;

    @NotNull
    @Lob
    private String content;*/
    
    public Business(){
    	
    }

	/*public Business(@NotNull @Size(max = 100) String title,
			@NotNull @Size(max = 250) String description,
			@NotNull String content) {
		super();
		this.title = title;
		this.description = description;
		this.content = content;
	}*/

/*	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPortfolioName() {
		return portfolioName;
	}

	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}
	
    // Getters and Setters (Omitted for brevity)
    
}