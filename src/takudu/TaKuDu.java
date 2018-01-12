/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takudu;

import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gouthamvel
 */
public class TaKuDu {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException  {
        testGoutham();
        testTreeNode();
        testCal();
    }
    
    public static void testTreeNode(){
        TreeNode n = new TreeNode();
        n.genTree(4, 0);
        System.out.println("=====");
        for(Object x :n.getCombinedValues()){
            System.out.println(x);
        }
    }
        
    public static void testCal(){
        int i;
        List<Point> list = new ArrayList<Point>();
        for (i =0; i< 100; i ++) {
            Point p = new Point();
            p.x = (float) (random() * 100);
            p.y = (float) (random() * 100);
            list.add(p);
        }
        System.out.println(Point.countPairs(list, 80));
    }
    
    public static void testGoutham() throws InterruptedException{
        Goutham g = new Goutham();
        g.failedLoginAttempt("goutham");
        g.failedLoginAttempt("goutham");
        g.failedLoginAttempt("goutham");
        g.failedLoginAttempt("goutham");
    }
    
}
