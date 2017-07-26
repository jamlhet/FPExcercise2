package edu.uniandes.domain

class LibrarySQL[T](var listRegisters: List[T]) {
  def insertInto(table: LibrarySQL[T])(newRegister: T): LibrarySQL[T] = {
    println(s"Insert process...")
    if (findOne(table)(newRegister).size > 1) {
      println(s"The item already exists in the database")
      this
    } else {
      this.listRegisters = this.listRegisters ::: List(newRegister)
      println(s"The item ${newRegister} was inserted successfully")
      this
    }
  }

  def select(table: LibrarySQL[T])(where: Any): List[T] = {
    println("Select process...")
    where match {
      case where: String =>
        if (where equals "*") {
          println(s"Records found ${listRegisters.size}")
          listRegisters.foreach(x => println(x))
          listRegisters
        } else {
          List()
        }
      case where: T => {
        findOne(table)(where)
      }
    }
  }

  private def findOne(table: LibrarySQL[T])(register: T): List[T] = {
    val selectRegister = this.listRegisters.filter(_ equals register)
    if (selectRegister.size > 0) {
      println(s"Record found : ${selectRegister}")
      selectRegister
    } else {
      println(s"The item ${register} is not registered in the DB")
      List()
    }
  }

  def update(table: LibrarySQL[T])(register: T, registerUpdate: T): Unit = {
    println("Update process...")
    val target: List[T] = findOne(table)(register)
    this.listRegisters.foreach(x => println(x))
    if (this.listRegisters.filter(_ equals registerUpdate).size > 0) {
      println(s"The item ${registerUpdate} already exists in the database")
    } else {
      this.listRegisters = this.listRegisters.filter(!_.equals(target.head))
      this.insertInto(table)(registerUpdate)
      println("Record successfully updated")
      select(table)("*")
    }
  }
}
