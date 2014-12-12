package com.cme.hr.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import com.cme.hr.exception.EducationNotFound;
import com.cme.hr.model.Education;
import com.cme.hr.service.EducationService;
import com.cme.hr.service.PersonService;
import com.cme.hr.validation.EducationValidator;
import com.cme.hr.validation.PersonValidator;

@Controller
@RequestMapping(value = "/education")
public class EducationController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Autowired
	private PersonService personService;

	@Autowired
	private EducationService educationService;

	@Autowired
	private EducationValidator educationValidator;

	@Autowired
	private PersonValidator personValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(educationValidator);

	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newEducationPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ModelAndView mav = new ModelAndView("education-new", "education",
				new Education());
		initSelect(mav);	

		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewEducation(@ModelAttribute Education education,
			BindingResult result, final RedirectAttributes redirectAttributes,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (result.hasErrors()) {
			System.out.println("soy el error " + result.toString());
			ModelAndView mav = new ModelAndView("education-new", "education",
					education);
			initSelect(mav);
			return mav;
		}

		ModelAndView mav = new ModelAndView();
		String message = "New education was successfully created.";
		redirectAttributes.addFlashAttribute("message", message);

		educationService.create(education);
		Integer p = education.getIdPerson();
		HttpSession session = request.getSession(true);
		session.setAttribute("id_Person", p);

		boolean save = WebUtils.hasSubmitParameter(request, "save");

		if (save) {
			mav.setViewName("redirect:/index.html");
		} else {
			mav.setViewName("redirect:/education/create.html");
		}

		return mav;
	}

	@RequestMapping(value = "/list/{idPerson}", method = RequestMethod.GET)
	public ModelAndView educationListPage(@PathVariable Integer idPerson) {
		ModelAndView mav = new ModelAndView("education-listId");
		List<Education> educationList = educationService
				.findByIdPerson(idPerson);
		mav.addObject("educationListId", educationList);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editEducation(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("education-edit");
		Education education = educationService.findById(id);
		mav.addObject("education", education);
		initSelect(mav);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editEducation(
			@ModelAttribute @Valid Education education, BindingResult result,
			@PathVariable Integer id,
			final RedirectAttributes redirectAttributes)
			throws EducationNotFound {

		if (result.hasErrors())
			return new ModelAndView("education-edit");

		ModelAndView mav = new ModelAndView("redirect:/index.html");
		String message = "Education was successfully updated.";

		educationService.update(education);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteEducation(@PathVariable Integer id,
			final RedirectAttributes redirectAttributes)
			throws EducationNotFound {

		ModelAndView mav = new ModelAndView("redirect:/index.html");

		String message = "The education was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	ArrayList<String> eduList = new ArrayList<String>();

	private void initSelect(ModelAndView mav) {
		if (eduList.isEmpty()) {
			eduList.add("elementary school");
			eduList.add("high school");
			eduList.add("technical");
			eduList.add("university");
		}

		mav.addObject("eduList", eduList);

	}

}