class Krimi(artikelName : String, preis : Double, bestand: Int, var taschenbuch : Boolean) :Buch(artikelName,preis,bestand){
    override fun toString(): String {
        return "$artikelName $preis "
    }
}