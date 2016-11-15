package eulerlib

object Util {
  // どちらから読んでも同じ数字か
  // 面倒なので文字列に変換してから判断
  def isPalindrome(n : Long) : Boolean = {
    if (n < 0)
      false
    else {
      val s = n.toString
      val l  = s.length
      if (l <= 1)
        true
      else
        s.substring(0, l / 2) == s.substring(l - l / 2, l).reverse
    }
  }
}
