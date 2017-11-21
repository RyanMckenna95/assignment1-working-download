package controllers;


import java.io.File;

import java.util.Scanner;


import utils.Serializer;
import utils.XMLSerializer;


public class Main
{
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception
	{

		File data = new File("./lib/data.xml");
		Serializer serializer = new XMLSerializer(data);
		LikeMovieAPI likeMovies = new LikeMovieAPI(serializer);
		Scanner sc = new Scanner(System.in);
		
	int mainMenu=0;
	System.out.println("Welcome to the Movie recommender. \n");
	System.out.println("please wait \n");
	if(data.isFile())
	{
	likeMovies.load();
	}
	likeMovies.initalLoad();
	System.out.println("Thank you for waiting.");
	
	do{
		System.out.println("**************************");
		System.out.println("*Welcome to the Main Menu*");
		System.out.println("*1.User Menu             *");
		System.out.println("*2.Movies Menu           *");
		System.out.println("*3.Ratings Menu          *");
		System.out.println("*0.Exit Program          *");
		System.out.println("**************************");
		System.out.println("Please Enter your Option: ");
		mainMenu=sc.nextInt();
		
		switch(mainMenu)
		{
		case 1:
			int userMenu=0;
			do{
				System.out.println("**************************");
				System.out.println("*Welcome to the User Menu*");
				System.out.println("*1.Add new User          *");
				System.out.println("*2.Delete a User         *");
				System.out.println("*3.Delete all Users      *");
				System.out.println("*4.Show all Users        *");
				System.out.println("*5.show User rating      *");
				System.out.println("*0.return to main menu   *");
				System.out.println("**************************");
				System.out.println("Please Enter your Option: ");
				userMenu=sc.nextInt();
				switch(userMenu)
				{
				case 1:
					System.out.println("Enter Users First Name :");
					String fName = sc.next();
					System.out.println("Enter Users Last Name : ");
					String lName = sc.next();
					System.out.println("Enter Users Age? : ");
					String age = sc.next();
					System.out.println("Enter Users Gender(M/F) :");
					String gender = sc.next();
					System.out.println("Enter Users Occupation : ");
					String occupation = sc.next();
					likeMovies.addUser(fName, lName, age, gender, occupation);
					System.out.println("User Added Succesfully");
					break;
					
				case 2:
					System.out.println("Enter User ID you want deleted: ");
					Long userId = sc.nextLong();
					likeMovies.deleteUser(userId);
					System.out.println("User Deleted");
					break;
					
				case 3:
					System.out.println("Deletion in progress");
					likeMovies.removeUsers();
					System.out.println("Users have been deleted.");
					break;
				
				case 4:
					System.out.println(likeMovies.getUsers());
					break;
					
				case 5:
					System.out.println("Enter the ID of the user you want the rating of:");
					Long searchID=sc.nextLong();
					System.out.println(likeMovies.getUserRatings(searchID));
					break;
				}
			}while(userMenu!=0);
			break;
			
		case 2:
			
			int movieMenu=0;
			do{
				System.out.println("**************************");
				System.out.println("*Welcome to the Movie Menu*");
				System.out.println("*1.Add new Movie          *");
				System.out.println("*2.Delete a Movie         *");
				System.out.println("*3.Delete all Movies      *");
				System.out.println("*4.Show all Movies        *");
				System.out.println("*5.show Movie rating      *");
				System.out.println("*0.return to main menu    *");
				System.out.println("***************************");
				System.out.println("Please Enter your Option: ");
				movieMenu=sc.nextInt();
					
					switch(movieMenu)
					{
					case 1:
						System.out.println("Enter Movie Title :");
						String title = sc.next();
						System.out.println("Enter Movie Release Date : ");
						String year = sc.next();
						System.out.println("Enter Movie Website Link : ");
						String url = sc.next();
						likeMovies.addMovie(title, year, url);
						System.out.println("Movie Succesfully Added");
						break;
						
					case 2:
						System.out.println("Enter Movie ID you want deleted: ");
						Long deleteID=sc.nextLong();
						likeMovies.deleteMovie(deleteID);
						System.out.println("The movie has been deleted");
						break;
					case 3:
						System.out.println("Deletion in progress");
						likeMovies.deleteMovies();
						System.out.println("All Movies have been deleted succesfully");
						break;
						
					case 4:
						System.out.println(likeMovies.getMovies());
						break;
					
					
					case 5:
						System.out.println("Enter the ID of the movie rating you want: ");
						Long searchID=sc.nextLong();
						System.out.println(likeMovies.getMovieRating(searchID));
						break;
						}
				}while(movieMenu!=0);
				break;
				
		case 3:
			int ratingMenu=0;
			do{
				System.out.println("*****************************");
				System.out.println("*Welcome to the rating Menu *");
				System.out.println("*1.Add new Rating           *");
				System.out.println("*2.Delete a Rating          *");
				System.out.println("*3.Delete all Ratings       *");
				System.out.println("*4.Show all Ratings         *");
				System.out.println("*5.Search for rating with ID*");
				System.out.println("*0.return to main menu      *");
				System.out.println("*****************************");
				System.out.println("Please Enter your Option: ");
				ratingMenu=sc.nextInt();
				
				switch(ratingMenu)
				{
				case 1:
					System.out.println("Enter User ID for the rating");
	    	  		 Long newUserID = sc.nextLong();
	    	  		System.out.println("Enter Movie ID for the rating");
	    	  		Long newMovieID = sc.nextLong();
	    	  		System.out.println("Enter your rating");
	    	  		Float rating = sc.nextFloat();
	    	  		likeMovies.addRating(newUserID, newMovieID, rating);
	    	  		System.out.println("Rating added");
	    	  		break;
					
				case 2:
					System.out.println("Enter Rating ID");
	    	  		Long deleteRatingID = sc.nextLong();
	    	  		likeMovies.deleteRating(deleteRatingID);
	    	  		System.out.println("Rating Deleted");
	    	  		break;
	    	  		
				case 3:
					System.out.println("Deletion in progress");
	    	  		likeMovies.deleteRatings();
	    	  		System.out.println("Ratings deleted");
	    	  		break;
	    	  		
				case 4:
					System.out.println(likeMovies.getRatings());
					break;
					
				case 5:
					System.out.println("Enter rating ID you want searched: ");
					Long ratingSearchID=sc.nextLong();
					System.out.println(likeMovies.getRating(ratingSearchID));
					break;
				}
			}while(ratingMenu!=0);
			break;
		}
	}while(mainMenu!=0);
	
	System.out.println("Storing changes..\n");
	likeMovies.store();
	System.out.println("Saving Complete \n");
	System.out.println("Thanks for using Movie recommender.");
	System.out.println("Goodbye");

	}
}

