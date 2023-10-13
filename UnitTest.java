import org.junit.Test;


public class UnitTest {
    @Test
    public void test1() throws Exception {
        HourlyEmployee e1 = new HourlyEmployee("John", "Doe", 15);
        {
            e1.setHours(24);
            System.out.println(e1.GetPaycheck());
        };
        HourlyEmployee e2 = new HourlyEmployee("Jane", "Doe", 22);
        {
            e2.setHours(20);
            System.out.println(e2.GetPaycheck());
            System.out.println(e2.toString());
        };

    }

    //Test for employee class
    @Test
    public void test2() throws Exception {
        SalariedEmployee e3 = new SalariedEmployee("John", "Doe", 15000);
        {
            System.out.println(e3.getFirstName());
            System.out.println(e3.getLastName());
            System.out.println(e3.GetPaycheck());

            }
            SalariedEmployee e4 = new SalariedEmployee("Jane", "Doe", 20000);
            {
                System.out.println(e4.getFirstName());
                System.out.println(e4.getLastName());
                System.out.println(e4.GetPaycheck());

            }
    };


        //Test if GetPaycheck method works
        @Test
        public void test3() throws Exception{
            double [][] commissionSchedule = new double[43][2];
            commissionSchedule[0][1] = 2.5;
            commissionSchedule[12][1] = 3.2;
            commissionSchedule[25][1] = 4.1;
            commissionSchedule[33][1] = 4.9;
            commissionSchedule[42][1] = 5.2;

            CommissionEmployee e5 = new CommissionEmployee("John", "Doe", 15000,commissionSchedule);
            {
                e5.setUnitsSold(20);
                System.out.println(e5.getUnitsSold());
                System.out.println(e5.GetPaycheck());
                System.out.println(e5.toString());

            }
        }


        @Test
    public void test4() throws Exception{
            SalariedEmployee e6 = new SalariedEmployee("John", "Doe", 15000);
            {
                System.out.println(e6.getFirstName());
                System.out.println(e6.getLastName());
                System.out.println(e6.GetPaycheck());
                System.out.println(e6.toString());
            }
        }


    }


