// Example class hierarchy
class Animal{ val sound="rustle" }

class Bird extends Animal{
	override val sound="chirp"
	val body_has="wings"
}

class Chicken extends Bird{
	override val sound="cluck"
	val moves="struts"
}

class Duck extends Bird{
	override val sound="quack"
	val moves="swims"
}


// Different classes with a prepend method
class Nonvariant[A]{
	val L = List()
	def prepend(elem: A) : List[A] = elem::L
}

class NaiveCovariant[+A]{
	val L = List()
	def prepend(failed_elem: A): List[A] = failed_elem::L
}

class NaiveContravariant[-A]{
	val L = List()
	def prepend(failed_elem: A): List[A] = failed_elem::L
}

class LessNaiveCovariant[+A]{
	val L = List()
	def prepend [U >: A] (elem: U): List[A] = elem::L
}

class TrueCovariant[+A]{
	val L = List()
	def prepend [U >: A] (elem: U): List[U] = elem::L
}

class TrueContravariant[-A]{
  val L = List()
  def prepend [U <: A] (elem: U): List[U] = elem::L
}

// a rhetorical question
// (i.e. there is an interesting reason this compiles but isn't a useful function)
class WhyDoesThisWork[-A]{
	val L = List()
	def prepend [A] (elem: A): List[A] = elem::L
}



// a functioning covariant container class
// a functioning covariant container class
/*sealed trait Cov_Works[+A]
case object Nil extends Cov_Works[Nothing]
case class Cons[+A](head: A, tail: Cov_Works[A]) extends Cov_Works[A]
object Cov_Works{
	def test_method() = println("testing")
	def prepend[A] (elem: A, L: Cov_Works[A]): Cov_Works[A] = Cons(elem,L)
}

class Cov_Works[+A](val L: List[A]){
	def prepend[U >: A] (elem: U): Cov_Works[U] = new Cov_Works(elem::L)
}
*/
