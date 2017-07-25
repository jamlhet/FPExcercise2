package edu.uniandes.Dominio

sealed trait TipoDeDato

case class Autor (autor:String) extends TipoDeDato
case class Titulo (titulo:String) extends TipoDeDato
case class NumeroDePaginas (numeroDePaginas:Int) extends TipoDeDato

class TablaItems(var registros: List[List[TipoDeDato]]){
  def insertInto(reg: List[List[TipoDeDato]]): TablaItems ={
    registros = registros ::: reg
    this
  }
}