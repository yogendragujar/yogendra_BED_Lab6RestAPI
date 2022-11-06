package com.greatlearning.studentregistration.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.studentregistration.model.Student;
import com.greatlearning.studentregistration.repository.StudentRepository;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentRepository studentsvc;

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		Student theStudent = new Student();
		theModel.addAttribute("student", theStudent);
		return "student-form";
	}

	@RequestMapping("/list")
	public String listStudents(Model theModel) {
		List<Student> theStudents = studentsvc.findAll();
		theModel.addAttribute("Students", theStudents);
		return "list-student";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// create model attribute to bind form data
		Student theStudent = new Student();
		theModel.addAttribute("Student", theStudent);
		return "student-form";
	}

	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") long id, @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("course") String course,
            @RequestParam("country") String country) {

		Student theStudent = new Student();
//		System.out.println(id);
		if (id != 0) {
//			theStudent.setId(theStudent.getId());
			theStudent = studentsvc.getById(id);
			theStudent.setFirstName(firstName);
            theStudent.setLastName(lastName);
            theStudent.setCourse(course);
            theStudent.setCountry(country);
		} else {
			theStudent = new Student(id, firstName, lastName, course, country);
		}

		// save the Student
		studentsvc.save(theStudent);

		// use a redirect to prevent duplicate submissions
		return "redirect:/student/list";

	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") long theId, Model theModel) {

		// get the Student from the service
		Student theStudent = studentsvc.getById(theId);
		// set Student as a model attribute to pre-populate the form
		theModel.addAttribute("Student", theStudent);

		return "student-form";
	}

	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam("id") long theId) {
		studentsvc.deleteById(theId);
		return "redirect:/student/list";

	}
	
	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() 
			+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", 
			"You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}
}
