package it.pusi77.bot;

/**
 * Contains default replies written in italian.
 */
public class DefaultReplies {

    /**
     * Welcome reply, sent after /start.
     */
    public static final String welcome = "Ben arrivato su MeteoPaviaBot! Questo bot è pensato per uso esclusivo del " +
                                        "suo creatore, non è adatto a essere usato da più utenti, quindi potrebbero " +
                                        "verificarsi problemi di vario tipo. Detto questo usalo pure, sono un messaggio"
                                        + " di benvenuto, non uno sbirro (semicit.).";

    /**
     * Help reply, sent after /help.
     */
    public static final String help = "Per avere le previsioni di uno dei prossimi 4 giorni " +
                                "(oggi compreso) ti basta scrivermi la data in formato " +
                                "AAAA-MM-GG. O più semplicemente puoi usare la tastiera "+
                                "virtuale.";

    /**
     * Reply sent if message is not recognized.
     */
    public static final String unrecognized = "Scusa, non ho capito.";
}
