package Util;

import java.util.Locale;

public class StringFunctions {

    /**
     * Converts an enum's toString to a nice string
     * @param string
     * @return
     */
    public static String enumString(String string) {
        String[] words = string.split("_");
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < words.length; i++) {
            if(i > 0) {
                builder.append(" ");
            }
            builder.append(words[i].charAt(0)).append(words[i].toLowerCase(Locale.ROOT).substring(1));
        }
        return builder.toString();
    }

}
