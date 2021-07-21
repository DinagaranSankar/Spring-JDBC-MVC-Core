package com.springliveproject.sm.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.springliveproject.sm.dbPojoclass.Student;
import com.springliveproject.sm.dbdao.StudentDBDAO;
import com.springliveproject.sm.dto.StudentDTO;

@Service
public class StudentServiceImpl  implements StudentService
{
	            Logger logger  = Logger.getLogger(StudentServiceImpl. class. getName());
	            
	            @Autowired
	             private StudentDBDAO studentDBDAO;
	            
	             @Override
	              public List<Student> loadStudentData() 
	             {
	            	      logger.info("inside student service  loadstudentdata method call");
	            	      
	            	       List<Student>  studentData  = studentDBDAO. loadStudentData();
	            	       
	            	       logger.info(" load method call in service method  using studenrServiceImpl ");
	            	       
		                    return studentData;
	              }

				@Override
				public void insertStudentData(StudentDTO studentDTO) 
				{
					    logger.info("inside student service  InsertStudentData method call");
					    
					    studentDBDAO. insertStudentData(studentDTO);
					     
					    logger.info("After call studentDBDAO method using service imlements");
					    
					    if(studentDTO. getCountry() .equals("UK"))
					    {
					    	 logger.info(" Using service class  email service loaded from user"+"|"+studentDTO.getName()+"|");	
					    }
					
				}

				@Override
				public Student  getStudentDataUsingId(int Id) 
				{
					    logger.info("inside get Student Data method  Using service class");
					    
					    Student studentId =  studentDBDAO. getStudentDataUsingId(Id);
					    
					    logger.info(" fetch data from StudentDBDAOImpl class :" +"|"+studentId+"|");
					    
					    return studentId ;
				}

				@Override
				public void updateStudentData(StudentDTO studentDTO) 
				{
					    logger.info("inside update student data method");
					    
					    studentDBDAO. updateStudentData(studentDTO);
				}

				@Override
				public void deleteStudentData(int Id) 
				{
					    logger.info("inside service deletestudent data method");
					    
					     studentDBDAO. deleteStudentData(Id);
				}

}
