
package macros

import language.experimental.macros
import scala.reflect.macros.Context

trait Foo[A] {
  def hello: String
}

object Foo {
  implicit def getFoo[A]: Foo[A] = macro impl[A]
  
  def impl[A: c.WeakTypeTag](c: Context): c.Expr[Foo[A]] = {
    import c.universe._
    
    val typeStr = c.literal(weakTypeOf[A].toString)
    reify {
      new Foo[A] {
        def hello = "I received this type: " + typeStr.splice
      }
    }
  }
}