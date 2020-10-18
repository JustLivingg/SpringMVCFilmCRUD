package com.skilldistillery.films.controllers;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.films.database.DatabaseAccessorObject;
import com.skilldistillery.films.database.InMemoryDAO;
import com.skilldistillery.films.entities.Film;

@Controller
public class FilmController {
	
	@Autowired
//	private DatabaseAccessorObject filmDAO;
//	
//	public void setFilmDAO(DatabaseAccessorObject filmDAO) {
//		this.filmDAO = filmDAO;
//	}
	public InMemoryDAO memoryDAO;
	
	public void setMemoryDAO(InMemoryDAO memoryDAO) {
		this.memoryDAO = memoryDAO;
	}
	
	@RequestMapping(path="index.do", method=RequestMethod.GET)
	  public ModelAndView index() {
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("index.html");
	    return mv;
	  }
	
	@RequestMapping(path = "findFilmById.do", method = RequestMethod.GET)
	public ModelAndView findFilmById(@RequestParam("id") Integer filmId) {
		ModelAndView mv = new ModelAndView();
		Film f;
		try {
			f = memoryDAO.findFilmById(filmId);
			mv.addObject("film", f);
			mv.setViewName("/WEB-INF/filminfo.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping(path = "findFilmBySearch.do", method = RequestMethod.GET)
	public ModelAndView findFilmByKeyword(@RequestParam("text") String text ) {
		ModelAndView mv = new ModelAndView();
		List<Film> f = null;
		f = memoryDAO.findFilmsBySearch(text);
		mv.addObject("film", f);
		mv.setViewName("/WEB-INF/filminfo.jsp");
		return mv;
	}
	
	
	
	
	
	
}
