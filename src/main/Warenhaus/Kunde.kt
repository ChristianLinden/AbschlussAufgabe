
open class Kunde (benutzer : String,passwort : String, var kontoNummer : Int, var guthaben : Double  ):Admin(benutzer,passwort){
    override fun toString(): String {
        return "Hallo $benutzer ihre Kontonummer ist die  $kontoNummer und sie haben zur Zeit einen Kontostand von $guthaben€"
    }
   }








