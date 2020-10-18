package com.skilldistillery.films.database;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.films.entities.Actor;
import com.skilldistillery.films.entities.Film;

public interface DatabaseAccessor {
  public Film findFilmById(int filmId) throws SQLException;
  
  public Actor findActorById(int actorId);
  
  public List<Actor> findActorsByFilmId(int filmId);
  //Added databaseAccessor for films by searching.
  public List<Film> findFilmsBySearch(String inputText);
  
  public void createFilm(Film film);
  
  public boolean deleteFilm(Film film);
  
  public boolean updateFilm(Film film, String column, String columnValue);
  
}