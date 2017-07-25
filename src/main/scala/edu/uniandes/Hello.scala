package edu.uniandes

import edu.uniandes.Dominio.{Dato, TablaItems, TipoDeDato}

object Hello extends App {

  val registro0: List[Dato] = List(
    new TipoDeDato[String]("Autor", "HGabo"),
    new TipoDeDato[String]("Titulo", "ZLa María"),
    new TipoDeDato[Int]("Numero de Paginas", 752)
  )

  val registro: List[Dato] = List(
    new TipoDeDato[String]("Autor", "HGabo"),
    new TipoDeDato[String]("Titulo", "ZLa María"),
    new TipoDeDato[Int]("Numero de Paginas", 752)
  )

  val registro1: List[Dato] = List(
    new TipoDeDato[String]("Autor", "BGabo"),
    new TipoDeDato[String]("Titulo", "YLa María"),
    new TipoDeDato[Int]("Numero de Paginas", 752)
  )

  val registro2: List[Dato] = List(
    new TipoDeDato[String]("Autor", "AGabo"),
    new TipoDeDato[String]("Titulo", "XLa María"),
    new TipoDeDato[Int]("Numero de Paginas", 752)
  )

  val Registros1: List[List[Dato]] = List(registro0)
  val Registros2: List[List[Dato]] = List(registro,registro1,registro2)

  val tablaLibros: TablaItems = new TablaItems(Registros1)
  tablaLibros.registrosTabla.foreach(println)
  println("----")
  tablaLibros.insertInto(Registros2).registrosTabla.foreach(println)
}