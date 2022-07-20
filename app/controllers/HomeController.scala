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

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val books: List[String] = List("book1", "book2", "book3")
    Ok(views.html.index(books))
  }

  def bookDetails(bookName: String, bookDesc: String): Action[AnyContent] = Action { _ =>
    Ok(s"$bookName is about $bookDesc")
  }
}
