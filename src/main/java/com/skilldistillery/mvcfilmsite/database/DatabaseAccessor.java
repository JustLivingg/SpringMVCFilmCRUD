package com.skilldistillery.mvcfilmsite.database;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface DatabaseAccessor {
  public Film findFilmById(int filmId) throws SQLException;
  
  public Actor findActorById(int actorId);
  
  public List<Actor> findActorsByFilmId(int filmId);
  //Added databaseAccessor for films by searching.
  public List<Film> findFilmsBySearch(String inputText);
  
  public Film createFilm(Film film);
  
  public boolean deleteFilm(Film film);
  
}