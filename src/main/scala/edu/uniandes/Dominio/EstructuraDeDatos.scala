package edu.uniandes.Dominio

trait Dato
case class TipoDeDato[T] (nombreCampo: String,valor: T) extends Dato
case class TablaItems(registros: List[List[Dato]])