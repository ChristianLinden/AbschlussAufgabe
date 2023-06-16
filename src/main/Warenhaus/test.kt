

fun main (){
    val warenhaus = Warenhaus()
    warenhaus.logIn()
    warenhaus.neuregistrieren()
    warenhaus.adminlogin()

    println(" ${warenhaus.warenKorb.size}")
    println("${warenhaus.buecher}")
    println("${warenhaus.elektro}")




}

