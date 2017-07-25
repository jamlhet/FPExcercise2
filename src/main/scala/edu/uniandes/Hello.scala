package edu.uniandes

import edu.uniandes.Dominio._

object Hello extends App {

  val registro0: List[TipoDeDato[_>: Autor with Titulo with NumeroDePaginas]] = List(
    new TipoDeDato[Autor](new Autor("HGabo")),
    new TipoDeDato[Titulo](new Titulo("ZLa María")),
    new TipoDeDato[NumeroDePaginas](new NumeroDePaginas(752))
  )

  val registro1: List[TipoDeDato[_>: Autor with Titulo with NumeroDePaginas]] = List(
    new TipoDeDato[Autor](new Autor("AGabo")),
    new TipoDeDato[Titulo](new Titulo("CLa María")),
    new TipoDeDato[NumeroDePaginas](new NumeroDePaginas(521))
  )

  val Registros1: List[List[TipoDeDato[_>: Autor with Titulo with NumeroDePaginas]]] = List(registro0)
  val Registros2: List[List[TipoDeDato[_>: Autor with Titulo with NumeroDePaginas]]] = List(registro1)

  val tablaLibros: TablaItems = new TablaItems(Registros1)
  tablaLibros.registrosTabla.foreach(println)
  println("----")
  tablaLibros.insertInto(Registros2)
  tablaLibros.registrosTabla.foreach(println)
  println("----")
  //tablaLibros.registrosTabla.sortBy(r=>r.sortBy(s=>s.valor[NumeroDePaginas]))
}