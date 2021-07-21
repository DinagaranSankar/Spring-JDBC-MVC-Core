package com.springliveproject.sm.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springliveproject.sm.dbPojoclass.Student;
import com.springliveproject.sm.dto.StudentDTO;
import com.springliveproject.sm.service.StudentService;

@Controller
public class StudentController 
{
	  Logger logger = Logger. getLogger ( StudentController. class . getName() );
	 
	   @Autowired
	    private StudentService  studentService;
	  
	   @GetMapping("/showStudentPage")
        public String showStudentData(Model model)
        {
		    //database code placed here from service layer
		      List<Student> studentData = studentService. loadStudentData();
		      
		      logger.info(" fetching record from service impl to database "+"|"+studentData+"|");
			      
		      model.addAttribute("students", studentData);
		   
    	       return "studentPage";
         }
	   
	   @GetMapping("/addStudent")
	   public String showAddStudentData(Model model , StudentDTO studentDTO)
	   {
		         model. addAttribute("studentDTO", studentDTO);
		         
		         return "addStudentPage";
	   }
	   
	   @PostMapping("/saveStudentData")
	   public String showSaveStudentData(@Valid StudentDTO studentDTO , BindingResult result )
	   {  
		       logger. info("fetching the value from url  using method post "+"|"+ studentDTO+"|");
		       
		       if(result . hasErrors())
		       {
		    	    List<ObjectError> allErrors  = result. getAllErrors();
		    	    
		    	    for(var tempError : allErrors)
		    	    {
		    	    	logger. info("display error message "+"|"+ tempError+"|");
		    	    }
		    	    return "addStudentPage";
		       }
		       
		       //To call a method  insertStudentData on using studentServiceImpl class
		       //if user does not have a id then insert
		       if(studentDTO. getId() == 0)
		       {
		    	   studentService. insertStudentData(studentDTO);	       
		       }
		       else 
		       {
		    	   studentService. updateStudentData(studentDTO);	  
			   }
		      
		       //not shown any value to database because method gives as a post
		       //again redirect to student page
		       return "redirect:/showStudentPage";
	   }
	   /*@ResponseBody
	   @GetMapping("/thankyou")
	   public String thankyou()
	   {
		   return " Thank You.. Your  New Student  Data  has been Inserted Successfully ";
	   }*/
	   
	   @GetMapping("/updateStudent")
	   public String showUpdateStudentData(@RequestParam ("StudentId") int  studentId , Model  model )
	   {       
		        logger. info("fetch Student data from url that is id data :"+"|"+studentId+"|");
		       
		        Student studentDataUsingId = studentService. getStudentDataUsingId(studentId);
		        
		        logger. info("fetch Student data from studentservice class  :"+"|"+studentDataUsingId+"|");
		        
		        model. addAttribute("studentDTO", studentDataUsingId);
		        	        
		         return "addStudentPage";
	   }
	   
	   @GetMapping("/deleteStudent")
	   public String showDeleteStudentData(@RequestParam ("StudentId") int studentId)
	   {
		        logger. info("fetch student id  data from url "+"|"+studentId+"|");
		        
		         //Create a new Method in service interface
		         studentService. deleteStudentData(studentId );
		         
		         return  "redirect:/showStudentPage";  
	   }
}
