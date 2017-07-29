package edu.uniandes.domain

import edu.uniandes.services.LibraryServices
import org.scalatest._

class LibraryServicesTest extends FlatSpec with Matchers {

  val libraryBorrow: LibrarySQL[BorrowItem] = new LibrarySQL[BorrowItem](List())
  val booksTable: LibrarySQL[LibraryItem] = new LibrarySQL[LibraryItem](List())
  val magazineTable: LibrarySQL[LibraryItem] = new LibrarySQL[LibraryItem](List())

  val book1 = LibraryItem(Author("hGabo"), Title("ALa María"), Pages(500))
  val book2 = LibraryItem(Author("ZGabo"), Title("RLa María"), Pages(100))
  val book3 = LibraryItem(Author("aGabo"), Title("xLa María"), Pages(10000))
  val book4 = LibraryItem(Author("XGabo"), Title("aLa María"), Pages(50))
  val book5 = LibraryItem(Author("oGabo"), Title("oLa María"), Pages(55))
  val book6 = LibraryItem(Author("hGabo"), Title("ALa María"), Pages(500), IsElectronic = true)
  val book7 = LibraryItem(Author("aGabo"), Title("xLa María"), Pages(10000), IsElectronic = true)

  val magazine1 = LibraryItem(Author("NYTimes"), Title("Times"), Pages(500), IssueNumber(19))
  val magazine2 = LibraryItem(Author("JuanCarlos"), Title("SOHO"), Pages(100000), IssueNumber(21))
  val magazine3 = LibraryItem(Author("Sport"), Title("Sport Illustrated"), Pages(10000), IssueNumber(45))
  val magazine4 = LibraryItem(Author("Play"), Title("PlayBoy"), Pages(50), IssueNumber(67))
  val magazine5 = LibraryItem(Author("Sport"), Title("Sport Illustrated"), Pages(10000), IssueNumber(98), IsElectronic = true)
  val magazine6 = LibraryItem(Author("NYTimes"), Title("ALa María"), Pages(500), IssueNumber(100), IsElectronic = true)
  val magazine7 = LibraryItem(Author("JuanCarlos"), Title("SOHO"), Pages(100000), IssueNumber(56), IsElectronic = true)

  booksTable.insertInto(booksTable)(book1)
  booksTable.insertInto(booksTable)(book2)
  booksTable.insertInto(booksTable)(book3)
  booksTable.insertInto(booksTable)(book4)
  booksTable.insertInto(booksTable)(book5)
  booksTable.insertInto(booksTable)(book6)
  booksTable.insertInto(booksTable)(book7)
  //repeat
  magazineTable.insertInto(magazineTable)(magazine1)
  magazineTable.insertInto(magazineTable)(magazine2)
  magazineTable.insertInto(magazineTable)(magazine3)
  magazineTable.insertInto(magazineTable)(magazine4)
  magazineTable.insertInto(magazineTable)(magazine5)
  magazineTable.insertInto(magazineTable)(magazine6)
  magazineTable.insertInto(magazineTable)(magazine7)

  "Borrow process physical item" should "borrow item" in {
    //Query
    val filter1: LibrarySQL[LibraryItem] = magazineTable.select(magazineTable)(List("=",Title("Sport Illustrated")))
    val filter2: LibrarySQL[LibraryItem] = filter1.select(filter1)(List("=",IsElectronic(false)))
    val mySelection = filter2.select(filter2)(List("=",IsBorrow(false))).listRegisters.head
    LibraryServices.borrowPhysicalItem(magazineTable,libraryBorrow)(mySelection.itemUUID,DaysBorrow(5))
    println("")
  }

}
