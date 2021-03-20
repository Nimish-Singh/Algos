package permutations;

import java.util.ArrayList;
import java.util.List;

// Given a string, find all of its permutations preserving the character sequence but changing case
public class StringPermutationsByChangingCase {
    public List<String> compute(String str) {
        List<String> permutations = new ArrayList<>();
        if (str == null)
            return permutations;

        permutations.add(str);

        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {

                int permSize = permutations.size();
                for (int index = 0; index < permSize; index++) {
                    char[] permChars = permutations.get(index).toCharArray();
                    if (Character.isUpperCase(permChars[i]))
                        permChars[i] = Character.toLowerCase(permChars[i]);
                    else
                        permChars[i] = Character.toUpperCase(permChars[i]);

                    permutations.add(String.valueOf(permChars));
                }
            }
        }
        return permutations;
    }
}
