import java.util.Scanner;

public class ApplicationLogin_1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        for (Integer i = 1; i <=3; i++) {

            Scanner sc=new Scanner(System.in);
            System.out.println("Enter username:");
            String userId=sc.next();

            System.out.println("Enter password:");
            String password=sc.next();
            boolean flag="giridhar".equals(userId)&"9492011".equals(password);

            if(flag) {
                System.out.println("Hi.., "+userId+"\n\t Welocme to JavaSE...");
                i=33;
            }else {
                if(i==3) {
                    System.out.println("Try after 3hrs credentials...\n Error:N number of attemmts");
                    i=33;
                }else {
                    System.out.println("Enter valid credentials...");
                }


            }
        }
    }




}
