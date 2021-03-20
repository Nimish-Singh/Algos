package permutations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ValidParenthesisCombos {
    public List<String> generate (int numberOfParenthesis) {
        List<String> combos = new ArrayList<>();
        Queue<ParanthesisCombo> queue = new LinkedList<>();
        queue.add(new ParanthesisCombo("", 0, 0));

        while (!queue.isEmpty()) {
            ParanthesisCombo combo = queue.poll();
            if (combo.openParenthesisCount == numberOfParenthesis && combo.closedParanthesisCount == numberOfParenthesis)
                combos.add(combo.combo);
            else {
                if (combo.openParenthesisCount < numberOfParenthesis)
                    queue.add(new ParanthesisCombo(combo.combo + "(", combo.openParenthesisCount + 1, combo.closedParanthesisCount));

                if (combo.openParenthesisCount > combo.closedParanthesisCount)
                    queue.add(new ParanthesisCombo(combo.combo + ")", combo.openParenthesisCount, combo.closedParanthesisCount + 1));
            }
        }
        return combos;
    }
}

class ParanthesisCombo {
    String combo;
    int openParenthesisCount, closedParanthesisCount;

    ParanthesisCombo(String combo, int openParenthesisCount, int closedParanthesisCount) {
        this.combo = combo;
        this.openParenthesisCount = openParenthesisCount;
        this.closedParanthesisCount = closedParanthesisCount;
    }
}
