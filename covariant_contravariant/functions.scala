class Animal{ val sound="rustle" }

class Bird(val name: String) extends Animal {
  override val sound="chirp"
  val body_has="wings"
}

class Chicken (name: String) extends Bird(name) {
  override val sound="cluck"
  val moves="struts"
}

class Duck (name: String) extends Bird(name) {
  override val sound="quack"
  val moves="swims"
}

// Chicken <: Bird <: Animal
// Duck <: Bird <: Animal

// Bird => Chicken
def nameNewChicken (a: Bird): Chicken = new Chicken(a.name)

// Chicken => Bird
def nameNewBird (a: Chicken): Bird = new Bird(a.name)

// Is one of these functions a subtype of the other?
