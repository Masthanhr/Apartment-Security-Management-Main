package com.cg.aps.controller;
	import java.util.List;

	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpSession;
	import javax.validation.Valid;

	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.MediaType;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.ExceptionHandler;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	import com.cg.aps.entities.Admin;
	import com.cg.aps.service.IAdminService;

	@RestController
	@RequestMapping("/aps/admin")
	public class AdminController {

		@Autowired
		IAdminService service;

		Logger logger = LoggerFactory.getLogger(AdminController.class);

		@ExceptionHandler
	    @PostMapping("/addAdmin")
	    public ResponseEntity<String> addAdmin(@Valid @RequestBody Admin admin, HttpServletRequest request) {
	        logger.info("Inside addAdmin method");
	        HttpSession session = request.getSession();
	        Admin sessionUser = (Admin) session.getAttribute("UserExists");
	        logger.info("Session User" + sessionUser);
	        if(sessionUser != null) {
	            Admin adminData = service.addNewAdmin(admin);
	            if(adminData!=null)
	            return new ResponseEntity<>("Added successfully", HttpStatus.OK);
	            else
	                return new ResponseEntity<>("User not added", HttpStatus.OK);
	        }
	       
	        else {
	            return new ResponseEntity<>("Login to add user", HttpStatus.BAD_REQUEST);
	        }

	    }
	   
	    @GetMapping(value="/{roleId}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Admin> userAdmin(@PathVariable(value="roleId") String roleId,
	                @PathVariable(value="password") String password, HttpServletRequest request ) {
	            HttpSession session = request.getSession();
	            Admin user=service.adminLogin(roleId, password);
	                if(user!=null)
	                {
	                    session.setAttribute("UserExists", user);
	                   
	                    logger.info( "Login successfully!" +user);
	                    return new ResponseEntity<>(user, HttpStatus.CREATED);
	                }
	                else
	                {
	                    logger.info("Login Failed!!!");
	                   
	                    return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
	                }
	    }
	    
	    
		@PostMapping("/signIn")
		public ResponseEntity<String> adminSignin(@Valid @RequestBody Admin admin) {
			logger.info("Inside adminSignin method");
			Admin adminData = service.signIn(admin);

			return new ResponseEntity<String>("Sign in succesful, welcome admin: " + adminData.getAdminId(), HttpStatus.OK);
		}

		@PostMapping("/signOut")
		public ResponseEntity<String> adminSignOut(@Valid @RequestBody Admin admin, HttpServletRequest request) {
			HttpSession session = request.getSession();
			session.removeAttribute("UserExists");
			session.invalidate();
			logger.info("Inside adminSignOut method");
			Admin adminData = service.signOut(admin);

			return new ResponseEntity<String>("Sign Out succesfull, Bye admin: " + adminData.getAdminId(), HttpStatus.OK);
		}

		@GetMapping("/getAllAdmin")
		public ResponseEntity<List<Admin>> getAllAdmins() {
			logger.info("Inside getAllAdmins method");
			List<Admin> adminList = service.getAll();
			return new ResponseEntity<List<Admin>>(adminList, HttpStatus.OK);
		}


	}


