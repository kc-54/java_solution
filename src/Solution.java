
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
}


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