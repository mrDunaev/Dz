/**
 *  Java 1. Homework 5
 * 
 * @author Dunaev
 * @version 16.11.2021
 */
class Homework5 {
    public static void main (String[] args) {
        Employee[] emplArray = new Employee[5];

        emplArray[0] = new Employee("Smirnova Anna", "Programmer", "smirnovaav@gmail.com", "89113657846", 110000, 33);
        emplArray[1] = new Employee("Dunaev Alexander", "Tester", "dunaevalex@gmail.com", "89215679854", 90000, 30);
        emplArray[2] = new Employee("Petrova Zinaida", "Cleaner", "petrovazina@mail.ru", "89113249233", 30000, 56);
        emplArray[3] = new Employee("Novikov Andrey", "Programmer", "novikovaf@mail.ru", "89217591954", 200000, 50);
        emplArray[4] = new Employee("Ivanova Elena", "HR", "ivanovaelena96@ya.ru", "89046774549", 60000, 25);

        for (int i = 0; i < emplArray.length; i++) {
            if (emplArray[i].getAge() > 40)
                System.out.println(emplArray[i] + "\n");
        }
    }
}

class Employee {
    private String fullname;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    Employee (String fullname, String position, String email, String phone, int salary, int age) {
        this.fullname = fullname;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Fullname: " + fullname + "\nPosition: " + position + "\nEmail: " + email + "\nPhone: " + phone + "\nSalary: " + salary + "\nAge: " + age;
    }
}
