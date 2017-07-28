package edu.uniandes.services

import java.util.Date

import edu.uniandes.domain._

class LibraryServices {

  def borrowPhysicalItem(libraryTable: LibrarySQL[LibraryItem], libraryBorrow: LibrarySQL[BorrowItem])
                        (itemUUID: ItemUUID, daysBorrow: DaysBorrow)
  : Unit = {
    val libraryItem: LibraryItem = libraryTable.select(libraryTable)(List("=", itemUUID)).head
    val borrowItem = BorrowItem(libraryItem.itemUUID, LastDayBorrowed(new Date()), daysBorrow)
    libraryBorrow.insertInto(libraryBorrow)(borrowItem)
  }

  def borrowItem(table: LibrarySQL[LibraryItem])(title: Title, daysBorrow: DaysBorrow): Unit = {

  }
}
