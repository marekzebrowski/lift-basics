package code.model
import net.liftweb._
import mapper._
import util._
import common._

object Supervisor extends Supervisor with KeyedMetaMapper[Long, Supervisor] with CRUDify[Long, Supervisor]{
   override def dbTableName = "supervisors"
}

class Supervisor extends KeyedMapper[Long, Supervisor] {
  def getSingleton = Supervisor
  def primaryKeyField = id
  object id extends MappedLongIndex(this)
  object user_id extends MappedLongForeignKey(this,User) {
    override def validSelectValues = Full(User.findAll(By(User.enabled,true)).map(user => (user.id.is,user.username.is)))   
  }
  
}

//object Supervisor extends Supervisor with LongKeyedMetaMapper[Supervisor]