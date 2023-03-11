import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
import java.util.*;



public class CarShop {
    
    private ArrayList<Double> mileageList = new ArrayList<>();
    private ArrayList<Double> priceList = new ArrayList<>();
    //private ArrayList carList = new ArrayList(); 
    private List<Car> carList = new ArrayList<>();
    private Cargrad cargrad = new Cargrad();
    private int testflag = 1;
    
    
    
    
    
    public CarShop(){
        
        if(testflag == 1){
              carList.add(new Car(1, "Honda", "Fit", 2013, 200500, 1.3, 'A', 5550.50));
             mileageList.add(200500.0);
             priceList.add(5550.50);


            carList.add(new Car(2, "Toyota", "Prius", 2012, 22000, 1.8, 'A', 8450.00));
            mileageList.add(22000.0);
            priceList.add(8450.00);
            
            carList.add(new Car(3, "Volkswagen", "Golf", 2016, 74550, 1.5, 'A', 12500.0));
            mileageList.add(74550.0);
            priceList.add(12500.0);
            
            
            carList.add(new Car(4, "Toyota", "Yaris", 2011, 110100, 1.0, 'A', 6550.50));
            mileageList.add(100100.0);
            priceList.add(6550.50);


           carList.add(new Car(5, "Toyota", "Prius", 2015, 52300, 1.8, 'C', 9999.95));
           mileageList.add(523000.0);
           priceList.add(9999.95);
           
           carList.add(new Car(6, "Volkswagen", "Polo", 2015, 140820, 1.5, 'B', 3050.50));
           mileageList.add(140820.0);
           priceList.add(3050.50);
            
            
            

        }
        else{
        Scanner scanner = new Scanner(System.in);
       
        System.out.println("Enter the number of cars you want to input:");
        int numCars = 0;
        try {
            numCars = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.nextLine();
            System.exit(0);
        }

        for (int i = 0; i < numCars; i++) {
            System.out.println("\nEnter data for Car " + (i + 1) + ":");
            System.out.print("Manufacturer: ");
            String manufacturer = scanner.next();

            System.out.print("Model: ");
            String model = scanner.next();

            int carID = i;
            int year = 0;
            while (true) {
                try {
                    System.out.print("Year: ");
                    year = scanner.nextInt();
                    if (year > 0 && year <= 2023) {
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter a valid year.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    scanner.nextLine();
                }
            }

            double mileage = 0;
            while (true) {
                try {
                    System.out.print("Mileage: ");
                    mileage = scanner.nextDouble();
                    if (mileage >= 0) {
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter a valid mileage.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine();
                }
            }

            double engineSize = 0;
            while (true) {
                try {
                    System.out.print("Engine Size: ");
                    engineSize = scanner.nextDouble();
                    if (engineSize >= 0.8 && engineSize<=6.0) {
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter a valid engine size.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine();
                }
            }

            char grade = ' ';

            while (true) {
                try {
                    System.out.print("Grade (A/B/C/D): ");
                    String input = scanner.next().toUpperCase();
                    if (input.length() == 1 && "ABCD".contains(input)) {
                        grade = input.charAt(0);
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter a valid grade (A/B/C/D).");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid character.");
                }
            }

            

            double price = 0;
            while (true) {
                try {
                    System.out.print("price: ");  // £
                    price = scanner.nextDouble();
                    if (price >= 0) {
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter a valid price.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine();
                }
            }
            Car  carinput  = new Car(carID,manufacturer,model,year,mileage,
            engineSize,grade,price); 
            carList.add( carinput );
            mileageList.add(mileage);
            priceList.add(price);
           
        }

        }
         System.out.println("Input is ready!");
    }
   
        
//Sort all cars’ data by model (in alphabetical order)
    void getmodelsort(){
        // ArrayList modlist = new ArrayList();
        // for( Car car: carList){
        //     modlist.add((car.toString());
        // }
        Collections.sort(carList, new Comparator<Car>() {
            @Override
            public int compare(Car c1, Car c2) {
                return c1.getmodel().compareTo(c2.getmodel());
            }
        });
       

        System.out.println("Sorted cars by model in alphabetical order:");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%-10s %-12s %-12s %-10s %-10s %-10s %-10s %s\n", "Car ID", "Manufacturer", "Model", "Year", "Mileage", "EngineSize", "Grade", "Price");

        for (Car car : carList) {
             System.out.printf("%-10d %-12s %-12s %-10d  %-10.1f%-10s %-10s £%,.2f\n", 
                car.getcarID(), car.getmanufacturer(), car.getmodel(), car.getyear(), 
                car.getmileage(), car.getengineSize()+"L", car.getgrade(), car.getprice());

        }
    }
    
          
        
    
// Sort all cars' data by price from low to high
    void sortByPriceAscending() {
        Collections.sort(carList, new Comparator<Car>() {
            @Override
            public int compare(Car c1, Car c2) {
                return Double.compare(c1.getprice(), c2.getprice());
            }
        });
    
      System.out.println();
      System.out.println("Sorted cars by price from low to high:");
      
     
      System.out.println("-----------------------------------------------------------------------------");
      System.out.printf("%-10s %-12s %-12s %-10s %-8s %-7s %-8s %s\n", "Car ID", "Manufacturer", "Model", "Year", "Mileage", "EngineSize", "Grade", "Price");

      for (Car car : carList) {
          System.out.printf("%-10d %-12s %-12s %-10d %-10.1f%-10s %-6s £%,.2f\n", 
            car.getcarID(), car.getmanufacturer(), car.getmodel(), car.getyear(), 
            car.getmileage(), car.getengineSize()+"L", car.getgrade(), car.getprice());

  }
    }
  
        

    //Search and identify the car with the lowest mileage 
    public Car findCarWithLowestMileage () {
        
        Car carWithLowestMileage = null;
        double lowestMileage = Double.MAX_VALUE;

        for (Car car : carList) {
            double mileage = car.getmileage();
            if (mileage < lowestMileage) {
                lowestMileage = mileage;
                carWithLowestMileage = car;
            }
        }
       // Print the car with lowest mileage to the console
        System.out.println();
        System.out.println("Car with lowest mileage: ");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%-10s %-12s %-12s %-10s %-10s %-10s %-10s %s\n", "Car ID", "Manufacturer", "Model", "Year", "Mileage", "EngineSize", "Grade", "Price");
        System.out.println(carWithLowestMileage);
        return carWithLowestMileage;
        
       
    }
    
  //Search and identify the car with the lowest price
    public Car findCarWithLowestPrice () {
        Car carWithLowestPrice = null;
        double lowestPrice = Double.MAX_VALUE;

        for (Car car : carList) {
            double price = car.getprice();
            if (price < lowestPrice) {
                lowestPrice = price;
                carWithLowestPrice = car;
            }
        }
        System.out.println("Car with lowest price: ");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%-10s %-12s %-12s %-10s %-10s %-10s %-10s %s\n", "Car ID", "Manufacturer", "Model", "Year", "Mileage", "EngineSize", "Grade", "Price");
        System.out.println(carWithLowestPrice);
        return carWithLowestPrice;
    }
    
    
  //Search car by ID (take car ID from user) and generate a report.
    
    public void generateReportForCarById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter car ID: ");
        int carID = scanner.nextInt();

        for (Car car : carList) {
            if (car.getcarID() == carID) {

                String carCondition =
                     cargrad.getcondition(car.getgrade()).toLowerCase();
                System.out.println("Car with ID " + carID + ":\n"
                        + "Manufacturer: " + car.getmanufacturer() + "\n " 
                        + "Model:" + car.getmodel() + "\n"
                        + "Year: " + car.getyear() + "\n"
                        + "Price: £" + car.getprice() + "\n"
                        + "Mileage: " + car.getmileage() + " miles\n"
                        + "Condition: " + carCondition + "\n");
                return;
            }

        }

        System.out.println("Car with ID " + carID + " not found.\n");
        
       
    }

 
    //generate sample car data stock 
    
    public void getsamplereport() {
        Collections.sort(carList, new Comparator<Car>() {
            @Override
            public int compare(Car c1, Car c2) {
                return c1.getmanufacturer().compareTo(c2.getmanufacturer());
            }
        });

        ArrayList<String> manulist = new ArrayList<>();
        ArrayList<Integer> numberlist = new ArrayList<>();
        ArrayList<Double> stockprice = new ArrayList<>();

        String cur_manufacturer = "";
        for (Car car : carList) {
            String manufacturer = car.getmanufacturer();
            if (!manufacturer.equals(cur_manufacturer)) {
                cur_manufacturer = manufacturer;
                manulist.add(manufacturer);
                numberlist.add(1);
                stockprice.add(car.getprice());
            } else {
                int last_index = numberlist.size() - 1;
                numberlist.set(last_index, numberlist.get(last_index) + 1);
                stockprice.set(last_index, stockprice.get(last_index) + car.getprice());
            }
        }

        System.out.println("Car Stock Report");
        System.out.println("-----------------");
        System.out.println("Manufacturer\t\tNumber of Vehicles\t\tStock Price");

        for (int i = 0; i < manulist.size(); i++) {
            System.out.printf("%-20s\t\t%-20d\t\t$%-20.2f\n", manulist.get(i), numberlist.get(i), stockprice.get(i));
        }
    }


    
   // 
    class Car{

        private int carID;
        private String manufacturer;
        private String model;
        private int year;
        private double engineSize;
        private char grade;
        private double price;
        private double mileage;
        // private ArrayList<Double> mileageList = new ArrayList<>();
        // private ArrayList<Double> priceList = new ArrayList<>();

        public Car(int carID, String manufacturer, String model, 
            int year, double mileage, double engineSize, char grade, double price) {
            this.carID = carID;
            this.manufacturer = manufacturer;
            this.model = model;
            this.year = year;
            this.engineSize = engineSize;
            this.grade = grade;
            this.price = price;
            this.mileage = mileage;
            // mileageList.add(mileage);
            // priceList.add(price);
        }
        
      //  public Object getengineSize() {
            // TODO Auto-generated method stub
        //  return null;
        //}

        public int getcarID(){
            return carID;
        }
        
        public String getmanufacturer(){
            return manufacturer;
        }
        public String getmodel(){
            return model;
        }
        
        public int getyear(){
            return year;
        }
        
        public double getengineSize(){
            return engineSize;
        }
        
        
        public char getgrade() {
            return grade;
        }
        
        public double getprice(){
            return price;
        }
        
        public double getmileage(){
            return mileage;
        }
        
      

       @Override
      // public String toString() {
       // return String.valueOf(carID) + " " + manufacturer 
             // + " "+ model + " "+ String.valueOf(year) + 
              // " "+String.valueOf(mileage) + " "+ engineSize+" "+ grade 
             //  +" "+ String.valueOf(price);
    
      
      
      
        public String toString() {
         
                //return String.format("%-10d %-12s %-12s %-10d %-10.1f %-10.1f %-10s £%,.2f", 
                       // carID, manufacturer, model, year, mileage, engineSize, grade, price);
           return String.format("%-10d %-12s %-12s %-10d %-10.1f %-10s %-10s £%,.2f",
                    carID, manufacturer, model, year, mileage, engineSize + "L", grade, price);
            }
            }
        

       
       
    
    
    
    





public static void main(String[] args) {
       
        CarShop carShop = new CarShop(); // Initialize carShop as an instance of the CarShop class

        // call the sorting methods 
        carShop.getmodelsort();
        carShop.sortByPriceAscending();

        // Call the findCarWithLowestMileage() method on the carShop instance
        Car carWithLowestMileage = carShop.findCarWithLowestMileage();

        
        
        System.out.println();
        // Find and print the car with lowest price
        Car lowestPriceCar = carShop.findCarWithLowestPrice();
        carShop.generateReportForCarById(); 
        carShop.getsamplereport();
        
    }
}

   class Cargrad{
    private ArrayList gradList =new ArrayList();
    private ArrayList<String> conditionList =new ArrayList<>();
    private ArrayList<String> descriptionList =new  ArrayList<>(); 

    public Cargrad(){
        gradList.add("A");
        gradList.add("B");
        gradList.add("C");
        gradList.add("D");
       
        conditionList.add("Excellent");
        conditionList.add("Good");
        conditionList.add("Average");
        conditionList.add("Poor");
       
        descriptionList.add("Very slightly used, virtually as good as new.");
        descriptionList.add("Good condition but with visible flaws.");
        descriptionList.add("Average condition, with minor damage..");
        descriptionList.add("Poor condition with significant damage, but the car is functional.");
        
    }
              
     public String getcondition(char grade) {
              switch (grade){
                  case 'A':
                      return conditionList.get(0);
                  case 'B':
                      return conditionList.get(1);
                  case 'c':
                      return conditionList.get(2);
                  case 'D':
                      return conditionList.get(3);
                  default: 
                      return "Unknown";
              }

        }

         
   }