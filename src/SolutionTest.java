import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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

	//unit test 2a
	@Test
	public void testDuckSound() {
		Animal duck = new Duck();
		String sound = invokeMethodAndReturnPrintString(duck,"sing");
		assertEquals(true, "Quack, quack".equals(sound));
	}
			
	//unit test 2b
	@Test
	public void testDuckSwim() {
		Animal duck = new Duck();
		assertEquals(true, invokeMethodAndReturnBool(duck,"canSwim"));
	}

	//unit test 2c
	@Test
	public void testChickenSound() {
		Animal chicken = new Chicken();
		String sound = invokeMethodAndReturnPrintString(chicken,"sing");
		assertEquals(true, "Cluck, cluck".equals(sound));
	}
	
	//unit test 2d
	@Test
	public void testChickenFly() {
		Animal chicken = new Chicken();
		assertEquals(false, invokeMethodAndReturnBool(chicken,"canFly"));
	}
	
	//unit test 3a
	@Test
	public void testRoosterSound() {
		Animal rooster = new Rooster();
		String sound = invokeMethodAndReturnPrintString(rooster,"sing");
		assertEquals(true, "Cock-a-doodle-doo".equals(sound));
	}
	
	//unit test 3b
	@Test
	public void testRoosterFly() {
		Animal rooster = new Rooster();
		assertEquals(false, invokeMethodAndReturnBool(rooster,"canFly"));
	}

	//unit test 4a
	@Test
	public void testParrotSoundWithDog() {
		Animal parrot = new Parrot(new Dog());
		String sound = invokeMethodAndReturnPrintString(parrot,"sing");
		assertEquals(true, "Woof, woof".equals(sound));
	}

	//unit test 4b
	@Test
	public void testParrotSoundWithCat() {
		Animal parrot = new Parrot(new Cat());
		String sound = invokeMethodAndReturnPrintString(parrot,"sing");
		assertEquals(true, "Meow".equals(sound));
	}

	//unit test 4c
	@Test
	public void testParrotSoundWithRooster() {
		Animal parrot = new Parrot(new Rooster());
		String sound = invokeMethodAndReturnPrintString(parrot,"sing");
		assertEquals(true, "Cock-a-doodle-doo".equals(sound));
	}

	//unit test 4d
	@Test
	public void testParrotSoundWithPhone() {
		Animal parrot = new Parrot("Ring ring");
		String sound = invokeMethodAndReturnPrintString(parrot,"sing");
		assertEquals(true, "Ring ring".equals(sound));
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

	//function to get string value of certain ability/method of an animal
	public String invokeMethodAndReturnPrintString(Animal animal, String method) {
		
		//method to capture the printout from sysout and return it in string
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);
		
		try {
			animal.getClass().getMethod(method).invoke(animal);
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
		
		System.out.flush();
		System.setOut(old);
		//regex to remove hidden characters
		return baos.toString().replaceAll("\\p{C}", "");
	}
}
