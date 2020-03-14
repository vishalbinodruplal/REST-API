package com.qadashboard.qadashboardprojectdetails.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qadashboard.qadashboardprojectdetails.models.ProjectDetail;
import com.qadashboard.qadashboardprojectdetails.projections.OverAllSITStatus;
import com.qadashboard.qadashboardprojectdetails.repository.ProjectDetailRepository;

@RestController
@CrossOrigin("http://localhost:4200")
public class ProjectDetailController {
	
	@Autowired
	private ProjectDetailRepository projectDetailRepository;
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/business/{portfolioName}/projectdetail")
    public List<ProjectDetail> getAllProjectDetailByBusinessPortfolioName(@PathVariable (value = "portfolioName") String portfolioName) {
        return projectDetailRepository.findByBusinessPortfolioName(portfolioName);
    }
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/business/{portfolioName}/projectdetail/pages")	///posts/{postId}/comments?page=0&size=3&sort=createdAt,desc
    public Page<ProjectDetail> getAllCommentsByPostId(@PathVariable (value = "portfolioName") String portfolioName,
                                                Pageable pageable) {
        return projectDetailRepository.findByBusinessPortfolioName(portfolioName, pageable);
    }
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/overallpass/{testingType}")
	public List<Object[]> getTotalTestCaseCount(@PathVariable String testingType){
		return projectDetailRepository.countTotalTestCaseInProjectName(testingType);
	}
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/overallpassed/{testingType}")
	public List<OverAllSITStatus> getTotalTestCasePassedInRelease(@PathVariable String testingType){
		List<Object[]> o = projectDetailRepository.countTotalTestCasePassedInRelease(testingType);
		List<OverAllSITStatus> overAllSitStatus = new ArrayList<>();
		o.forEach(obj -> {
			overAllSitStatus.add(new OverAllSITStatus(obj[0]+"", Double.parseDouble(obj[1]+""), Double.parseDouble(obj[2]+"")));
		});
		
		System.out.print(overAllSitStatus);
		return overAllSitStatus;
	}

}
