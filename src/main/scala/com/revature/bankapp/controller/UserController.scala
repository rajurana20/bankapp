package com.revature.bankapp.controller

import com.revature.bankapp.model.User
import com.revature.bankapp.cli.UserCli
import com.revature.bankapp.util.ConnectionUtil
import scala.util.Using
import scala.collection.mutable.ArrayBuffer
import com.revature.bankapp.dao.UserDao
import com.revature.bankapp.util.FileUtil
import scala.language.postfixOps;

/** A Book Data Access Object.  BookDao has CRUD methods for Books
  *
  * It allows us to keep all of our database access logic in this file,
  * while still allowing the rest of our application to use Books
  * retrieved from the database.
  */
object UserController {
  def getAll(): Unit = {
    print("\u001b[H")
    UserDao.getAll().foreach(println)
  }

  def addUser () = {
    val user= UserCli.addNewUser();
    if(UserDao.save(user)){
      println("Successfully Added")
    }
    else{
      println("Failed . Try Again")
    }
  }

  def updateUser () = {
    getAll();
    println();
    print("Enter User Id ?? : ")
    val id = UserCli.inputId();
    val user= UserCli.updateUser(UserDao.findById(id));
    if (!user.equals(null)){
      if(UserDao.update(user)){
        println("Successfully Updated")
      }
    }
    else{
      println("Failed . Try Again")
    }
  }

  def deleteUser()={
    getAll();
    println();
    print("Enter Id??");
    val id:Int = UserCli.inputId();
    if (UserDao.delete(id))
    {
      println("Successfully Deleted")
    }
    else{
      println("Failed . Try Again");
    }
  }

  def insertFromCsvToDatabase(file : String)={
    
      var content: String =FileUtil.getTextContent(file);
      var userStrings :Array[String] =content.split("\n");
      for(userString <- userStrings)
      {
        var userArg= userString.split(",");
        var user=User(0, userArg(0),userArg(1),userArg(2),userArg(3),userArg(4),userArg(5),userArg(6), userArg(7),userArg(8), userArg(9));
        if(UserDao.save(user)){
          println("Suceefully saved")
        }
        else{
          println("Failed")
        }
        println( user);
      }

    //lst.foreach(println);
  }

  def importFromCsvToDatabase(file : String)
  {
    if (UserDao.insertFromCsvToDatabase(file))
    {
      println("Successfully Imported");
    }
    else{
      println("Failed");
    }
  }

}