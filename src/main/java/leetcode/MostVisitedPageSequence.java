package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a log of website requests where each log entry logs a request for one page, as in:

    [TIME] [CUSTOMER ID] [PAGE VISITED]

log.txt
10:10:01 1001 A
10:10:02 1001 B
10:10:03 1001 C
10:10:04 1002 E
10:10:05 1001 D
10:10:06 1001 E
10:10:07 1002 B
10:10:08 1002 C
10:10:09 1002 D
10:10:10 1002 A

3 pages long.


Find the top 3-page sequence visited.
For example, if we have two customers and we log Customer1001 visiting pages A > B > C > D > E;
and we log Customer1002 visiting pages E > B > C > D > A, then the top 3-page sequence is B > C > D.
*/

public class MostVisitedPageSequence {
    public String findMaxSequence(List<String> pages) {
        // iterating over input, and inserting a page visit by customer into map.
        Map<String, List<String>> customerPageSeqMap = new HashMap<>();
        for (String page : pages) {
            String[] parsedInput = page.split(" ");

            String customerId = parsedInput[1];
            String pageId = parsedInput[2];

            if (!customerPageSeqMap.containsKey(customerId)) {
                customerPageSeqMap.put(customerId, new ArrayList<>());
            }

            customerPageSeqMap.get(customerId).add(pageId);
        }

        // iterating over page visit list, to record a 3 page sequence
        Map<String, Integer> pageSeqCount = new HashMap<>();
        for (List<String> pageSeq : customerPageSeqMap.values()) {
            for (int index = 0; index < pageSeq.size() - 2; index++) {
                String pageSequence = pageSeq.get(index) + pageSeq.get(index + 1) + pageSeq.get(index + 2);
                pageSeqCount.put(pageSequence, pageSeqCount.getOrDefault(pageSequence, 0) + 1);
            }
        }

        int max = 0;
        String mostFrequentSeq = "";

        for (Map.Entry<String, Integer> entry : pageSeqCount.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                mostFrequentSeq = entry.getKey();
            }
        }

        return mostFrequentSeq;
    }
}
