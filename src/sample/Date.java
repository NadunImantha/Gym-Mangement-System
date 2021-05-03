package sample;

public class Date {
    //Membership date
    public static String membershipStartDate() {
        while (true){
            int date = InputValidation.integerValue("Membership Start Date (DD) : ");
            int month = InputValidation.integerValue("Membership Start Month (MM) : ");
            int year = InputValidation.integerValue("Membership Start Year (YYYY) : ");
            if ((date > 0 && date <= 31) && (month > 0 && month <= 12) && (year > 1000 && year < 9999)){
                return (date+"/"+month+"/"+year);
            }
            else
                System.out.println("  Please Enter Correct Information..!");
        }
    }
}
