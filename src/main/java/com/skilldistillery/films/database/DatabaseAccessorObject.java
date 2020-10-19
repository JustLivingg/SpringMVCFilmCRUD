
package com.skilldistillery.films.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.films.entities.Actor;
import com.skilldistillery.films.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useJDBCCompliantTimeZoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String user = "student";
	private static final String pass = "student";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Film findFilmById(int filmId) throws SQLException {
		Film film = null;

		Connection conn = DriverManager.getConnection(URL, user, pass);

		String sql = "SELECT * FROM film LEFT JOIN language ON language.id = film.language_id  LEFT JOIN film_category ON film_category.film_id = film.id LEFT JOIN category ON category.id = film_category.category_id WHERE film.id =?";

		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setInt(1, filmId);
		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {

			rs.beforeFirst();
			while (rs.next()) {
				film = new Film(rs.getInt("id"), rs.getString("title"), rs.getString("description"),
						rs.getInt("release_year"), rs.getInt("language_id"), rs.getInt("rental_duration"),
						rs.getDouble("rental_rate"), rs.getInt("length"), rs.getDouble("replacement_cost"),
						rs.getString("rating"), rs.getString("special_features"), findActorsByFilmId(rs.getInt("id")));
			}
		}

		// Always close your utilities.
		rs.close();
		stmt.close();
		conn.close();
		return film;
	}

	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT id, first_name, last_name " + "FROM actor" + "WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				actor = new Actor(rs.getInt(1), rs.getString(2), rs.getString(3));

			}
			// Always close your utilities.
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> cast = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT * " + "FROM actor a " + "JOIN film_actor fa on fa.actor_id =a.id "
					+ "JOIN film f on f.id = fa.film_id " + "WHERE f.id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next() == false && filmId != 0) {
				return null;
			} else {
				while (rs.next()) {
					int id = rs.getInt(1);
					String firstName = rs.getString(2);
					String lastName = rs.getString(3);
					Actor actor = new Actor(id, firstName, lastName);
					cast.add(actor);
				}
			}
			// Always close your utilities.
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cast;
	}

	public List<Film> getFilmsByActorId(int actorId) {
		List<Film> films = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT id, title, description, release_year, language_id, rental_duration, ";
			sql += " rental_rate, length, replacement_cost, rating, special_features " + " FROM film "
					+ "JOIN film_actor ON film.id = film_actor.film_id " + " " + "WHERE actor_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next() == false && actorId != 0) {
				return null;
			} else {
				while (rs.next()) {
					int filmId = rs.getInt(1);
					String title = rs.getString(2);
					String desc = rs.getString(3);
					short releaseYear = rs.getShort(4);
					int langId = rs.getInt(5);
					int rentDur = rs.getInt(6);
					double rate = rs.getDouble(7);
					int length = rs.getInt(8);
					double repCost = rs.getDouble(9);
					String rating = rs.getString(10);
					String features = rs.getString(11);
					Film film = new Film(filmId, title, desc, releaseYear, langId, rentDur, rate, length, repCost,
							rating, features, findActorsByFilmId(filmId));
					films.add(film);
				}
			}
			// Always close your utilities.
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

	@Override
	public List<Film> findFilmsBySearch(String inputText) {
		List<Film> filmSearch = new ArrayList<>();

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT film.id as id, title, description, release_year, language_id,"
					+ " language.name as film_language, rental_duration, rental_rate, length, replacement_cost,"
					+ " rating, special_features, category.name as film_category" + " FROM film"
					+ " JOIN language on film.language_id = language.id"
					+ " JOIN film_category on film.id = film_category.film_id"
					+ " JOIN category on film_category.category_id = category.id"
					+ " WHERE title like ? or description like ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + inputText + "%");
			stmt.setString(2, "%" + inputText + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				filmSearch.add(new Film(rs.getInt("id"), rs.getString("title"), rs.getString("description"),
						rs.getInt("release_year"), rs.getInt("language_id"), rs.getInt("rental_duration"),
						rs.getDouble("rental_rate"), rs.getInt("length"), rs.getDouble("replacement_cost"),
						rs.getString("rating"), rs.getString("special_features"), findActorsByFilmId(rs.getInt("id"))));
			}

			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			System.err.println(e);
		}

		return filmSearch;
	}
	
	@Override
	public Film createFilm(Film film) {
		Film createFilm = film;
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false);
			String sql = "INSERT INTO Film (title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating, specialFeatures) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
//			String sql = "INSERT INTO Film (title, language_id) VALUES (?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, createFilm.getTitle());
			stmt.setString(2, createFilm.getDescription());
			stmt.setInt(3, createFilm.getReleaseYear());
			stmt.setInt(4, createFilm.getLanguageId());
			stmt.setInt(5, createFilm.getRentalDuration());
			stmt.setDouble(6, createFilm.getRentalRate());
			stmt.setInt(7, createFilm.getLength());
			stmt.setDouble(8, createFilm.getReplacementCost());
			stmt.setString(9, createFilm.getRating());
			stmt.setString(10, createFilm.getSpecialfeatures());

			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				ResultSet keys = stmt.getGeneratedKeys();
				if (keys.next()) {
					int newFilmId = keys.getInt(1);
					createFilm.setId(newFilmId);

				} else {
					createFilm = null;
				}
			}
			conn.commit(); // COMMIT TRANSACTION
			stmt.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
		}
		return createFilm;
	}

	@Override
	public boolean deleteFilm(Film film) {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "DELETE FROM film_actor WHERE film_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, film.getId());
			int updateCount = stmt.executeUpdate();

			sql = "DELETE FROM film WHERE id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, film.getId());
			updateCount = stmt.executeUpdate();
			conn.commit(); // COMMIT TRANSACTION
			stmt.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback delete film");
				}
			}
			return false;
		}
		return true;
	}

	@Override
	public boolean updateFilm(Film film, String column, String columnValue) {
		Connection conn = null;
		if (column.equals("id")) {
			return false;
		} else {
			try {
				conn = DriverManager.getConnection(URL, user, pass);
				conn.setAutoCommit(false); // START TRANSACTION

				String sql = "UPDATE FILM SET column = columnValue " + "WHERE id = ?";

				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setInt(1, film.getId());

				int updateCount = stmt.executeUpdate();

				if (updateCount == 0) {
					return false;
				}

				conn.commit();
				stmt.close();
				conn.close();
			} catch (SQLException sqle) {
				// TODO Auto-generated catch block
				sqle.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException sqle) {
				System.err.print("Error trying to rollback update film.");
			}
		}

		return true;

	}

}
