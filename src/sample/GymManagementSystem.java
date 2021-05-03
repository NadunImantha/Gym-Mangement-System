package sample;

import java.io.IOException;

public class GymManagementSystem{
    public static void main(String[] args) throws IOException {
        System.out.println("<---- WELCOME TO THE GYM MANAGEMENT SYSTEM ---->");
        FileHandling.readFile(); //Get records form file and add to members details array
        int freeSlots = 100 - FileHandling.toDeleteMembershipNo.size();
        System.out.println("<---- You Have "+freeSlots+" Free Slots");
        System.out.println();

        while(true){
            //User choice to do...?
            System.out.println("  1 - Add a new member");
            System.out.println("  2 - Delete a member");
            System.out.println("  3 - Print list of members");
            System.out.println("  4 - Save in file");
            System.out.println("  5 - Open interface");
            System.out.println("  6 - Quit");

            int userChoiceNumber = InputValidation.integerValue("Enter one of following number : ");  //Get user input number

            //Add a new member
            if (userChoiceNumber == 1){
                //members count 100
                if (FileHandling.toDeleteMembershipNo.size() < 100){
                    //Display member types
                    System.out.println("  1 - Student Member");
                    System.out.println("  2 - Over 60 Member");
                    System.out.println("  3 - Default Member");
                    int memberTypeNumber = InputValidation.integerValue("Enter member type number : ");
                    System.out.println();
                    if (memberTypeNumber == 1){
                        //Student members details
                        System.out.println("~~~ STUDENT MEMBER");
                        StudentMember.studentMembersDetails();
                    }
                    else if (memberTypeNumber == 2){
                        //Over 60 members details
                        System.out.println("~~~ OVER 60 MEMBER");
                        Over60Member.over60MembersDetails();
                    }
                    else if (memberTypeNumber == 3){
                        //Default members details
                        System.out.println("~~~ DEFAULT MEMBER");
                        DefaultMember.defaultMembersDetails();
                    }
                    else
                        System.out.println("  Invalid Input..!");
                }
                else
                    System.out.println("No Free Slots Available...!");

                FileHandling.saveRecordsToFile();   //Save to file and arrays
            }


            //Delete a member
            else if (userChoiceNumber == 2){
                //Delete details
                System.out.print("Enter Membership Number To Delete Member : ");
                String deleteMember = InputValidation.input.next();

                int count = 0;
                //Check membership numbers
                for (Object number:FileHandling.toDeleteMembershipNo){
                    if (number.equals(deleteMember)){
                        count += 1;
                        //Get index number that relevant member
                        int indexNo = FileHandling.toDeleteMembershipNo.indexOf(deleteMember);
                        //Remove Records from arrays
                        FileHandling.toDeleteMembershipNo.remove(indexNo);
                        FileHandling.toDeleteMembershipStartDate.remove(indexNo);
                        FileHandling.toDeleteMemberFirstName.remove(indexNo);
                        FileHandling.toDeleteMemberLastName.remove(indexNo);
                        FileHandling.toDeleteMembershipType.remove(indexNo);
                        //Display removed record membership number
                        System.out.println("  Remove "+deleteMember+" Member Successfully.");
                        break;
                    }
                }

                if (count == 0)
                    System.out.println("  Can Not Find...!");

                FileHandling.saveRecordsToFile();   //Save to file and arrays
            }


            //Print list of members
            else if (userChoiceNumber == 3){
                //Check if there have any record to display
                if (FileHandling.toDeleteMembershipNo.size() != 0){
                    System.out.println(" Membership NO\t\tStart Date\t\t  First Name\t\tLast Name\t\tMembership Type");
                    System.out.println("------------------------------------------------------------------------------------");
                    for (int k=0; k < FileHandling.toDeleteMembershipNo.size(); k++){
                        String records = "\t"+FileHandling.toDeleteMembershipNo.get(k) +"\t\t\t"+FileHandling.toDeleteMembershipStartDate.get(k)+"\t\t\t"+FileHandling.toDeleteMemberFirstName.get(k)+"\t\t\t"+FileHandling.toDeleteMemberLastName.get(k)+"\t\t\t"+FileHandling.toDeleteMembershipType.get(k);
                        System.out.println(records);
                    }
                }
                else
                    System.out.println("  No Records To Display...!");
            }


            //Save entered records to file
            else if (userChoiceNumber == 4){
                System.out.println(" Update Your Records.");
                /*FileHandling.saveRecordsToFile();*/
            }


            //Open interface
            else if (userChoiceNumber == 5){
                //open interface
                System.out.println("  GUI Is Running....");
                listGui.main(args);
            }


            //Quit form program
            else if (userChoiceNumber == 6){
                System.out.println("Thank You..");
                break;
            }

            else{
                System.out.println("  Can not identify...!");
            }
            System.out.println();
        }
    }
}
