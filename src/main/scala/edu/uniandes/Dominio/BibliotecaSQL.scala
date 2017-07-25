package edu.uniandes.Dominio

trait Dato

object BibliotecaSQL {
  def sort[A: Ordering](coll: Seq[Iterable[A]]) = coll.sorted
}