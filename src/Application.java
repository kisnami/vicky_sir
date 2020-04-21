import authentication.ValidationForUserDetails;
import database.SignUp_DB;
import pojo.SignUpUserDetails;
import utils.SendMail;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        SignUp_DB signUp_db = new SignUp_DB();
        SendMail sendMail = new SendMail();

        SignUpUserDetails userDetails = getUserDetails();
        //otp.sendMailToUser("ks.karthikumar@gmail.com");
        if (checkFieldFromUserDetails(userDetails)) {
            //signUp_db.insertUserDetails(userDetails);
            int OTP = sendMail.sendMailToUser(userDetails.getUserEmail());
            if (sendMail.verifyOTP()) {
                //signUp_db.updateOTP(OTP);
                System.out.println("Account Create successfully..!");
            } else {
                System.err.println("You typed wrong OTP please makesure type correct otp..!");
            }
        }
    }

    private static boolean checkFieldFromUserDetails(SignUpUserDetails userDetails) {
        ValidationForUserDetails validation = new ValidationForUserDetails(userDetails);
        if (!validation.checkEmailId()) {
            System.err.println("Mail ID WRONG..!");
            return false;
        }
        if (!validation.checkUserPassword(userDetails.getUserPassword())) {
            System.err.println("NOT FULFILL PASSWORD POLICY");
            return false;
        }
        if (!validation.checkUserPassword(userDetails.getPhasePassword())) {
            System.err.println("NOT FULFILL PHASE PASSWORD POLICY");
            return false;
        }
        if (!userDetails.getUserPassword().trim().equals(userDetails.getConfirmPassword().trim())) {
            System.err.println("PASSWORD MISMATCH..!");
            return false;
        }
        if (!userDetails.getPhasePassword().trim().equals(userDetails.getConfirmPhasePassword().trim())) {
            System.err.println("PHASE PASSWORD MISMATCH..!");
            return false;
        }
        return true;
    }

    private static SignUpUserDetails getUserDetails() {
        SignUpUserDetails signup = new SignUpUserDetails();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter user name = ");
        signup.setUserName(scan.next());
        System.out.println("Enter Email ID = ");
        signup.setUserEmail(scan.next());
        System.out.println("Enter Password = ");
        signup.setUserPassword(scan.next());
        System.out.println("Enter Confirm Password = ");
        signup.setConfirmPassword(scan.next());
        System.out.println("Enter Phase Password = ");
        signup.setPhasePassword(scan.next());
        System.out.println("Enter Confirm Phase Password = ");
        signup.setConfirmPassword(scan.next());
        return signup;
    }
}
