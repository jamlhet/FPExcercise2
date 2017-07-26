package edu.uniandes.domain

abstract class DataType[T]() extends Ordered[T]{

}

case class Author(author: String) extends DataType[Author] {
  override def compare(that: Author): Int = this.author compare that.author
}

case class Title(title: String) extends DataType[Title] {
  override def compare(that: Title): Int = this.title compare that.title
}

case class Pages(pages: Int) extends DataType[Pages] {
  override def compare(that: Pages): Int = this.pages compare that.pages
}

case class Book(author: Author, title: Title, pages: Pages)