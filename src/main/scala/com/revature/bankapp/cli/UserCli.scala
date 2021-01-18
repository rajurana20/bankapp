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


    def updateUser(user:User):User={
        println("Press Enter if don't want to modify");
        print(s"First Name : ${user.firstName} ?? _"); 
        var firstName:String=StdIn.readLine();
        if (firstName =="")
        {
            firstName = user.firstName;
        }


        println();
        print(s"Last Name : ${user.lastName} ?? _"); 
        var lastName = StdIn.readLine();
        if (lastName =="")
        {
            lastName = user.lastName;
        }

        println();
        print(s"Street Address : ${user.streetAddress} ?? "); 
        var streetAddress = StdIn.readLine();
        if (streetAddress =="")
        {
            streetAddress = user.streetAddress;
        }

        println();
        print(s" City : ${user.city} ?? _"); 
        var city = StdIn.readLine();
        if (city =="")
        {
            city = user.city;
        }

        println();
        print(s"State : ${user.state} ?? _"); 
        var state = StdIn.readLine();
        if (state =="")
        {
            state = user.state;
        }

        println();
        print(s"SSN without dash ?? : ${user.ssn} ?? _"); 
        var ssn = StdIn.readLine();
        if (ssn =="")
        {
            ssn = user.ssn;
        }

        println();
        print(s"ID number : ${user.idNumber} ?? _"); 
        var idNumber= StdIn.readLine();
        if (idNumber =="")
        {
            idNumber = user.idNumber;
        }

        println();
        print(s"ID Type : ${user.idType} ?? _"); 
        var idType= StdIn.readLine();
        if (idType =="")
        {
            idType = user.idType;
        }

        println();
        print(s"ID issueing Organization : ${user.issuedOrganization} ?? _"); 
        var issuedOrganization = StdIn.readLine();
        if (issuedOrganization =="")
        {
            issuedOrganization = user.issuedOrganization;
        }

        println();
        print(s"Validity Date : ${user.validDate} ?? _"); 
        var validDate= StdIn.readLine();
        if (validDate =="")
        {
            validDate = user.validDate;
        }

        User(user.userId,firstName,lastName,streetAddress,city,state,ssn,idNumber,idType,issuedOrganization, validDate);
    }




    def inputId()={
        StdIn.readInt();
    }
}