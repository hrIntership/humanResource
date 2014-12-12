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

import com.cme.hr.exception.SupplementaryInfoNotFound;
import com.cme.hr.model.SupplementaryInfo;
import com.cme.hr.service.SupplementaryInfoService;
import com.cme.hr.service.PersonService;


@Controller
@RequestMapping(value = "/supplementaryInfo")
public class SupplementaryInfoController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Autowired
	private PersonService personService;

	@Autowired
	private SupplementaryInfoService supplementaryInfoService;


	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newSupplementaryInfoPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ModelAndView mav = new ModelAndView("supplementaryInfo-new", "supplementaryInfo",
				new SupplementaryInfo());
		initSelect(mav);	

		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewSupplementaryInfo(@ModelAttribute SupplementaryInfo supplementaryInfo,
			BindingResult result, final RedirectAttributes redirectAttributes,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (result.hasErrors()) {
			System.out.println("soy el error " + result.toString());
			ModelAndView mav = new ModelAndView("supplementaryInfo-new", "supplementaryInfo",
					supplementaryInfo);
			initSelect(mav);
			return mav;
		}

		ModelAndView mav = new ModelAndView();
		String message = "New supplementaryInfo was successfully created.";
		redirectAttributes.addFlashAttribute("message", message);

		supplementaryInfoService.create(supplementaryInfo);
		Integer p = supplementaryInfo.getIdPerson();
		HttpSession session = request.getSession(true);
		session.setAttribute("id_Person", p);

		boolean save = WebUtils.hasSubmitParameter(request, "save");

		if (save) {
			mav.setViewName("redirect:/index.html");
		} else {
			mav.setViewName("redirect:/supplementaryInfo/create.html");
		}

		return mav;
	}

	@RequestMapping(value = "/list/{idPerson}", method = RequestMethod.GET)
	public ModelAndView supplementaryInfoListPage(@PathVariable Integer idPerson) {
		ModelAndView mav = new ModelAndView("supplementaryInfo-listId");
		List<SupplementaryInfo> supplementaryInfoList = supplementaryInfoService
				.findByIdPerson(idPerson);
		mav.addObject("supplementaryInfoListId", supplementaryInfoList);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editSupplementaryInfo(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("supplementaryInfo-edit");
		SupplementaryInfo supplementaryInfo = supplementaryInfoService.findById(id);
		mav.addObject("supplementaryInfo", supplementaryInfo);
		initSelect(mav);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editSupplementaryInfo(
			@ModelAttribute @Valid SupplementaryInfo supplementaryInfo, BindingResult result,
			@PathVariable Integer id,
			final RedirectAttributes redirectAttributes)
			throws SupplementaryInfoNotFound {

		if (result.hasErrors())
			return new ModelAndView("supplementaryInfo-edit");

		ModelAndView mav = new ModelAndView("redirect:/index.html");
		String message = "SupplementaryInfo was successfully updated.";

		supplementaryInfoService.update(supplementaryInfo);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteSupplementaryInfo(@PathVariable Integer id,
			final RedirectAttributes redirectAttributes)
			throws SupplementaryInfoNotFound {

		ModelAndView mav = new ModelAndView("redirect:/index.html");

		String message = "The supplementaryInfo was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	ArrayList<String> bloodTypeList = new ArrayList<String>();

	private void initSelect(ModelAndView mav) {
		if (bloodTypeList.isEmpty()) {
			bloodTypeList.add("Group O+");
			bloodTypeList.add("Group O–");
			bloodTypeList.add("Group A+");
			bloodTypeList.add("Group A–");
			bloodTypeList.add("Group B+");
			bloodTypeList.add("Group B–");
			bloodTypeList.add("Group AB+");
			bloodTypeList.add("Group AB-");
		}

		mav.addObject("bloodTypeList", bloodTypeList);

	}

}