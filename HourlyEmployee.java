public class HourlyEmployee extends Employee
{
    // variables below are used to hold the payrate and hours
    private int payrate, hours;

    //Constructor that takes in a first name, last name, and pay rate
    public HourlyEmployee(String firstName, String lastName, int pay_rate){
        super(firstName, lastName);
        payrate = pay_rate;
    }

    // getPayrate() method that returns the payrate
    public int getPayrate()
    {
        return payrate;
    }
    // setPayrate() method that sets the payrate
    public void setPayrate(int pay_rate)
    {
        payrate = pay_rate;
    }
    // getHours() method that returns the hours
    public int getHours() {
        return hours;
    }
    // setHours() method that sets the hours
    public void setHours(int hours) {
        this.hours = hours;
    }
    // GetPaycheck() method that returns payrate * hours
    @Override
    public  float GetPaycheck() {
        return (float) (payrate * hours);
    }
    // toString() method that returns HourlyEmployee and the employee number, first name, last name, by using
    // the Employee toString() method, and the payrate
    @Override
    public String toString() {
        return "Hourly: $" + payrate +" " +super.toString();
    }
}
