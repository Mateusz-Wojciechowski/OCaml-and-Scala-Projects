import scala.annotation.tailrec
import scala.collection.mutable


val stirlingMemo: mutable.Map[(Int, Int), BigInt] = mutable.Map()

def stirling(n: Int, k: Int): BigInt = {
  if (k == 0 && n == 0) 1
  else if (k == 0 || n == 0) 0
  else if (k == 1 || k == n) 1
  else stirlingMemo.getOrElseUpdate((n, k), stirling(n - 1, k - 1) + k * stirling(n - 1, k))
}

def bell(n: Int): BigInt = {
  stirlingMemo.clear()

  @tailrec
  def loop(i: Int, acc: BigInt): BigInt = {
    if (i > n) acc
    else loop(i + 1, acc + stirling(n, i))
  }

  loop(0, 0)
}

trait Stream[+A] {
  def head: A
  def tail: () => Stream[A]
}

//////////////////////////////////////////////

def from(n: Int): Stream[Int] = new Stream[Int] {
  def head: Int = n
  def tail: () => Stream[Int] = () => from(n + 1)
}

def bellStream(start: Int = 0): Stream[BigInt] = new Stream[BigInt] {
  def head: BigInt = bell(start)
  def tail: () => Stream[BigInt] = () => bellStream(start + 1)
}

def getStreamElements[A](stream: Stream[A], n: Int): List[A] = {
  if(n<=0){
    Nil
  }
  else {
    stream.head :: getStreamElements(stream.tail(), n - 1)
  }
}

def getEveryOtherElement[A](stream: Stream[A], n: Int): List[A] = {
  if (n <= 0) Nil
  else stream.head :: getEveryOtherElement(stream.tail().tail(), n-2)
}


def skipElements[A](stream: Stream[A], n: Int): Stream[A] = {
  if (n<=0){
    stream
  }
  else{
    skipElements(stream.tail(), n - 1)
  }
}

def zipStreams[A, B](s1: Stream[A], s2: Stream[B], n: Int): Stream[(A, B)] = {
  if(n<=0){
    new Stream[(A, B)]{
      def head: (A, B) = throw new NoSuchElementException("head of empty stream")

      def tail: () => Stream[(A, B)] = () => this
    }
  }
  else{
    new Stream[(A, B)] {
      def head: (A, B) = (s1.head, s2.head)

      def tail: () => Stream[(A, B)] = () => zipStreams(s1.tail(), s2.tail(), n - 1)
    }
  }
}

def mapStream[A,B](s: Stream[A], fun: A=>B): Stream[B] = new Stream[B] {

  def head: B = fun(s.head)

  def tail: () => Stream[B] = () => mapStream(s.tail(), fun)
}

def stream_head[A](stream: Stream[A]): A ={
  stream.head
}
def stream_tail[A](stream: Stream[A]): Stream[A] ={
  stream.tail()
}

// Testowanie
val b_stream = bellStream()

val first_n_nums = getStreamElements(b_stream, 10)
val firs_n_other_nums = getEveryOtherElement(b_stream, 10)
val skipped_stream = skipElements(b_stream, 5)
val skipped_nums = getStreamElements(skipped_stream, 5)

val n_stream = from(1)

val zipped_stream = zipStreams(b_stream, n_stream, 5)
val zipped_elements = getStreamElements(zipped_stream, 5)

val triple_bell_stream = mapStream(b_stream, (x: BigInt) => x * 3)
val first_n_triple_nums = getStreamElements(triple_bell_stream, 10)




