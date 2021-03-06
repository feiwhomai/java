/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

 * OJ's undirected graph serialization:
 * Nodes are labeled uniquely.
 * 
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 * 
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.

 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * Second node is labeled as 1. Connect node 1 to node 2.
 * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * Visually, the graph looks like the following:
 * 
 *        1
 *  *       / \
 *      /   \
 *     0 --- 2
 *          / \
 *          \_/
 * 
 */
package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import leetcode.util.UndirectedGraphNode;

public class LeetCode133CloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (null == node) {
            return null;
        }

        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node, newNode);
        queue.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode currNode = queue.poll();
            UndirectedGraphNode currCopy = map.get(currNode);

            for (UndirectedGraphNode neighbor : currNode.neighbors) {
                if (map.containsKey(neighbor)) {
                    currCopy.neighbors.add(map.get(neighbor));
                } else {
                    UndirectedGraphNode neighborCopy = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, neighborCopy);
                    currCopy.neighbors.add(neighborCopy);
                    queue.add(neighbor);
                }
            }
        }
        return newNode;
    }
}
