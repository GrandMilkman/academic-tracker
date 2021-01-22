package org.edu.vsu.controller;

import org.edu.vsu.entity.Course;
import org.edu.vsu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/listCourse", method = RequestMethod.GET)
    public ModelAndView courseList() {
        ModelAndView mav = new ModelAndView();
        List<Course> courseList = courseService.getAll();
        mav.addObject("courses", courseList);
        mav.setViewName("course_list");
        return mav;
    }

    @RequestMapping(value = "/courseCreate", method = RequestMethod.GET)
    public ModelAndView createCoursePage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("create_course");
        return mav;
    }

    @RequestMapping(value = "/courseCreateAction", method = RequestMethod.POST)
    public ModelAndView createCourse(@ModelAttribute("courseForm") Course course) {
        ModelAndView mav = new ModelAndView("redirect:/listCourse");
        if (course != null) {
            courseService.create(course);
        }
        return mav;
    }

    @RequestMapping(value = "/courseDelete{id}", method = RequestMethod.GET)
    public ModelAndView deleteCourse(@PathVariable("id") Long id) {
        courseService.delete(id);
        return new ModelAndView("redirect:/listCourse");
    }

    @RequestMapping(value = "/courseEdit{id}", method = RequestMethod.GET)
    public ModelAndView editCoursePage(@PathVariable("id") Long id) {
        Course course = courseService.get(id);
        ModelAndView mav = new ModelAndView();
        mav.addObject("course", course);
        mav.setViewName("edit_course");
        return mav;
    }

    @RequestMapping(value = "/courseEditAction", method = RequestMethod.POST)
    public ModelAndView createCourseAction(@ModelAttribute("course") Course course) {
        ModelAndView mav = new ModelAndView("redirect:/listCourse");
        if (course != null) {
            courseService.update(course);
        }
        return mav;
    }
}
