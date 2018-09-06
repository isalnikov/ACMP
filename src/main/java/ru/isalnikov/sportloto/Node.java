
package ru.isalnikov.sportloto;

import java.util.HashSet;
import java.util.Objects;

/**
 *
 * @author i.salnikov
 */
public class Node{

    private int id;
    private String name;

    @Override
    public String toString() {
        return String.format(" id = %s , %s", id,name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Node other = (Node) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id;
        hash = 71 * hash + Objects.hashCode(this.name);
        return hash;
    }
    
    

 



    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        HashSet<Node> ts = new HashSet<>();

        Node node = new Node(1, "Car");

        ts.add(node);

        System.out.println(ts);
        
        boolean b = ts.contains(node);
        System.out.println(b);
        
        node.setName("dog");
        
        boolean b1 = ts.contains(node);
        System.out.println(b1); 
        
    }

  

}
