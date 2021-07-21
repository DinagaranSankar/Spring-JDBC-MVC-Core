package com.springliveproject.sm.dbdao;

import java.util.List;

import com.springliveproject.sm.dbPojoclass.Student;
import com.springliveproject.sm.dto.StudentDTO;

public interface StudentDBDAO 
{
      List<Student>  loadStudentData();
      
      void insertStudentData(StudentDTO studentDTO);
      
      Student  getStudentDataUsingId(int Id);
      
      void updateStudentData(StudentDTO studentDTO);
      
      void deleteStudentData(int Id);
}
