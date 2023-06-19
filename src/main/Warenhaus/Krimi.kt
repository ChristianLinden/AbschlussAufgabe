class Krimi(artikelName : String, preis : Double, var taschenbuch : Boolean) :Buch(artikelName,preis){
    override fun toString(): String {
        return "$artikelName $preis"
    }
}