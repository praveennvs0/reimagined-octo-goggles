package newPackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class KnightsTour {

    public static void main(String args[]) {
        int n = 5;

        for (int l = 0; l < n; l++)
            for (int m = 0; m < n; m++) {
                Position startingPosition = new Position(l, m);
                KnightsTourHelper(startingPosition, n);

            }
    }

    private static void KnightsTourHelper(Position startingPosition, int n) {
        System.out.println(
                "Starting tour with the position : " + startingPosition.getX() + "," + startingPosition.getY());
        int[][] visited = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                visited[i][j] = 0;

        List<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
        boolean isFound = Knightstour(startingPosition, visited, solution, n);
        if (isFound) {
            printPositions(solution);
        } else {
            System.out.println("No solution starting with the position : " + startingPosition.getX() + ","
                    + startingPosition.getY());

        }
    }

    private static boolean Knightstour(Position currentPosition, int[][] visited, List<ArrayList<Integer>> solution,
            int n) {

        if (visited[currentPosition.getX()][currentPosition.getY()] == 0) {
            solution.add(currentPosition.returnList());
            visited[currentPosition.getX()][currentPosition.getY()] = 1;
        }
        
        if (allSquaresVisited(visited, n)) {
            System.out.println("SOLUTION FOUND");
            return true && solution.size() == n * n;
        }

        List<Position> reachablePositions = fetchPositionsReachableNotVisitedAlready(currentPosition, n, visited);
        //If no squares to go from here, it means choosing this square won't lead to solution. Hence, backtrack.
        if (reachablePositions.isEmpty()) {
            solution = removePositionFromSolution(solution, currentPosition);
            visited[currentPosition.getX()][currentPosition.getY()] = 0;
            return false;
        }
        for (int i = 0; i < reachablePositions.size(); i++) {
            if (Knightstour(reachablePositions.get(i), visited, solution, n)) {
                return true;
            }
            //Whatever adjacent square we chose did not lead us to the solution. hence, backtrack

            solution = removePositionFromSolution(solution, reachablePositions.get(i));
            visited[reachablePositions.get(i).getX()][reachablePositions.get(i).getY()] = 0;

        }

        return false;

    }

    private static List<ArrayList<Integer>> removePositionFromSolution(List<ArrayList<Integer>> solution,
            Position removePosition) {

        for (Iterator<ArrayList<Integer>> iter = solution.iterator(); iter.hasNext();) {
            ArrayList<Integer> innerList = iter.next();
            if (innerList.get(0) == removePosition.getX() && innerList.get(1) == removePosition.getY()) {
                iter.remove();
                break;
            }

        }
        return solution;
    }

    private static boolean allSquaresVisited(int[][] visited, int n) {

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (visited[i][j] == 0)
                    return false;
        return true;
    }

    private static void printPositions(List<ArrayList<Integer>> solution) {

        for (int i = 0; i < solution.size(); i++) {
            ArrayList<Integer> innerList = solution.get(i);
            System.out.print("(" + innerList.get(0) + "," + innerList.get(1) + ")");
            System.out.print("->");
        }
    }

    private static List<Position> fetchPositionsReachableNotVisitedAlready(Position p, int n, int[][] visited) {
        List<Position> positionsList = new ArrayList<Position>();

        int i = p.getX();
        int j = p.getY();
        Position p1 = new Position(i - 1, j + 2);
        Position p2 = new Position(i - 1, j - 2);
        Position p3 = new Position(i + 1, j - 2);
        Position p4 = new Position(i + 1, j + 2);
        Position p5 = new Position(i - 2, j + 1);
        Position p6 = new Position(i - 2, j - 1);
        Position p7 = new Position(i + 2, j + 1);
        Position p8 = new Position(i + 2, j - 1);

        positionsList.add(p1);
        positionsList.add(p2);
        positionsList.add(p3);
        positionsList.add(p4);
        positionsList.add(p5);
        positionsList.add(p6);
        positionsList.add(p7);
        positionsList.add(p8);

        List<Position> filterPositions = positionsList.stream()
                .filter(pos -> pos.getX() >= 0 && pos.getX() <= n - 1 && pos.getY() >= 0 && pos.getY() <= n - 1)
                .collect(Collectors.toList());

        List<Position> filterPositionsAfterRemovingAlreadyVisitedSquares = filterPositions.stream()
                .filter(pos -> visited[pos.getX()][pos.getY()] == 0).collect(Collectors.toList());

        return filterPositionsAfterRemovingAlreadyVisitedSquares;

    }
}
