package srss

// represents the feed
case class Feed(rss: RSS) {
  val items       = rss.getItems
  val title       = rss.getChannelTitle
  val description = rss.getChannelDescription
  val link        = rss.getChannelLink
  var offset      = 0

  def showChannelInfo: String =
    s"""
    Current channel: $title
    $link
    $description
    """

  def showNext: String =
    if (offset <= items.length) {
      val res = ("-" * 50) +
      s"""
      Item ${offset + 1}: ${rss.getItemTitle(items(offset))}
      ${rss.getItemLink(items(offset))}
      ${rss.getItemDescription(items(offset))}
      """ +
      ("-" * 50)
      offset += 1
      res
    } else {
      offset = 0
      "No more items to show, resetting!"
    }
}
