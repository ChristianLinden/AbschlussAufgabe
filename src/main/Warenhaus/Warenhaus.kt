import java.util.Comparator

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
    var warenKorb: MutableList<String> = mutableListOf()
    fun logIn() {
        println("Dieser Shop ist erst ab dem 12 Lebenjahr zugänglich. Bitte gib dein Alter ein: ")
        var alter = readln().toInt()
        if (alter < 12)
            println("Willkommen im Shop ❤️")
        else
            (alter > 12)
            println("Du bist leider noch zu jung für unsere Angebote. 🐨")
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
        var userName: String
        var pin: String
        println("Bitte geben Sie Ihren gewünschten Namen ein:")
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
        println("Vielen Dank, wir haben den Artikel $bestellung ihren Warenkorb zugefügt.")
        warenKorb.add(bestellung)
        println(" Derzeit befinden sich folgende Artikel in ihrem Warenkorb $warenKorb")


    }
}