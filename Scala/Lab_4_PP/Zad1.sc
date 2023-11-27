type Point2D = (Float, Float)

def distance(p1: Point2D, p2: Point2D): Float = {
  val (x1, y1) = p1
  val (x2, y2) = p2
  math.sqrt(math.pow(x1 - x2, 2) + math.pow(y1 - y2, 2)).toFloat
}

println(distance((2,3), (3,4)))

// zeby pracowac w przestrzeni z wieksza iloscia wymiarow
// nalezy zwiekszyc liczbe argumentow krotki
// alternatywnie zamiast uzywac krotki mozna uzyc klasy ktora przyjmuje tablice floatow
// kazdy z nich to wspolrzedna punktu dla konkretnego wymiaru
// mozna uzyc tez sekwencji
