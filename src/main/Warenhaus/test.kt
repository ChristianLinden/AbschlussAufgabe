

fun main (){
    val warenhaus = Warenhaus()
    warenhaus.buecher.add(Krimi("Herr der Ringe", 12.99, true, true))
    warenhaus.buecher.add(Roman("Erster Quatsch", 12.99, true))
    warenhaus.buecher.add(Roman("Sandmaenchen", 9.99, true))
    warenhaus.buecher.add(Krimi("Zug ins Nirgendwo", 7.99, true, true))
    warenhaus.elektro.add(Fernseher("GrundigTV42", 599.00,true))
    warenhaus.elektro.add(Fernseher("TelefunkenTV5274", 799.00, true))
    warenhaus.elektro.add(Lautsprecher("BoseLT21", 1299.00, 500, true, false))
    warenhaus.elektro.add(Lautsprecher("Alexa", 39.99, 15, false, grossgeraet = false))
    warenhaus.logIn()
    warenhaus.neuregistrieren()
    warenhaus.adminlogin()
    warenhaus.warenKorb

    println("${warenhaus.buecher}")
    println("${warenhaus.elektro}")




}

