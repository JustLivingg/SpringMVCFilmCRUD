package com.skilldistillery.films.controllers;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.films.database.InMemoryDAO;
import com.skilldistillery.films.entities.Actor;
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
	public ModelAndView findFilmBySearch(@RequestParam("keyword") String text ) {
		ModelAndView mv = new ModelAndView();
		List<Film> f = null;
		f = memoryDAO.findFilmsBySearch(text);
		mv.addObject("film", f);
		mv.setViewName("/WEB-INF/searchFilm.jsp");
		return mv;
	}
	
	@RequestMapping(path="addFilmToDatabase.do", method=RequestMethod.POST)
	public ModelAndView addFilm(Film film, RedirectAttributes redir) {
		memoryDAO.createFilm(film);
		ModelAndView mv = new ModelAndView();
		redir.addFlashAttribute("film", film);
		mv.setViewName("redirect:filmCreated.do");
		return mv;
	}
	
	@RequestMapping(path="filmCreated.do", method=RequestMethod.GET)
	public ModelAndView created() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/filminfo.jsp");
		return mv;
	}
	
	@RequestMapping(path="deleteFilm.do", method=RequestMethod.POST)
	public ModelAndView deleteFilm(@RequestParam("id") Integer filmId, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		Film f;
		try {
			f = memoryDAO.findFilmById(filmId);
			Boolean deleted = memoryDAO.deleteFilm(f);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		redir.addFlashAttribute("redirect:filmDeleted.do");
		return mv;
	}
	
	@RequestMapping(path="filmDeleted.do", method=RequestMethod.GET)
	public ModelAndView deleted() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/filmDeleted.jsp");
		return mv;
	}
}
