package leetcode;

import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TopDeviceLocationsTest {
    private final TopDeviceLocations topDeviceLocations = new TopDeviceLocations();
    private final List<String> devices = List.of(
            "Madrid-Kart-01",
            "Milan-Kart-01",
            "Milan-Kart-2",
            "Milan-Kart-3",
            "London-Kart-1",
            "London-Kart-2",
            "Milan-Sorter-01",
            "Denver-Arm-1"
    );

    @Test
    public void sampleInput1() {
        String[] topLocations = topDeviceLocations.getNumberDevices(devices, "Kart", 2)
                .toArray(new String[0]);

        assertArrayEquals(new String[]{"Milan", "London"}, topLocations);
    }
}
