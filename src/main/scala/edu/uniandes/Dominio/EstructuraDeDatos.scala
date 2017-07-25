package edu.uniandes.Dominio

case class TipoDeDato[T] (nombreCampo: String,valor: T)

case class TablaItems(registros: List[List[TipoDeDato[_>: String with Int]]]){
  var registrosTabla = registros
  def insertInto(reg: List[List[TipoDeDato[_>: String with Int]]]): TablaItems ={
    registrosTabla = this.registrosTabla ::: reg
    this
  }
}