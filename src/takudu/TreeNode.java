/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takudu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


class TreeNode<T extends Comparable<T>> {
    private List<T> values;
    private List<TreeNode<T>> children;

    // methods for adding/removing values
    // methods for adding/removing children
    
    public TreeNode(){
        values = new ArrayList<T>();
        children = new ArrayList<TreeNode<T>>();
    }
    
    public boolean genTree(int x, int value) {
      if (x > 0) {
          values.add((T)(Integer)value);
          TreeNode<T> c1 = new TreeNode<T>();
          c1.genTree(x - 1, value + 2);
          children.add(c1);
          TreeNode<T> c2 = new TreeNode<T>();
          c1.genTree(x - 1, value + 3);
          children.add(c2);      
      }
      return true;
    }

    public List<T>  getCombinedValues() {
        return getUnsortedCombinedValues().stream().sorted().distinct().collect(Collectors.toList());
    }

    private List<T> getUnsortedCombinedValues(){
        List<T> result = new ArrayList<T>(values);

        children.forEach((child) -> {
            result.addAll(child.getUnsortedCombinedValues());
        });
        return result;
    }

}