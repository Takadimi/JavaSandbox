package LearningSpace;

import java.io.*;
import java.util.*;

public class ObjectWriter {
	
	public static void main(String[] args) {
		
		Mob zombie = new Mob("Gary", 60, 5, 8, 10);
		
		try {
			
			FileOutputStream fo = new FileOutputStream("Zombie.obj");
			ObjectOutputStream oo = new ObjectOutputStream(fo);
			oo.writeObject(zombie);
			oo.close();
			System.out.println("Object created successfully.");
			
		} catch (IOException e) {
			System.out.println("Error -- " + e.toString());
		}
		
	}
	
}

class Mob implements Serializable {
	
	String name;
	int height;
	float attack;
	int defense;
	int health;
	
	public Mob(String name, int height, float attack, int defense, int health) {
		
		this.name = name;
		this.height = height;
		this.attack = attack;
		this.defense = defense;
		this.health = health;
		
	}
	
}
