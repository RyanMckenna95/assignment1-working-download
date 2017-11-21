package models;

public class Fixtures {
	public static User[] users = { 
			new User("Ryan", "Mckenna", "22", "M", "Student"),
			new User("Ellie", "Patterson", "22", "M", "Student") 
	};

	public static Movie[] movies = { 
			new Movie("E.T", "1989", "E.T.com"),
			new Movie("flight club", "1999", "fightclub.com"), 
			new Movie("day after tomorrow", "2004", "dayaftertomorrow.com"),
			new Movie("wall-e", "2009", "wall-e.com")

	};
	
	public static Rating[] rating = { 
			new Rating(1L, 2L, 3),
			new Rating(2L, 3L, 4), 
			new Rating(3L, 4L, 5),
			new Rating(4L, 5L, 6)

	};
}

