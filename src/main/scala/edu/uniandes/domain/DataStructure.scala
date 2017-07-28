package edu.uniandes.domain

import java.util.Date

abstract class LibraryDataType[T]() extends Ordered[T] {

}

case class Author(author: String) extends LibraryDataType[Author] {
  override def compare(that: Author): Int = this.author compare that.author
}

case class ItemUUID(itemUUID: String) extends LibraryDataType[ItemUUID] {
  override def compare(that: ItemUUID): Int = this.itemUUID compare that.itemUUID
}

case class BorrowUUID(borrowUUID: String) extends LibraryDataType[BorrowUUID] {
  override def compare(that: BorrowUUID): Int = this.borrowUUID compare that.borrowUUID
}

case class Title(title: String) extends LibraryDataType[Title] {
  override def compare(that: Title): Int = this.title compare that.title
}

case class Pages(pages: Int) extends LibraryDataType[Pages] {
  override def compare(that: Pages): Int = this.pages compare that.pages
}

case class IssueNumber(issueNumber: Int) extends LibraryDataType[IssueNumber] {
  override def compare(that: IssueNumber): Int = this.issueNumber compare that.issueNumber
}

case class IsElectronic(isElectronic: Boolean) extends LibraryDataType[IsElectronic] {
  override def compare(that: IsElectronic): Int = this.isElectronic compare that.isElectronic
}

case class FirstDayBorrowed(firstDayBorrowed: Date) extends LibraryDataType[FirstDayBorrowed] {
  override def compare(that: FirstDayBorrowed): Int = this.firstDayBorrowed compareTo that.firstDayBorrowed
}

case class LastDayBorrowed(lastDayBorrowed: Date) extends LibraryDataType[LastDayBorrowed] {
  override def compare(that: LastDayBorrowed): Int = this.lastDayBorrowed compareTo that.lastDayBorrowed
}

case class DaysBorrow(daysBorrow: Int) extends LibraryDataType[DaysBorrow] {
  override def compare(that: DaysBorrow): Int = this.daysBorrow compare that.daysBorrow
}

case class IsBorrow(borrow: Boolean) extends LibraryDataType[IsBorrow] {
  override def compare(that: IsBorrow): Int = this.borrow compare that.borrow
}

case class CostBorroweItem(costBorroweItem: Double) extends LibraryDataType[CostBorroweItem] {
  override def compare(that: CostBorroweItem): Int = this.costBorroweItem compare that.costBorroweItem
}



case class LibraryItem(
                        author: Author = Author("Anonymous"),
                        title: Title = Title("No title"),
                        pages: Pages = Pages(0),
                        issueNumber: IssueNumber = IssueNumber(0),
                        IsElectronic: Boolean = false,
                        IsBorrow: Boolean = false,
                        itemUUID: ItemUUID = ItemUUID(java.util.UUID.randomUUID.toString.substring(0, 13))
                      ) {

  def borrowItem(table: LibrarySQL[LibraryItem])(itemUUID: ItemUUID, daysBorrow: DaysBorrow): Unit = {
    //TODO: Consultar el item.
    //TODO: Crear el objeto BorrowItem.
    //TODO: Si el LibraryItem es electronico calcular costo
    //TODO: Insertar el objeto BorrowItem.
    //TODO:
    //TODO:
  }

  def borrowItem(table: LibrarySQL[LibraryItem])(title: Title, daysBorrow: DaysBorrow): Unit = {

  }
}

case class BorrowItem(
                       itemUUID: ItemUUID,
                       firstDayBorrowed: FirstDayBorrowed = FirstDayBorrowed(new Date()),
                       daysBorrow: DaysBorrow = DaysBorrow(0),
                       lastDayBorrowed: LastDayBorrowed,
                       costBorroweItem: CostBorroweItem = CostBorroweItem(1000),
                       borrowUUID: BorrowUUID = BorrowUUID(java.util.UUID.randomUUID.toString.substring(0, 13))
                      ) {

  def borrowItem(table: LibrarySQL[LibraryItem])(itemUUID: ItemUUID, daysBorrow: DaysBorrow): Unit = {

  }

  def borrowItem(table: LibrarySQL[LibraryItem])(title: Title, daysBorrow: DaysBorrow): Unit = {

  }
}