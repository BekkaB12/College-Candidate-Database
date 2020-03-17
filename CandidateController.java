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
public class CandidateController {
 
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
	    model.addAttribute("listProducts", listCandidates);
	     
	    return "index";
	}
	
	@RequestMapping("/new")
	public String showNewCandidatePage(Model model) {
	    Candidate candidate = new Candidate();
	    model.addAttribute("Candidate", candidate);
	     
	    return "new_candidate";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCandidate(@ModelAttribute("candidate") Candidate candidate) {
	    service.save(candidate);
	     
	    return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditCandidatePage(@PathVariable(name = "id") Long id) {
	    ModelAndView mav = new ModelAndView("edit_candidate");
	    Candidate candidate = service.get(id);
	    mav.addObject("candidate", candidate);
	     
	    return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) {
	    service.delete(id);
	    return "redirect:/";       
	}
	
}
