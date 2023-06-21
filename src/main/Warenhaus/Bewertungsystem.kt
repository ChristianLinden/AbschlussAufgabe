class Bewertungssytem {
    private  val bewertungen : MutableMap<String, MutableList<Bewertung>> = mutableMapOf()
    fun bewertungHinzufuegen(artikel : String,bewertung : Int, kritik : String?){
        if (!bewertungen.containsKey(artikel)){
            bewertungen[artikel] = mutableListOf()
        }
        val bewertungsliste = bewertungen[artikel]
        bewertungsliste?.add(Bewertung(bewertung, kritik))
    }
    fun durchschnittlBewertung (artikel: String): Double{
    val bewertungsliste = bewertungen[artikel]?: return 0.0
    val summe = bewertungsliste.sumBy { it.bewertng}
    return summe.toDouble() / bewertungsliste.size.toDouble()}
    fun alleDurchschnittsBewertungen (){
        for (arttikel in bewertungen.keys){
            val durschnitt = durchschnittlBewertung(arttikel)
            println("Die Durchschnittliche Bewertung für Artikel ´$arttikel´: $durschnitt")
        }
    }
}