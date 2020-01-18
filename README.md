# MeteoPaviaBot
Un metodo comodo per consultare le previsioni dei prossimi 4 giorni tramite Telegram.
## Premesse
Questo bot è pensato principalmente per il mio uso personale, di conseguenza non è adatto a essere usato da più utenti. Ciò è dovuto al fatto che non utilizza database e non salva dati, il problema principale è dato dall'uso contemporaneo che causa difetti nelle risposte. Sono a conoscenza della causa del problema, probabilmente nel futuro lo risolverò.
Il bot utilizza le API private di MeteoAM, quindi non sono certo di poter rendere pubblico l'url da cui il programma scarica i dati.
## Utilizzo
Per poter avviare il bot è sufficiente inserire l'url della API (non sarà difficile ottenerlo tramite l'app ufficiale) e un token ottenuto da BotFather nelle variabili contenute nella classe ChangeMeValues. Inoltre è necessario cambiare il nome del bot nella classe Bot.

Sono necessarie le seguenti librerie esterne:
* com.google.code.gson:gson:2.8.6
* org.telegram:telegrambots:4.5
# Licenza
Vedi il file LICENSE.
