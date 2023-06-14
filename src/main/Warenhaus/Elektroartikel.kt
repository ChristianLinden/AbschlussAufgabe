open class Elektroartikel ( var artikelName: String, var preis : Double, var grossgeraet : Boolean) {
    override fun toString(): String {
        return "$artikelName  $preis€"
    }
}