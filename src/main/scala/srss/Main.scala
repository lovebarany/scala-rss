package srss

import scalaj.http._
import scala.util.{Try, Success, Failure}

object Main extends App {

  def mainLoopText: String = """
                                | Type 'n' to get the next item.
                                | Type 'f' to change the feed.
                                | Type 'i' to get the info on the current channel.
                                | Type 'q' to quit.""".stripMargin

  var feed: Feed = Feed(RSS(Http("http://static.userland.com/gems/backend/rssTwoExample2.xml").asString.body))

  println("RSS reader written in Scala.")

  def readLink(link: String): Unit = {
    val httpResponse: Try[HttpResponse[String]] = Try{ Http(link).asString }
    httpResponse match {
      case Success(h) => feed = Feed(RSS(h.body))
      case Failure(e) => println("An error occured while reading link!")
    }
  }

  println("Input RSS feed link: ")
  val feedLink = scala.io.StdIn.readLine
  readLink(feedLink)

  println(feed.showChannelInfo)
  println(feed.showNext)

  def changeFeed: Unit = {
    println("Input new RSS feed link: ")
    val feedLink = scala.io.StdIn.readLine
    readLink(feedLink)
  }

  var quit = false

  while (!quit) {
    println(mainLoopText)
    val input = scala.io.StdIn.readLine
    input match {
      case "n" => println(feed.showNext)
      case "f" => changeFeed
      case "q" => quit = true
      case "i" => println(feed.showChannelInfo)
      case c   => println("Unknown command: " + c)
    }
  }
}
