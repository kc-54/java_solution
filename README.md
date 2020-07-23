# Java_solution
2359 Media Java test 


This is a solution for java test created by Kelvin

For question A:


The ability of each animal is defined using an interface. 

The animal in general is defined using abstract class Animal. 

The specific animal will extend this abstract class Animal and implements interfaces they need.


The abstract class Animal also has several methods (canFly, canSwim, canSing, and canWalk)  that return a boolean value. 

These methods return true if the class (Ex. Bird class) implements a certain method and will return false if it doesn't implement the method. 

For example, A bird class implements canFly and canSing interface, hence, when the method canSwim in animal class is called, it will return false since the bird class doesn't implement the canSwim interface.

For a specific animal that extends other specific animals (ex. Rooster extends Chicken), @Override can be used to override their superclass method.

For Parrot class, each parrot knows either Object neighbor or only sounds. The parrot constructor can receive either Object neighbor or only sounds. 
For the sing() method, it will check, if the neighbor is an Animal object and can sing, it will imitate the Animal object Sing. Else if the neighbor is a known sound (Ex. phone "ring ring"), it will print out the sound. Else, it will print out the default message "I am singing".



For question B:


The abstract class Animal has 2 variable property and action with getter and setter. Ex. Clownfish have property "orange and small" and action "make jokes". 

Generally, fish can swim, so the class Fish implements canSwim is created for other specific fish to extends. 

For each specific fish that extends fish class, it can set their property and action in the constructor class. 

For the dolphin use case, the class can extends Animal abstract class and implements CanSwim instead of extends from fish class.

There isn't question C


For question D:


For the butterfly use case, the class can extends Animal abstract class and implements CanFly, CanWalk.

For caterpillar use case, the class extends Animal abstract class and implements CanWalk. 

The caterpillar class also has a metamorph method that returns a new butterfly object. When the caterpillar metamorph into a butterfly, it will reassign the caterpillar with the butterfly obj returned.

Example: 

Animal caterpillar = new Caterpillar();

caterpillar = ((Caterpillar)caterpillar).metamorph();

((Butterfly)caterpillar).fly(); //call fly method on butterfly



For question E:


For instantiating the array of animals : 
Animal[] animals = {new Bird(), new Duck(), new Chicken(), new Rooster(), new Parrot(), new Fish(), new Shark(), new Clownfish(), new Dolphin(), new Butterfly()}

To count the number of animals with specific ability, the function will loop through the array and will call the method canAbility(ex. canFly), if it is true, it will increment the counter. 
At the end of the loop, it will return the counter as the result.

