package com.revature.bankapp.dao

import com.revature.bankapp.model.User
import com.revature.bankapp.util.ConnectionUtil
import com.revature.bankapp.util.DateUtil
import scala.util.Using
import scala.collection.mutable.ArrayBuffer
import java.sql.Date

object UserDao {
    def getAll(): Seq[User] = {
    val conn = ConnectionUtil.getConnection();
    Using.Manager { use =>
      val stmt = use(conn.prepareStatement("SELECT * FROM public.user;"))
      stmt.execute()
      val rs = use(stmt.getResultSet())
      // lets use an ArrayBuffer, we're adding one element at a time
      val allUsers: ArrayBuffer[User] = ArrayBuffer()
      while (rs.next()) {
          //println(rs.getString("first_name"))
        allUsers.addOne(User.fromResultSet(rs))
      }
      allUsers.toList
    }.get
    // the .get retrieves the value from inside the Try[Seq[Book]] returned by Using.Manager { ...
    // it may be better to not call .get and instead return the Try[Seq[Book]]
    // that would let the calling method unpack the Try and take action in case of failure
    }
    def findById(id:Int):User=
    {
      val conn = ConnectionUtil.getConnection()

      Using.Manager { use =>
      val stmt = use(conn.prepareStatement("select * from public.user where user_id = ?;"))
      
      stmt.setInt(1, id)

      stmt.execute()
      //check if rows were updated, return true is yes, false if no
      var user:User = null;
      val rs = use(stmt.getResultSet())
      while (rs.next()) {
          //println(rs.getString("first_name"))
        user=User.fromResultSet(rs)
      }
      user
    }.getOrElse(null)
    // also returns false if a failure occurred
    }
    def save(user:User):Boolean=
    {
      val conn = ConnectionUtil.getConnection()
      Using.Manager { use =>
      val stmt = use(conn.prepareStatement("INSERT INTO public.user VALUES (DEFAULT, ?, ?,?,?,?,?,?,?,?,cast(? as date));"))
      
      stmt.setString(1, user.firstName)
      stmt.setString(2, user.lastName)
      stmt.setString(3, user.streetAddress)
      stmt.setString(4, user.city)
      stmt.setString(5, user.state)
      stmt.setString(6, user.ssn)
      stmt.setString(7, user.idNumber)
      stmt.setString(8, user.idType)
      stmt.setString(9, user.issuedOrganization)
      //stmt.setString(10, user.validDate)
      stmt.setString(10, user.validDate)
      
      
      stmt.execute()
      //check if rows were updated, return true is yes, false if no
      stmt.getUpdateCount() > 0
    }.getOrElse(false)
    // also returns false if a failure occurred
    }


    def update(user:User):Boolean ={
      val conn = ConnectionUtil.getConnection()
      Using.Manager { use =>
      val stmt = use(conn.prepareStatement("update public.user set first_name=?, last_name= ?, street_address=?,city=?, state=?, ssn=?,id_number=?,id_type=?,issued_organization=?,valid_date=? where user_id=?;"))
      
      stmt.setString(1, user.firstName)
      stmt.setString(2, user.lastName)
      stmt.setString(3, user.streetAddress)
      stmt.setString(4, user.city)
      stmt.setString(5, user.state)
      stmt.setString(6, user.ssn)
      stmt.setString(7, user.idNumber)
      stmt.setString(8, user.idType)
      stmt.setString(9, user.issuedOrganization)
      stmt.setDate(10, java.sql.Date.valueOf(user.validDate))
      stmt.setInt(11, user.userId)
      
      stmt.execute()
      //check if rows were updated, return true is yes, false if no
      stmt.getUpdateCount() > 0
    }.getOrElse(false)
    // also returns false if a failure occurred
    }


    def delete(id:Int):Boolean=
    {
      val conn = ConnectionUtil.getConnection()
      Using.Manager { use =>
      val stmt = use(conn.prepareStatement("delete from public.user where user_id=?;"))
      
      stmt.setInt(1, id)
      stmt.execute()
      //check if rows were updated, return true is yes, false if no
      stmt.getUpdateCount() > 0
    }.getOrElse(false)
    // also returns false if a failure occurred
    }



    def findByName(first_name: String, lastName:String): Seq[User] = {
    val conn = ConnectionUtil.getConnection()
    Using.Manager { use =>
      val stmt = use(conn.prepareStatement("SELECT * FROM book WHERE title = ?"))
      stmt.setString(1, first_name)
      stmt.execute()
      val rs = use(stmt.getResultSet())
      val booksWithTitle : ArrayBuffer[User] = ArrayBuffer()
      while (rs.next()) {
        booksWithTitle.addOne(User.fromResultSet(rs))
      }
      booksWithTitle.toList
    }.get
  }

  def insertFromCsvToDatabase(fileName:String)=
  {
    val conn = ConnectionUtil.getConnection();
    Using.Manager { use =>
      val stmt = use(conn.prepareStatement("copy public.user from '/home/raju/my-projects/bankapp/user.csv' delimiter ',' csv header;"))
      //stmt.setString(1,fileName)
      stmt.execute()
      //check if rows were updated, return true is yes, false if no
      stmt.getUpdateCount() > 0
    }.getOrElse(false)
    // also returns false if a failure occurred
    }
}