package com.leetcode.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseSchedule {

//    https://leetcode.com/problems/course-schedule/
//    Time Complexity: O(V + E) where:
//V is the number of courses (nodes),
//E is the number of dependencies (edges).
//We visit each course and its dependencies once.
//Space Complexity: O(V + E) due to the adjacency list storing the graph.
//The HashSet can hold up to O(V) elements at most
// (in the worst case, all courses might be in the stack at once).
// However, once a course is fully processed, we empty its list.

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build the adjacency list to represent the course prerequisites graph
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            adjList.get(prereq[1]).add(prereq[0]);
        }

        // HashSet to track nodes in the current DFS recursion stack (used for cycle detection)
        Set<Integer> visiting = new HashSet<>();

        // Perform DFS for each course
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, adjList, visiting)) {
                return false; // Cycle detected, not possible to finish all courses
            }
        }
        return true; // No cycle detected, possible to finish all courses
    }

    private boolean dfs(int course, List<List<Integer>> adjList, Set<Integer> visiting) {
        // If the course is already in the current recursion stack, a cycle is detected
        if (visiting.contains(course)) {
            return false; // Cycle detected
        }

        // If the course has no prerequisites, it is safe to mark it as processed (empty list case)
        if (adjList.get(course).isEmpty()) {
            return true;
        }

        // Mark the course as being visited (part of the current recursion stack)
        visiting.add(course);

        // Visit all its neighbors (next courses)
        for (int neighbor : adjList.get(course)) {
            if (!dfs(neighbor, adjList, visiting)) {
                return false; // Cycle detected in one of the neighbors
            }
        }

        // After visiting all neighbors, mark the course as fully visited by clearing its adjacency list
        adjList.get(course).clear();

        // Remove the course from the current recursion stack
        visiting.remove(course);

        return true;
    }

//    private List<List<Integer>> preMap = new ArrayList<>();
//    Set<Integer> visiting = new HashSet<>();
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        for(int i = 0; i < numCourses; i++){
//            preMap.add(new ArrayList<>());
//        }
//        for(int[] preReq : prerequisites){
//            preMap.get(preReq[1]).add(preReq[0]);
//        }
//
//        for(int i = 0; i < numCourses; i++){
//            if(!dfs(i)) return false;
//        }
//        return true;
//    }
//
//    private boolean dfs(int course){
//        if(visiting.contains(course)) return false;
//        if(preMap.get(course).isEmpty()) return true;
//        visiting.add(course);
//        for(int neighbor : preMap.get(course)){
//            if(!dfs(neighbor)) return false;
//        }
//        preMap.get(course).clear();
//        visiting.remove(course);
//        return true;
//    }
}


