package edu.uniandes.domain

class LibrarySQL[T](var listRegisters: List[T]) {

  def insertInto(table: LibrarySQL[T])(newRegister: T): LibrarySQL[T] = {
    if(table.listRegisters.exists(_ equals newRegister))
      println("The item is already registered")
    else
      table.listRegisters = table.listRegisters ::: List(newRegister)
    //println(s"The item $newRegister was inserted successfully")
    println(s"Insert process ok")
    table
  }

  def select(table: LibrarySQL[T])(where: List[_ >: String with Any]): List[T] = {
    println(s"Select process. Records in table= ${table.listRegisters.size}")
    where.head match {
      case "*" =>
        //table.listRegisters.foreach(x => println(x))
        table.listRegisters
      case ">" =>
        where.last match {
          case Author(x) =>
            table.listRegisters.filter(_.asInstanceOf[LibraryItem].author.author > x)
          case Title(x) =>
            table.listRegisters.filter(_.asInstanceOf[LibraryItem].title.title > x)
          case Pages(x) =>
            table.listRegisters.filter(_.asInstanceOf[LibraryItem].pages.pages > x)
          case IssueNumber(x) =>
            table.listRegisters.filter(_.asInstanceOf[LibraryItem].issueNumber.issueNumber > x)
          case FirstDayBorrowed(x) =>
            table.listRegisters.filter(_.asInstanceOf[BorrowItem].firstDayBorrowed.firstDayBorrowed after x)
          case DaysBorrow(x) =>
            table.listRegisters.filter(_.asInstanceOf[BorrowItem].daysBorrow.daysBorrow > x)
          case _ =>
            println(s"Data type not supported")
            List()
        }
      case "<" =>
        where.last match {
          case Author(x) =>
            table.listRegisters.filter(_.asInstanceOf[LibraryItem].author.author < x)
          case Title(x) =>
            table.listRegisters.filter(_.asInstanceOf[LibraryItem].title.title < x)
          case Pages(x) =>
            table.listRegisters.filter(_.asInstanceOf[LibraryItem].pages.pages < x)
          case IssueNumber(x) =>
            table.listRegisters.filter(_.asInstanceOf[LibraryItem].issueNumber.issueNumber < x)
          case FirstDayBorrowed(x) =>
            table.listRegisters.filter(_.asInstanceOf[BorrowItem].firstDayBorrowed.firstDayBorrowed before x)
          case DaysBorrow(x) =>
            table.listRegisters.filter(_.asInstanceOf[BorrowItem].daysBorrow.daysBorrow < x)
          case _ =>
            println(s"Data type not supported")
            List()
        }
      case "=" =>
        where.last match {
          case Author(x) =>
            table.listRegisters.filter(_.asInstanceOf[LibraryItem].author.author equals x)
          case Title(x) =>
            table.listRegisters.filter(_.asInstanceOf[LibraryItem].title.title equals x)
          case Pages(x) =>
            table.listRegisters.filter(_.asInstanceOf[LibraryItem].pages.pages equals x)
          case IssueNumber(x) =>
            table.listRegisters.filter(_.asInstanceOf[LibraryItem].issueNumber.issueNumber equals x)
          case FirstDayBorrowed(x) =>
            table.listRegisters.filter(_.asInstanceOf[BorrowItem].firstDayBorrowed.firstDayBorrowed equals x)
          case DaysBorrow(x) =>
            table.listRegisters.filter(_.asInstanceOf[BorrowItem].daysBorrow.daysBorrow equals x)
          case IsElectronic(x) =>
            table.listRegisters.filter(_.asInstanceOf[LibraryItem].IsElectronic)
          case ItemUUID(x) =>
            table.listRegisters.filter(_.asInstanceOf[LibraryItem].itemUUID.itemUUID equals x)
          case _ =>
            println(s"Data type not supported")
            List()
        }
      case _ =>
        println(s"No records found")
        List()
    }
  }

  private def findOne(table: LibrarySQL[T])(register: T): List[T] = {
    val selectRegister = table.listRegisters.filter(_ equals register)
    if (selectRegister.nonEmpty) {
      println(s"Record found : $selectRegister")
      selectRegister
    } else {
      println(s"The item $register is not registered in the DB")
      List()
    }
  }

  def update(table: LibrarySQL[T])(register: T, registerUpdate: T): Unit = {
    println("Update process...")
    val target: List[T] = findOne(table)(register)
    this.listRegisters.foreach(x => println(x))
    if (table.listRegisters.exists(_ equals registerUpdate)) {
      println(s"The item $registerUpdate already exists in the database")
    } else {
      table.listRegisters = table.listRegisters.filter(!_.equals(target.head))
      table.insertInto(table)(registerUpdate)
      println("Record successfully updated")
      select(table)(List("*"))
    }
  }
}