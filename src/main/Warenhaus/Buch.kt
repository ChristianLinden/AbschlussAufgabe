  open class Buch(artikelName : String, preis: Double, bestand: Int) : Produkt(artikelName,preis,bestand){
      override fun toString(): String {
          return "$artikelName $preis "
      }
  }
