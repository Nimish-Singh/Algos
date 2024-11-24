package leetcode;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ReorderLogsTest {
    private final ReorderLogs reorderLogs = new ReorderLogs();
    private String[] logs;

    @Test
    public void sampleInput1() {
        logs = new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};

        String[] reorderedLogs = reorderLogs.reorderLogFiles(logs);

        assertArrayEquals(new String[]{"let1 art can", "let3 art zero", "let2 own kit dig", "dig1 8 1 5 1", "dig2 3 6"}, reorderedLogs);
    }

    @Test
    public void sampleInput2() {
        logs = new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"};

        String[] reorderedLogs = reorderLogs.reorderLogFiles(logs);

        assertArrayEquals(new String[]{"g1 act car", "a8 act zoo", "ab1 off key dog", "a1 9 2 3 1", "zo4 4 7"}, reorderedLogs);
    }
}
