fun main(args : Array<String>)
{
    val student = Student()
    when(val validation =isValidName(student.name) + isValidStudentNumber(studentNumber = student.number))
        {
            is Valid -> println("valid student")
            is Invalid -> println(validation.toString())
        }
   // println(validation)

}

class Student(val name : String= "", val number : String ="123c45")