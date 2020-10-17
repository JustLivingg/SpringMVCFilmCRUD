package com.skilldistillery.films.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.entities.Film;
import com.skilldistillery.mvcfilmsite.database.DatabaseAccessorObject;

@Controller
public class FilmController {
	
	@Autowired
	private DatabaseAccessorObject filmDAO;
	
	public void setFilmDAO(DatabaseAccessorObject filmDAO) {
		this.filmDAO = filmDAO;
	}
	
	@RequestMapping(path="index.do", method=RequestMethod.GET)
	  public ModelAndView index() {
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("WEB-INF/index.html");
	    return mv;
	  }
	
	@RequestMapping(path = "findFilmById.do", method = RequestMethod.GET)
	public ModelAndView findFilmById(@RequestParam("id") int filmId) {
		ModelAndView mv = new ModelAndView();
		Film f = filmDAO.findFilmById(filmId);
		mv.addObject("film", f);
		mv.setView(view);
		
	}
	
}
