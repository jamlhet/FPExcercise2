package edu.uniandes

import edu.uniandes.domain._

object Library extends App {

  val book0 = LibraryItem()
  val book1 = LibraryItem(Author("hGabo"), Title("ALa María"), Pages(500))
  val book2 = LibraryItem(Author("ZGabo"), Title("RLa María"), Pages(100))
  val book3 = LibraryItem(Author("aGabo"), Title("xLa María"), Pages(10000))
  val book4 = LibraryItem(Author("XGabo"), Title("aLa María"), Pages(50))
  val book5 = LibraryItem(Author("oGabo"), Title("oLa María"), Pages(55))

  val booksTable: LibrarySQL[LibraryItem] = new LibrarySQL(List(book0, book1, book2, book3, book4, book5))
  //booksTable.insertInto(booksTable)(book4)
  //booksTable.select(booksTable)(List("*"))
  booksTable.select(booksTable)(List(">", Pages(100))).foreach(r => println(r))
  booksTable.select(booksTable)(List(">", Title("OLa María"))).foreach(r => println(r))
  booksTable.select(booksTable)(List(">", Author("aGabo"))).foreach(r => println(r))
  booksTable.select(booksTable)(List("<",Pages(500))).foreach(r => println(r))
  booksTable.select(booksTable)(List("=",Pages(500))).foreach(r => println(r))
  //booksTable.update(booksTable)(book4, book1)
  //booksTable.update(booksTable)(book4, book5)
  //booksTable.listRegisters.sortWith(_.pages > _.pages)
  println("------------------")
  booksTable.listRegisters.filter(_.pages.pages > 100).foreach(r => println(r))
  println("------------------")
  booksTable.listRegisters.filter(_.title.title > "OLa María").foreach(r => println(r))
  println("------------------")
  booksTable.listRegisters.filter(_.author.author > "oGabo").foreach(r => println(r))
}