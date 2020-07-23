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
	

	//Question B
	//unit test 1a
	@Test
	public void testFishSing() {
		Animal fish = new Fish();
		assertEquals(false, invokeMethodAndReturnBool(fish,"canSing"));
	}
	
	//unit test 1b
	@Test
	public void testFishWalk() {
		Animal fish = new Fish();
		assertEquals(false, invokeMethodAndReturnBool(fish,"canWalk"));
	}

	//unit test 1c
	@Test
	public void testFishSwim() {
		Animal fish = new Fish();
		assertEquals(true, invokeMethodAndReturnBool(fish,"canSwim"));
	}

	//unit test 2a
	@Test
	public void testSharkProperty() {
		Animal shark = new Shark();
		String prop = invokeMethodAndReturnString(shark,"get_property");
		assertEquals(true, "Large and grey".equals(prop));
	}
	
	//unit test 2b
	@Test
	public void testClownfishProperty() {
		Animal clownfish = new Clownfish();
		String prop = invokeMethodAndReturnString(clownfish,"get_property");
		assertEquals(true, "Small and colourful (orange)".equals(prop));
	}
	
	//unit test 2c
	@Test
	public void testClownfishAction() {
		Animal clownfish = new Clownfish();
		String prop = invokeMethodAndReturnString(clownfish,"get_action");
		assertEquals(true, "Make jokes".equals(prop));
	}

	//unit test 2d
	@Test
	public void testSharkAction() {
		Animal shark = new Shark();
		String prop = invokeMethodAndReturnString(shark,"get_action");
		assertEquals(true, "Eat other fish".equals(prop));
	}

	//unit test 3a
	@Test
	public void testDolphinSwim() {
		Animal dolphin = new Dolphin();
		assertEquals(true, invokeMethodAndReturnBool(dolphin,"canSwim"));
	}

	//Question D
	//unit test 1a
	@Test
	public void testButterflyFly() {
		Animal butterfly = new Butterfly();
		assertEquals(true, invokeMethodAndReturnBool(butterfly,"canFly"));
	}
	
	//unit test 1b
	@Test
	public void testButterflySing() {
		Animal butterfly = new Butterfly();
		assertEquals(false, invokeMethodAndReturnBool(butterfly,"canSing"));
	}

	//unit test 2a
	@Test
	public void testCaterpillarFly() {
		Animal caterpillar = new Caterpillar();
		assertEquals(false, invokeMethodAndReturnBool(caterpillar,"canFly"));
	}
	
	//unit test 2b
	@Test
	public void testCaterpillarWalk() {
		Animal caterpillar = new Caterpillar();
		assertEquals(true, invokeMethodAndReturnBool(caterpillar,"canWalk"));
	}
	
	//unit test 2 after metamorph
	@Test
	public void testCaterpillarMetamorph() {
		Animal caterpillar = new Caterpillar();
		caterpillar = ((Caterpillar)caterpillar).metamorph();
		
		assertEquals(true, invokeMethodAndReturnBool(caterpillar,"canFly"));
	}
	

	//Question E
	//unit test 1a
	@Test
	public void testCountAnimalFly() {
		Animal[] animals = {
				new Bird(), new Duck(), new Chicken(), new Rooster(), new Shark(), new Parrot(), new Clownfish(), new Dolphin()
			};
		//Duck, Bird, Parrot can fly
		assertEquals(3, Solution.count_fly(animals));
	}

	//unit test 1b
	@Test
	public void testCountAnimalWalk() {
		Animal[] animals = {
				new Bird(), new Duck(), new Chicken(), new Rooster(), new Shark(), new Parrot(), new Clownfish(), new Dolphin()
			};
		//Bird, Duck, Chicken, Rooster and Parrot can walk
		assertEquals(5, Solution.count_walk(animals));
	}

	//unit test 1c
	@Test
	public void testCountAnimalSing() {
		Animal[] animals = {
				new Bird(), new Duck(), new Chicken(), new Rooster(), new Shark(), new Parrot(), new Clownfish(), new Dolphin()
			};
		//Bird, Duck, Chicken, Rooster and Parrot can sing
		assertEquals(5, Solution.count_sing(animals));
	}

	//unit test 1d
	@Test
	public void testCountAnimalSwim() {
		Animal[] animals = {
				new Bird(), new Duck(), new Chicken(), new Rooster(), new Shark(), new Parrot(), new Clownfish(), new Dolphin()
			};
		//Duck, Shark, Clownfish, Dolphin can swim
		assertEquals(4, Solution.count_swim(animals));
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
	

	//function to get string value from method return of Animal obj
	public String invokeMethodAndReturnString(Animal animal, String method) {
		String string = null;
		try {
			string = (String)animal.getClass().getMethod(method).invoke(animal);
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
		
		return string;
	}
}
