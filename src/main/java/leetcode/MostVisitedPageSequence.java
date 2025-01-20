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
        Map<String, List<String>> customerPageSeqMap = parseAndGetPageSequenceByCustomer(pages);

        // iterating over page visit list, to record a 3 page sequence
        Map<String, Integer> pageSeqCount = getPageSequenceCount(customerPageSeqMap);

        return getMaxFrequencySequence(pageSeqCount);
    }

    private Map<String, List<String>> parseAndGetPageSequenceByCustomer(List<String> pages) {
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
        return customerPageSeqMap;
    }

    private Map<String, Integer> getPageSequenceCount(Map<String, List<String>> customerPageSeqMap) {
        Map<String, Integer> pageSeqCount = new HashMap<>();
        for (List<String> pageSeq : customerPageSeqMap.values()) {
            for (int index = 0; index < pageSeq.size() - 2; index++) {
                String pageSequence = pageSeq.get(index) + pageSeq.get(index + 1) + pageSeq.get(index + 2);
                pageSeqCount.put(pageSequence, pageSeqCount.getOrDefault(pageSequence, 0) + 1);
            }
        }
        return pageSeqCount;
    }

    private String getMaxFrequencySequence(Map<String, Integer> pageSeqCount) {
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

    public String findMaxSequenceOptimised(List<String> pages) {
        Map<String, String> customerPageSeqMap = new HashMap<>();
        Map<String, Integer> pageSeqCount = new HashMap<>();
        int max = 0;
        String answer = "";

        for (String page : pages) {
            String[] parsedInput = page.split(" ");

            String customerId = parsedInput[1];
            String pageId = parsedInput[2];

            String seq = customerPageSeqMap.get(customerId);

            if (seq == null || seq.length() < 2) {
                customerPageSeqMap.put(customerId, customerPageSeqMap.getOrDefault(customerId, "") + pageId);
                continue;
            }

            String newKey;
            if (seq.length() == 2) {
                newKey = seq + pageId;
            } else {
                newKey = seq.substring(1) + pageId;
            }

            customerPageSeqMap.put(customerId, newKey);
            pageSeqCount.put(newKey, pageSeqCount.getOrDefault(newKey, 0) + 1);
            if (pageSeqCount.get(newKey) > max) {
                max = pageSeqCount.get(newKey);
                answer = newKey;
            }
        }

        return answer;
    }
}
