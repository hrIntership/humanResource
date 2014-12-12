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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import com.cme.hr.exception.EmergencyContactsNotFound;
import com.cme.hr.model.EmergencyContacts;
import com.cme.hr.service.EmergencyContactsService;
import com.cme.hr.service.PersonService;

@Controller
@RequestMapping(value = "/emergencyContacts")
public class EmergencyContactsController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Autowired
	private PersonService personService;

	@Autowired
	private EmergencyContactsService emergencyContactsService;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newEmergencyContactsPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ModelAndView mav = new ModelAndView("emergencyContacts-new", "emergencyContacts",
				new EmergencyContacts());
		initSelect(mav);	

		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewEmergencyContacts(@ModelAttribute EmergencyContacts emergencyContacts,
			BindingResult result, final RedirectAttributes redirectAttributes,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (result.hasErrors()) {
			System.out.println("soy el error " + result.toString());
			ModelAndView mav = new ModelAndView("emergencyContacts-new", "emergencyContacts",
					emergencyContacts);
			initSelect(mav);
			return mav;
		}

		ModelAndView mav = new ModelAndView();
		String message = "New emergencyContacts was successfully created.";
		redirectAttributes.addFlashAttribute("message", message);

		emergencyContactsService.create(emergencyContacts);
		Integer p = emergencyContacts.getIdPerson();
		HttpSession session = request.getSession(true);
		session.setAttribute("id_Person", p);

		boolean save = WebUtils.hasSubmitParameter(request, "save");

		if (save) {
			mav.setViewName("redirect:/index.html");
		} else {
			mav.setViewName("redirect:/emergencyContacts/create.html");
		}

		return mav;
	}

	@RequestMapping(value = "/list/{idPerson}", method = RequestMethod.GET)
	public ModelAndView emergencyContactsListPage(@PathVariable Integer idPerson) {
		ModelAndView mav = new ModelAndView("emergencyContacts-listId");
		List<EmergencyContacts> emergencyContactsList = emergencyContactsService
				.findByIdPerson(idPerson);
		mav.addObject("emergencyContactsListId", emergencyContactsList);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editEmergencyContacts(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("emergencyContacts-edit");
		EmergencyContacts emergencyContacts = emergencyContactsService.findById(id);
		mav.addObject("emergencyContacts", emergencyContacts);
		initSelect(mav);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editEmergencyContacts(
			@ModelAttribute @Valid EmergencyContacts emergencyContacts, BindingResult result,
			@PathVariable Integer id,
			final RedirectAttributes redirectAttributes)
			throws EmergencyContactsNotFound {

		if (result.hasErrors())
			return new ModelAndView("emergencyContacts-edit");

		ModelAndView mav = new ModelAndView("redirect:/index.html");
		String message = "EmergencyContacts was successfully updated.";

		emergencyContactsService.update(emergencyContacts);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteEmergencyContacts(@PathVariable Integer id,
			final RedirectAttributes redirectAttributes)
			throws EmergencyContactsNotFound {

		ModelAndView mav = new ModelAndView("redirect:/index.html");

		String message = "The emergencyContacts was successfully deleted.";

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