package com.revature.bankapp.model

import java.sql.ResultSet

case class User(userId:Int, firstName:String, lastName:String, streetAddress:String, city : String, state : String, ssn : String, idNumber:String, idType:String, issuedOrganization:String, validDate:String){

}
object  User{
    /**
    * Produces a User from a record in a ResultSet.  Note that this method does *not* call next()!
    *
    * @param rs
    * @return
    */
  def fromResultSet(rs : ResultSet) : User = {
    apply(
      rs.getInt("user_id"),
      rs.getString("first_name"),
      rs.getString("last_name"),
      rs.getString("street_address"),
      rs.getString("city"),
      rs.getString("state"),
      rs.getString("ssn"),
      rs.getString("id_number"),
      rs.getString("id_type"),
      rs.getString("issued_organization"),
      rs.getString("valid_date")
    )
  }
}