package edu.uniandes.domain

import java.util.Date

import edu.uniandes.services.LibraryServices

abstract class LibraryDataType[T]() extends Ordered[T]

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
                        author: Author,
                        title: Title,
                        pages: Pages,
                        issueNumber: IssueNumber = IssueNumber(0),
                        IsElectronic: Boolean = false,
                        IsBorrow: Boolean = false,
                        itemUUID:  ItemUUID = ItemUUID(java.util.UUID.randomUUID.toString.substring(0, 6))
                      ){
  /*val stringItem = s"${author.author}${title.title}${pages.pages}${issueNumber.issueNumber}$IsElectronic"
  val itemUUID: ItemUUID = LibraryServices.itemUUID(stringItem)*/
}

case class BorrowItem(
                       itemUUID: ItemUUID,
                       lastDayBorrowed: LastDayBorrowed,
                       daysBorrow: DaysBorrow = DaysBorrow(0),
                       costBorroweItem: CostBorroweItem = CostBorroweItem(1000),
                       firstDayBorrowed: FirstDayBorrowed = FirstDayBorrowed(new Date()),
                       borrowUUID: BorrowUUID = BorrowUUID(java.util.UUID.randomUUID.toString.substring(0, 6))
                     )