import kotlin.contracts.contract
import kotlin.math.exp

fun main() {
    val warenhaus = Warenhaus()
    val durchschnittlicheBewertung = warenhaus.durchschnittlicheBewertung()
    warenhaus.durchschnittlicheBewertung()
    println("So wurden wir bisher im Durchschnitt bewertet $durchschnittlicheBewertung ")
    println("Bitte geben Sie uns doch auch eine Bewertung , sobald Sie eingeloggt b.z.w angemeldet sind")
    warenhaus.loginMenu(Warenhaus = "")
}