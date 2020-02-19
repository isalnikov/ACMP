package ru.isalnikov.sportloto;

/**
 * Обход бинарных деревьев: рекурсия, итерации и указатель на родителя
 * https://habr.com/ru/post/144850/
 * 
 */
public class BinaryTreeWalk {
//
//       static void contLevelOrder(Node top){
//        Queue<Node> queue=new LinkedList<> ();
//        do{
//            top.treatment();
//            if (top.left!=null) queue.add(top.left);
//            if (top.right!=null) queue.add(top.right);
//            if (!queue.isEmpty()) top=queue.poll();
//        }while (!queue.isEmpty());
//    }
    
//    void recPreOrder() {
//        treatment();
//        if (left != null) {
//            left.recPreOrder();
//        }
//        if (right != null) {
//            right.recPreOrder();
//        }
//    }
//
//    void recInOrder() {
//        if (left != null) {
//            left.recInOrder();
//        }
//        treatment();
//        if (right != null) {
//            right.recInOrder();
//        }
//    }
//
//    void recPostOrder() {
//        if (left != null) {
//            left.recPostOrder();
//        }
//        if (right != null) {
//            right.recPostOrder();
//        }
//        treatment();
//    }
//    
    public static class Node {

        Node left;
        Node right;
        Node parent;
        String value;

        public Node(Node p, String v) {
            parent = p;
            value = v;
        }

    }
    
    public static void main(String[] args) {
        
    }
    
}
