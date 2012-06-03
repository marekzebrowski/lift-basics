package code.model


import net.liftweb._
import mapper._
import util._
import common._

object Package extends Package with KeyedMetaMapper[Long, Package] with CRUDify[Long, Package]{
   override def dbTableName = "packages"
}

class Package extends KeyedMapper[Long, Package] {
  def getSingleton = Package
  def primaryKeyField = id
  object id extends MappedLongIndex(this)
  object enabled extends MappedBoolean(this)
  object name extends MappedString(this,255)
}


object Client extends Client with KeyedMetaMapper[Long, Client] with CRUDify[Long, Client]{
   override def dbTableName = "clients"
}

class Client extends KeyedMapper[Long, Client] {
  def getSingleton = Client
  def primaryKeyField = id
  object id extends MappedLongIndex(this)
  object accountcreationdate extends MappedLong(this)
  object accountexpirationdate extends MappedLong(this)
  object address extends MappedString(this,255)
  object city extends MappedString(this,255)
  object contactperson extends MappedString(this,255)
  object email extends MappedString(this,255)
  object enabled extends MappedBoolean(this)
  object name extends MappedString(this,255)
  object nip extends MappedString(this,255)
  object postcode extends MappedString(this,255)
  object status extends MappedInt(this)
  object telephone extends MappedString(this,255)
  object package_id extends MappedLongForeignKey(this,Package) {
        override def validSelectValues = Full(Package.findAll(By(Package.enabled,true))
            .map(p => (p.id.is,p.name.is)))   
  }
  object supervisor_id extends MappedLongForeignKey(this,Supervisor)
}


