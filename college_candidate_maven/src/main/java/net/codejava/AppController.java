package net.codejava;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
 
    @Autowired
    private CandidateService service;

	public CandidateService getService() {
		return service;
	}

	public void setService(CandidateService service) {
		this.service = service;
	}
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
	    List<Candidate> listCandidates = service.listAll();
	    model.addAttribute("listCandidates", listCandidates);
	     
	    return "index";
	}
	
	
	@RequestMapping("/new")
	public String showNewCandidatePage(Model model) {
	    Candidate candidate = new Candidate();
	    model.addAttribute("candidate", candidate);
	     
	    return "new_candidate";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCandidate(@ModelAttribute("candidate") Candidate candidate) {
	    service.save(candidate);
	     
	    return "redirect:/";
	}
	
	@RequestMapping("/edit/{primaryKey}")
	public ModelAndView showEditCandidatePage(@PathVariable(name = "primaryKey") Long primaryKey) {
	    ModelAndView mav = new ModelAndView("edit_candidate");
	    Candidate candidate = service.get(primaryKey);
	    mav.addObject("candidate", candidate);
	     
	    return mav;
	}
	
	@RequestMapping("/delete/{primaryKey}")
	public String deleteProduct(@PathVariable(name = "primaryKey") Long primaryKey) {
	    service.delete(primaryKey);
	    return "redirect:/";       
	}
	
}
