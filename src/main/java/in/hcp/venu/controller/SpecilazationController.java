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
import org.springframework.web.servlet.ModelAndView;

import in.hcp.venu.entity.Specilazation;
import in.hcp.venu.service.SpeclizationService;
import in.hcp.venu.view.SpecilizationExcelView;

@Controller
@RequestMapping("/spec")
public class SpecilazationController {
	
	
	@Autowired
	private SpeclizationService service;
	@GetMapping("/show")
	public String userPage()
	{
	
	return"Specialization";
	}
   @PostMapping("/save")
    public String getUserData(@ModelAttribute Specilazation specilazation,Model model)
{
		Integer id=service.saveSpecialization(specilazation);
		String message="User id'"+id+"'is Created";
		model.addAttribute("message",message);
	return"Specialization";
}
   @GetMapping("/data")
   public String getData(@ModelAttribute Specilazation specilazation,Model model)
   {
	              List<Specilazation> list= service.getAllData();
	                  model.addAttribute("list",list);
	                 return"SpecializationData";
   }
   @GetMapping("/delete")
   public String deleteData(@RequestParam Integer id,Model model)
   {
	   service.deleteData(id);
	   String message="Speicalization Data '"+id+"'is Deleted";
	   List<Specilazation> list= service.getAllData();
       model.addAttribute("list",list);
	   return"SpecializationData";
	   
   }
   @GetMapping("/edit")
   public String editData(@RequestParam Integer id,Model model)
  
   {
	   Specilazation message=service.editData(id);
	   model.addAttribute("message",message);
	    
	   return"SpecilazationlEditForm";
   }
   @PostMapping("/update")
   public String updateData(@ModelAttribute Specilazation specilazation,Model model)
   {
       service.updateData(specilazation);
       model.addAttribute(specilazation);
   return"redirect:data";
   }
   
   @GetMapping("/excel")
   public ModelAndView exportExcel() {
	   ModelAndView m=new ModelAndView();
	   m.setView(new SpecilizationExcelView());
	  List<Specilazation> list= service.getAllData();
	  m.addObject("list",list);
	  
	return m;
	   
   }
     

}
