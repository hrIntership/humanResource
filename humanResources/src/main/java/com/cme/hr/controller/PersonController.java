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

import com.cme.hr.exception.PersonNotFound;
import com.cme.hr.model.City;
import com.cme.hr.model.Country;
import com.cme.hr.model.Person;
import com.cme.hr.model.Province;
import com.cme.hr.service.CityService;
import com.cme.hr.service.CountryService;
import com.cme.hr.service.PersonService;
import com.cme.hr.service.ProvinceService;
import com.cme.hr.validation.PersonValidator;

import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/person")
public class PersonController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Autowired
	private CountryService countryService;

	@Autowired
	private ProvinceService provinceService;

	@Autowired
	private CityService cityService;

	@Autowired
	private PersonService personService;

	@Autowired
	private PersonValidator personValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(personValidator);

	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newPersonPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Person person = new Person();
		ModelAndView mav = new ModelAndView("person-new", "person", person);

		initSelect(mav);

		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewPerson(@ModelAttribute @Valid Person person,
			BindingResult result, final RedirectAttributes redirectAttributes,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out
				.println("/n/n/n/n/n/nacaaaaaaaaaaaaaaaaaaaaaaa en el pppppppppppppppssssss");
		if (result.hasErrors()) {
			System.out.println("soy el error " + result.toString());
			ModelAndView mav = new ModelAndView("person-new", "person", person);
			initSelect(mav);
			return mav;
		}

		personService.create(person);
		Integer p = person.getIdPerson();
		HttpSession session = request.getSession(true);
		session.setAttribute("id_Person", p);

		ModelAndView mav = new ModelAndView("redirect:/background/create.html");

		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView personListPage() {
		ModelAndView mav = new ModelAndView("person-list");
		List<Person> personList = personService.findAll();
		mav.addObject("personList", personList);

		return mav;
	}

	@RequestMapping(value = "/edit/{idPerson}", method = RequestMethod.GET)
	public ModelAndView editPersonPage(@PathVariable Integer idPerson,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView mav = new ModelAndView("person-edit");

		Person person = personService.findById(idPerson);
		initSelect(mav);
		mav.addObject("person", person);
		return mav;
	}

	@RequestMapping(value = "/edit/{idPerson}", method = RequestMethod.POST)
	public ModelAndView editPerson(@ModelAttribute @Valid Person person,
			BindingResult result, @PathVariable Integer idPerson,
			final RedirectAttributes redirectAttributes) throws PersonNotFound {

		if (result.hasErrors())
			return new ModelAndView("person-edit");

		ModelAndView mav = new ModelAndView("redirect:/person/list.html");
		String message = "Person was successfully updated.";

		personService.update(person);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{idPerson}", method = RequestMethod.GET)
	public ModelAndView deletePerson(@PathVariable Integer idPerson,
			final RedirectAttributes redirectAttributes) throws PersonNotFound {

		ModelAndView mav = new ModelAndView("redirect:/index.html");

		Person person = personService.delete(idPerson);
		String message = "The person " + person.getLastname() + ","
				+ person.getFirstname() + " was successfully deleted.";

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
		if (provinceList.isEmpty()) {
			provinceList = provinceService.findByIdCountry(1);
		}
		if (cityList.isEmpty()) {
			cityList = cityService.findByIdProvince(1);
		}
		if (stateList.isEmpty()) {
			stateList.add("external");
			stateList.add("internal");
		}
		if (msList.isEmpty()) {
			msList.add("single");
			msList.add("married");
			msList.add("widowed");
			msList.add("separated");
			msList.add("divorced");
			msList.add("other");
		}

		mav.addObject("idTypeList", idTypeList);
		mav.addObject("countryList", countryList);
		mav.addObject("provinceList", provinceList);
		mav.addObject("cityList", cityList);
		mav.addObject("msList", msList);
		mav.addObject("stateList", stateList);

	}

}