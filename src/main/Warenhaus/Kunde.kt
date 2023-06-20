
open class Kunde (name : String) {
    var paypal : Double = 2500.00
    var guthaben : Double = 2500.00

    fun bezahlen(betrag: Double) {
            if (guthaben  >= betrag) {
                guthaben -= betrag
                println("Bezahlung erfolgreich. Neues Guthaben: $guthaben")
            } else {
                println("Nicht genügend Guthaben. Bezahlung fehlgeschlagen.")
            }
        }
    fun paypalZahlen(betrag: Double) {
        if (paypal  >= betrag) {
            paypal -= betrag
            println("Bezahlung erfolgreich. Neues Guthaben: $paypal")
        } else {
            println("Nicht genügend Guthaben. Bezahlung fehlgeschlagen.")
        }



    }}


