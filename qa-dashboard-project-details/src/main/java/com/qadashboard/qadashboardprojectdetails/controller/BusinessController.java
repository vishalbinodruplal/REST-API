package com.qadashboard.qadashboardprojectdetails.controller;

import io.micrometer.core.ipc.http.HttpSender.Response;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qadashboard.qadashboardprojectdetails.MyUserDetailsService;
import com.qadashboard.qadashboardprojectdetails.models.AuthenticationRequest;
import com.qadashboard.qadashboardprojectdetails.models.AuthenticationResponse;
import com.qadashboard.qadashboardprojectdetails.models.Business;
import com.qadashboard.qadashboardprojectdetails.repository.BusinessRepository;
import com.qadashboard.qadashboardprojectdetails.util.JwtUtil;

@RestController
public class BusinessController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@Autowired
    private BusinessRepository businessRepository;
	
	/*
	 * This annotation to handle Cross-Origin-Resource-Sharing (CORS).
	 * This annotation is used at class level as well as method level in RESTful Web service controller.
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/businesses")
    public List<Business> getAllBusiness() {
        return businessRepository.findAll();
    }
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
				throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
					);
		} catch (BadCredentialsException e){
			throw new Exception("Incorrect Usename or Password : " + e);
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		
		System.out.print(jwt);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

}
