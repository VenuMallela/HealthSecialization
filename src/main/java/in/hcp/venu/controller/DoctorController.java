 package in.hcp.venu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.hcp.venu.entity.Doctor;
import in.hcp.venu.exception.DoctorNotFoundException;
import in.hcp.venu.service.IDoctorService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
     @Autowired
	private IDoctorService service;
     
     @GetMapping("/register")
     public String showRegister(
    		 @RequestParam(value="message",required=false)String message,
    		 Model model) {
    	 model.addAttribute("message",message);
    	 return "DoctorRegister";
     }
     @PostMapping("/save")
 	public String save(
 			@ModelAttribute Doctor doctor,
 			RedirectAttributes attributes
 			)
 	{
 		Long id = service.saveDoctor(doctor);
 		attributes.addAttribute("message", "Doctor ("+id+") is created");
 		return "redirect:register";
 	}
     @GetMapping("/all")
      public String display(
    		  @RequestParam(value="message",required=false)String message,
    		  Model model) {
    	 List<Doctor> list= service.getAllDoctors();
    	model.addAttribute("list",list);
    	model.addAttribute("message",message);
    	  return"DoctorData";
      }
     @GetMapping("/delete")
     public String deleteData(@RequestParam("id")Long id,
    		                    RedirectAttributes attributes) {
    	 String message=null;
    	 try {
    		service.removeDoctor(id);
    		message="Doctor("+id+") is removed";
    	 }catch(DoctorNotFoundException e) {
    		 e.printStackTrace();
    		 message=e.getMessage();
    	 }
    	 attributes.addAttribute("message",message);
    	 
    	 return "redirect:all";
     }
     
}
