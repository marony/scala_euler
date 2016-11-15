package eulerlib

import scala.annotation.tailrec

object MathUtil {
  // 素数判定
  def isPrime(n : Long) : Boolean = {
    if (n == 2)
      return true
    if (n < 2 || (n % 2) == 0)
      return false
    Seq.range(3, Math.sqrt(n.toDouble).toLong + 1).forall(n % _ != 0)
  }

  // 素数リスト
  def primes = {
    def nextPrime(n : Long) : Long = {
      Stream.iterate(n + 2L)(_ + 2L).find(isPrime) match {
        case Some(m) => m
        case None    => -1L
      }
    }
    Stream.iterate(2L) {
      case 2L => 3L
      case m => nextPrime(m)
    }
  }

  // 素因数分解
  def primeFactors(n : Long) : List[Long] = {
    @tailrec
    def _primeFactors(n : Long, r : List[Long]) : List[Long] = {
      primes.takeWhile(_ <= n).find(n % _ == 0) match {
        case Some(m) => _primeFactors(n / m, m :: r)
        case None => r
      }
    }
    _primeFactors(n, Nil)
  }

  // 因数分解
  def factors(n : Long) : Stream[Long] = {
    Stream.iterate(1L)(_ + 1L).takeWhile(_ <= n).filter(n % _ == 0L)
  }

  // 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
  def triangleNumbers = Stream.iterate((1L, 1L)){ case (x, y) => (x + 1L, x + y + 1L)}.map(_._2)
}
