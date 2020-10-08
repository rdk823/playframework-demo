package controllers

import com.google.inject._
import play.api._
import play.api.http.HttpErrorHandler
import play.api.http.Status._
import play.api.libs.json.Json
import play.api.mvc.Results._
import play.api.mvc._

import scala.concurrent._

@Singleton
class ErrorHandler @Inject()
  extends HttpErrorHandler {

  val logger: Logger = Logger(this.getClass)

  def onClientError(request: RequestHeader,
                    statusCode: Int,
                    message: String): Future[Result] =
    statusCode match {

      case NOT_FOUND =>
        Future.successful {
          val message =
            s"${request.method.toUpperCase} ${request.uri} does not exist"
          NotFound(Json.obj("error" -> message))
        }

      case code =>
        Future.successful {
          Status(code)(Json.obj("error" -> message))
        }
    }

  override def onServerError(request: RequestHeader, exception: Throwable): Future[Result] = {
    exception match {

      case _ =>

        logger.error(exception.getMessage, exception)
        Future.successful(
          InternalServerError(Json.obj("error" -> "Internal Server Error")))
    }

  }
}