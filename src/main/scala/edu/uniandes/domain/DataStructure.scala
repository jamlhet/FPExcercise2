package edu.uniandes.domain

import scala.math.Ordered.orderingToOrdered

sealed trait DataType

case class Author(autor:String) extends DataType with Ordered[Author]{
  override def compare(that: Author): Int = (this.autor) compare (that.autor)
}

case class Title(title:String) extends DataType with Ordered[Title]{
  override def compare(that: Title): Int = (this.title) compare (that.title)
}

case class Pages(pages:Int) extends DataType with Ordered[Pages]{
  override def compare(that: Pages): Int = (this.pages) compare (that.pages)
}

case class Book(author: Author, title:Title, pages:Pages)

class ItemsTable(var libros: List[List[DataType]]){
  def insertInto(newBook: List[List[DataType]]): ItemsTable ={
    libros = libros ::: newBook
    this
  }
}

