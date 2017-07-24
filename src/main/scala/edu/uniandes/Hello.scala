package edu.uniandes

import edu.uniandes.Dominio.{Dato, TablaItems, TipoDeDato}

object Hello extends App {
  val lista: Seq[TipoDeDato[String]] = List(
    new TipoDeDato[String]("items", "Revistas"),
    new TipoDeDato[String]("items", "Libros digitales"),
    new TipoDeDato[String]("items", "Revistas digitales"),
    new TipoDeDato[String]("items", "Libros")
  )
  lista.sortBy(r => r.valor).foreach(println)

  val registro: List[Dato] = List(
    new TipoDeDato[String]("Autor", "Gabo"),
    new TipoDeDato[String]("Titulo", "La María"),
    new TipoDeDato[Int]("Numero de Paginas", 752)
  )

  val registro1: List[Dato] = List(
    new TipoDeDato[String]("Autor", "Gabo"),
    new TipoDeDato[String]("Titulo", "La María"),
    new TipoDeDato[Int]("Numero de Paginas", 752)
  )

  val registro2: List[Dato] = List(
    new TipoDeDato[String]("Autor", "Gabo"),
    new TipoDeDato[String]("Titulo", "La María"),
    new TipoDeDato[Int]("Numero de Paginas", 752)
  )

  val Registros: List[List[Dato]] = List(registro,registro1,registro2)

  val tablaLibros = new TablaItems(Registros)
}