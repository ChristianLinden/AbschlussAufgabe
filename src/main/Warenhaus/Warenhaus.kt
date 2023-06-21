import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Comparator
import kotlin.concurrent.thread
import kotlin.math.E

open class Warenhaus() {
    var buecher: MutableList<Buch> = mutableListOf(
            Krimi("Der letzte Schrei", 12.99, 2, true),
            Krimi("Und er schrie immer noch", 15.99, 3, true),
            Krimi("Das mordende Schaf", 9.99, 2, true),
            Krimi("Der letzte Überlebende", 29.99, 3, false),
            Roman("Der Herr der sieben Meere", 29.99, 1, false),
            Roman("Der Kuchen Streik", 19.99, 3, false),
            Roman("Käptain Langohr", 6.99, 3, true),
            Roman("Es war einmal", 9.99, 2, true))
    var elektro: MutableList<Elektroartikel> = mutableListOf(
            Fernseher("Telefunken", 599.00, false, 3, ),
            Fernseher("Grundig TV 5310", 999.00, true, 2),
            Fernseher("Grundig TV 7250", 599.00, true, 1),
            Fernseher("Samsung", 1199.00, true, 2),
            Lautsprecher("Telefunken", 299.00, 250, true, 2),
            Lautsprecher("Bosse", 1599.00, 800, true, 2),
            Lautsprecher("Amazon Alexa", 39.99, 25, false, 1),
            Lautsprecher("Jambra", 59.99, 55, true, 1))
    val bewertungen: MutableList<WarenhausBewertung> = mutableListOf(
            WarenhausBewertung(5, "alles super, gerne wieder"),
            WarenhausBewertung(3, "Personal könnte was schneller sein"),
            WarenhausBewertung(5, "schnelle Lieferung"),
            WarenhausBewertung(2, "Artikel(TV) gekauft und prompt geliefert und aufgestellt")

    )

    var kundenListe: MutableMap<String, String> = mutableMapOf(
            "Test" to "4711"
    )
    var adminListe: MutableMap<String, String> = mutableMapOf(
            "Test001" to "4715"
    )
    var warenKorb: MutableList<Produkt> = mutableListOf()

    fun logIn() {

        var loggedIn: Boolean = false
        var username: String
        var pin: String


        println("Geben sie ihren Username ein:")
        username = readln()
        println("Geben sie ihre Pin ein:")
        pin = readln()

        loggedIn = username in kundenListe && pin == kundenListe[username]!!
        if (loggedIn)
            println("Willkommen, $username")
        else
            println("Login fehlgeschlagen.")

    }

    fun neuregistrieren() {
        println("Dieser Shop ist erst ab dem 12 Lebensjahr zugänglich. Bitte gib dein Alter ein: ")
        try {
            var alter = readln().toInt()

            if (alter > 11)
                println("Willkommen im Shop ❤️")
            else
                println("Du bist leider noch zu jung für unsere Angebote. 🐨")
        } catch (ex: Exception) {
            neuregistrieren()
        }
        var userName: String
        var pin: String
        println("Sie können sich nun Registrieren. Bitte geben Sie Ihren gewünschten Namen ein:")
        userName = readln()
        if (userName in kundenListe)
            println("Dieser Name existiert bereits, bitte wählen sie einen anderen")
        else
            println("bitte geben sie Ihren gewünschten Pin ein")
        pin = readln()
        kundenListe.put(userName, pin)
        println("Ihr neuer Account mit den Daten $userName und $pin wurde ersstellt")
    }

    fun adminlogin() {
        var loggedIn: Boolean = false
        var adminname: String
        var pin: String


        println("Geben sie ihren Username ein:")
        adminname = readln()
        println("Geben sie ihre Pin ein:")
        pin = readln()

        loggedIn = adminname in adminListe && pin == adminListe[adminname]!!
        if (loggedIn)
            println("Willkommen, $adminname")
        else
            println("Login fehlgeschlagen.")

    }

    fun einkaufbuecher() {
        for ((artikel, preis) in buecher.withIndex()) {
            println("$artikel $preis")//Liste aller Artikel in buecher
        }
        println("Bitte geben sie ihren Artikel ein (Nur die Artikelbezeichnung) :")
        var bestellung = readln()
        var found = false
        for (buch in buecher) {
            if (bestellung == buch.artikelName) {
                println("Vielen Dank, wir haben den Artikel $bestellung ihren Warenkorb zugefügt.")
                warenKorb.add(buch)
                found = true
                break
            }
        }
        if (!found) {
            println("Artikel derzeit nicht vorhanden")
        }
        println(" Derzeit befinden sich folgende Artikel in ihrem Warenkorb $warenKorb")


    }

    fun einkaufelectro() {
        elektro.sort()
        for ((artikel, preis) in elektro.withIndex()) {
            println("$artikel $preis")//übersicht wird ausgegeben
        }
        println("Bitte geben sie ihren Artikel ein(Bitte nur mit der Artikelbezeichnung):")
        var bestellung = readln()
        var found = false
        for (elektroArtikel in elektro) {
            if (bestellung == elektroArtikel.artikelName) {
                println("Vielen Dank, wir haben den Artikel $bestellung ihren Warenkorb zugefügt.")
                warenKorb.add(elektroArtikel)
                found = true
                break
            }
        }
        if (!found) {
            println("Artikel derzeit nicht vorhanden")
        }
        println(" Derzeit befinden sich folgende Artikel in ihrem Warenkorb $warenKorb")
    }


    open fun bezahlen() {

        var gesamtpreis = 0.0
        var prämientext = ""
        val now = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")
        val formattedDateTime = now.format(formatter)


        for (artikel in warenKorb) {
            gesamtpreis += artikel.preis
        }
        if (gesamtpreis < 50.0) {
            prämientext = "Sie erhalten noch keine Prämie"
        } else if (gesamtpreis < 100.0) {
            prämientext = "Sie erhalten einen 5€ Amazon-Gutschein für ihren nächsten Einkauf"
        } else if (gesamtpreis < 150.0) {
            prämientext = "Sie erhalten einen 15€ Amazon-Gutschein für ihren nächsten Einkauf"
        } else if (gesamtpreis < 200.0) {
            prämientext = "Sie erhalten einen 25€ Amazon-Gutschein für ihren nächsten Einkauf"
        } else {
            prämientext = "Sie erhalten einen 50$ Gutschein für ihren nächsten Einkauf"
        }
        println("-------------------------------------------------------")
        println(prämientext)
        val kunde = Kunde("")
        println("-------------------------------------------------------")
        println("Gesamtpreis:                        $gesamtpreis")
        println("-------------------------------------------------------")
        println("Vielen Dank für Ihren Einkauf")
        println("$formattedDateTime")
        kunde.bezahlen(gesamtpreis)
        warenKorb.clear()

    }

    fun paypalBezahlen() {
        var gesamtpreis = 0.0
        var prämientext = "."
        val now = LocalDateTime.now()//gegoogelt b.z.w Chatgpd zu Hilfe genommen beim Datum
        val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")
        val formattedDateTime = now.format(formatter)


        for (artikel in warenKorb) {
            gesamtpreis += artikel.preis
        }
        if (gesamtpreis < 50.0) {
            prämientext = "Sie erhalten noch keine Prämie"
        } else if (gesamtpreis < 100.0) {
            prämientext = "Sie erhalten einen 5€ Amazon-Gutschein für ihren nächsten Einkauf"
        } else if (gesamtpreis < 150.0) {
            prämientext = "Sie erhalten einen 15€ Amazon-Gutschein für ihren nächsten Einkauf"
        } else if (gesamtpreis < 200.0) {
            prämientext = "Sie erhalten einen 25€ Amazon-Gutschein für ihren nächsten Einkauf"
        } else {
            prämientext = "Sie erhalten einen 50$ Gutschein für ihren nächsten Einkauf"
        }
        println("-------------------------------------------------------")
        println(prämientext)
        val kunde = Kunde("")
        println("-------------------------------------------------------")
        println("Gesamtpreis:                        $gesamtpreis")
        println("-------------------------------------------------------")
        println("$formattedDateTime")
        kunde.bezahlen(gesamtpreis)
        warenKorb.clear()

    }

    fun hauptMenue(Warenhaus: String) {
        val kunde = Kunde("")
        println("""
        Was möchten sie tun:
        [1]     Guthaben abfragen
        [2]     Geld einzahlen(Guthaben)
        [3]     Bücher kaufen
        [4]     Elektroartikel kaufen
        [5]     Warenkorb
        [6]     Bewertung Sie Uns
        [7]     Wie möchten Sie zahlen  
        [8]     LogOut      
    """.trimIndent())

        var input: String = readln()

        when (input) {
            "1" -> {
                println("Ihr aktuelles Guthaben beträgt: ${kunde.guthaben}")
                hauptMenue(Warenhaus)
            }

            "2" -> {
                println("Welchen Betrag möchten Sie auf Ihr Einkaufskonto einzahlen: ")
                var einzahlung = readln().toDouble()
                kunde.guthaben = einzahlung + kunde.guthaben
                println("Ihr neues Guthaben beträgt: ${kunde.guthaben}€")
                hauptMenue(Warenhaus)
            }

            "3" -> {
                einkaufbuecher()
                hauptMenue(Warenhaus)
            }

            "4" -> {
                einkaufelectro()
                hauptMenue(Warenhaus)

            }

            "5" -> {
                println("In Ihrem Warenkorb befinden sich zur Zeit : $warenKorb")
                hauptMenue(Warenhaus)
            }

            "6" -> {
                bewertungAbgeben()
                hauptMenue(Warenhaus)
            }

            "7" -> {
                bezahlenAuswahl(Warenhaus)
                hauptMenue(Warenhaus)
            }

            "8" -> {
                println("Danke für Ihren Besuch, Sie sind erfolgreich abgemeldet ")
                loginMenu(Warenhaus)
            }

            else -> {
                println("Ungültige Eingabe")
                hauptMenue(Warenhaus)
            }
        }
    }

    fun loginMenu(Warenhaus: String) {
        println("""
        Herzlich Willkommen im Phantasie Store
        Was möchten sie tun?
        [0]     Registrieren
        [1]     Login
        [2]     Admin Login
    """.trimIndent())
        var input: String = readln()

        when (input) {

            "0" -> {
                println("Danke für Ihre Neuanmeldung ${neuregistrieren()}")
                hauptMenue(Warenhaus)
            }

            "1" -> {
                logIn()
                hauptMenue(Warenhaus)
            }

            "2" -> {
                adminlogin()
                adminMenue(Warenhaus)
            }
        }
    }

    fun adminMenue(Warenhaus: String) {
        println("""
        Was möchten sie tun?
        [0]     Bestand abfragen
        [1]     Bücher nachbestellen 
        [2]     Elektroartikel nachbestellen
        [3]     Logout
    """.trimIndent())
        var input: String = readln()

        when (input) {

            "0" -> {
                bestandsabfrage()
                adminMenue(Warenhaus)
            }

            "1" -> {
                automBestellenbuecher(2, 5)
                adminMenue(Warenhaus)
            }

            "2" -> {
                automBestellenelectro(2, 5)
                adminMenue(Warenhaus)
            }

            "3" -> {
                println("Danke für Ihren Besuch, Sie sind erfolgreich abgemeldet ")
                loginMenu(Warenhaus)
            }
        }
    }

    fun bezahlenAuswahl(Warenhaus: String) {
        println("""
        Wie möchten Sie zahlen
        [0]     Mit Einkaufsguthaben
        [1]     Paypal
        
    """.trimIndent())
        var input: String = readln()

        when (input) {

            "0" -> {
                bezahlen()
            }

            "1" -> {
                paypalBezahlen()
            }
        }
    }

    fun bewertungAbgeben() {
        println("Bitte geben Sie Ihre Bewertung ((1 für schlecht - 5 für gut) für unsere Service und gesamt Bild  ein")
        try {
            val bewertung = readln().toInt()//eingabe der Bewertung von 1 - 5
            println("Bitte teilen Sie uns optional Ihre Kritik mit")
            val kritik = readln()//eingabe der Kritik
            val neueBewertung = WarenhausBewertung(bewertung, kritik)
            bewertungen.add(neueBewertung)//wird der Liste hinzugefügt
            println("Vielen Dank für Ihre Bewertung")
        } catch (ex: Exception) {
            (bewertungAbgeben())
        }

    }

    fun durchschnittlicheBewertung(): Double {

        if (bewertungen.isEmpty()) {
            return 0.0
        }

        val summe = bewertungen.sumOf { it.bewertng }//Hier wird die Summe aller Bewertungen ausgerechnet
        return summe.toDouble() / bewertungen.size.toDouble()//hier dann durch die Anzahl der Beweretungen geteilt
        val durchnittlicheBewertung = durchschnittlicheBewertung()
        println("Wir wurden im Durchschnitt wie folgt bewertet $durchnittlicheBewertung")
    }

    fun bestandsabfrage() {
        println("Bestände:")
        println("Bücher:")
        for (buch in buecher) {
            println("${buch.artikelName}: ${buch.bestand}")
        }
        println("Bestände:")
        println("Elektroartikel:")
        for (artikel in elektro) {
            println("${artikel.artikelName}: ${artikel.bestand}")
        }
    }

    fun automBestellenbuecher(minBestand: Int, nachbestellterBestand: Int) {
        val artikelZumNachbestellen = buecher.filter { it.bestand <= minBestand }//durchsucht Bücher, löst Bestellung aus
        for (artikel in artikelZumNachbestellen) {
            artikel.bestand += nachbestellterBestand//fügt jedem Artikel den Bestellten hinzu
            println("$artikel wurde nachbestellt ")
        }
    }

    fun automBestellenelectro(minBestand: Int, nachbestellterBestand: Int) {
        val artikelZumNachbestellen = elektro.filter { it.bestand <= minBestand }
        for (artikel in artikelZumNachbestellen) {
            artikel.bestand += nachbestellterBestand
            println("$artikel wurde nachbestellt ")
        }
    }

}











