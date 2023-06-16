fun main () {
    val warenhaus = Warenhaus()
    println("Dieser Shop ist erst ab dem 12 Lebenjahr zugänglich. Bitte gib dein Alter ein: ")
    var alter = readln().toInt()
    if (alter > 12 )
        println("Willkommen im Shop ❤️")
    else
    println("Du bist leider noch zu jung für unsere Angebote. 🐨")
}