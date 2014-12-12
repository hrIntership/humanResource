package com.cme.hr.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import com.cme.hr.exception.BCheckNotFound;
import com.cme.hr.model.BCheck;
import com.cme.hr.service.BCheckService;
import com.cme.hr.service.PersonService;

@Controller
@RequestMapping(value = "/bCheck")
public class BCheckController extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PersonService personService;

	@Autowired
	private BCheckService bCheckService;
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newBCheckPage(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException{
		ModelAndView mav = new ModelAndView("bcheck-new", "bCheck",new BCheck());
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewBCheck(
			@ModelAttribute BCheck bCheck, BindingResult result,
			final RedirectAttributes redirectAttributes,
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException{

		if (result.hasErrors()) {
			return new ModelAndView("bcheck-new");
		}

		ModelAndView mav = new ModelAndView();
		String message = "New background check was successfully created.";
		redirectAttributes.addFlashAttribute("message", message);

		bCheckService.create(bCheck);
		 Integer p= bCheck.getIdPerson();
		 HttpSession session = request.getSession(true);
        session.setAttribute("id_Person", p);
        
		boolean save = WebUtils.hasSubmitParameter(request, "save");

		if (save) {
			mav.setViewName("redirect:/index.html");
		} else {
			mav.setViewName("redirect:/index.html");
		}

		return mav;
	}


	@RequestMapping(value = "/list/{idPerson}", method = RequestMethod.GET)
	public ModelAndView bCheckListPage(@PathVariable Integer idPerson) {
		ModelAndView mav = new ModelAndView("bcheck-listId");
		List<BCheck> bCheckList = bCheckService.findByIdPerson(idPerson);
		mav.addObject("bCheckListId", bCheckList);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editBCheckPage(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("bcheck-edit");
		BCheck bCheck = bCheckService.findById(id);
		mav.addObject("bCheck", bCheck);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editBCheck(
			@ModelAttribute @Valid BCheck bCheck, BindingResult result,
			@PathVariable Integer id,
			final RedirectAttributes redirectAttributes)
			throws BCheckNotFound {

		if (result.hasErrors())
			return new ModelAndView("bCheck-edit");

		ModelAndView mav = new ModelAndView("redirect:/index.html");
		String message = "Background Check was successfully updated.";

		bCheckService.update(bCheck);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteBackground(@PathVariable Integer id,
			final RedirectAttributes redirectAttributes)
			throws BCheckNotFound {

		ModelAndView mav = new ModelAndView("redirect:/index.html");

		
		String message = "The background check was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	


}