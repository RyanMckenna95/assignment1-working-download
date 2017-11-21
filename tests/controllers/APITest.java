package controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import controllers.LikeMovieAPI;
import models.Movie;
import models.Rating;
import models.User;
import static models.Fixtures.users;
import static models.Fixtures.movies;
import static models.Fixtures.rating;

public class APITest {

	private LikeMovieAPI likeMovie=new LikeMovieAPI();
	
//Testing that the id's are being given correctly
	@Test
	public void testUser() {
		User u1 = new User("Ryan","Mckenna","22","M","Student");
		assertEquals(0, likeMovie.getUsers().size());
		likeMovie.addUser("Ryan","Mckenna","22","M","Student");
		assertEquals(1, likeMovie.getUsers().size());
		assertEquals(u1,likeMovie.getUser(2));
	}
	
	//delete function
	@Test
	public void testDeleteUser()
	{
		assertEquals(0, likeMovie.getUsers().size());
		likeMovie.addUser("Ryan", "Mckenna", "22", "M", "Student");
		likeMovie.addUser("Bob", "The", "32", "M", "Builder");
		assertEquals(2, likeMovie.getUsers().size());
		likeMovie.deleteUser(4);
		assertEquals(1,likeMovie.getUsers().size());
	}
	@Test
	public void testMovie()
	{
		Movie mov1 = new Movie("Super 8","2013","super8.com");
		assertEquals(0, likeMovie.getMovies().size());
		likeMovie.addMovie("Super 8", "2013", "super8.com");
		assertEquals(1, likeMovie.getMovies().size());
		assertEquals(mov1,likeMovie.getMovie(4));
	}
	@Test
	public void testDeleteMovie()
	{
		assertEquals(0, likeMovie.getMovies().size());
		likeMovie.addMovie("Super 8", "2013", "super8.com");
		likeMovie.addMovie("Cloverfield", "2009","cloverfield.com");
		assertEquals(2, likeMovie.getMovies().size());
		likeMovie.deleteMovie(2);
		assertEquals(1,likeMovie.getMovies().size());
	}
}