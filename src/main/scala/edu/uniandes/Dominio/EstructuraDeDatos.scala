package edu.uniandes.Dominio

import scala.math.Ordered.orderingToOrdered

sealed trait TipoDeDato

case class Autor (autor:String) extends TipoDeDato with Ordered[Autor]{
  override def compare(that: Autor): Int = (this.autor) compare (that.autor)
}

case class Titulo (titulo:String) extends TipoDeDato
case class NumeroDePaginas (numeroDePaginas:Int) extends TipoDeDato

class TablaItems(var registros: List[List[TipoDeDato]]){
  def insertInto(reg: List[List[TipoDeDato]]): TablaItems ={
    registros = registros ::: reg
    this
  }
}