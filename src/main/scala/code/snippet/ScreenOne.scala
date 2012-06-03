package code.snippet

import net.liftweb._
import http._

object ScreenOne extends LiftScreen {
	val in=field("In","")
	val infor=field("Infor","infor")
	def finish() {
	  S.notice("Processed")
	}
  
}