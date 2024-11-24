package leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/reorder-data-in-log-files/description/
public class ReorderLogs {
    public String[] reorderLogFiles(String[] logs) {
        List<String> alphaLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();

        for (String log : logs) {
            if (isDigitLog(log)) {
                digitLogs.add(log);
                continue;
            }

            alphaLogs.add(log);
        }

        alphaLogs.sort((a, b) -> a.substring(a.indexOf(' ') + 1).compareTo(b.substring(b.indexOf(' ') + 1)) == 0 ? a.split(" ")[0].compareTo(b.split(" ")[0]) : a.split(" ")[1].compareTo(b.split(" ")[1]));

        String[] answer = new String[logs.length];

        int index = 0;
        while(index < alphaLogs.size()) {
            answer[index] = alphaLogs.get(index);
            index++;
        }

        index = 0;
        while(index < digitLogs.size()) {
            answer[index + alphaLogs.size()] = digitLogs.get(index);
            index++;
        }

        return answer;
    }

    private boolean isDigitLog(String log) {
        String logContent = log.substring(log.indexOf(' ') + 1);
        for (int i = 0; i < logContent.length(); i++)
                if (Character.isLetter(logContent.charAt(i)))
                        return false;
        return true;
    }
}
