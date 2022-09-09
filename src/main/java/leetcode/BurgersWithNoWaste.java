package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/number-of-burgers-with-no-waste-of-ingredients/
public class BurgersWithNoWaste {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        /* After solving equations (for 0 waste)
        4Jumbo + 2Small = tomatoSlices
        Jumbo + Small = cheeseSlices
        we get the relation Jumbo = (tomatoSlices - 2cheeseSlices) / 2
        Small = (cheeseSlices - Jumbo)
         */

        int decidingEquation = tomatoSlices - 2 * cheeseSlices;
        if (decidingEquation < 0 || decidingEquation % 2 != 0) {
            return Collections.emptyList();
        }

        int jumboBurgers = decidingEquation / 2;
        int smallBurgers = cheeseSlices - jumboBurgers;

        if (smallBurgers < 0) {
            return Collections.emptyList();
        }

        List<Integer> burgers = new ArrayList<>();
        burgers.add(jumboBurgers);
        burgers.add(smallBurgers);
        return burgers;
    }
}
