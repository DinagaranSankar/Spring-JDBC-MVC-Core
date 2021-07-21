package com.springliveproject.sm.dbdao;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springliveproject.sm.dbPojoclass.Student;
import com.springliveproject.sm.dto.StudentDTO;
import com.springliveproject.sm.rowmapper.StudentRowMapper;

@Repository
public class StudentDBDAOImpl implements StudentDBDAO
{
	      Logger logger = Logger. getLogger ( StudentDBDAOImpl. class . getName() );
	       
	      @Autowired
	       private JdbcTemplate jdbcTemplate;
	       
	       @Override
	        public List<Student> loadStudentData() 
	        {
	    	        String sql = " SELECT * FROM STUDENTS ";
	   
	    	        List<Student> studentList   =  jdbcTemplate . query  ( sql, new StudentRowMapper() );
	    	        
	    	        logger.info( "using studentDBDAOImpl fetch data from db using rowmapper " + studentList  );
	    	        
		            return studentList;
	         }

	       @Override
	       public void insertStudentData(StudentDTO studentDTO) 
	       {
	    	  
	    	   String sql =  " INSERT INTO STUDENTS (NAME , MOBILE , COUNTRY) VALUES (? , ? ,  ? ) " ;
	    	   
	    	   Object [ ]    sqlParameter  =  { studentDTO. getName() , studentDTO. getMobile() , studentDTO. getCountry() };
	    	   
	    	   int update = jdbcTemplate .  update(sql ,  sqlParameter);
	    	   
	    	   if(update > 0)
	    	   {
	    		   logger. info(" 1  row insert record successfully" +"|"+update +"|");
	    	   }
	    	   else 
	    	   {
	    		   logger. info("Something went wrong check your code " +"|"+update +"|");
			    }

	       }

	       @Override
	       public Student getStudentDataUsingId(int Id)
	       {
	    	   logger. info(" inside  get student data method using id ");

	    	   String sql = " SELECT * FROM STUDENTS WHERE ID= ? ";

	    	   Student  studentId = jdbcTemplate. queryForObject(sql , new StudentRowMapper() , Id );
	    	   
	    	   logger. info("using id to fetch data from rowmapper "+"|"+studentId+"|");

	    	   return studentId ;
	       }
	       
	       @Override
	       public void updateStudentData(StudentDTO studentDTO) 
	       {
	    	      String sql = " UPDATE STUDENTS SET  NAME = ?, MOBILE = ?, COUNTRY = ? WHERE ID = ? ";

	    	      Object [] args = { studentDTO. getName() , studentDTO. getMobile() , studentDTO. getCountry() , studentDTO.getId() };
	    	   
	    	       int update = jdbcTemplate . update(sql , args ) ;
	    	       
	    	       if(update  > 0)
	    	       {
	    	    	   logger.info("1 row updated " +"|"+update+"|");
	    	       }
	    	       else 
	    	       {
	    	    	   logger.info(" no  row updated " +"|"+update+"|");
				    }
	       }

	       @Override
	       public void deleteStudentData(int Id) 
	       {
	    	      logger.info("inside delete student record method");
	    	      
	    	      String  sql  = " DELETE FROM STUDENTS WHERE ID = ? ";
	    	      
	    	       int count = jdbcTemplate. update(sql, Id );
	    	       
	    	       if(count > 0)
	    	       {
	    	    	    logger.info(" 1 Record Delete Successfully"+"|"+count +"|");
	    	       }
	    	       else 
	    	       {
					   logger.info(" No Record will be Deleted " +"|"+count+"|");
				    }
	       }

}

