enum SolidFigure:
  case Cuboid(width: Double, height: Double, depth: Double)
  case Cone(radius: Double, height: Double)
  case Sphere(radius: Double)
  case Cylinder(radius: Double, height: Double)

def volume(figure: SolidFigure): Double = figure match
  case SolidFigure.Cuboid(w, h, d) => w * h * d
  case SolidFigure.Cone(r, h) => math.Pi * r * r * h / 3
  case SolidFigure.Sphere(r) => 4.0 / 3.0 * math.Pi * r * r * r
  case SolidFigure.Cylinder(r, h) => math.Pi * r * r * h


val cuboid = SolidFigure.Cuboid(2, 3, 4)
val cone = SolidFigure.Cone(2, 3)
val sphere = SolidFigure.Sphere(2)
val cylinder = SolidFigure.Cylinder(2, 3)

println(volume(cuboid))
println(volume(cone))
println(volume(sphere))
println(volume(cylinder))