package ratingsTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static models.Fixtures.rating;
import org.junit.Test;

public class testRatings {

	@Test
	public void testAdd(){
		assertEquals(1,1L,rating[0].userID);
		assertEquals(1,2L,rating[0].movieID);
		assertEquals(3,rating[0].newRating);
	}
	
	@Test
	public void testIds() {
		
		assertNotEquals(rating[0].id, rating[1].id);
	}
	
	@Test
	public void testToString() {
		assertEquals("Rating{"+rating[0].id +", 1, 2, 3}", rating[0].toString());
	}
}
