package sample;

public class DefaultMember {
    //Member first name
    public static String firstName(){
        System.out.print("Enter Your First Name : ");
        String fName = InputValidation.input.next();
        return fName;
    }

    //Member last name
    public static String lastName(){
        System.out.print("Enter Your Last Name : ");
        String lName = InputValidation.input.next();
        return lName;
    }

    //Membership number
    public static String membershipNumber(){
        while (true){
            System.out.print("Enter Your Membership Number (####) : ");
            String membershipNumber = InputValidation.input.next();

            //Check duplicate numbers
            int count = 0;
            for (int k=0; k < FileHandling.toDeleteMembershipNo.size(); k++){
                if (FileHandling.toDeleteMembershipNo.get(k).equals(membershipNumber))
                    count++;
            }
            if (count == 0)
                return membershipNumber;
            else
                System.out.println("  Membership Number Is Already Eexist...!");
        }
    }

    //Default members details
    public static void defaultMembersDetails() {
        FileHandling.membershipNo.add(membershipNumber());
        FileHandling.memberFirstName.add(firstName());
        FileHandling.memberLastName.add(lastName());
        FileHandling.membershipStartDate.add(Date.membershipStartDate());
        FileHandling.memberType.add("Default");
    }
}
