package com.springliveproject.sm.dto;

import javax.validation.constraints.NotBlank;

import com.springliveproject.sm.customvalidator.Name;
import com.springliveproject.sm.customvalidator.Phone;

public class StudentDTO 
{
	   private  int Id;
	   @NotBlank(message = "{name.empty}")
	  @Name
       private String name;
	  @Phone
       private Long mobile;
       @NotBlank(message ="{Invalid.empty}")
       private String country;
       
       public int getId() {
    	   return Id;
       }
       public void setId(int id) {
    	   Id = id;
       }
       public String getName() {
    	   return name;
       }
       public void setName(String name) {
    	   this.name = name;
       }
       public Long getMobile() {
    	   return mobile;
       }
       public void setMobile(Long mobile) {
    	   this.mobile = mobile;
       }
       public String getCountry() {
    	   return country;
       }
       public void setCountry(String country) {
    	   this.country = country;
       }
       
       @Override
	public String toString() {
		return "StudentDTO [Id=" + Id + ", name=" + name + ", mobile=" + mobile + ", country=" + country + "]";
	}
}
