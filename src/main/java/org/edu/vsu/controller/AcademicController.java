package org.edu.vsu.controller;

import org.edu.vsu.entity.Academic;
import org.edu.vsu.service.AcademicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AcademicController {

    @Autowired
    AcademicService academicService;

    @RequestMapping(value = "/listAcademic", method = RequestMethod.GET)
    public ModelAndView academicList() {
        ModelAndView mav = new ModelAndView();
        List<Academic> academicList = academicService.getAll();
        mav.addObject("academics", academicList);
        mav.setViewName("academic_list");
        return mav;
    }

    @RequestMapping(value = "/academicCreate", method = RequestMethod.GET)
    public ModelAndView createAcademicPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("create_academic");
        return mav;
    }

    @RequestMapping(value = "/academicCreateAction", method = RequestMethod.POST)
    public ModelAndView createAcademic(@ModelAttribute("academicForm") Academic academic) {
        ModelAndView mav = new ModelAndView("redirect:/listAcademic");
        if (academic != null) {
            academicService.create(academic);
        }
        return mav;
    }

    @RequestMapping(value = "/academicDelete{id}", method = RequestMethod.GET)
    public ModelAndView deleteAcademic(@PathVariable("id") Long id) {
        academicService.delete(id);
        return new ModelAndView("redirect:/listAcademic");
    }

    @RequestMapping(value = "/academicEdit{id}", method = RequestMethod.GET)
    public ModelAndView editAcademicPage(@PathVariable("id") Long id) {
        Academic academic = academicService.get(id);
        ModelAndView mav = new ModelAndView();
        mav.addObject("academic", academic);
        mav.setViewName("edit_academic");
        return mav;
    }

    @RequestMapping(value = "/academicEditAction", method = RequestMethod.POST)
    public ModelAndView createAcademicAction(@ModelAttribute("academic") Academic academic) {
        ModelAndView mav = new ModelAndView("redirect:/listAcademic");
        if (academic != null) {
            academicService.update(academic);
        }
        return mav;
    }
}
