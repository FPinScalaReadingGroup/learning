// animal
class Animal{ val sound="rustle" }

// bird
class Bird extends Animal{
	override val sound="chirp"
	val body_has="wings"
}

// chicken
class Chicken extends Bird{
	override val sound="cluck"
	val moves="struts"
}

// duck
class Duck extends Bird{
	override val sound="quack"
	val moves="swims"
}

/*
// failed covariant container class. sad!
class Cov_Fail[+A]{
	val L = List()
	def prepend(failed_elem: A): List[A] = failed_elem::L
}

// failed contravariant container class. weak!
class Con_Fail[-A]{
	val L = List()
	def prepend(failed_elem: A): List[A] = failed_elem::L
}

// failed covariant container class. low energy!
class Cov_Works2[+A]{
	val L = List()
	def prepend [U >: A] (elem: U): List[A] = elem::L
}
*/

class No_Fail[A]{
	val L = List()
	def prepend(elem: A) : List[A] = elem::L
}

// a functioning covariant container class
/*sealed trait Cov_Works[+A]
case object Nil extends Cov_Works[Nothing]
case class Cons[+A](head: A, tail: Cov_Works[A]) extends Cov_Works[A]

object Cov_Works{
	def test_method() = println("testing")
	def prepend[A] (elem: A, L: Cov_Works[A]): Cov_Works[A] = Cons(elem,L)
}*/

class Cov_Works[+A](val L: List[A]){
	def prepend[U >: A] (elem: U): Cov_Works[U] = new Cov_Works(elem::L)
}

// a functioning contravariant container class
class Con_Works[-A]{
	val L = List()
	def prepend [A] (elem: A): List[A] = elem::L
}

