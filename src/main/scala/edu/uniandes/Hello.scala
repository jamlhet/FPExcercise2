package edu.uniandes

import edu.uniandes.Dominio._

object Hello extends App {

  val registro0: List[TipoDeDato] = List(
    Autor("HGabo"),
    Titulo("ZLa María"),
    NumeroDePaginas(752)
  )

  val registro1: List[TipoDeDato] = List(
    Autor("AGabo"),
    Titulo("CLa María"),
    NumeroDePaginas(1000)
  )

  val registro2: List[TipoDeDato] = List(
    Autor("AGabo"),
    Titulo("XLa María"),
    NumeroDePaginas(10)
  )

  val Registros0: List[List[TipoDeDato]] = List(registro0)
  val Registros1: List[List[TipoDeDato]] = List(registro1)
  val Registros2: List[List[TipoDeDato]] = List(registro2)

  val tablaLibros = new TablaItems(Registros0)
  tablaLibros.registros.foreach(println)
  println("----")

  tablaLibros.insertInto(Registros1)
  tablaLibros.registros.foreach(println)
  println("----")

  tablaLibros.insertInto(Registros2)
  tablaLibros.registros.foreach(println)
  println("----")

  tablaLibros.registros.sortBy(r => r.collectFirst {
    case NumeroDePaginas(n) => n
  }.getOrElse(0)).foreach(println)

  val hola: List[List[TipoDeDato]] = tablaLibros.registros
}