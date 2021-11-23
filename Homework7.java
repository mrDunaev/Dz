/**
 * Java 1. Homework 7
 * 
 * @author Dunaev
 * @version 23.11.2021
 */
class Homework7 {
    public static void main (String[] args) {
        //Creating cats and plate
        Cat[] cats = {
            new Cat("Barsik", 3),
            new Cat("Murzik", 4),
            new Cat("Ryjik", 7),
            new Cat("Pushok", 5)
        };
        Plate plate = new Plate(10);
        System.out.println("BEFORE FEEDING");
        printState(cats, plate);

        //Cats eating for the first time
        catsEating(cats, plate);
        System.out.println("\nAFTER FIRST FEEDING");
        printState(cats, plate);

        //Adding food in plate 
        plate.addFood(10);
        System.out.println("\nADDING FOOD IN PLATE");
        System.out.println(plate);

        //Second feeding
        catsEating(cats, plate);
        System.out.println("\nAFTER SECOND FEEDING");
        printState(cats, plate);
    }

    static void printState(Cat[] cats, Plate plate) {
        for (Cat cat : cats) {
            System.out.println(cat);
        }
        System.out.println(plate);
    }

    static void catsEating(Cat[] cats, Plate plate) {
        for (Cat cat : cats) {
            cat.eat(plate);
        }
    }
}

class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    Cat (String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    void eat(Plate plate) {
        if (!satiety)
            satiety = plate.decreaseFood(appetite);
    }

    @Override
    public String toString() {
        return "Cat " + name +  " with appetite " + appetite + " is " + (satiety ? "full." : "hungry.");
    }
}

class Plate {
    private int food;

    Plate(int food) {
        this.food = food;
    }

    boolean decreaseFood(int food) {
        if (this.food >= food) {
            this.food -= food;
            return true;
        }
        return false;
    }

    void addFood(int food) {
        this.food += food;
    }

    @Override
    public String toString() {
        return  "Plate: " + food;
    }
}