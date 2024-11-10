object EmailExtractor {
  def unapply(email: String): Option[(String, String)] = {
    val parts = email.split("@")
    if (parts.length == 2) Some((parts(0), parts(1))) else None
  }
}

def matchEmail(email: String): String = email match {
  case EmailExtractor(user, domain) => s"User: $user, domain: $domain"
  case _ => "Not a valid email address"
}

object EmailMatcher {
  def main(args: Array[String]): Unit = {
    println(matchEmail("scala_learner@scalefocus.com"))
    println(matchEmail("not-an-email"))
  }
}