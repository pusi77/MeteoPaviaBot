# MeteoPaviaBot
Un comodo metodo per consultare le previsioni dei prossimi 4 giorni tramite Telegram.
## Premesse
Questo bot è pensato principalmente per il mio uso personale, di conseguenza non è adatto a essere usato da più utenti. Ciò è dovuto al fatto che non utilizza database e non salva dati, il problema principale è dato dall'uso contemporaneo che causa difetti nelle risposte. Sono a conoscenza della causa del problema, probabilmente nel futuro lo risolverò.
Il bot utilizza le API private di MeteoAM, quindi non sono certo di poter rendere pubblico l'url da cui il programma scarica i dati.
## Utilizzo
Per poter avviare il bot è necessario reperire l'url delle API di MeteoAM (non sarà difficile ottenerlo tramite l'app ufficiale) e il token da BotFather. A questo punto bisogna avviare il programma da linea di comando inserendo il token e l'url come parametri, in questo ordine.


Esempio: java -jar MeteoPaviaBot.jar TOKEN123456789 http://somesite.something/data.json



# ToDo
- [ ] Aggiungere eccezioni in caso di Token o Url errati
- [ ] Aggiungere emoticons alle risposte
- [ ] Risolvere il problema dell'utilizzo contemporaneo da più utenti (selectedDay in MessageReplier)
# Licenza
Vedi il file LICENSE.
