package com.skilldistillery.films.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FilmController {
	@RequestMapping(path="index.do", method=RequestMethod.GET)
	  public ModelAndView index() {
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("WEB-INF/index.html");
	    return mv;
	  }
	
	@RequestMapping(path = "findFilmbyId.do", method = RequestMethod.GET)
	public ModelAndView findFilmById(@RequestParam("id") int filmId) {
		ModelAndView mv = new ModelAndView();
		
	}
	
}
