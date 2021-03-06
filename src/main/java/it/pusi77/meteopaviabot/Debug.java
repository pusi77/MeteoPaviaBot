package it.pusi77.meteopaviabot;

/**
 * Contains methods useful for debugging.
 */
public class Debug {

    /**
     * Boolean value controlling all the debug methods.
     */
    public static boolean debug = false;

    /**
     * Like println with "[DEBUG]" prefix;
     * @param string string to be printed
     */
    public static void dPrintln(String string){
        if (debug) {
            System.out.println("[DEBUG] " + string);
        }
    }
}
