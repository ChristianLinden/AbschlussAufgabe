**Readme - Warenhaus-Code**

Der vorliegende Code stellt eine Implementierung eines Warenhauses dar.   
Das Warenhaus verfügt über eine Auswahl an Büchern und Elektroartikeln, die von Kunden gekauft werden können. 
Kunden können sich registrieren, einloggen, Artikel kaufen, Bewertungen abgeben und ihren Warenkorb verwalten. 
Es gibt auch eine Administratorfunktion zum Verwalten des Bestands und zum Nachbestellen von Artikeln.

Funktionen

-***logIn()***: Diese Funktion ermöglicht es einem Kunden, sich einzuloggen. Der Benutzer wird nach einem Benutzernamen und einer PIN gefragt und überprüft, ob die Eingaben mit den gespeicherten Kundendaten übereinstimmen.

-***neuregistrieren()***: Diese Funktion ermöglicht es einem neuen Kunden, sich im Warenhaus zu registrieren. Der Benutzer wird nach einem Namen und einer PIN gefragt, und die eingegebenen Daten werden zur Kundenliste hinzugefügt.

-***adminlogin()***: Diese Funktion ermöglicht es dem Administrator, sich einzuloggen. Der Benutzer wird nach einem Benutzernamen und einer PIN gefragt und überprüft, ob die Eingaben mit den gespeicherten Administrator-Daten übereinstimmen.

-***einkaufbuecher()***: Diese Funktion ermöglicht es einem Kunden, Bücher zu kaufen. Es werden alle verfügbaren Bücher aufgelistet, und der Benutzer kann den gewünschten Artikel auswählen und zum Warenkorb hinzufügen.

-***einkaufelectro()***: Diese Funktion ermöglicht es einem Kunden, Elektroartikel zu kaufen. Es werden alle verfügbaren Elektroartikel aufgelistet, und der Benutzer kann den gewünschten Artikel auswählen und zum Warenkorb hinzufügen.

-***bezahlen()***: Diese Funktion ermöglicht es einem Kunden, den Warenkorb zu bezahlen. Der Gesamtpreis aller Artikel im Warenkorb wird berechnet, und je nach Gesamtpreis wird eine entsprechende Prämie angezeigt. Der Kunde kann entweder mit seinem Guthaben bezahlen oder die Zahlung über PayPal abwickeln.

-***paypalBezahlen()***: Diese Funktion ermöglicht es einem Kunden, den Warenkorb über PayPal zu bezahlen. Der Gesamtpreis aller Artikel im Warenkorb wird berechnet, und je nach Gesamtpreis wird eine entsprechende Prämie angezeigt.

-***hauptMenue(Warenhaus: String)***: Diese Funktion stellt das Hauptmenü für Kunden dar. Es werden verschiedene Optionen angezeigt, darunter das Abfragen des Guthabens, das Einzahlen von Geld, das Kaufen von Büchern oder Elektroartikeln, das Anzeigen des Warenkorbs, das Abgeben von Bewertungen und die Auswahl der Zahlungsmethode. Je nach Auswahl des Benutzers werden die entsprechenden Funktionen aufgerufen.

-***loginMenu(Warenhaus: String)***: Diese Funktion stellt das Anmelde- und Registrierungsmenü dar. Kunden können entweder einen neuen Account registrieren oder sich mit ihren vorhandenen Anmeldedaten einloggen.

-***adminMenue(Warenhaus: String)***: Diese Funktion stellt das Menü für den Administrator dar. Der Administrator kann den Best.


