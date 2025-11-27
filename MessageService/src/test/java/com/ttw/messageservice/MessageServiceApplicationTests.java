package com.ttw.messageservice;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MessageServiceApplicationTests {
	Calendar cal = Calendar.getInstance();
	Date date = cal.getTime();

    @Test
    void contextLoads() {
    	
    	
    	
    }
    @Test
    public void hello() {
		System.out.println(date.toString());
	}

}
