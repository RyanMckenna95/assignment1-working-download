package controllers;

import java.util.Collection;
import java.io.File;
import java.io.IOException;
import java.util.*;
import com.google.common.base.Optional;
import models.User;
import utils.Serializer;
import models.Movie;
import models.Rating;
public class LikeMovieAPI {

	private Serializer serializer;
	
	private Map<Long, User> userIndex = new HashMap<>();
	private Map<Long, Movie> movieIndex=new HashMap<>();
	private Map<String, User> userNameIndex=new HashMap<>();
	private Map<Long, Rating> ratingIndex=new HashMap<>();
	
	public LikeMovieAPI(){
		
	}
	
	public LikeMovieAPI(Serializer serializer)
	{
		this.serializer=serializer;
	}
	
	@SuppressWarnings("unchecked")
	public void load()throws Exception
	{
		serializer.read();
		userIndex=(Map<Long, User>)serializer.pop();
		movieIndex=(Map<Long, Movie>)serializer.pop();
		User.counter=(Long) serializer.pop();
	}
	
	public void store() throws Exception
	{
		serializer.push(User.counter);
		serializer.push(userIndex);
		serializer .push(movieIndex);
		serializer.write();
	}
	//serializer^^
	
	//user controles
	
	public Collection<User> getUsers() {
		return userIndex.values();
	}
	
	public User getUser(long id)
	{
		return userIndex.get(id);
	}

	public void removeUsers() {
		userIndex.clear();
		userNameIndex.clear();
	}

	public void addUser(String fName,String lName,String age,String gender,String occupation) {
		User user = new User(fName,lName,age,gender,occupation);
		userIndex.put(user.id,user);
	}
	public User getUserByName(String name){
		return userNameIndex.get(name);
	}

	public User getUserRatings(long id) {
		return userIndex.get(id);
	}

	public void deleteUser(long id) {
		User user=userIndex.remove(id);
		userNameIndex.remove(user.firstName);
		
	}
	
	public User getUserById(Long id) {
		return userIndex.get(id);
	}
	//user controls^^
	
	//movie controls
	
	public void addMovie(String title,String year,String url)
	{
		Movie movie = new Movie(title,year,url);
        movieIndex.put(movie.id, movie);
	}
	
	public Collection<Movie> getMovies()
	{
		return movieIndex.values();
	}
	
	public Movie getMovie(long id)
	{
		return movieIndex.get(id);
		
	}
	
	public Map<Long, Rating> getMovieRating(long id) {
		Optional<Movie> movie = Optional.fromNullable(movieIndex.get(id));
			return movie.get().rating;
	}
	
	public void deleteMovies()
	{
		movieIndex.clear();
	}
	
	public void deleteMovie(long id)
	{
		movieIndex.remove(id);
	}
	//movie controls^^
	
	//rating controls
	public Collection<Rating> getRatings()
	{
		return ratingIndex.values();
	}
	
	public Rating getRating(long id)
    {
    	return ratingIndex.get(id);
    }
	
	public void addRating(Long userID, Long movieID, Float rating) {
		Optional<Movie> movie = Optional.fromNullable(movieIndex.get(movieID));
		if (movie.isPresent()) {
			movie.get().movieArray.add(new Rating(userID, movieID, rating));
		}
	}
	
	public void deleteRatings()
	{
		ratingIndex.clear();
	}
	public void deleteRating(long id)
    {
    	ratingIndex.remove(id);
    }
	
	
	
	public void initalLoad()throws IOException{
		String delims="[|]";
		Scanner scanner = new Scanner(new File("./lib/users5.dat"));
		while (scanner.hasNextLine()) {
			String userDetails = scanner.nextLine();
			// parse user details string
			String[] userTokens = userDetails.split(delims);

			if (userTokens.length == 7) {
				addUser(userTokens[1], userTokens[2], userTokens[3], userTokens[4], userTokens[5]);
			} else {
				scanner.close();
				throw new IOException("Invalid member length: " + userTokens.length);
			}
		}
		scanner.close();
		
		   Scanner scanner1 = new Scanner( new File("./lib/items5.dat"));
           while (scanner1.hasNextLine()) {
              String userDetails1 = scanner1.nextLine();
               // parse user details string
              String[]  userTokens1 = userDetails1.split(delims);
               if (userTokens1.length == 23) {
                   addMovie(userTokens1[1],userTokens1[2],userTokens1[3]);
               } else {
                   scanner1.close();
                   throw new IOException("Invalid member length: " + userTokens1.length);
               }
           }
           scanner1.close();
               
          Scanner scanner2 = new Scanner (new File("./lib/ratings5.dat"));
               while (scanner2.hasNextLine()) {
                 String  userDetails2 = scanner2.nextLine();
                   // parse user details string
                  String[]  userTokens2 = userDetails2.split(delims);
                   if (userTokens2.length == 4) {
                       addRating(Long.valueOf(userTokens2[0]),Long.valueOf(userTokens2[1]),Float.valueOf(userTokens2[2]));
                   } else {
                       scanner2.close();
                       throw new IOException("Invalid member length: " + userTokens2.length);
                   }
      
           }
               scanner2.close();
       }
	
}

