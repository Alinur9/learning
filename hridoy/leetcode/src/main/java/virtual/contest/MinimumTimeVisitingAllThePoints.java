package virtual.contest;

public class MinimumTimeVisitingAllThePoints {
      public int minTimeToVisitAllPoints(int[][] points) {

          int steps = 0;

          for(int i = 0; i < points.length - 1; i++) {
              int dx = Math.abs(points[i][0] - points[i+1][0]);
              int dy = Math.abs(points[i][1] - points[i+1][1]);
              steps += Math.max(dx, dy);
          }

          return steps;

    }

    public static void main(String[] args) {

          int[][] points = {{1,1},{3,4},{-1,0}};
          MinimumTimeVisitingAllThePoints obj = new MinimumTimeVisitingAllThePoints();
        System.out.println(obj.minTimeToVisitAllPoints(points));

    }
}
