package blind75.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// https://leetcode.com/problems/course-schedule/
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();

        for (int course = 0; course < numCourses; course++) {
            inDegree.put(course, 0);
            adjacencyList.put(course, new HashSet<>());
        }

        for (int[] prereq : prerequisites) {
            int orderLater = prereq[0];
            int orderFirst = prereq[1];
            inDegree.put(orderLater, inDegree.get(orderLater) + 1);
            adjacencyList.get(orderFirst).add(orderLater);
        }

        Queue<Integer> courses = new LinkedList<>();

        for (Integer course : inDegree.keySet()) {
            if (inDegree.get(course) == 0)
                courses.offer(course);
        }

        List<Integer> listOfCoursesSorted = new ArrayList<>();

        while (!courses.isEmpty()) {
            Integer course = courses.poll();
            listOfCoursesSorted.add(course);

            for (Integer child : adjacencyList.get(course)) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0)
                    courses.offer(child);
            }
        }

        return listOfCoursesSorted.size() == numCourses;
    }
}
