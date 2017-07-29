package edu.uniandes.services

import java.nio.charset.StandardCharsets
import java.util.{Calendar, Date, UUID}

import edu.uniandes.domain._

object LibraryServices {

  def borrowItem(libraryTable: LibrarySQL[LibraryItem], libraryBorrow: LibrarySQL[BorrowItem])
                (libraryItem: LibraryItem, daysBorrow: DaysBorrow)
  : Unit = {
    if (libraryItem.IsBorrow)
      println("The item is not available")
    else {
      val c = Calendar.getInstance
      c.setTime(new Date())
      c.add(Calendar.DATE,daysBorrow.daysBorrow)
      val lastDayBorrowed: Date = c.getTime
      if(libraryItem.IsElectronic) {
        val costBorroweItem = CostBorroweItem(1000*daysBorrow.daysBorrow)
        val borrowItem = BorrowItem(libraryItem.itemUUID, LastDayBorrowed(lastDayBorrowed), daysBorrow,costBorroweItem)
        libraryBorrow.insertInto(libraryBorrow)(borrowItem)
        println(s"Borrow cost ${costBorroweItem.costBorroweItem}")
      }else{
        val borrowItem = BorrowItem(libraryItem.itemUUID, LastDayBorrowed(lastDayBorrowed), daysBorrow)
        libraryBorrow.insertInto(libraryBorrow)(borrowItem)
      }
      val librayItemUpdate = LibraryItem(
        libraryItem.author,
        libraryItem.title,
        libraryItem.pages,
        libraryItem.issueNumber,
        libraryItem.IsElectronic,
        IsBorrow = true,
        libraryItem.itemUUID
      )
      libraryTable.update(libraryTable)(libraryItem, librayItemUpdate)
    }
  }
}