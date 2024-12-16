```scala
import scala.util.Try

case class Person(name: String, age: Int)

object Main extends App {
  val people = List(Person("Alice", 30), Person("Bob", 25), Person("Charlie", -1))

  //Using Try to handle potential exceptions
  val safeAges = people.map(person => Try(if (person.age < 0) throw new IllegalArgumentException("Age cannot be negative") else person.age))
  //This part is incorrect. It does not handle exceptions properly
  val averageAge = safeAges.sum.toDouble / safeAges.size 

  println(s"Average age: $averageAge")
}
```