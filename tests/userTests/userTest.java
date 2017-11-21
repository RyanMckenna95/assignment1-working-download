package userTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import models.User;
import static models.Fixtures.users;


public class userTest {
	User sterling=new User("Sterling", "Archer", "35","M","spy");
	
	@Test
	public void testAdd(){
		assertEquals("Sterling", sterling.firstName);
		assertEquals("Archer", sterling.lastName);
		assertEquals("M", sterling.gender);
		assertEquals("spy", sterling.occupation);
	}
	
	@Test 
	public void IDsTest(){
		Set<Long>testID=new HashSet<>();
		for(User user: users)
		{
			testID.add(user.id);
		}
		assertEquals(users.length, testID.size());
	}
	
	
	@Test
	public void testToString(){
		assertEquals("User{"+sterling.id+",Sterling, Archer, 35, M, spy}",sterling.toString());
	}
}
