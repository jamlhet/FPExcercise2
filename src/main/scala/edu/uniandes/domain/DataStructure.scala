package edu.uniandes.domain

import java.util.Date

abstract class LibraryDataType[T]() extends Ordered[T] {

}

case class Author(author: String) extends LibraryDataType[Author] {
  override def compare(that: Author): Int = this.author compare that.author
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

case class LastDayBorrowed(lastDayBorrowed: Date) extends LibraryDataType[LastDayBorrowed] {
  override def compare(that: LastDayBorrowed): Int = this.lastDayBorrowed compareTo that.lastDayBorrowed
}

case class DaysBorrow(daysBorrow: Int) extends LibraryDataType[DaysBorrow] {
  override def compare(that: DaysBorrow): Int = this.daysBorrow compare that.daysBorrow
}

case class LibraryItem(
                        author: Author = Author("Anonymous"),
                        title: Title = Title("No title"),
                        pages: Pages = Pages(0),
                        issueNumber: IssueNumber = IssueNumber(0),
                        IsElectronic: Boolean = false,
                        lastDayBorrowed: LastDayBorrowed = LastDayBorrowed(new Date()),
                        daysBorrow: DaysBorrow = DaysBorrow(0)
                      )