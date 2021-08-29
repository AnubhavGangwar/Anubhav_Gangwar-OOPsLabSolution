package com.CompanyLogIn;

import java.util.Scanner;
public class CredentialService {
	 public String firstName;
     public String lastName;
     public String pass;
     public String dept;
     public String email;
     public int defaultPasswordLength=10;
     public String companySuffix="company.com";


     public CredentialService(String firstName,String lastName) {
         this.firstName = firstName;
         this.lastName = lastName;



         this.dept=setDepartment();

         this.pass=randomPassword(defaultPasswordLength);       
//       System.out.println("Your password is: "+this.pass+"\n\n");

         email=firstName.toLowerCase()+"."+lastName.toLowerCase()+"@" +dept+"."+companySuffix;

     }

     private String setDepartment() {
         System.out.print("Please Enter The Department From The Following :\n1 for Technical\n2 for Admin\n3 for HumanResourse\n4 for Legal\nEnter the department code: ");
         Scanner in=new Scanner(System.in);
         int depchoice=in.nextInt();
         if(depchoice==1) {
             return "technical";
         }
         else if(depchoice==2) {
             return "admin";
         }
         else if(depchoice==3) {
             return "hr";
         }
         else if(depchoice==4){
             return "legal";
         }
		return "";
     }

     private String randomPassword(int length) {
         String passwordSet= "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
         char[] password=new char[length];
         for(int i=0;i<length;i++) {
             int rand=(int) (Math.random()*passwordSet.length());
             password[i]=passwordSet.charAt(rand);
         }
         return new String(password);
     }

     public void changePassword(String password) {
         this.pass=password;
     }

     public String getPassword() { return pass;}
     public String getemail() {return email;}

     public String showinfo() {
         return "\n \nDear "+firstName+" "+lastName+" Your Credentials Are As Follows \nEmail -->    "+email+"\nPassword --> "+pass+"";
     }

 }


