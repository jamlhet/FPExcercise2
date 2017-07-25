package edu.uniandes.Dominio

trait Dato

case class TipoDeDato[T] (nombreCampo: String,valor: T) extends Dato

case class TablaItems(registros: List[List[Dato]]){
  var registrosTabla = registros
  def insertInto(reg: List[List[Dato]]): TablaItems ={
    registrosTabla = this.registrosTabla ::: reg
    this
  }
}