package edu.uniandes

import edu.uniandes.Dominio.TipoDeDato

object Hello extends App {
  val lista = List(
    new TipoDeDato[String]("items", "Revistas"),
    new TipoDeDato[String]("items", "Libros digitales"),
    new TipoDeDato[String]("items", "Revistas digitales"),
    new TipoDeDato[String]("items", "Libros")
  )
  lista.sortBy(r => r.valor).foreach(println)
}