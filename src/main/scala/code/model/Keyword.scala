package code.model

import scala.xml.Node

import net.liftweb._
import util._
import Helpers._
import common._
import json._

case class Keyword(val lang: String, val term: String) {
  def save(): Unit = {} 
}
object Keyword {
  private implicit val formats = net.liftweb.json.DefaultFormats
  
  implicit def toXml(kw: Keyword): Node = 
    <keyword> {Xml.toXml(kw)} </keyword>
  implicit def toXml(keywords: Seq[Keyword]): Node =
    <keywords>
  		{keywords.map(toXml)}
    </keywords>
    
  implicit def toJson(kw: Keyword): JValue = Extraction.decompose(kw)
  implicit def toJson(items: Seq[Keyword]): JValue = Extraction.decompose(items)
  
  /** deletes keywords 
   * @param lang 
   * @param term
   * @returns number of deleted keyword entries
   */
  def delete(lang: String, term: String) : Int = {
    1
  }
  
  def count() : Int = {
    0
  }
  
  def findKeywords() : List[Keyword] = {
    Nil
  }
}