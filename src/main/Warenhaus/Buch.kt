  open class Buch(artikelName : String, preis: Double) : Produkt(artikelName,preis){
      override fun toString(): String {
          return "$artikelName $preis"
      }
  }
