open class Warenhaus()  {

    var buecher: MutableList<Buch> = mutableListOf()
    var elektro: MutableList<Elektroartikel> = mutableListOf()
    var kundenListe: MutableMap<String, String> = mutableMapOf(
        "Test" to "4711")
    var aadminListe: MutableMap<String,String> = mutableMapOf(
        "Test001" to "4715")
    var warenKorb : MutableList<String> = mutableListOf()
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
    fun adminlogin (){
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
    }
