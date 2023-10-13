import java.util.Scanner;
import java.util.ArrayList;
public class Payroll {
    private static ArrayList<Employee> employees = new ArrayList<Employee>(100);
    private static int employee_num = 0;


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String choice = "";
        //This do while loop will display the menu and ask the user for a choice
        do {
            displayMenu();
            choice = input.nextLine().toUpperCase();
            switch (choice) {
                case "A":
                    addEmployee();
                    break;
                case "P":
                    EmployeeSearch();
                    break;
                case "D":
                    displayEmployee();
                    break;
                case "C":
                    CalculatePayRoll();
                    break;
                case "Q":
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (!choice.equals("Q"));
    }

    //This method displays the menu
    public static void displayMenu() {
        System.out.println("A - Add an employee");
        System.out.println("P - Search employee by last name");
        System.out.println("D - Display employee by ID");
        System.out.println("C - Calculate payroll");
        System.out.println("Q - Quit");
    }

    //This method adds an employee to the arraylist
    //It asks the user for theemployee first name, last name
    //It then provides a switch statement for the user to choose the employee type
    public static void addEmployee() {
        Scanner input = new Scanner(System.in);
        String firstName = "";
        String lastName = "";
        String EmployeeType = "";
        int payRate = 0;
        int yearly_Pay = 0;
        int UnitsSold = 0;
        int ValuePerUnit=0;
        float yearlyBasePay = 0;
        double commissionSchedule[][] = null;
        // if(firstName.matches("[a-zA-Z]+") && lastName.matches("[a-zA-Z]+"))
        do {
            System.out.println("Please enter the employee's first name");
            firstName = input.nextLine().trim();
            if (!firstName.matches("[a-zA-Z]+") || firstName.isEmpty()) {
                System.out.println("Invalid name. Please enter characters only");

            } else if (firstName.equalsIgnoreCase("q")) {
                System.out.println("Returning to main menu");
                return;
            }
            System.out.println("Please enter the employee's last name");
            lastName = input.nextLine().trim();
            if (!lastName.matches("[a-zA-Z]+") || lastName.isEmpty()) {
                System.out.println("Invalid name. Please enter characters only");
            } else if (lastName.equalsIgnoreCase("q")) {
                System.out.println("Returning to main menu");
                return;
            }
        } while (!firstName.matches("[a-zA-Z]+") || !lastName.matches("[a-zA-Z]+"));
        do {
            System.out.println("Please enter the employee's type:");
            System.out.println("H - Hourly");
            System.out.println("S - Salary");
            System.out.println("C - Commission");
            EmployeeType = input.nextLine().toUpperCase();
            switch (EmployeeType) {
                case "H" -> {
                    System.out.println("Please enter the employee's pay rate: ");
                    payRate = input.nextInt();
                    employees.add(employee_num, new HourlyEmployee(firstName, lastName, payRate));
                    employee_num++;
                    break;

                }
                case "S" -> {
                    System.out.println("Please enter the employee's yearly pay: ");
                    yearly_Pay = input.nextInt();
                    employees.add(employee_num, new SalariedEmployee(firstName, lastName, yearly_Pay));
                    employee_num++;
                    break;

                }

                case "C" -> {
                    String UnitsSoldString, ValuePerUnitString;
                    System.out.println("Please enter the employee's yearly base pay: ");
                    yearlyBasePay = input.nextFloat();
                    input.nextLine();
                    int i = 1;
                    do{
                        System.out.println("Enter the number of units sold for period " + i + ": ");
                        UnitsSoldString = input.nextLine();
                        if(UnitsSoldString.equalsIgnoreCase("Q")) {
                            break;
                        }
                        UnitsSold = Integer.parseInt(UnitsSoldString);
                        System.out.println("Enter the value per unit for period " + i + ": ");
                        ValuePerUnitString = input.nextLine();
                        if(ValuePerUnitString.equalsIgnoreCase("Q")){
                            break;
                        }
                        ValuePerUnit = Integer.parseInt(ValuePerUnitString);
                        commissionSchedule = new double[UnitsSold][ValuePerUnit];
                        i++;
                    }while(!UnitsSoldString.equalsIgnoreCase("Q") || !ValuePerUnitString.toUpperCase().equals("Q"));
                    employees.add(new CommissionEmployee(firstName, lastName, yearlyBasePay, commissionSchedule));
                    }
                default -> {
                    System.out.println("Invalid choice");
                    continue;
                }
            }break;
        }while (true);
    }

    // This method is used to search for an employee by last name
    // using the quick sort algorithm
    public static void EmployeeSearch()
    {
        Scanner input = new Scanner(System.in);
        String lastName = "";
        do {
            System.out.println("Please enter the employee's last name");
            lastName = input.nextLine().trim();
            if (!lastName.matches("[a-zA-Z]+") || lastName.isEmpty()) {
                System.out.println("Invalid name. Please enter characters only");
            } else if (lastName.equalsIgnoreCase("q")) {
                System.out.println("Returning to main menu");
                return;
            }
        } while (!lastName.matches("[a-zA-Z]+"));
        quickSort(employees, 0, employee_num - 1);
        int i = 0;
        while (i < employee_num && employees.get(i).getLastName().toUpperCase().equals(lastName)) {
            i++;
        }
        if (i == employee_num) {
            System.out.println("Employee not found");
        } else {
            System.out.println(employees.get(i));

        }



    }
    // This method is used to sort the employees by Id number
    // using the quick sort algorithm
    public static void displayEmployee() {
        int employee_num = -1;
        Scanner input = new Scanner(System.in);
        while (employee_num < 0) {
            System.out.println("Enter the employee's ID number: ");
            String ID = input.nextLine();
            if (ID.equalsIgnoreCase("q")) {
                return;
            }
            try {
                employee_num = Integer.parseInt(ID);
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID number");
            }
        }

            quickSort(employees, 0, Payroll.employees.size() - 1);
            int i = binarySearch(employees, employee_num);
            i = 0;
            if (i < -1) {
                System.out.println("Employee not found");
            }else {
                System.out.println(employees.get(i).toString());
            }

    }
    // This method is used to sort the employees by last name
    // It uses the quick sort algorithm
    public static  void quickSort( ArrayList<Employee> employees, int low, int high) {
        if (Payroll.employees == null || Payroll.employees.size() == 0) {
            return;
        }
        if (low >= high)
            return;
        int pivot = low + (high - low) / 2;

        int i = low, j = high;
        while (i <= j) {
            while (Payroll.employees.get(i).getLastName().compareTo(Payroll.employees.get(pivot).getLastName()) < 0) {
                i++;
            }
            while (Payroll.employees.get(j).getLastName().compareTo(Payroll.employees.get(pivot).getLastName()) > 0) {
                j--;
            }
            if (i <= j) {
                Employee temp = Payroll.employees.get(i);
                Payroll.employees.set(i, Payroll.employees.get(j));
                Payroll.employees.set(j, temp);
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(Payroll.employees, low, j);
        if (high > i)
            quickSort(Payroll.employees, i, high);
    }
    // This method will search for an employee in the ArrayList
    // using the binary search algorithm
    public static int binarySearch(ArrayList<Employee> employees, int employee_num){
        int low = 0;
        int high = employees.size() - 1;
        while(low <= high)
        {
            int mid = (low + high) / 2;
            if(Employee.getEmployee_num() == employee_num)
            {
                return mid;
            }
            else if(Employee.getEmployee_num() < employee_num)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return low;
    }
    // This method will calculate the pay for each employee
    // and display the results
    public static void CalculatePayRoll()
    {
        Scanner keyboard = new Scanner(System.in);
        for(int i = 0; i < employee_num; i++)
        {
            Employee employee = employees.get(i);
            //This if statement will check if the employee is a salaried employee
            // and if so, it will ask the user to enter the number of hours worked
            // and then set the hours worked for the employee
            if(employee instanceof HourlyEmployee) {
                HourlyEmployee hourlyEmployee = (HourlyEmployee) employee;
                System.out.println("Please enter the number of hours worked for " + employee.getFirstName() + " " + employee.getLastName());
                String hours = keyboard.nextLine();
                if (hours.equalsIgnoreCase("q")) {
                    System.out.println("Are you sure you want to quit? Any changes made will be lost (Y/N)");
                    String quit = keyboard.nextLine();
                    if (quit.equalsIgnoreCase("y")) {
                        return;
                    } else {
                        System.out.println("Please enter the number of hours worked for " + employee.getFirstName() + " " + employee.getLastName());
                        hours = keyboard.nextLine();
                    }
                }
                int hoursWorked = Integer.parseInt(hours);
                ((HourlyEmployee) employee).setHours(hoursWorked);
            }
            //This if statement will check if the employee is a salaried employee
            //If it is, it will ask the user to enter the number of units sold and the value per unit
            //It will then set the units sold and the value per unit for the employee
            else if( employee instanceof CommissionEmployee)
            {
                CommissionEmployee commissionEmployee = (CommissionEmployee) employee;
                System.out.println("Enter the number of units sold for " + employee.getFirstName() + " " + employee.getLastName());
                String UnitsSoldString = keyboard.nextLine();
                if(UnitsSoldString.equalsIgnoreCase("q"))
                {
                    System.out.println("Are you sure you want to quit? Any changes made will be lost (Y/N)");
                    String quit = keyboard.nextLine();
                    if(quit.equalsIgnoreCase("y"))
                    {
                        return;
                    }
                    else
                    {
                        System.out.println("Enter the number of units sold for " + employee.getFirstName() + " " + employee.getLastName());
                        UnitsSoldString = keyboard.nextLine();
                    }
                }
                int unitsSold = Integer.parseInt(UnitsSoldString);
                commissionEmployee.setUnitsSold(unitsSold);
            }
        }
        //This for loop will sort the employees by paycheck
        // using the selection sort algorithm
        for (int i = 0; i < employees.size() - 1; i++)
        {
            int max = i;
            for (int j = i + 1; j < employees.size(); j++)
            {
                if (employees.get(j).GetPaycheck() > employees.get(max).GetPaycheck())
                {
                    max = j;
                }
            }
            if(max != i)
            {
                Employee temp = employees.get(i);
                employees.set(i, employees.get(max));
                employees.set(max, temp);
            }
        }
        //This for loop will display the employees and their paychecks
        for(Employee employee : employees)
        {
           System.out.println(employee.getLastName() + ", " + employee.getFirstName() + "\t\t\t" + PayCheckFormat(employee.GetPaycheck()));
        }
        System.out.println("End of Payroll");
    }
    //This method formats the paycheck to be displayed in the correct format
    private static String PayCheckFormat(float pay)
    {
        return String.format("$%,10.2f", pay);
    }
}






