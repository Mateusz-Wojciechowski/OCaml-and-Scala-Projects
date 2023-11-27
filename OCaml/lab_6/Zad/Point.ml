module type Point = sig
  type point
  val create_point: float -> float -> float
  val distance: point -> point -> float 
end

module Point = struct
  type point = {x: float; y: float; z:float}
  let create_point x y z = {x;y;z}
  let distance p1 p2 =
    let dis_x = p1.x -. p2.x in 
    let dis_y = p1.y -. p2.y in
    let dis_z = p1.z -. p2.z in
    sqrt(dis_x**2. +. dis_y**2. +. dis_z**2.)
end

module type Segment = sig
  type segment
  val create_segment: Point.point -> Point.point -> segment
  val segment_len: segment -> float
end

module Segment = struct
  type segment = {point1: Point.point; point2: Point.point}
  let create_segment p1 p2 = {point1 = p1; point2 = p2}
  let segment_len segment = 
    Point.distance segment.point1 segment.point2
end

let point1 = Point.create_point 1.0 2.0 3.0;;
let point2 = Point.create_point 2.0 3.0 4.0;;

Point.distance point1 point2;;

let segment1 = Segment.create_segment point1 point2;;

Segment.segment_len segment1;;