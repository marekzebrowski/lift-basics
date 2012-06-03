package code.snippet
import net.liftweb._
import http._
import scala.xml.NodeSeq
import scala.xml.{NodeSeq, Text}
import net.liftweb.util._
import net.liftweb.common._
import java.util.Date
import code.lib._
import Helpers._


class DumbForm {
	// pobieranie parametru, może być inne
	val inputParam = for {
	  r <- S.request if r.post_?
	  v <- S.param("it")
	} yield v
  
	def render(in:NodeSeq) :NodeSeq = {
	  println ("render called")
	  println ("input nodeseq" )
	  println(in)
	  inputParam match {
	    case Full(x) => {
	      println("we have input, render "+x)
	      ("#result *+" #> x) (in)
	    }
	    case _ =>  {
	      println("No input present")
	      in
	    }
	  }
	}
}