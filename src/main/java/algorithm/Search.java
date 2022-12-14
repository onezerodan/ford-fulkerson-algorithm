package algorithm;

import model.Graph;

import java.util.*;

public class Search {

    // key = y vertex, value = x vertex
    private static HashMap<Integer, Integer> matchedEdges = new HashMap<>();

    public static HashMap<Integer, Integer> maxMatching(Graph graph) {

        for (int xVertex = 1; xVertex <= graph.getXVerticesAmount(); xVertex++) {

            HashMap<Integer, Boolean> visitedY = new HashMap<>();

            if (graph.findByXVertex(xVertex).getYVertex() != -1 ) {
                int previousMatchedEdgesSize = matchedEdges.size();
                dfs(graph, xVertex, visitedY);

                // If цепь не является увеличивающей
                if (previousMatchedEdgesSize == matchedEdges.size()) {
                    int finalXVertex = xVertex;
                    return new HashMap<Integer, Integer>() {{
                        put(-1, finalXVertex);

                    }};
                }
            }

            // If vertex is not connected with any other
            else {
                int finalXVertex = xVertex;
                return new HashMap<Integer, Integer>() {{
                    put(-1, finalXVertex);

                }};
            }
        }
        System.out.println(sortMapByValues(matchedEdges));

        return sortMapByValues(matchedEdges);
    }

    public static boolean dfs(Graph graph, int xVertex, HashMap<Integer, Boolean> visitedY) {
        for (int yVertex = 1; yVertex <= graph.getYVerticesAmount(); yVertex++) {
            if (graph.connected(xVertex, yVertex) && !visitedY.containsKey(yVertex) ) {

                // Mark y vertex as visited
                visitedY.put(yVertex, true);

                // If yVertex is not assigned to an xVertex
                // OR previously assigned xVertex (for yVertex) has an alternate yVertex available.
                // Since yVertex is marked as visited, xVertex in the following
                // recursive call will not get yVertex again
                if (!matchedEdges.containsKey(yVertex) || dfs(graph, matchedEdges.get(yVertex), visitedY)) {
                    matchedEdges.put(yVertex, xVertex);
                    System.out.println("X: " + xVertex + " Y: " + yVertex);
                    return true;
                }
            }
        }
        return false;
    }

    private static HashMap<Integer, Integer> sortMapByValues(HashMap<Integer, Integer> map) {
        HashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
        return sortedMap;
    }

}
