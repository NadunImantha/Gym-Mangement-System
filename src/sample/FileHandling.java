package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandling {
    public static ArrayList membershipNo = new ArrayList();
    public static ArrayList membershipStartDate = new ArrayList();
    public static ArrayList memberFirstName = new ArrayList();
    public static ArrayList memberLastName = new ArrayList();
    public static ArrayList memberType = new ArrayList();

    public static ArrayList toDeleteMembershipNo = new ArrayList();
    public static ArrayList toDeleteMembershipStartDate = new ArrayList();
    public static ArrayList toDeleteMemberFirstName = new ArrayList();
    public static ArrayList toDeleteMemberLastName = new ArrayList();
    public static ArrayList toDeleteMembershipType = new ArrayList();

    public static File membershipNoFile = new File("MembershipNo.txt");
    public static File memberShipStartDateFile = new File("MemberShipStartDate.txt");
    public static File memberFirstNameFile = new File("MemberFirstName.txt");
    public static File memberLastNameFile = new File("MemberLastName.txt");
    public static File membershipTypeFile = new File("MembershipType.txt");


    public static void readFile() throws FileNotFoundException {
        //Read all files add add them to relevant arrays
        Scanner readMembershipNo = new Scanner(membershipNoFile);
        while (readMembershipNo.hasNextLine()){
            toDeleteMembershipNo.add(readMembershipNo.nextLine());
        } readMembershipNo.close();

        Scanner readMembershipDate = new Scanner(memberShipStartDateFile);
        while (readMembershipDate.hasNextLine()){
            toDeleteMembershipStartDate.add(readMembershipDate.nextLine());
        } readMembershipDate.close();

        Scanner readMemberFirstName = new Scanner(memberFirstNameFile);
        while (readMemberFirstName.hasNextLine()){
            toDeleteMemberFirstName.add(readMemberFirstName.nextLine());
        } readMemberFirstName.close();

        Scanner readMemberLastName = new Scanner(memberLastNameFile);
        while (readMemberLastName.hasNextLine()){
            toDeleteMemberLastName.add(readMemberLastName.nextLine());
        } readMemberLastName.close();

        Scanner readMemberShipType = new Scanner(membershipTypeFile);
        while (readMemberShipType.hasNextLine()){
            toDeleteMembershipType.add(readMemberShipType.nextLine());
        } readMemberShipType.close();
    }

    public static void saveRecordsToFile() throws IOException {
        //Check new records
        if (membershipNo.size() != 0){
            System.out.println(" Update Your Records Successfully...");
            for (int k=0; k < membershipNo.size(); k++){
                //Add new members details to arrays
                toDeleteMembershipNo.add(membershipNo.get(k));
                toDeleteMembershipStartDate.add(membershipStartDate.get(k));
                toDeleteMemberFirstName.add(memberFirstName.get(k));
                toDeleteMemberLastName.add(memberLastName.get(k));
                toDeleteMembershipType.add(memberType.get(k));
            }
            //Clear all arrays
            membershipNo.clear();
            membershipStartDate.clear();
            memberFirstName.clear();
            memberLastName.clear();
            memberType.clear();
        } else
            System.out.println("  No Update Found...");


        if (toDeleteMembershipNo.size() != 0){
            //Clear file and add records from array
            FileWriter F_Writer_MembershipNo = new FileWriter(membershipNoFile);
            PrintWriter PW_MembershipNo = new PrintWriter(F_Writer_MembershipNo, true);

            FileWriter F_Writer_MembershipDate = new FileWriter(memberShipStartDateFile);
            PrintWriter PW_MembershipDate = new PrintWriter(F_Writer_MembershipDate, true);

            FileWriter F_Writer_MemberFirstName = new FileWriter(memberFirstNameFile);
            PrintWriter PW_MemberFirstName = new PrintWriter(F_Writer_MemberFirstName, true);

            FileWriter F_Writer_MemberLastName = new FileWriter(memberLastNameFile);
            PrintWriter PW_MemberLastName = new PrintWriter(F_Writer_MemberLastName, true);

            FileWriter F_Writer_MembershipType = new FileWriter(membershipTypeFile);
            PrintWriter PW_MembershipType = new PrintWriter(F_Writer_MembershipType, true);

            //Write records to file
            for (int i=0; i < toDeleteMembershipNo.size(); i++){
                PW_MembershipNo.println(toDeleteMembershipNo.get(i));
                PW_MembershipDate.println(toDeleteMembershipStartDate.get(i));
                PW_MemberFirstName.println(toDeleteMemberFirstName.get(i));
                PW_MemberLastName.println(toDeleteMemberLastName.get(i));
                PW_MembershipType.println(toDeleteMembershipType.get(i));
            }
        } else
            System.out.println("  No Records To Save...");
    }
}
