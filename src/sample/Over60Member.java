package sample;

import java.util.ArrayList;

public class Over60Member {
    public static ArrayList over60membersAgeArr = new ArrayList();

    public static void over60MembersDetails(){
        FileHandling.membershipNo.add(DefaultMember.membershipNumber());
        FileHandling.memberFirstName.add(DefaultMember.firstName());
        FileHandling.memberLastName.add(DefaultMember.lastName());
        FileHandling.membershipStartDate.add(Date.membershipStartDate());
        FileHandling.memberType.add("Over 60");

        //Check age is more that 60
        while(true){
            int age = InputValidation.integerValue("Enter Your Age : ");
            if (age >= 60){
                over60membersAgeArr.add(age);
                break;
            }
            else
                System.out.println("Something Went Wrong...!");
        }
    }
}
