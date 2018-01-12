/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takudu;

import java.util.List;

/**
 *
 * @author gouthamvel
 */
public class Point {
  float x;
  float y;
  
  public String toString(){
      return "("+x+","+y+")";
  }
  
  /**
   *
   * @param list
   * @param minDist
   * @return
   */
  public static int countPairs(List<Point> list, double minDist) {
    int count = 0;
    int i;
    List<Point> tempList;

    for (i = 0; i < list.size(); i++) {
      Point p1 = list.get(i);
      // subList last index is exclusive so we provide index which is one more than the possible index
      tempList = list.subList(i + 1, list.size());
      for (Point p2 : tempList) {
        if (distance(p1, p2) < minDist) {
          count++;
        }
      }
    }
    return count;
  }

  private static double distance(Point p1, Point p2) {
    double dx = (p1.x - p2.x);
    double dy = (p1.y - p2.y);
    return Math.sqrt((dx * dx) + (dy * dy));
  }
}
