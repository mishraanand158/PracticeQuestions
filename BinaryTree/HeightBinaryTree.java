package BinaryTree;

import java.util.*;
import java.io.*;

public class HeightBinaryTree {

    public static class Node {

        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
            }

    }
/**
 *  // initial stack is empty so push on it add Node and state = 1.
 *  1 means next node will on the left side of the current node
 *  2 means next node will on the right side of the current node
 *  3 pop the node from the stack
 *
 */

    /**
     * Algo -> push then increase the state of pushed Node
     * if top stack value one then push that node right side of the top Node
     * if node is null then only increase the value of the top node
     */
    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void display(Node node) {

        if (node == null) return;

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += "<-" + node.data + "->";
        str += node.right == null ? "." : node.right.data + "";

        System.out.println(str);

        display(node.left);
        display(node.right);

    }

    public static int height(Node node){

        if(node == null)
            return 0;
        int left = height(node.left);
        int right= height(node.right);

        return Math.max(left,right)+1;
    }


    public static void main(String[] args) {

        //Integer taking because we want to insert null as a value in the array , So object is required for this .
        Integer[] arr = {50, 12, 25, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};

        Node root = new Node(arr[0], null, null);
        Pair rtr = new Pair(root, 1);
        Stack<Pair> st = new Stack<>();
        st.push(rtr);

        int idx = 0; // creating to read the arrayIndex

        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);

                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;

                }
                top.state++;
            } else if (top.state == 2) {

                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);

                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;

                }
                top.state++;

            } else {
                st.pop();
            }
        }
        display(root);
        System.out.println(height(root));
    }


}