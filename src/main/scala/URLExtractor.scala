object URLExtractor {
  def unapply(url: String): Option[(String, String, String)] = {
    // Attempt to split the URL into protocol, domain, and path
    val urlPattern = "([a-zA-Z]+)://([a-zA-Z0-9.-]+)(/.*)?".r
    url match {
      case urlPattern(protocol, domain, path) =>
        Some(protocol, domain, Option(path).getOrElse("/")) // If the path is `null`, set it to "/"
      case _ => None
    }
  }
}

def describeURL(url: String): String = url match {
  case URLExtractor(protocol, domain, path) =>
    s"Protocol: $protocol, Domain: $domain, Path: $path"
  case _ =>
    "Invalid URL format"
}

object CustomExtractorExample {
  def main(args: Array[String]): Unit = {
    val url1 = "https://www.scalefocus.com/resources"
    val url2 = "ftp://ftp.scalefocus.com/files"
    val url3 = "invalid-url"

    println(describeURL(url1))
    println(describeURL(url2))
    println(describeURL(url3))
  }
}