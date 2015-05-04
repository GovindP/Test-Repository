
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Dijkstras_Shortest_Path {

    private int distances[];
    private Set<Integer> settled;
    private Set<Integer> unsettled;
    private int number_of_nodes;
    private int adjacencyMatrix[][];

    public Dijkstras_Shortest_Path(int number_of_nodes) {
        this.number_of_nodes = number_of_nodes;
        distances = new int[number_of_nodes + 1];
        settled = new HashSet<Integer>();
        unsettled = new HashSet<Integer>();
        adjacencyMatrix = new int[number_of_nodes + 1][number_of_nodes + 1];
    }

    public void dijkstra_algorithm(int adjacency_matrix[][], int source) {
        int evaluationNode;
        for (int i = 1; i <= number_of_nodes; i++) {
            for (int j = 1; j <= number_of_nodes; j++) {
                adjacencyMatrix[i][j] = adjacency_matrix[i][j];
            }
        }

        for (int i = 1; i <= number_of_nodes; i++) {
            distances[i] = Integer.MAX_VALUE;
        }

        unsettled.add(source);
        distances[source] = 0;
        while (!unsettled.isEmpty()) {
            evaluationNode = getNodeWithMinimumDistanceFromUnsettled();
            unsettled.remove(evaluationNode);
            settled.add(evaluationNode);
            evaluateNeighbours(evaluationNode);
        }
    }

    private int getNodeWithMinimumDistanceFromUnsettled() {
        int min;
        int node = 0;

        Iterator<Integer> iterator = unsettled.iterator();
        node = iterator.next();
        min = distances[node];
        for (int i = 1; i <= distances.length; i++) {
            if (unsettled.contains(i)) {
                if (distances[i] <= min) {
                    min = distances[i];
                    node = i;
                }
            }
        }
        return node;
    }

    private void evaluateNeighbours(int evaluationNode) {
        int edgeDistance = -1;
        int newDistance = -1;

        for (int destinationNode = 1; destinationNode <= number_of_nodes; destinationNode++) {
            if (!settled.contains(destinationNode)) {
                if (adjacencyMatrix[evaluationNode][destinationNode] != Integer.MAX_VALUE) {
                    edgeDistance = adjacencyMatrix[evaluationNode][destinationNode];
                    newDistance = distances[evaluationNode] + edgeDistance;
                    if (newDistance < distances[destinationNode]) {
                        distances[destinationNode] = newDistance;
                    }
                    unsettled.add(destinationNode);
                }
            }
        }
    }

    public static void main(String... arg) {

        int number_of_vertices;
        int source = 0, destination = 0;
        Scanner scan = new Scanner(System.in);
        int[] stairs = new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        try {
            System.out.println("Enter the number of vertices");
            number_of_vertices = stairs.length;
            		//scan.nextInt();

            int[][] paths = new int[stairs.length + 1][stairs.length + 1];
            for (int i = 1; i <= stairs.length; i++) {
                int item = stairs[i - 1];
                for (int j = 1; j <= stairs.length; j++) {
                    if (i <= j && j < (i + item + 1)) {
                        paths[i][j] = 1;
                    } else {
                        paths[i][j] = Integer.MAX_VALUE;
                    }
                }

            }

            System.out.println("Enter the source ");
            source = 1;
            		//scan.nextInt();

            System.out.println("Enter the destination ");
            destination = stairs.length;
            		//scan.nextInt();

            Dijkstras_Shortest_Path dijkstrasAlgorithm = new Dijkstras_Shortest_Path(
                    number_of_vertices);
            dijkstrasAlgorithm.dijkstra_algorithm(paths, source);

            System.out.println("The Shorted Path from " + source + " to " + destination + " is: ");
            for (int i = 1; i <= dijkstrasAlgorithm.distances.length - 1; i++) {
                if (i == destination) {
                    if (dijkstrasAlgorithm.distances[i] != Integer.MAX_VALUE) {
                        System.out.println(source + " to " + i + " is " + dijkstrasAlgorithm.distances[i]);
                    } else {
                        System.out.println(-1);
                    }
                }
            }
        } catch (InputMismatchException inputMismatch) {
            System.out.println("Wrong Input Format");
        }
        scan.close();
    }
}
