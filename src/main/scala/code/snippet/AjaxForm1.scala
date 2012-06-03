package code.snippet

import scala.xml.{NodeSeq, Text}
import net.liftweb.util._
import net.liftweb.common._
import java.util.Date
import code.lib._
import Helpers._
import net.liftweb.http._
import net.liftweb.http.js._
import net.liftweb.http.js.JsCmds._

object AjaxFormOne {

  var inputVal="default"
  var infor="i"
    
  def process() :JsCmd = {
    //that is colled when form is submitted
    println("process ok "+inputVal + infor)
    SetHtml("result", Text(inputVal + " "+infor) )
  }
    
  def render = {
    println("render")
    "name=infor" #> SHtml.text(infor, infor = _) &
    "name=in" #> ( SHtml.text(inputVal, inputVal = _ ) ++ SHtml.hidden(process))
  }
}