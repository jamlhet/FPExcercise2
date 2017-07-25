package edu.uniandes.Dominio

case class TipoDeDato[T] (valor: T)

case class Autor (autor:String)
case class Titulo (titulo:String)
case class NumeroDePaginas (numeroDePaginas:Int)

case class TablaItems(registros: List[List[TipoDeDato[_>: Autor with Titulo with NumeroDePaginas]]]){
  var registrosTabla = registros
  def insertInto(reg: List[List[TipoDeDato[_>: Autor with Titulo with NumeroDePaginas]]]): TablaItems ={
    registrosTabla = this.registrosTabla ::: reg
    this
  }
}