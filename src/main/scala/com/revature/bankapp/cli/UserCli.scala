package com.revature.bankapp.cli

import com.revature.bankapp.model.User
import scala.io.StdIn

object UserCli {
    def addNewUser():User={
        println();
        print("First Name?? : "); 
        val firstName = StdIn.readLine();

        println();
        print("Last Name?? : "); 
        val lastName = StdIn.readLine();

        println();
        print("Street Address?? : "); 
        val streetAddress = StdIn.readLine();

        println();
        print(" City ?? : "); 
        val city = StdIn.readLine();

        println();
        print("State?? : "); 
        val state = StdIn.readLine();

        println();
        print("SSN without dash ?? : "); 
        val ssn = StdIn.readLine();

        println();
        print("ID number ?? : "); 
        val idNumber= StdIn.readLine();

        println();
        print("ID Type ?? : "); 
        val idType= StdIn.readLine();

        println();
        print("ID issueing Organization ?? : "); 
        val issuedOrganization = StdIn.readLine();

        println();
        print("Validity Date ?? : "); 
        val validDate= StdIn.readLine();

        User(0,firstName,lastName,streetAddress,city,state,ssn,idNumber,idType,issuedOrganization, validDate);
    }
}