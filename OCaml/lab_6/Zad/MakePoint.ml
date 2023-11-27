module type Coordinate = sig
  type t
  val add: t -> t -> t
  val toStr: t -> string
end


module MakePoint (Coord: Coordinate) = struct
  type point = {x: Coord.t; y: Coord.t}

  let createPoint x y = {x;y}

  let add p1 p2 = {x=Coord.add p1.x p2.x; y=Coord.add p1.y p2.y}

  let toStr p = "(" ^ Coord.toStr p.x ^ ", " ^ Coord.toStr p.y ^ ")"
end


module FloatCoord: Coordinate with type t = float = struct
  type t = float
  let add = (+.)
  let toStr = string_of_float
  let of_float (x: float) : t = x
end

module FloatPoint = MakePoint(FloatCoord)

let p1 = FloatPoint.createPoint 3.2 5.3
let p2 = FloatPoint.createPoint 1.5 2.3
let p3 = FloatPoint.add p1 p2


