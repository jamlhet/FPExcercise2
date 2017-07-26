package edu.uniandes

object TestSort extends App {
  val coll: List[List[Int]] = List(List(1, 3), List(1, 2), List(0), Nil, List(2))
  val coll3: List[List[PhysicalBook]] = List(List(new PhysicalBook("a", 100)), List(new PhysicalBook("z", 11)), List(new PhysicalBook("r", 12)))
  coll3.foreach(println)
  println("-----------")
  sort(coll3)(Ordering.by(x => (x.a))).foreach(println)
  println("-----------")
  sort(coll3)(Ordering.by(x => (x.b))).foreach(println)
  def sort[A](coll: Seq[Iterable[A]])(implicit ordering: Ordering[A]) = coll.sorted
}

case class PhysicalBook(a:String, b:Int)

case class column()