package edu.uniandes

import edu.uniandes.domain._

object Library extends App{

  val book1 = new Book(Author("HGabo"),Title("ZLa María"),Pages(500))
  val book2 = new Book(Author("ZGabo"),Title("RLa María"),Pages(100))
  val book3 = new Book(Author("AGabo"),Title("XLa María"),Pages(10000))
  val book4 = new Book(Author("XGabo"),Title("ALa María"),Pages(50))

  val booksTable = new LibraryTable(List(book1,book2,book3))
  booksTable.insertInto(booksTable)(book4)
  booksTable.selectAll(booksTable)().foreach(println)
  println("----------------")
  //booksTable.selectAll(booksTable).sortBy(r =>r.author).foreach(println)
  println("----------------")
  //booksTable.selectAll(booksTable).sortBy(r =>r.title).foreach(println)
  println("----------------")
  //booksTable.selectAll(booksTable).sortBy(r =>r.pages).foreach(println)
  println("----------------")
  booksTable.findOne(booksTable)(book4)
}