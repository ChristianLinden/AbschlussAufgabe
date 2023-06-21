open class Produkt(var artikelName: String, var preis: Double, var bestand: Int) : Comparable<Produkt>{
    override fun toString(): String {
        return "$artikelName $preis $bestand"
}

    override fun compareTo(other: Produkt): Int {
       return preis.compareTo(other.preis)
    }
}