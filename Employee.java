public abstract class Employee {

    // variables below are used to hold the employee number, current employee number, first name, and last name
    private static int employee_num, current_employee_num;
    private static String firstName, lastName;

    // Constructor that takes in a first name and last name
    // Sets the first name and last name to the parameters
    // Sets the employee number to the current employee number
    // Increments the current employee number
    public Employee(String firstName, String lastName) {
        Employee.firstName = firstName;
        Employee.lastName = lastName;
        employee_num = 1;
        employee_num = current_employee_num;
        current_employee_num++;
    }
    // getEmployee_num() method gets the employee number
    public static int getEmployee_num()
    {
        return employee_num;
    }
    // setEmployee_num() method sets the employee number
    public static void setEmployee_num(int employee_num)
    {
        Employee.employee_num = employee_num;
    }

    // getLastName() method gets the last name
    public void setLastName(String lastName) {
        lastName = Employee.lastName;
    }
    // setLastName() method sets the last name
    public String getLastName() {
        return lastName;
    }
    // getFirstName() method gets the first name
    public void setFirstName(String firstName) {

        firstName = Employee.firstName;
    }
    // setFirstName() method sets the first name
    public String getFirstName() {
        return firstName;
    }

    // toString() method that returns the employee number, first name, and last name
    public String toString() {
        return firstName + " " + lastName + " " + employee_num;
    }

   // GetPaycheck() method that returns a float and is abstract so it can be overridden in the subclasses
    public abstract float GetPaycheck();

}
