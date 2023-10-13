public class CommissionEmployee extends SalariedEmployee
{

        // variables below are used to hold the commission schedule, units sold, base rate, and rate
        private static double[][] commissionSchedule;
        private static int unitsSold;
        private double baseRate, rate;

        // Constructor that takes in a first name, last name, yearly pay, commission schedule, and base rate
        public CommissionEmployee(String firstName, String lastName, float yearlyPay,double[][] commission_Schedule) {
            super(firstName, lastName, yearlyPay);
            commissionSchedule = commission_Schedule;

        }

        // GetPaycheck method returns the paycheck amount by looping through the commission schedule and finding the rate per unit
        // Then multiplying the units sold by the rate per unit and adding the base rate/26
        @Override
        public float GetPaycheck() {
            double rate = 0;
            for (int i = 0; i < commissionSchedule.length; i++) {
                // Skip if the minimum units is 0
                if (commissionSchedule[i][1] == 0) {
                    continue;
                }
                // If the units sold is greater than the minimum units, set the rate to the value per unit
                if (unitsSold > i) {
                    rate = commissionSchedule[i][1];
                }
            }
            return (float)(unitsSold * rate + (baseRate/26));
        }



        // Get the commission schedule
        public static double[][] getCommissionSchedule() {
            return commissionSchedule;
        }

        // Set the commission schedule to the parameter commission_Schedule
        public void setCommissionSchedule(double[][] commission_Schedule) {
            commissionSchedule = commission_Schedule;
        }

        // Get the units sold
        public int getUnitsSold() {
            return unitsSold;
        }

        // Set the units sold to the parameter units_Sold
        public static void setUnitsSold(int units_Sold) {
            unitsSold = unitsSold;
        }


        // This method is used to print out the CommissionEmployee information using the toString() method in the Employee class
        @Override
        public String toString() {
            return  "Commissioned, Base: $" + baseRate + String.format("Id:%d - %s, %s", getEmployee_num(), getLastName(), getFirstName());
        }
    }


