import algorithm.Search;
import model.Edge;
import model.Graph;
import service.IOService;

import java.util.HashMap;

public class Program {

    public static void main(String[] args) {
        Graph graph = null;
        try {
            graph = IOService.readGraph("in.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert graph != null;
        HashMap<Integer, Integer> result = Search.maxMatching(graph);
        IOService.writeAnswer(result);
    }
}
