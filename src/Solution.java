
public class Solution { 
	public static void main(String[] args) { 
		
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
