package edu.uniandes

import edu.uniandes.domain._

object LibraryV1 extends App {

  val book1: List[DataType] = List(
    Author("HGabo"),
    Title("ZLa María"),
    Pages(752)
  )

  val book2: List[DataType] = List(
    Author("AGabo"),
    Title("CLa María"),
    Pages(1000)
  )

  val book3: List[DataType] = List(
    Author("AGabo"),
    Title("XLa María"),
    Pages(10)
  )

  val register1: List[List[DataType]] = List(book1)
  val register2: List[List[DataType]] = List(book2)
  val register3: List[List[DataType]] = List(book3)

  val bookTable = new ItemsTable(register1)
  bookTable.libros.foreach(println)
  println("----")

  bookTable.insertInto(register2)
  bookTable.libros.foreach(println)
  println("----")

  bookTable.insertInto(register3)
  bookTable.libros.foreach(println)
  println("----")

  bookTable.libros.sortBy(r => r.collectFirst {
    case Pages(n) => n
  }.getOrElse(0)).foreach(println)

  val hola: List[List[DataType]] = bookTable.libros

  //BibliotecaSQL.sort(hola)(Ordering.by(x => (x)))

}