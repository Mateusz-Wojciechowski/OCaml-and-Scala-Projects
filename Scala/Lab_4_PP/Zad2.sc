type Person_Tuple = (String, String, Int, String, Double)
type Partnership = (Person_Tuple, Person_Tuple)

class Person(val name: String, val surname: String, val age: Int, val gender: String, val shoe_size: Double)
case class PartnerRecord(person1: Person, person2: Person)

val partnership: Partnership = (("Marcin", "Kowalski", 29, "Male", 42.5), ("Anna", "Nowak", 56, "Female", 38))
val partnership_record: PartnerRecord = PartnerRecord(new Person("Michal", "Kowalski", 29, "Male", 42.5), new Person("Anna", "Nowak", 56, "Female", 38))

def youngerPersonTuple(partnership: Partnership): Person_Tuple = {
  if(partnership._1._3 <=partnership._2._3){
    partnership._1
  }
  else{
    partnership._2
  }
}

def youngerPersonRecord(partnership: PartnerRecord): Person = {
  if (partnership.person1.age <= partnership.person2.age) {
    partnership.person1
  }
  else {
    partnership.person2
  }
}

val youngerTuple = youngerPersonTuple(partnership)
val youngerRecord = youngerPersonRecord(partnership_record)

println(youngerTuple._1)
println(youngerRecord.name)
// to jest niedozwolone poniewaz krotka jest niemutowalna
//partnership._1 = new Person("Marian", "Kiepski", 48, "Male", 46.0)

// to tez nie jest dozwolone bo case class jest niemutowalny
//partnership_record.person1 = new Person("Marian", "Kiepski", 48, "Male", 46.0)

// to tez mozliwe tylko gdy pole jest var
//partnership_record.person1.name = "Mariusz"