package com.qadashboard.qadashboardprojectdetails.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qadashboard.qadashboardprojectdetails.models.ProjectDetail;

@Repository
public interface ProjectDetailRepository extends JpaRepository<ProjectDetail, Long> {
	
    Page<ProjectDetail> findByBusinessPortfolioName(String businessPortfolioName, Pageable pageable);
    List<ProjectDetail> findByBusinessPortfolioName(String businessPortfolioName);
    
    //Optional<ProjectDetail> findByIdAndPostId(Long id, Long postId);
    //List<Comment> findByIdAndPostId(Long id, Long postId);
    
    /*@Query(nativeQuery=true, value="select project_name, release_time, sum(total_testcase) as total "
    		+ "from projectdetails group by project_name, release_time order by release_time desc")
    List<Object[]> countTotalTestCaseInProjectName();*/
    
    @Query(nativeQuery=true, value="select project_name, sum(total_passed)/sum(total_testcase)*100 as totalPasses, "
    		+ "sum(total_failed)/sum(total_testcase)*100 "
    		+ "from projectdetails where testing_type = ?1 group by project_name order by release_time desc")
    List<Object[]> countTotalTestCaseInProjectName(String releaseType);
    
    
    @Query(nativeQuery=true, value="select release_time, sum(total_passed)/sum(total_testcase)*100 as totalPassed, "
    		+ "sum(total_failed)/sum(total_testcase)*100 "
    		+ "from projectdetails where testing_type = ?1 group by release_time order by "
    		+ "release_time desc limit 5")
    List<Object[]> countTotalTestCasePassedInRelease(String testingType);
    
}

//    		+ "(select distinct release_time from projectdetails order by release_time asc limit 2) as v2 "