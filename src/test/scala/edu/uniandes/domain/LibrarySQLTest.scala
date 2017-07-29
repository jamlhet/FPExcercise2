package edu.uniandes.domain

import org.scalatest._

class LibrarySQLTest extends FlatSpec with Matchers {

  val libraryBorrow: LibrarySQL[BorrowItem] = new LibrarySQL[BorrowItem](List())
  val booksTable: LibrarySQL[LibraryItem] = new LibrarySQL[LibraryItem](List())

  val book1 = LibraryItem(Author("hGabo"), Title("ALa María"), Pages(500))
  val book2 = LibraryItem(Author("ZGabo"), Title("RLa María"), Pages(100))
  val book3 = LibraryItem(Author("aGabo"), Title("xLa María"), Pages(10000))
  val book4 = LibraryItem(Author("XGabo"), Title("aLa María"), Pages(50))
  val book5 = LibraryItem(Author("oGabo"), Title("oLa María"), Pages(55))
  val book6 = LibraryItem(Author("hGabo"), Title("ALa María"), Pages(500),IsElectronic = true)
  val book7 = LibraryItem(Author("aGabo"), Title("xLa María"), Pages(10000),IsElectronic = true)

  "Insert into" should "ok" in {
    booksTable.insertInto(booksTable)(book1)
    booksTable.insertInto(booksTable)(book2)
    booksTable.insertInto(booksTable)(book3)
    booksTable.insertInto(booksTable)(book4)
    booksTable.insertInto(booksTable)(book5)
    booksTable.insertInto(booksTable)(book6)
    booksTable.insertInto(booksTable)(book7)
    //repeat
    booksTable.insertInto(booksTable)(book1)
    booksTable.insertInto(booksTable)(book2)
    booksTable.insertInto(booksTable)(book3)
    booksTable.insertInto(booksTable)(book4)
    booksTable.insertInto(booksTable)(book5)
    booksTable.insertInto(booksTable)(book6)
    booksTable.insertInto(booksTable)(book7)

    assert(booksTable.listRegisters nonEmpty)
    assert(booksTable.listRegisters.length == 7)
  }

  "Select *" should "7" in {
    assert(booksTable.select(booksTable)(List("*")).length == 7)
  }

  "Select > pages 100" should " 4" in {
    assert(booksTable.select(booksTable)(List(">", Pages(100))).length == 4)
  }

  "Select > title oLa María" should " 2" in {
    assert(booksTable.select(booksTable)(List(">", Title("oLa María"))).length == 2)
  }

  "Select > autor aGabo" should " 3" in {
    assert(booksTable.select(booksTable)(List(">", Author("aGabo"))).length == 3)
  }

  "Select < pages 500" should " 3" in {
    assert(booksTable.select(booksTable)(List("<", Pages(500))).length == 3)
  }


  "Select = pages 500" should " 2" in {
    assert(booksTable.select(booksTable)(List("=", Pages(500))).length == 2)
  }

  "Select is electronic" should " 2" in {
    assert(booksTable.select(booksTable)(List("=", IsElectronic(true))).length == 2)
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
