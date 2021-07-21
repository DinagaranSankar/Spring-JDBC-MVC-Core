package com.springliveproject.sm.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import org.springframework.jdbc.core.RowMapper;

import com.springliveproject.sm.dbPojoclass.Student;

public class StudentRowMapper  implements RowMapper<Student>
{
	        Logger logger = Logger. getLogger ( StudentRowMapper. class . getName() );
	        
	        // This method fetch record from database
	        @Override
	        public Student mapRow(ResultSet rs, int rowNum) throws SQLException 
	        {
	        	      //fetch record using result Set one by one and set it to student Pojo class
	        	       logger.info( " using rowmapper " +"|"+ rs+"|" +rowNum+"|" ) ;
	        	       
	        	       Student student = new Student();
	        	       
	        	       student.setId(rs.getInt("ID"));
	        	       student.setName( rs.getString("NAME"));
	        	       student.setMobile(rs.getLong("MOBILE"));
	        	       student.setCountry(rs.getString("COUNTRY"));
	        	       
	        	       logger.info( "inside calling rowmapper method" ) ;
	        	       
	        	       return student;
	        }

}
