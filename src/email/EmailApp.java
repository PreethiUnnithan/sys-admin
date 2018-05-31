/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email;

import java.util.Scanner;

/**
 *
 * @author suppo
 */
public class EmailApp {
    private String firstName;
   private String lastName;
    private String department;
    private String company;
    private String password;
    private String email;
    private int mailboxCapacity=500;
    private int defaultPasswordLength=8;
    private String alternateEmail;
    private String companySuffix="amdon.com";
    //constructor to receive the first & last name
    public EmailApp(String firstName, String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
        System.out.println("Email created  :" + this.firstName+" "+this.lastName);
        //call a method asking for the department
        this.department=setDepartment();
        System.out.println("Department:  "+this.department);
        //call a method that returns a random password
        this.password=randomPassword(defaultPasswordLength);
        
        System.out.println("Your password is: "+this.password);
        
        //combine all elements to generate email
        email=firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+companySuffix;
        System.out.println("Your email is: "+ email);
        
    }
    // ask for the department
    private String setDepartment(){
        System.out.println("DEP CODES:\n1 for sales\n2 for development\n3 for accounting\n0 for none\n Enter the department");
        Scanner in=new Scanner(System.in);
        int depChoice=in.nextInt();
        if(depChoice==1){return "sales";}
        else if(depChoice==2){return "development";}
        else if(depChoice==3){return "accounting";}
        else{return"";}
    
}
    //generate a random pwd
    
    private String randomPassword(int length){
        String passwordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[]password=new char[length];
        for(int i=0;i<length;i++){
            int rand=(int) (Math.random()*passwordSet.length());
            password[i]=passwordSet.charAt(rand);
            
        }
            return new String (password) ;   
    }
    
    //setting is defining properties
    //set email capacity, using encapsulation by hiding actual property setmailbox capacity
    public void setMailboxCapacity(int capacity){
        this .mailboxCapacity=capacity;
    }
    
    //set alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail=altEmail;
    }
    //change pwd
    
    public void setChangePassword(String password){
        this.password=password;
    }
    
    //getting is getting
    public int getMailboxCapacity(){return mailboxCapacity;}
    public String getAlternateEmail(){return alternateEmail;}
    public String getChangePassword(){return password;}
    public String showInfo(){
        return "Display name: " +firstName+" "+lastName+
                "\nCompany Email: " + email+
                "\nMailbox Capacity: "+ mailboxCapacity+"mb";
        
    }
}
    

