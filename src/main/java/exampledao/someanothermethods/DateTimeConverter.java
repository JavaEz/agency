package exampledao.someanothermethods;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeConverter {

	// Function tot convert String to Date 
    public static LocalDate getDateFromString(String string) 
    { 
    	 DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
        // Convert the String to Date in the specified format 
        LocalDate date = LocalDate.parse(string, format); 
  
        // return the converted date 
        return date; 
    } 
    
    public static Date toSqlDate (String string) {
    	
    	 DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
    	
    	 java.sql.Date sqlDate = java.sql.Date.valueOf(LocalDate.parse(string, format));
    			 
    			 return sqlDate;
    	
    }
	
}
