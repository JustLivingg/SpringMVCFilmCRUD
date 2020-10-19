package com.skilldistillery.films.controllers;
import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.films.database.DatabaseAccessor;
import com.skilldistillery.films.entities.Film;

@Controller
public class FilmController {
	
	@Autowired
	private DatabaseAccessor filmDAO;
	
	public void setFilmDAO(DatabaseAccessor filmDAO) {
		this.filmDAO = filmDAO;
	}
//	public InMemoryDAO memoryDAO;
//	
//	public void setMemoryDAO(InMemoryDAO memoryDAO) {
//		this.memoryDAO = memoryDAO;
//	}
	
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
			f = filmDAO.findFilmById(filmId);
			mv.addObject("film", f);
			mv.setViewName("/WEB-INF/filminfo.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping(path = "findFilmBySearch.do", method = RequestMethod.GET)
	public ModelAndView findFilmBySearch(@RequestParam("keyword") String text ) {
		ModelAndView mv = new ModelAndView();
		List<Film> f = null;
		f = filmDAO.findFilmsBySearch(text);
		mv.addObject("film", f);
		mv.setViewName("/WEB-INF/searchFilm.jsp");
		return mv;
	}
	
	@RequestMapping(path="addFilmToDatabase.do", method=RequestMethod.POST)
	public ModelAndView addFilm(@Valid Film film)
	{
		Film f = filmDAO.createFilm(film);
		ModelAndView mv = new ModelAndView();
		mv.addObject("newFilm", f);
		mv.setViewName("/WEB-INF/createFilm.jsp");
		return mv;
	}
	
//	@RequestMapping(path="filmCreated.do", method=RequestMethod.GET)
//	public ModelAndView created(@Valid Film film) {
//		Film f = filmDAO.createFilm(film);
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("newFilm", f);
//		mv.setViewName("/WEB-INF/createFilm.jsp");
//		return mv;
//	}
	
	@RequestMapping(path="deleteFilm.do", method=RequestMethod.POST)
	public ModelAndView deleteFilm(@RequestParam("id") Integer filmId) {
		ModelAndView mv = new ModelAndView();
		Film f = new Film();
		Boolean deleted = false;
		try {
			f = filmDAO.findFilmById(filmId);
			deleted = filmDAO.deleteFilm(f);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		mv.setViewName("redirect:filmDeleted.do");
		return mv;
	}
	
	@RequestMapping(path="filmDeleted.do", method=RequestMethod.GET)
	public ModelAndView deleted() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/filmDeleted.jsp");
		return mv;
	}
}
