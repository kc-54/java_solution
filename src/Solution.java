import java.util.Locale;

public class Solution { 
	public static void main(String[] args) { 
		
	} 

	public static int count_fly(Animal[] animals){
		int result = 0;
		for(Animal iter : animals){
			if(iter.canFly()){
				result++;
			}
		}
		return result;
	}
	public static int count_walk(Animal[] animals){
		int result = 0;
		for(Animal iter : animals){
			if(iter.canWalk()){
				result++;
			}
		}
		return result;
	}
	public static int count_sing(Animal[] animals){
		int result = 0;
		for(Animal iter : animals){
			if(iter.canSing()){
				result++;
			}
		}
		return result;
	}
	public static int count_swim(Animal[] animals){
		int result = 0;
		for(Animal iter : animals){
			if(iter.canSwim()){
				result++;
			}
		}
		return result;
	}
} 

//interface for each ability
interface canFly{
	public void fly();
}

interface canSing{
	public void sing();
}

interface canWalk{
	public void walk();
}

interface canSwim{
	public void swim();
}

//abstract class for super class animal
abstract class Animal {
	//property and action for each animal
	private String property = "";
	private String action = "";
	
	//method to get information whether the subclass can perform certain ability
	public boolean canFly(){
		return canFly.class.isAssignableFrom(this.getClass());
	}
	public boolean canSing(){
		return canSing.class.isAssignableFrom(this.getClass());
	}
	public boolean canWalk(){
		return canWalk.class.isAssignableFrom(this.getClass());
	}
	public boolean canSwim(){
		return canSwim.class.isAssignableFrom(this.getClass());
	}
	
	//getter and setter for property and action
	public void set_property(String property){
		this.property = property;
	}
	public void set_action(String action){
		this.action = action;
	}
	public String get_property(){
		return this.property;
	}
	public String get_action(){
		return this.action;
	}
}

//class bird
class Bird extends Animal implements canSing,canWalk,canFly{	

	//implements all the interface
	public void sing(){
		System.out.println("I can Sing");
	}

	public void walk(){
		System.out.println("I can Walk");
	}

	public void fly(){
		System.out.println("I can Fly");
	}

}

//class duck
class Duck extends Animal implements canSing,canWalk,canSwim,canFly{
	
	//implements interface
	//the sing method will say Quack, quack
	public void sing(){
		System.out.println("Quack, quack");
	}

	public void swim(){
		System.out.println("I can Swim");
	}

	public void fly(){
		System.out.println("I can Fly");
	}

	public void walk(){
		System.out.println("I can Walk");
	}

}

//class chicken
class Chicken extends Animal implements canSing,canWalk{

	//implements interface
	//the sing method will say Cluck, cluck
	public void sing(){
		System.out.println("Cluck, cluck");
	}

	public void walk(){
		System.out.println("I can Walk");
	}
}


//model a rooster base on chicken
class Rooster extends Chicken{

	//override the sing method from cluck, cluck to cock-a-doodle-doo
	@Override
	public void sing(){
		Locale currentLocale = Locale.getDefault();
		if("da".equals(currentLocale.getLanguage())) {//danish
			System.out.println("kykyliky");
		}else if("nl".equals(currentLocale.getLanguage())) {//dutch
			System.out.println("kukeleku");
		}else if("fi".equals(currentLocale.getLanguage())) {//finnish
			System.out.println("kukko kiekuu");
		}else if("fr".equals(currentLocale.getLanguage())) {//french
			System.out.println("cocorico");
		}else if("de".equals(currentLocale.getLanguage())) {//german
			System.out.println("kikeriki");
		}else if("el".equals(currentLocale.getLanguage())) {//greek
			System.out.println("kikiriki");
		}else if("iw".equals(currentLocale.getLanguage())) {//hebrew
			System.out.println("coo-koo-ri-koo");
		}else if("it".equals(currentLocale.getLanguage())) {//italian
			System.out.println("chicchirichi");
		}else {//default english
			System.out.println("Cock-a-doodle-doo");
		}
	}

}


//parrot class
class Parrot extends Bird{
	//parrot neighbour(object or only sounds). Assuming objects are animal type and sounds are non animal type (ex. phone)
	private Object neighbour;
	private String neighbour_sound;

	public Parrot(){
	}

	//if parrot neighbour is animal class object
	public Parrot(Object neighbour){
		this.neighbour = neighbour;
	}

	//if parrot only knows the sound strings
	public Parrot(String neighbour_sound){
		this.neighbour_sound = neighbour_sound;
	}

	//override the sing method
	@Override
	public void sing(){
		//if both neighbour obj and sounds is unknown, print default sing
		if(this.neighbour == null && neighbour_sound == null){
			System.out.println("I am singing");
		}else if(this.neighbour != null && canSing.class.isAssignableFrom(this.neighbour.getClass())){
			//if neighbour is animal obj, print the animal sound
			try{
				this.neighbour.getClass().getMethod("sing").invoke(this.neighbour);
			}catch(Exception e){
				System.out.println("Error : " + e);
			}
		}else if(this.neighbour_sound != null){
			//if parrot only know neighbour sound, print the sound
			System.out.println(this.neighbour_sound);
		}else{
			//else, print default sing
			System.out.println("I am singing");
		}
	}
}

//example dog and cat class for parrot neighbour
class Dog extends Animal implements canSing,canWalk{
	
	public void sing(){
		System.out.println("Woof, woof");
	}

	public void walk(){
		System.out.println("I can Walk");
	}
}

class Cat extends Animal implements canSing,canWalk{
	
	public void sing(){
		System.out.println("Meow");
	}

	public void walk(){
		System.out.println("I can Walk");
	}
}


//solution for B
//modelling a fish
class Fish extends Animal implements canSwim{
	public void swim(){
		System.out.println("I can Swim");
	}
}

//specialize a class from fish
class Shark extends Fish {

	public Shark(){
		this.set_property("Large and grey");
		this.set_action("Eat other fish");
	}
}

//specialize a class from fish
class Clownfish extends Fish {

	public Clownfish(){
		this.set_property("Small and colourful (orange)");
		this.set_action("Make jokes");
	}

}

class Dolphin extends Animal implements canSwim{
	public void swim(){
		System.out.println("I can Swim");
	}
}

//modelling a butterfly
class Butterfly extends Animal implements canFly,canWalk{

	public void fly(){
		System.out.println("I can Fly");
	}

	public void walk(){
		System.out.println("I can Walk");
	}

}
//modelling a caterpillar
class Caterpillar extends Animal implements canWalk{
	public void walk(){
		System.out.println("I can Walk");
	}
	
	//return butterfly obj when metamorph
	public Animal metamorph(){
		return new Butterfly();
	}
}