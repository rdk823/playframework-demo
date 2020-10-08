package controllers

import javax.inject._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.Future

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class ApplicationController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {


  def welcome = Action.async {
    Future.successful {
      Ok("Application is up and running")
    }
  }

  def healthCheck = Action.async {
    Future.successful {
      Ok(Json.obj("Status" -> "up"))
    }
  }

}
