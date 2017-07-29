package edu.uniandes.domain

import org.scalatest._

class LibrarySQLTest extends FlatSpec with Matchers {

  val booksTable: LibrarySQL[LibraryItem] = new LibrarySQL[LibraryItem](List())

  val book1 = LibraryItem(Author("hGabo"), Title("ALa María"), Pages(500))
  val book2 = LibraryItem(Author("ZGabo"), Title("RLa María"), Pages(100))
  val book3 = LibraryItem(Author("aGabo"), Title("xLa María"), Pages(10000))
  val book4 = LibraryItem(Author("XGabo"), Title("aLa María"), Pages(50))
  val book5 = LibraryItem(Author("oGabo"), Title("oLa María"), Pages(55))
  val book6 = LibraryItem(Author("hGabo"), Title("ALa María"), Pages(500),IsElectronic = true)
  val book61 = LibraryItem(Author("hGabo"), Title("ALa María"), Pages(500),IsElectronic = true)
  val book62 = LibraryItem(Author("hGabo"), Title("ALa María"), Pages(500),IsElectronic = true)
  val book7 = LibraryItem(Author("aGabo"), Title("xLa María"), Pages(10000),IsElectronic = true)
  val book71 = LibraryItem(Author("aGabo"), Title("xLa María"), Pages(10000),IsElectronic = true)
  val book72 = LibraryItem(Author("aGabo"), Title("xLa María"), Pages(10000),IsElectronic = true)

  "Insert into" should " 11 items" in {
    booksTable.insertInto(booksTable)(book1)
    booksTable.insertInto(booksTable)(book2)
    booksTable.insertInto(booksTable)(book3)
    booksTable.insertInto(booksTable)(book4)
    booksTable.insertInto(booksTable)(book5)
    booksTable.insertInto(booksTable)(book6)
    booksTable.insertInto(booksTable)(book61)
    booksTable.insertInto(booksTable)(book62)
    booksTable.insertInto(booksTable)(book7)
    booksTable.insertInto(booksTable)(book71)
    booksTable.insertInto(booksTable)(book72)
    //repeat
    booksTable.insertInto(booksTable)(book1)
    booksTable.insertInto(booksTable)(book2)
    booksTable.insertInto(booksTable)(book3)
    booksTable.insertInto(booksTable)(book4)
    booksTable.insertInto(booksTable)(book5)
    booksTable.insertInto(booksTable)(book6)
    booksTable.insertInto(booksTable)(book7)

    assert(booksTable.listRegisters nonEmpty)
    assert(booksTable.listRegisters.length == 11)
  }

  "Select *" should "11" in {
    assert(booksTable.select(booksTable)(List("*")).listRegisters.length == 11)
  }

  "Select > pages 100" should " 8" in {
    assert(booksTable.select(booksTable)(List(">", Pages(100))).listRegisters.length == 8)
  }

  "Select > title oLa María" should " 4" in {
    assert(booksTable.select(booksTable)(List(">", Title("oLa María"))).listRegisters.length == 4)
  }

  "Select > autor aGabo" should " 5" in {
    assert(booksTable.select(booksTable)(List(">", Author("aGabo"))).listRegisters.length == 5)
  }

  "Select < pages 500" should " 3" in {
    assert(booksTable.select(booksTable)(List("<", Pages(500))).listRegisters.length == 3)
  }


  "Select = pages 500" should " 4" in {
    assert(booksTable.select(booksTable)(List("=", Pages(500))).listRegisters.length == 4)
  }

  "Select is electronic" should " 6" in {
    assert(booksTable.select(booksTable)(List("=", IsElectronic(true))).listRegisters.length == 6)
  }

  /*
  booksTable.update(booksTable)(book4, book1)
  booksTable.update(booksTable)(book4, book5)
  booksTable.listRegisters.sortWith(_.pages > _.pages)
  println("------------------")
  booksTable.listRegisters.filter(_.pages.pages > 100).foreach(r => println(r))
  println("------------------")
  booksTable.listRegisters.filter(_.title.title > "OLa María").foreach(r => println(r))
  println("------------------")
  booksTable.listRegisters.filter(_.author.author > "oGabo").foreach(r => println(r))
  LibraryServices.borrowPhysicalItem()
  */

}
