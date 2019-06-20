package srss

import scala.xml._
import scala.util.{Try, Success, Failure}

// assumes a rss standard of 2.0
case class RSS(xmlDesc: String) {
  private val xml = XML.loadString(xmlDesc)

  private def getChannel =
    xml \ "channel"

  private def getInChannel(section: String): String =
    (getChannel \ section).text

  def getChannelTitle: String =
    getInChannel("title")

  def getChannelLink: String =
    getInChannel("link")

  def getChannelDescription: String =
    getInChannel("description")

  def getChannelLanguage: String =
    getInChannel("language")


  def getItems =
    (getChannel \ "item").toList

  private def getInItem(n: Node, section: String): String =
    (n \ section).text

  def getItemTitle(n: Node): String =
    getInItem(n, "title")

  def getItemLink(n: Node): String =
    getInItem(n, "link")

  def getItemDescription(n: Node): String =
    getInItem(n, "description")
}
