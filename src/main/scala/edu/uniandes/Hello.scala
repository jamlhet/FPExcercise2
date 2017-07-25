package edu.uniandes

import edu.uniandes.Dominio._

object Hello extends App {

  val registro0: List[TipoDeDato[_>: String with Int]] = List(
    new TipoDeDato[String]("Autor", "HGabo"),
    new TipoDeDato[String]("Titulo", "ZLa María"),
    new TipoDeDato[Int]("Numero de Paginas", 752)
  )

  val registro1: List[TipoDeDato[_>: String with Int]] = List(
    new TipoDeDato[String]("Autor", "HGabo"),
    new TipoDeDato[String]("Titulo", "ZLa María"),
    new TipoDeDato[Int]("Numero de Paginas", 800)
  )

  val registro2: List[TipoDeDato[_>: String with Int]] = List(
    new TipoDeDato[String]("Autor", "HGabo"),
    new TipoDeDato[String]("Titulo", "ZLa María"),
    new TipoDeDato[Int]("Numero de Paginas", 800)
  )

  val Registros1: List[List[TipoDeDato[_>: String with Int]]] = List(registro0)
  val Registros2: List[List[TipoDeDato[_>: String with Int]]] = List(registro1)
  val Registros3: List[List[TipoDeDato[_>: String with Int]]] = List(registro2)

  val tablaLibros: TablaItems = new TablaItems(Registros1)
  tablaLibros.registrosTabla.foreach(println)
  println("----")
  tablaLibros.insertInto(Registros2)
  tablaLibros.registrosTabla.foreach(println)
  println("----")
  tablaLibros.registrosTabla.sortBy(r=>r.sorted)
}