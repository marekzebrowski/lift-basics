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
import net.liftweb.json._
import net.liftweb.json.JsonParser._


class JsonFormOne {
    object  jsonHandler extends JsonHandler {
      
    	def apply(in: Any) :JsCmd = {
    	  println(in)
    	  in match {
    	    case JsonCmd("processForm", _, params :Map[String, _], all) => {
    	      println("in is JsonCmd")
    	      val infor=params.getOrElse("infor", "")
    	      val ina=params.getOrElse("in","")
    	      SetHtml("result2",Text(infor+" "+ina))
    	      
    	    }
    	    case _ => {
    	      println("In class is"+in.getClass)
    	      SetHtml("result2",Text("Unknown command"))
    	    }
    	  }
    	}
    }
      
    def head = Script(jsonHandler.jsCmd)
    
	def render(in:NodeSeq) :NodeSeq   = {
	  println("render starts ")
	  println( in )
	  println("head is")
	  println(head)
	  val rs = ("#formToJson" #> ((ns:NodeSeq) =>  SHtml.jsonForm(jsonHandler, ns )) &
	      "#jsonFormScript" #> head) (in)
	  println(rs)
	  rs
	}
}