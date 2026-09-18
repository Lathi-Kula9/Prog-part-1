import java.util.Scanner;


public class main {

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println(" Registration ");
            
            System.out.print("Enter first name: ");
            String firstName = input.nextLine();
            
            System.out.print("Enter last name: ");
            String lastName = input.nextLine();
            
            System.out.print("Enter username (must contain '_' and be <= 5 characters): ");
            String username = input.nextLine();
            
            System.out.print("Enter password (8+ chars, a capital, a number, a special character): ");
            String password = input.nextLine();
            
            System.out.print("Enter cell phone number (e.g. +27838968976): ");
            String cellPhoneNumber = input.nextLine();
            
            // Create one Login object holding everything this user just typed in.
            Login user = new Login(firstName, lastName, username, password, cellPhoneNumber);
            
            // registerUser() checks everything and gives us back a message
            // telling us exactly what went right or wrong.
            System.out.println();
            System.out.println(user.registerUser());
            
            // Only bother asking them to log in if registration actually succeeded.
            boolean registeredSuccessfully = user.checkUserName()
                    && user.checkPasswordComplexity()
                    && user.checkCellPhoneNumber();
            
            if (registeredSuccessfully) {
                System.out.println();
                System.out.println("Login");
                
                System.out.print("Enter username: ");
                String loginUsername = input.nextLine();
                
                System.out.print("Enter password: ");
                String loginPassword = input.nextLine();
                
                System.out.println();
                System.out.println(user.returnLoginStatus(loginUsername, loginPassword));
            }
        }
    }
}
