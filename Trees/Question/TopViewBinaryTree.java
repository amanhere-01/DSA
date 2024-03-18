package Trees.Question;

import kotlin.Pair;

import java.util.*;
// Vertical oder traversal
public class TopViewBinaryTree {
    // In java alternate of Pair is Map
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>(); // key = column && value= node.value
        Queue<Map.Entry<Node, Integer>> queue = new LinkedList<>();
        queue.offer(new AbstractMap.SimpleEntry<>(root, 0));
        while (!queue.isEmpty()) {
            Map.Entry<Node, Integer> entry = queue.poll();
            int column = entry.getValue();
            Node node = entry.getKey();

            // Add to the map
            if (!map.containsKey(column)) {
                map.put(column, node.val);
            }
            if (node.left != null) {
                queue.offer(new AbstractMap.SimpleEntry<>(node.left, column - 1));
            }
            if (node.right != null) {
                queue.offer(new AbstractMap.SimpleEntry<>(node.right, column + 1));
            }
        }

        for (var e : map.entrySet()) {
            ans.add(e.getValue());
        }
        return ans;
    }

    // Pair is in kotlin
    static ArrayList<Integer> topView2(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();        // key = column && value= node.value
        Queue<Pair<Node,Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root,0));
        while (!queue.isEmpty()){
            Pair<Node, Integer> pair = queue.poll();
            int column = pair.getSecond();
            Node node = pair.getFirst();

            // Add to the map
            if(!map.containsKey(column)){
                map.put(column,node.val);
            }
            if(node.left!=null){
                queue.offer(new Pair<>(node.left, column-1));
            }
            if(node.right!=null){
                queue.offer(new Pair<>(node.right, column+1));
            }
        }

        for (var e : map.entrySet()){
            ans.add(e.getValue());
        }
        return ans;
    }
}
