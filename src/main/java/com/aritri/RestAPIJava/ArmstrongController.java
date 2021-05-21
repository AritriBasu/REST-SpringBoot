package com.aritri.RestAPIJava;

import org.springframework.web.bind.annotation.GetMapping;   
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;    

@Controller
public class ArmstrongController {
	
	@RequestMapping("/")    
	public String index()  
	{ 
	 //input template
	 return"index";    
	}    
	
	@GetMapping("/checkArmstrong")
	public String checkArmstrong(@RequestParam(name="name", required=false) int name, Model model) {
		
		//Armstrong checking logic
		String outText;
		int num=name;
		int temp=num;
		int countDigits=0;
		while(num!=0) {
			num/=10;
			countDigits++;
		}
		num=temp;
		int d;
		double sum=0;
	    while(num>0)  
	    {  
	    d=num%10;  
	    sum=sum+Math.pow(d,countDigits);
	    num=num/10; 
	    }  
	    if(temp==sum)  
	    	outText=temp+" is an Armstrong number!";   
	    else  
	    	outText=temp+" is not an Armstrong number!";  
		
		//setting output text
		model.addAttribute("output", outText);
		
		//output template
		return "armstrong_output";
	}
}
