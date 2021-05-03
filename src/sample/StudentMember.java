package sample;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentMember {
    public static ArrayList studentMemberSchArr = new ArrayList();

    public static void studentMembersDetails() {
        FileHandling.membershipNo.add(DefaultMember.membershipNumber());
        FileHandling.memberFirstName.add(DefaultMember.firstName());
        FileHandling.memberLastName.add(DefaultMember.lastName());
        FileHandling.membershipStartDate.add(Date.membershipStartDate());
        FileHandling.memberType.add("Student");

        //School name
        System.out.print("Enter Your School Name : ");
        Scanner sc = new Scanner(System.in);
        String schName = sc.nextLine();
        studentMemberSchArr.add(schName);
    }
}
