import java.util.Comparator
import kotlin.concurrent.thread

open class Warenhaus() {
    var buecher: MutableList<Buch> = mutableListOf(
            Krimi("Der letzte Schrei", 12.99, true),
            Krimi("Und er schrie immer noch", 15.99, true),
            Krimi("Das mordende Schaf", 9.99, true),
            Krimi("Der letzte Überlebende", 29.99, false),
            Roman("Der Herr der sieben Meere", 29.99, false),
            Roman("Der Kuchen Streik", 19.99, false),
            Roman("Käptain Langohr", 6.99, true),
            Roman("Es war einmal", 9.99, true))
    var elektro: MutableList<Elektroartikel> = mutableListOf(
            Fernseher("Telefunken", 599.00, false),
            Fernseher("Grundig", 999.00, true),
            Fernseher("Grundig", 599.00, true),
            Fernseher("Samsung", 1199.00, true),
            Lautsprecher("Telefunken", 299.00, 250, true),
            Lautsprecher("Bosse", 1599.00, 800, true),
            Lautsprecher("Amazon Alexa", 39.99, 25, false),
            Lautsprecher("Jambra", 59.99, 55, true))
    var kundenListe: MutableMap<String, String> = mutableMapOf(
            "Test" to "4711"
    )
    var aadminListe: MutableMap<String, String> = mutableMapOf(
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
        println("Dieser Shop ist erst ab dem 12 Lebenjahr zugänglich. Bitte gib dein Alter ein: ")
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
            println("Dieser Name exestiert berreits, bitte wählen sie einen anderen")
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

        loggedIn = adminname in aadminListe && pin == aadminListe[adminname]!!
        if (loggedIn)
            println("Willkommen, $adminname")
        else
            println("Login fehlgeschlagen.")

    }

    fun einkaufbuecher() {
        println("Wir haben folgende Bücher im Angebot : $buecher ")
        println("Bitte geben sie ihren Artikel ein:")
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
        println("Wir haben folgende Electroartikel im Angebot : $elektro ")
        println("Bitte geben sie ihren Artikel ein:")
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
        println("------------------------------------------------")
        println(prämientext)
        val kunde = Kunde("Max Mustermann", 2500.0)
        println("------------------------------------------------")
        println("Gesamtpreis:                        $gesamtpreis")
        println("------------------------------------------------")
        kunde.bezahlen(gesamtpreis)


    }

    fun hauptMenue(Warenhaus: String) {
        val kunde = Kunde("", 0.00)
        println("""
        Was möchten sie tun?
        [0]     Registrieren
        [0.1]   Login
        [1]     Guthaben abfragen
        [2]     Geld einzahlen(Guthaben)
        [3]     Bücher kaufen
        [4]     Elektroartikel kaufen
        [4.1]   Einkaufswagen einsehen
        [5]     Bezahlen
        [6]     Admin Login
    """.trimIndent())

        var input: String = readln()

        when (input) {
            "0" -> {
                println("Bitte Registrieren sie sich ${neuregistrieren()}")
                hauptMenue(Warenhaus)
            }

            "0.1" -> {
                println("Bitte melden sie sich an: ${logIn()} ")
                hauptMenue(Warenhaus)
            }

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
                println("Viel Spass bei ihrem Einkauf: ${einkaufbuecher()}")
                hauptMenue(Warenhaus)
            }

            "4" -> {
                println("Viel Spass bei ihrem Einkauf: ${einkaufelectro()}")
                hauptMenue(Warenhaus)

            }

            "4.1" -> {
                println("In Ihrem Warenkorb befinden sich zur Zeit : $warenKorb")
                hauptMenue(Warenhaus)
            }

            "5" -> {
                println("Vielen Dank für Ihren einkauf ${bezahlen()}")
                hauptMenue(Warenhaus)
            }

            "6" -> {
                println("Danke für Ihren Besuch : ${hauptMenue(Warenhaus)}")
            }

            "7" -> {
                println("Admin Login ${adminlogin()}")
                hauptMenue(Warenhaus)
            }

            else -> {
                println("Ungültige Eingabe")
                hauptMenue(Warenhaus)
            }
        }
    }
}

