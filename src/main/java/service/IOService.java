package service;

import model.Edge;
import model.Graph;

import java.io.*;
import java.util.*;

public class IOService {

    // returns Edmonds matrix of graph
    public static Graph readGraph(String filePath) throws FileNotFoundException {

        Graph result = new Graph();
        File file = new File(filePath);
        Scanner input = new Scanner(file);
        String[] firstLine = input.nextLine().split(" ");

        int k = Integer.parseInt(firstLine[0]);
        int l = Integer.parseInt(firstLine[1]);
        result.setXVerticesAmount(k);
        result.setYVerticesAmount(l);
        int xVertex = 1;



        while (input.hasNextLine()) {
            String nextLine = input.nextLine();

            Scanner line = new Scanner(nextLine);
            while (line.hasNextInt()) {
                int yVertex = line.nextInt();
                if (yVertex != 0) {
                    result.addEdge(new Edge(xVertex, yVertex));
                }

            }
            if (nextLine.equals("0")) {
                result.addEdge(new Edge(xVertex, -1));
            }
            xVertex++;
        }
        return result;
    }

    public static void writeAnswer(HashMap<Integer, Integer> matchedEdges) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("out.txt"))) {


            if (matchedEdges.get(-1) != null) {
                writer.write("N");
                writer.append("\n").append(String.valueOf(matchedEdges.get(-1)));
                return;
            }
            writer.append("Y").append("\n");



            for (Map.Entry<Integer, Integer> entry : matchedEdges.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();

                writer.append(String.valueOf(key)).append(" ");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

