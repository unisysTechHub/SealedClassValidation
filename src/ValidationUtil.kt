
sealed  class Validation
{abstract infix operator fun plus(other: Validation): Validation
}
object Valid : Validation()
{
 override fun plus(other : Validation) : Validation = when(other)
 {
  is Valid -> this
  is Invalid -> other
 }
}
data class Invalid(val errors : MutableList<String>) : Validation()
{
    companion object
    {
        operator fun invoke(error : String) = Invalid(mutableListOf(error))
    }

    override fun plus(other: Validation): Validation  = when(other)
    {
        is Valid -> this
        is Invalid -> Invalid(errors = this.errors + other.errors)
    }

}

fun isValidName(name : String) : Validation =
    if (name.isNotEmpty())
            Valid
        else
            Invalid("invalid length of name")

fun isValidStudentNumber(studentNumber : String) : Validation =
        if(studentNumber.all { Character.isDigit(it) })
            Valid
        else
            Invalid("Invalid student number")

operator fun MutableList<String>.plus(other : MutableList<String>) : MutableList<String>
{   this.addAll(other)
    return this
}





