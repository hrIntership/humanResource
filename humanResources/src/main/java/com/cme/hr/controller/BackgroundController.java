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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import com.cme.hr.exception.BackgroundNotFound;
import com.cme.hr.model.Background;
import com.cme.hr.service.BackgroundService;
import com.cme.hr.service.PersonService;
import com.cme.hr.validation.BackgroundValidator;
import com.cme.hr.validation.PersonValidator;

@Controller
@RequestMapping(value = "/background")
public class BackgroundController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Autowired
	private PersonService personService;

	@Autowired
	private BackgroundService backgroundService;

	@Autowired
	private BackgroundValidator backgroundValidator;

	@Autowired
	private PersonValidator personValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(backgroundValidator);

	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newBackgroundPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ModelAndView mav = new ModelAndView("background-new", "background",
				new Background());
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewBackground(
			@ModelAttribute Background background, BindingResult result,
			final RedirectAttributes redirectAttributes,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (result.hasErrors()) {
			return new ModelAndView("background-new");
		}

		ModelAndView mav = new ModelAndView();
		String message = "New background was successfully created.";
		redirectAttributes.addFlashAttribute("message", message);

		backgroundService.create(background);
		Integer p = background.getIdPerson();
		HttpSession session = request.getSession(true);
		session.setAttribute("id_Person", p);

		boolean save = WebUtils.hasSubmitParameter(request, "save");

		if (save) {
			mav.setViewName("redirect:/education/create.html");
		} else {
			mav.setViewName("redirect:/background/create.html");
		}

		return mav;
	}

	@RequestMapping(value = "/list/{idPerson}", method = RequestMethod.GET)
	public ModelAndView backgroundListPage(@PathVariable Integer idPerson) {
		ModelAndView mav = new ModelAndView("background-listId");
		List<Background> backgroundList = backgroundService
				.findByIdPerson(idPerson);
		mav.addObject("backgroundListId", backgroundList);

		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editBackgroundPage(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("background-edit");
		Background background = backgroundService.findById(id);
		mav.addObject("background", background);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editBackground(
			@ModelAttribute @Valid Background background, BindingResult result,
			@PathVariable Integer id,
			final RedirectAttributes redirectAttributes)
			throws BackgroundNotFound {

		if (result.hasErrors())
			return new ModelAndView("background-edit");

		ModelAndView mav = new ModelAndView("redirect:/index.html");
		String message = "Background was successfully updated.";

		backgroundService.update(background);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteBackground(@PathVariable Integer id,
			final RedirectAttributes redirectAttributes)
			throws BackgroundNotFound {

		ModelAndView mav = new ModelAndView("redirect:/index.html");

		String message = "The background was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}