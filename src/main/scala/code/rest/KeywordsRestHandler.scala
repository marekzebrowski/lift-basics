package code.rest

import code.model._
import net.liftweb.http._
import net.liftweb.http.rest._
import net.liftweb.json._
import scala.xml.Node


/**
 * webservice do operowania keywordami
 * 
 * dodaj kw, lang - POST 
 * usuń kw, lang - DELETE 
 * list kw, lang (z ograniczeniami)
 * GET kw - ograniczenia w paramentrach ?lang,prefix=...,regex...
 * kw/count jw z ograniczeniami
 * 
 */
object KeywordsRestHandler extends RestHelper {
	serve { 
	  case  "keywords" :: "count" :: _ JsonGet _  => JInt(Keyword.count()) 
	  case  "keywords" :: _ Post req =>
	    for {
	      lang <- req.param("lang") ?~ "lang parameter missing" ~> 400
	      term <- req.param("term") ?~ "term parameter missing" ~> 400
	    } yield {
	      val kw= Keyword(lang,term)
	      kw.save()
	      kw 
	    } : JValue
	  case  "keywords" :: _ JsonGet _  => Keyword.findKeywords() : JValue
	  case  "keywords" :: _ XmlGet _  => Keyword.findKeywords() : Node 
	  case  "keywords" :: _ JsonDelete req  =>
	    for {
	      lang <- req.param("lang") ?~ "lang parameter missing" ~> 400
	      term <- req.param("term") ?~ "term parameter missing" ~> 400
	    } yield {
	      JInt(Keyword.delete(lang,term))
	    }
	  }
}