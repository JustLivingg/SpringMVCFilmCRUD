package com.skilldistillery.films.database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.films.entities.Actor;
import com.skilldistillery.films.entities.Film;

public class InMemoryDAO implements DatabaseAccessor{
	
	private List<Film> films;
	private List<Actor> actors;
	
	public InMemoryDAO() {
		films = new ArrayList<>();
		actors = new ArrayList<>();
		
		actors.add(new Actor(1, "Penelope", "Guiness"));
		actors.add(new Actor(2, "Nick", "Wahlberg"));
		actors.add(new Actor(3, "Ed", "Chase"));
		actors.add(new Actor(4, "Jennifer", "Davis"));
		actors.add(new Actor(5, "Penelope", "Guiness"));
		
		films.add(new Film(1, "ACADEMY DINOSAUR", "A Epic Drama of a Feminist And a Mad Scientist who must Battle a Teacher in The Canadian Rockies", 1993, 3, 6, 0.99, 86, 20.99, "PG", "Deleted Scenes,Behind the Scenes", actors));
		films.add(new Film(2, "ACE GOLDFINGER", "A Astounding Epistle of a Database Administrator And a Explorer who must Find a Car in Ancient China ", 2000, 1, 3, 4.99, 48, 12.99, "G", "Trailers,Deleted Scenes", actors));
		films.add(new Film(3, "ADAPTATION HOLES", "A Astounding Reflection of a Lumberjack And a Car who must Sink a Lumberjack in A Baloon Factory", 2008, 1, 7, 2.99, 50, 18.99, "NC17", "Trailers,Deleted Scenes ", actors));
		
	}

	@Override
	public Film findFilmById(int filmId) throws SQLException {
		Film f = null;
		for(Film film : films) {
			if(film.getId() == filmId) {
				f = film;
				break;
			}
		}
		return f;
	}

	@Override
	public Actor findActorById(int actorId) {
		Actor a = null;
		for (Actor actor : actors) {
			if(a.getId() == actorId) {
				a = actor;
				break;
			}
		}
		return a;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> aList = new ArrayList<>();
			for (Film film : films) {
			if(film.getId() == filmId) {
				for(int i = 0; i < film.getCast().size(); i++)
				aList.addAll(film.getCast());
			}
		}
		return aList;
	}

	@Override
	public List<Film> findFilmsBySearch(String inputText) {
		List<Film> f = new ArrayList<>();
		for(Film film : films) {
			if(film.getTitle().toLowerCase().contains(inputText.toLowerCase()) || film.getDescription().toLowerCase().contains(inputText.toLowerCase())) {
				f.add(film);
			}
		}
		return f;
	}

	@Override
	public Film createFilm(Film film) {
		films.add(film);
		return null;
	}

	@Override
	public boolean deleteFilm(Film film) {
		return films.remove(film);
		
	}

	@Override
	public boolean updateFilm(Film film, String column, String columnValue) {
		for(Film f : films) {
			if(f == film) {
				if(column.equals("title")) {
					f.setTitle(columnValue);
				}
				else if(column.equals("description")) {
					f.setDescription(column);
				}
				else if(column.equals("releaseYear")) {
					f.setReleaseYear((Integer.parseInt(columnValue)));
				}
				else if(column.equals("languageId")) {
					f.setLanguageId((Integer.parseInt(columnValue)));
				}
				else if(column.equals("rentalDuration")) {
					f.setRentalDuration((Integer.parseInt(columnValue)));
				}
				else if(column.equals("rentalRate")) {
					f.setRentalRate((Double.parseDouble(columnValue)));
				}
				else if(column.equals("length")) {
					f.setLength((Integer.parseInt(columnValue)));
					}
				else if(column.equals("replacementCost")) {
					f.setReplacementCost((Double.parseDouble(columnValue)));
				}
				else if(column.equals("rating")) {
					f.setRating(columnValue);
				}
				else if(column.equals("specialFeatures")) {
					f.setSpecialfeatures(columnValue);
				}
				else { return false; }
				
			}
		}
		
		
		return true;
	}
	

}
