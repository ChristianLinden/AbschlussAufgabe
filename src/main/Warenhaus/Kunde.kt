
open class Kunde (name : String,var guthaben : Double ) {
        fun bezahlen(betrag: Double) {
            if (guthaben >= betrag) {
                guthaben -= betrag
                println("Bezahlung erfolgreich. Neues Guthaben: $guthaben")
            } else {
                println("Nicht genügend Guthaben. Bezahlung fehlgeschlagen.")
            }
        }
    }


