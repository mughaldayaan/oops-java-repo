import java.util.ArrayList;
import java.util.Scanner;

class Car {
    private String name;
    private String variant;
    private int year;
    private double dailyRate;

    public Car(String name, String variant, int year, double dailyRate) {
        this.name = name;
        this.variant = variant;
        this.year = year;
        this.dailyRate = dailyRate;
    }

    public double calculateRentalCost(int days) {
        return dailyRate * days;
    }

    public String getname() {
        return name;
    }

    public String getvariant() {
        return variant;
    }

    public int getYear() {
        return year;
    }
}

class LuxuryCar extends Car {
    private boolean isPremium;

    public LuxuryCar(String name, String variant, int year, double dailyRate, boolean isPremium) {
        super(name, variant, year, dailyRate);
        this.isPremium = isPremium;
    }

    public boolean isPremium() {
        return isPremium;
    }
}

class EconomyCar extends Car {
    public EconomyCar(String name, String variant, int year, double dailyRate) {
        super(name, variant, year, dailyRate);
    }
}

class CarRentalSystem {
    private ArrayList<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }
    public boolean removeCarBynameAndvariant(String carToRemove) {
        for (Car car : cars) {
            if ((car.getname()).equalsIgnoreCase(carToRemove)) {
                cars.remove(car);
                return true;
            }
        }
        return false;
    }
    public void displayAvailableCars() {
        System.out.println("Available Cars:");
         if(cars.isEmpty()){
                System.out.println("No car availabe");
            }
            else{ 
        for (Car car : cars) {
            System.out.println("name: " + car.getname());
            System.out.println("variant: " + car.getvariant());
            System.out.println("Year: " + car.getYear());
            System.out.println("Daily Rate: $" + car.calculateRentalCost(1));
        }
    }
    }
}

public class Main_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CarRentalSystem carRentalSystem = new CarRentalSystem();

        while (true) {
            System.out.println("Car Rental System Menu:");
            System.out.println("1. Add a Car");
            System.out.println("2. Remove a Car");
            System.out.println("3. Display Available Cars");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the name of the car");
                    String name = sc.next();
                    System.out.println("Enter the variant of the car");
                    String variant = sc.next();
                    System.out.println("At which year the car what created");
                    int year = sc.nextInt();
                    System.out.println("Enter the daily rate of your car");
                    double dr = sc.nextDouble();
                    Car car = new Car(name, variant, year, dr);
                    carRentalSystem.addCar(car);
                    System.out.println("Car added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Car (name variant) to remove: ");
                    String carToRemove = sc.next();

                    if (carRentalSystem.removeCarBynameAndvariant(carToRemove)) {
                        System.out.println("Car removed successfully.");
                    } else {
                        System.out.println("Car not found.");
                    }
                    break;

                case 3:
                    carRentalSystem.displayAvailableCars();
                    break;

                case 4:
                    System.out.println("Exiting Car Rental System.");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }

    
    
}


