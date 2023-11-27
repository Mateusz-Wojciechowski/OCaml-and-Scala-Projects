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

(* translacja *)

module type TranslationSig = sig
  type t
  val create : float -> float -> float -> t
  val translate_point : t -> Point.point -> Point.point
end

module Translation : TranslationSig = struct
  type t = {dx: float; dy: float; dz: float}

  let create dx dy dz = { dx; dy; dz }

  let translate_point translation point =
    Point.create_point
      (point.Point.x +. translation.dx)
      (point.Point.y +. translation.dy)
      (point.Point.z +. translation.dz)
end

module Translate_Point (Transl: TranslationSig) = struct
  let translate_point translation point = Transl.translate_point translation point
end

module Translate_Segment (Transl: TranslationSig) = struct
  let translate_segment translation segment =
    let translated_p1 = Transl.translate_point translation segment.Segment.point1 in
    let translated_p2 = Transl.translate_point translation segment.Segment.point2 in
    Segment.create_segment translated_p1 translated_p2
end 


module TranslatedPoint = Translate_Point(Translation)
module TranslatedSegment = Translate_Segment(Translation)

let point1 = Point.create_point 1.0 2.0 3.0
let point2 = Point.create_point 2.0 3.0 4.0

let segment1 = Segment.create_segment point1 point2
let segment1_len_before = Segment.segment_len segment1
let translation = Translation.create 1.0 1.0 1.0
let translated_point1 = TranslatedPoint.translate_point translation point1
let translated_point2 = TranslatedPoint.translate_point translation point2
let translated_segment = TranslatedSegment.translate_segment translation segment1
let segment1_len_after = Segment.segment_len segment1


