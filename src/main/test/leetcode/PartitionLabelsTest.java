package leetcode;

import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PartitionLabelsTest {
    private final PartitionLabels partitionLabels = new PartitionLabels();

    @Test
    public void sampleInput1() {
        List<Integer> labels = partitionLabels.partitionLabels("ababcbacadefegdehijhklij");
        assertArrayEquals(new int[]{9,7,8}, labels.stream().mapToInt(x -> x).toArray());
    }

    @Test
    public void sampleInput2() {
        List<Integer> labels = partitionLabels.partitionLabels("eccbbbbdec");
        assertArrayEquals(new int[]{10}, labels.stream().mapToInt(x -> x).toArray());
    }

    @Test
    public void sampleInput3() {
        List<Integer> labels = partitionLabels.partitionLabels("caedbdedda");
        assertArrayEquals(new int[]{1, 9}, labels.stream().mapToInt(x -> x).toArray());
    }
}
