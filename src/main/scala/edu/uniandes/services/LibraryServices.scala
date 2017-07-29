package edu.uniandes.services

import java.nio.charset.StandardCharsets
import java.util.{Date, UUID}

import edu.uniandes.domain._

object LibraryServices {

  def borrowPhysicalItem(libraryTable: LibrarySQL[LibraryItem], libraryBorrow: LibrarySQL[BorrowItem])
                        (itemUUID: ItemUUID, daysBorrow: DaysBorrow)
  : Unit = {
    val libraryItem: LibraryItem = libraryTable.select(libraryTable)(List("=", itemUUID)).listRegisters.head
    val borrowItem = BorrowItem(libraryItem.itemUUID, LastDayBorrowed(new Date()), daysBorrow)
    libraryBorrow.insertInto(libraryBorrow)(borrowItem)
  }

  def borrowItem(table: LibrarySQL[LibraryItem])(title: Title, daysBorrow: DaysBorrow): Unit = {

  }

  def itemUUID(msg: String): ItemUUID = {
    ItemUUID(UUID.nameUUIDFromBytes(msg.getBytes(StandardCharsets.UTF_8)).toString)
  }
}