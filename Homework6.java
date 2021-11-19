/**
 *  Java 1. Homework 6
 * 
 * @author Dunaev
 * @version 19.11.2021
 */
class Homework6 {
    public static void main (String[] args) {
        IAnimal[] animals = {
            new Dog("Bobik", 500, 10),
            new Cat("Barsik", 200, 0)
        };

        for (IAnimal animal : animals) {
            System.out.println(animal.run(501));
            System.out.println(animal.swim(15));
        }
    }
}

interface IAnimal {
    String run(int distance);
    String swim(int distance);
}

abstract class Animal implements IAnimal {
    protected String name;
    protected int runMaxDistance;
    protected int swimMaxDistance;

    Animal (String name, int runMaxDistance, int swimMaxDistance) {
        this.name = name;
        this.runMaxDistance = runMaxDistance;
        this.swimMaxDistance = swimMaxDistance;
    }

    @Override
    public String run (int distance) {
        if (distance <= runMaxDistance) {
            return name + " runs " + distance + " m.";
        } else {
            return name + " cannot run distance more than " + runMaxDistance + " m.";
        }
    }

    @Override
    public String swim (int distance) {
        if (distance <= swimMaxDistance) {
            return name + " swims " + distance + " m.";
        } else {
            return name + " cannot swim distance more than " + swimMaxDistance + " m.";
        }
    }
}

class Dog extends Animal {
    Dog (String name, int runMaxDistance, int swimMaxDistance) {
        super(name, runMaxDistance, swimMaxDistance);
    }
}

class Cat extends Animal {
    Cat (String name, int runMaxDistance, int swimMaxDistance) {
        super(name, runMaxDistance, swimMaxDistance);
    }

    @Override
    public String swim (int distance) {
        return name + " cannot swim, because it is a cat.";
    }
}