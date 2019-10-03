package controllers

import play.api.mvc._

class Example extends Controller {

  def example() = Action {
    Ok(views.html.example("THIS EXAMPLE WORKS!"))
  }

  def greeting(name: String) = Action { implicit request: Request[AnyContent] =>
    Ok(s"Welcome $name!")
  }

  def redirectMe() = Action { implicit request: Request[AnyContent] =>
    Redirect("/redirectToHere").flashing("Success" -> "redirect has occurred")
  }

  def redirectMeAgain() = Action { implicit request: Request[AnyContent] =>
    Redirect(routes.Example.redirectToHere()).flashing("Success" -> "redirect has occurred")
  }

  def redirectToHere() = Action { implicit request: Request[AnyContent] =>
    Ok("You have been redirected")//{
      //request.flash.get("Success").getOrElse(“Welcome”)
    //}
  }

  def notYetImplemented = TODO

  def cookieExample = Action { implicit request: Request[AnyContent] =>
    Ok("Cookie test"). withCookies(
      Cookie("Test", "Successful")
    )
  }

  def sessionStorageExample = Action {implicit request: Request[AnyContent] =>
    Ok("Session storage example").withSession("Test" -> "Successful", "Test2" -> "Successful")
  }


}
