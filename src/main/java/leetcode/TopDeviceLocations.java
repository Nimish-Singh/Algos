package leetcode;

import java.util.*;

/*
We have a list of strings that represent a list of robotics workcells in our warehouses identified by the id format: location-deviceType-id
Example: Madrid-Kart-02

Write a function that returns the top locations, sorted by the amount of devices of a give type, limited by a value called "maxLimit".
List<String> getNumberDevices(List<String> devices, String deviceType, int maxLimit)

EXAMPLE:
Given the list of IDs:
Madrid-Kart-01, Milan-Kart-01, Milan-Kart-2, Milan-Kart-3, London-Kart-1, London-Kart-2, Milan-Sorter-01, Denver-Arm-1

Result of getNumberDevices for "Kart" with max limit 2:
(0) Milan
(1) London
 */

public class TopDeviceLocations {

    public List<String> getNumberDevices(List<String> devices, String deviceType, int maxLimit) {
        // deviceType -> location, count
        Map<String, Map<String, Integer>> deviceTypeMap = new HashMap<>();
        for (String device : devices) {
            String[] parsedInput = device.split("-");

            String currentDeviceType = parsedInput[1];
            String location = parsedInput[0];
            if (!deviceTypeMap.containsKey(currentDeviceType)) {
                deviceTypeMap.put(parsedInput[1], new HashMap<>());
            }
            Map<String, Integer> locationCount = deviceTypeMap.get(currentDeviceType);
            locationCount.put(location, locationCount.getOrDefault(location, 0) + 1);
        }

        Map<String, Integer> locationCountMap = deviceTypeMap.getOrDefault(deviceType, new HashMap<>());

        PriorityQueue<String> maxHeap = new PriorityQueue<>((a, b) ->
                        locationCountMap.get(b) - locationCountMap.get(a) == 0 ?
                        a.compareTo(b) :
                        locationCountMap.get(b) - locationCountMap.get(a));

        maxHeap.addAll(locationCountMap.keySet());

        List<String> answer = new ArrayList<>();

        for (int index = 1; index <= maxLimit && !maxHeap.isEmpty(); index++) {
            answer.add(maxHeap.poll());
        }

        return answer;
    }
}
