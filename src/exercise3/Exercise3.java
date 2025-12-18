package exercise3;

import java.text.Normalizer;
import java.util.Arrays;

/*
    O usuário digita um texto e o corretor corrige o “m” quando aparecer alguma palavra errada. O programa deve retornar ao usuário o texto corrigido. Por exemplo:
    Entrada: O homem está alimentando as ponbas
    Saída: O homem está alimentando as pombas
 */

public class Exercise3 {
    private static String correctText(String text) {
        String[] textLetters = text.split("");
        String[] consonantsBeforeM = {"p", "b"};
        String vowels[] = {"a", "e", "i", "o", "u"};

        for (int i = 0; i < textLetters.length; i++) {
            if (Arrays.asList(consonantsBeforeM).contains(textLetters[i])) {
                int nextVowelIndex = 0;
                
            // Check if string in the next index is a vowel and next index is in array length.
            if (i + 1 < textLetters.length &&
                Arrays.asList(vowels).contains(Normalizer.normalize(textLetters[i + 1], Normalizer.Form.NFD))
            ) {
                nextVowelIndex = i + 1;
            // If not check if string in the next index plus one is a vowel and next index is in array length.
            } else if(
                i + 2 < textLetters.length &&
                Arrays.asList(vowels).contains(Normalizer.normalize(textLetters[i + 2], Normalizer.Form.NFD))
            ) {
                nextVowelIndex = i + 2;
            };

            if (nextVowelIndex + 1  < textLetters.length) {
                // Check if an string equals another
                if (textLetters[nextVowelIndex + 1].equals("n")) {
                    textLetters[nextVowelIndex + 1] = "m";
                };
            };
          };
        };

        // Join array of strings
        String fixedText = String.join("", textLetters);

        return fixedText;
    }
    public static void main() {
        String text = "O homem está alimentando as ponbas";
        String fixedText = correctText(text);

        System.out.println(fixedText);

        text = "As roupas estão em pronoção";
        fixedText = correctText(text);

        System.out.println(fixedText);
    }
}
