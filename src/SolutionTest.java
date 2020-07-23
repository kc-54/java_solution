import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

public class SolutionTest {
	//Question A

	//unit test 1a
	@Test
	public void testBirdSing() {
		Animal birdie = new Bird();
		assertEquals(true, invokeMethodAndReturnBool(birdie,"canFly"));
	}

	//function to get boolean value of certain ability/method of an animal
	public Boolean invokeMethodAndReturnBool(Animal animal, String method) {
		Boolean ablePerform = null;
		try {
			ablePerform = (Boolean)animal.getClass().getMethod(method).invoke(animal);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ablePerform;
	}
}
