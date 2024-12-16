```scala
import scala.util.Try

case class Person(name: String, age: Int)

object Main extends App {
  val people = List(Person("Alice", 30), Person("Bob", 25), Person("Charlie", -1))

  //Using Try to handle potential exceptions and filter out negative ages
  val safeAges = people.map(person => Try(if (person.age < 0) throw new IllegalArgumentException("Age cannot be negative") else person.age))
                                 .filter(_.isSuccess).map(_.get)

  val averageAge = if(safeAges.isEmpty) 0 else safeAges.sum.toDouble / safeAges.size 

  println(s"Average age: $averageAge")
}
```