package movieTest;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import models.Movie;

public class moviesTest {

	Movie test = new Movie("Terminal","2003","terminal.com");
	
	@Test
	public void testAdd()
	{
		assertEquals("Terminal", test.title);
		assertEquals("2003", test.year);
		assertEquals("terminal.com", test.url);
	}
	
	@Test
	public void testToString()
	{
		assertEquals("Movie{"+test.id+", Terminal, 2003, terminal.com, []}", test.toString());
	}
}
