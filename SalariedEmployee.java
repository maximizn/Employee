
public class SalariedEmployee extends Employee
{
    protected float yearlyPay; // protected float yearlyPay variable that holds the yearly pay of the employee

    // Constructor that takes in a first name, last name, and yearly pay
    public SalariedEmployee(String firstName, String lastName, float yearly_Pay) {
        super(firstName, lastName);
        yearlyPay = yearly_Pay;
    }

    // Get the yearlyPay
    public float getYearlyPay() {
        return yearlyPay;
    }

    // Set the yearly pay to the parameter yearly_Pay
    public void setYearlyPay(float yearly_Pay) {
        yearlyPay = yearly_Pay;
    }

    // GetPaycheck() method that returns yearlyPay / 26
    @Override
    public float GetPaycheck() {
        return (float) (yearlyPay / 26);
    }

    // toString() method that returns SalariedEmployee and the employee number, first name, last name, by using
    // the Employee toString() method, and the yearly pay
    @Override
    public String toString() {
        return "Salaried, Base: $" + yearlyPay + super.toString();
    }
}
