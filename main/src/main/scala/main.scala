
import macros.Foo

object Main {

  def getFoo[A](implicit foo: Foo[A]) = foo.hello

  def main(args: Array[String])  {
    println("Hello world! Getting type class Foo!")
    println(getFoo[Int])
    println(getFoo[String])
  }

}