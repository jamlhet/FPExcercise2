package edu.uniandes.Dominio

case class TipoDeDato[T](
                          nombreCampo: String,
                          valor: T
                        )

case class Registro[T](
                        registro: List[TipoDeDato[T]]
                      )

case class TablaLibrosFisicos(
                             registros: List[Registro[TablaLibrosFisicos]]
                             ){

}