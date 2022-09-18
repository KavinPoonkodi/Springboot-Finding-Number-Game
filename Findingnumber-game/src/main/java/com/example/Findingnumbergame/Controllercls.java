package com.example.Findingnumbergame;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Controllercls {
	static String str;
	
	@Autowired
	Repository rep;
	
	@Autowired
	Emailsendercls em;
	
  @RequestMapping("/index")
  public String first()
  {
	  return "index";
  }
  
  @RequestMapping("/step1")
  public String progessOne(Firsthelper fp) {
	 str=fp.getFullName();
	 String mil=fp.getEmail();
    rep.save(fp);int i=0;
    for(Firsthelper hp:rep.findAll()) {
    	String fin=hp.getEmail();
    	if(mil.equals(fin)) {
    		//System.out.println("taken");
    		i++;
    	}else {
    		//System.out.println("not taken");
    	}}
	 try {
	 String body="Thanks for your valuable time for attending this finding number by math tricks. Have fun. Follow your dreams. Thank you..! ";
 	String sub="Acknowlegement mail for visiting finding the number game";
	 em.sender(fp.getEmail(), sub, body);}
	 catch(Exception e) {
		 System.out.println(e);
	 }
	 if(i==1) {
 		return "step1";
 	}
	  return "index";
  }
  @RequestMapping("/step2")
  public String progrestwo() {
	  return "step2";
  }
  @RequestMapping("/result")
  public ModelAndView end(Helpercls hp, Model mm) {
	  ModelAndView mv=new ModelAndView();
	  int j=hp.getResult();
	 
	  int res=j-5;
	   mv.addObject("output",res);
//	  mv.addObject("hpp",hp);
//	  mm.addAttribute("moded",res);
	  System.out.println(j);
	  System.out.println(str);
	  
	  return mv;
  }
}
