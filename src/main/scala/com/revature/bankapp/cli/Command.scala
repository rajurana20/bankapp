package com.revature.bookapp.cli

import scala.io.StdIn
import scala.util.matching.Regex
import com.revature.bankapp.dao.UserDao
import com.revature.bankapp.controller.UserController

/** A CLI that allows the user to interact with our application
  *
  * This Cli is a class because in the future we might provide customization options
  * that can be set when creating a new Cli instance.
  *
  * This Cli class will contain all our logic involving interacting with the user
  * we don't want all of our classes to be able to receive input from the command line
  * or write to the command line.  Instead, we'll have (almost) all that happen here.
  */
class Cli {

  /** commandArgPattern is a regular expression (regex) that will help us
    * extract the command and argument from user input on the command line
    *
    * Regex is a tool used for pattern matching strings.  Lots of languages and other tools
    * support regex.  It's good to learn at least the basic, but you can also just use this
    * code for your project if you like.
    */
  val commandArgPattern: Regex = "(\\w+)\\s*(.*)".r

  /** Prints a greeting to the user
    */
  def printWelcome(): Unit = {
    println("Welcome to Bank App CLI!")
  }

  /** Prints the commands available to the user
    */
  def printOptions(): Unit = {
    println("Commands available:")
    println("list users : lists all books stored in Bookapp")
    println("find [firstName lastName] : lists all the users with that name")
    println("add user : adds a new book to the database")
    println("update user : update a existing user to the database")
    println("delete user : delete a user from the database")
    println("exit : exits Bank App CLI")
  }

  /** This runs the menu, this is the entrypoint to the Cli class.
    *
    * The menu will interact with the user on a loop and call other methods/classes
    * in order to achieve the result of the user's commands
    */
  def menu(): Unit = {
    printWelcome()
    var continueMenuLoop = true
    while (continueMenuLoop) {
      printOptions()
      val input = StdIn.readLine()
      input match {
        case commandArgPattern(cmd, arg) if cmd.equalsIgnoreCase("exit") => {
          continueMenuLoop = false
        }
        case commandArgPattern(cmd, arg)
            if cmd.equalsIgnoreCase("list") && arg.equalsIgnoreCase("users") => {
            UserController.getAll();
        }
        case commandArgPattern(cmd, arg) if cmd.equalsIgnoreCase("find") => {
          printUsers(arg)
        }
        case commandArgPattern(cmd, arg)
            if cmd.equalsIgnoreCase("add") && arg.equalsIgnoreCase("user") => {
              UserController.addUser();
            }
        case commandArgPattern(cmd, arg) => {
          println(s"""Failed to parse command: "$cmd" with arguments: "$arg"""")
        }
        case _ => {
          println("Failed to parse any input")
        }
      }
    }
    println("Thank you for using Bookapp CLI, goodbye!")
  }

  

  def printUsers(title: String): Unit = {
    //BookDao.get(title).foreach(println)
  }
  
  /**
    * runs an add book sub menu, we're skipping some QoL features present on the main menu
    */
  def runAddUserSubMenu(): Unit = {
      /*
    println("title?")
    val titleInput = StdIn.readLine()
    println("ISBN?")
    val isbnInput = StdIn.readLine()
    try {
      if (BookDao.saveNew(Book(0, titleInput, isbnInput))) {
        println("added new book!")
      } 
    } catch {
      case e : Exception => {
        println("failed to add book.")
      }
      
    }
    */
  }

}