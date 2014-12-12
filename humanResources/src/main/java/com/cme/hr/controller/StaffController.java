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

import com.cme.hr.exception.StaffNotFound;
import com.cme.hr.model.FamilyMember;
import com.cme.hr.model.Staff;
import com.cme.hr.service.StaffService;
import com.cme.hr.validation.StaffValidator;

@Controller
@RequestMapping(value="/staff")

public class StaffController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Autowired
	private StaffService staffService;

	@Autowired
	private StaffValidator staffValidator;
	
	@InitBinder
	
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(staffValidator);
		
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView newStaffPage() {
	   	Staff staff=new Staff();
		ModelAndView mav = new ModelAndView("staff-new", "staff",staff);
		initSelect(mav);	
	
		return mav;
	}
	
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ModelAndView createNewStaff(@ModelAttribute @Valid Staff staff,
			BindingResult result,
			final RedirectAttributes redirectAttributes,
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException{
   
		if (result.hasErrors()){
		System.out.println("soy el error "+ result.toString());
			 ModelAndView mav = new ModelAndView("staff-new","staff",staff);
			 initSelect(mav);		
			 return mav;
		}
		
		 staffService.create(staff);
		 Integer p= staff.getIdPerson();
		 HttpSession session = request.getSession(true);
         session.setAttribute("id_Staff", p);

		ModelAndView mav = new ModelAndView("redirect:/background/create.html");
	    
		
		return mav;		
	}
	
	@RequestMapping(value = "/list/{idPerson}", method = RequestMethod.GET)
	public ModelAndView StaffListPage(@PathVariable Integer idPerson) {
		ModelAndView mav = new ModelAndView("Staff-listId");
		List<Staff> StaffList = staffService.findByIdPerson(idPerson);
		mav.addObject("StaffListId", StaffList);
		return mav;
	}
	
	@RequestMapping(value="/edit/{idStaff}", method=RequestMethod.GET)
	public ModelAndView editStaffPage(@PathVariable Integer idStaff,
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException{
		ModelAndView mav = new ModelAndView("staff-edit");
		
		Staff staff = staffService.findById(idStaff);			
		initSelect(mav);
		mav.addObject("staff", staff);
		return mav;
	}
	
	@RequestMapping(value="/edit/{idStaff}", method=RequestMethod.POST)
	public ModelAndView editStaff(@ModelAttribute @Valid Staff staff,
			BindingResult result,
			@PathVariable Integer idStaff,
			final RedirectAttributes redirectAttributes) throws StaffNotFound {
		
		if (result.hasErrors())
			return new ModelAndView("staff-edit");
		
		 ModelAndView mav  = new  ModelAndView("redirect:/staff/list.html"); 	
		String message = "Staff was successfully updated.";

		staffService.update(staff);
		
		redirectAttributes.addFlashAttribute("message", message);	
		return mav;
	}
	
	@RequestMapping(value="/delete/{idStaff}", method=RequestMethod.GET)
	public ModelAndView deleteStaff(@PathVariable Integer idStaff,
			final RedirectAttributes redirectAttributes) throws StaffNotFound {
		
		ModelAndView mav = new ModelAndView("redirect:/index.html");		
		
		Staff staff = staffService.delete(idStaff);
		String message = "The staff was successfully deleted.";
		
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	ArrayList<String> stateList = new ArrayList<String>();

	private void initSelect(ModelAndView mav) {

		if (stateList.isEmpty()) {
			stateList.add("external");
			stateList.add("internal");
		}

		mav.addObject("stateList", stateList);
     
     }
	
}