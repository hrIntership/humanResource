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

import com.cme.hr.exception.FamilyMemberNotFound;
import com.cme.hr.model.City;
import com.cme.hr.model.Country;
import com.cme.hr.model.FamilyMember;
import com.cme.hr.model.Province;
import com.cme.hr.service.CountryService;
import com.cme.hr.service.FamilyMemberService;
import com.cme.hr.service.PersonService;

@Controller
@RequestMapping(value = "/familyMember")
public class FamilyMemberController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Autowired
	private PersonService personService;

	@Autowired
	private CountryService countryService;
	
	@Autowired
	private FamilyMemberService familyMemberService;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newFamilyMemberPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ModelAndView mav = new ModelAndView("familyMember-new", "familyMember",
				new FamilyMember());
		initSelect(mav);	

		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewFamilyMember(@ModelAttribute FamilyMember familyMember,
			BindingResult result, final RedirectAttributes redirectAttributes,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (result.hasErrors()) {
			System.out.println("soy el error " + result.toString());
			ModelAndView mav = new ModelAndView("familyMember-new", "familyMember",
					familyMember);
			initSelect(mav);
			return mav;
		}

		ModelAndView mav = new ModelAndView();
		String message = "New familyMember was successfully created.";
		redirectAttributes.addFlashAttribute("message", message);

		familyMemberService.create(familyMember);
		Integer p = familyMember.getIdPerson();
		HttpSession session = request.getSession(true);
		session.setAttribute("id_Person", p);

		boolean save = WebUtils.hasSubmitParameter(request, "save");

		if (save) {
			mav.setViewName("redirect:/index.html");
		} else {
			mav.setViewName("redirect:/familyMember/create.html");
		}

		return mav;
	}

	@RequestMapping(value = "/list/{idPerson}", method = RequestMethod.GET)
	public ModelAndView familyMemberListPage(@PathVariable Integer idPerson) {
		ModelAndView mav = new ModelAndView("familyMember-listId");
		List<FamilyMember> familyMemberList = familyMemberService
				.findByIdPerson(idPerson);
		mav.addObject("familyMemberListId", familyMemberList);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editFamilyMember(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("familyMember-edit");
		FamilyMember familyMember = familyMemberService.findById(id);
		mav.addObject("familyMember", familyMember);
		initSelect(mav);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editFamilyMember(
			@ModelAttribute @Valid FamilyMember familyMember, BindingResult result,
			@PathVariable Integer id,
			final RedirectAttributes redirectAttributes)
			throws FamilyMemberNotFound {

		if (result.hasErrors())
			return new ModelAndView("familyMember-edit");

		ModelAndView mav = new ModelAndView("redirect:/index.html");
		String message = "FamilyMember was successfully updated.";

		familyMemberService.update(familyMember);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteFamilyMember(@PathVariable Integer id,
			final RedirectAttributes redirectAttributes)
			throws FamilyMemberNotFound {

		ModelAndView mav = new ModelAndView("redirect:/index.html");

		String message = "The familyMember was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	List<Country> countryList = new ArrayList<Country>();
	List<Province> provinceList = new ArrayList<Province>();
	List<City> cityList = new ArrayList<City>();
	ArrayList<String> idTypeList = new ArrayList<String>();
	ArrayList<String> stateList = new ArrayList<String>();
	ArrayList<String> msList = new ArrayList<String>();

	private void initSelect(ModelAndView mav) {
		if (idTypeList.isEmpty()) {
			idTypeList.add("DU");
			idTypeList.add("Passport");
			idTypeList.add("Driver's License Number");
		}
		if (countryList.isEmpty()) {
			countryList = countryService.findAll();
		}

		mav.addObject("idTypeList", idTypeList);
		mav.addObject("countryList", countryList);


	}

}