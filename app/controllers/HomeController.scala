package controllers

import javax.inject._
import play.api._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def login: Action[AnyContent] = Action { _ =>
    Ok(views.html.loginPage())
  }

  def validateLogin: Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val postValues = request.body.asFormUrlEncoded
    postValues.map { args =>
      val username = args("username").head
      val password = args("password").head
      Redirect(routes.HomeController.index)
    }.getOrElse(Redirect(routes.HomeController.login))
  }

  def index(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val books: List[String] = List("book1", "book2", "book3")
    Ok(views.html.index(books))
  }

  def bookDetails(bookName: String, bookDesc: String): Action[AnyContent] = Action { _ =>
    Ok(s"$bookName is about $bookDesc")
  }
}
