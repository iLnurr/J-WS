package iserba.controller;

import iserba.service.YMDTPService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView newUserQuota() {
        ModelAndView model = new ModelAndView("main");
        return model;
    }

    @RequestMapping(value = "/saveQuota", method = RequestMethod.POST)
    public ModelAndView saveQuota(@ModelAttribute YMDTPService YMDTPService, HttpServletRequest request) {
        String dtpEventInfo = request.getParameter("dtpEventInfo");
        YMDTPService.sendMessageAbout(dtpEventInfo);
        return new ModelAndView("redirect:/");
    }
}
