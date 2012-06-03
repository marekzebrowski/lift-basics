package code
package model

import net.liftweb.mapper._
import net.liftweb.util._
import net.liftweb.common._

/**
 * The singleton that has methods for accessing the database

object Supervisor extends KeyedMetaMapper[Long, Supervisor] with CRUDify[Long,Supervisor]{

 */
object User extends User with KeyedMetaMapper[Long, User] with CRUDify[Long,User]{
  override def dbTableName = "users" // define the DB table name
}

/**
 * An O-R mapped "User" class that includes first name, last name, password and we add a "Personal Essay" to it
 */
class User extends KeyedMapper[Long, User] {
  def getSingleton = User // what's the "meta" server
  def primaryKeyField = id
  object id extends MappedLongIndex(this)
  object username extends MappedString(this,255)
  object email extends MappedString(this,255) 
  object enabled extends MappedBoolean(this)
  object password extends MappedPassword(this) {
    override def dbColumnName = "password"
  }
  object locale extends MappedString(this,2) 
  object creationdate extends MappedDateTime(this) {
    override def writePermission_? = false
  }
  object client extends MappedLongForeignKey(this,Client)
  object languages extends MappedString(this,255)
  
}

