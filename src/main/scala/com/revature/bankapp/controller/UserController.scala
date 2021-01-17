package com.revature.bankapp.controller

import com.revature.bankapp.model.User
import com.revature.bankapp.cli.UserCli
import com.revature.bankapp.util.ConnectionUtil
import scala.util.Using
import scala.collection.mutable.ArrayBuffer
import com.revature.bankapp.dao.UserDao

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
    UserDao.save(user);
  }

}