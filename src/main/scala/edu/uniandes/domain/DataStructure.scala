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

class LibraryTable[T](var listRegisters: List[T]){
  def insertInto(table:LibraryTable[T])(newRegister: T): LibraryTable[T] ={
    if(findOne(table)(newRegister).size>1) {
      println(s"The item already exists in the database")
      this
    }else{
      this.listRegisters = this.listRegisters ::: List(newRegister)
      this
    }
  }

  def selectAll(table:LibraryTable[T])(): List[T] = {
    println(s"Records found ${listRegisters.size}")
    listRegisters.foreach(x=>println(x))
    println("**************")
    listRegisters
  }

  def findOne(table:LibraryTable[T])(register: T): List[T]={
    val selectRegister = this.listRegisters.filter(_ equals register)
    if(selectRegister.size>0) {
      println(s"Record found : ${selectRegister}")
      println("**************")
      selectRegister
    }else{
      println(s"The item ${register} is not registered in the DB")
      println("**************")
      List()
    }
  }

  def update(table:LibraryTable[T])(register: T, registerUpdate: T): Unit={
    val target: List[T] = findOne(table)(register)
    this.listRegisters.foreach(x => println(x))
    println("**************")
    if(this.listRegisters.filter(_ equals registerUpdate).size>0) {
      println(s"The item ${registerUpdate} already exists in the database")
    }else{
      this.listRegisters = this.listRegisters.filter(!_.equals(target.head))
      this.insertInto(table)(registerUpdate)
    }

  }
}