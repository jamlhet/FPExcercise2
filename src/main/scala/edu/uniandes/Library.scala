package edu.uniandes

import edu.uniandes.domain._

object Library extends App{

  val book1 = new Book(Author("HGabo"),Title("ZLa María"),Pages(500))
  val book2 = new Book(Author("ZGabo"),Title("RLa María"),Pages(100))
  val book3 = new Book(Author("AGabo"),Title("XLa María"),Pages(10000))
  val book4 = new Book(Author("XGabo"),Title("ALa María"),Pages(50))
  val book5 = new Book(Author("XGabo"),Title("ALa María"),Pages(55))

  val booksTable = new LibrarySQL(List(book1,book2,book3))
  booksTable.insertInto(booksTable)(book4)
  booksTable.select(booksTable)("*")
  booksTable.select(booksTable)(book4)
  booksTable.select(booksTable)(book5)
  booksTable.update(booksTable)(book4,book1)
  println("+++++++++++++++++++++++++++++++")
  booksTable.update(booksTable)(book4,book5)
}