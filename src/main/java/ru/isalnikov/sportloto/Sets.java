
package ru.isalnikov.sportloto;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import org.spark_project.guava.base.Objects;


public class Sets {
    
    
    public static class Post {
  
        private long id;
        private String text;

        public Post() {
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(id,text); //To change body of generated methods, choose Tools | Templates.
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
            final Post other = (Post) obj;
            if (this.id != other.id) {
                return false;
            }
            return java.util.Objects.equals(this.text, other.text);
        }


        public Post(long id, String text) {
            this.id = id;
            this.text = text;
        }

        @Override
        public String toString() {
            return String.format(" %s [%s]",id,text );
        }
        
    
        
    
    }
    public static void main(String[] args) {
        List<Post> posts = Arrays.asList(new Post(1,"1"),new Post(2,"2"));
        System.out.println(posts);
        
        TreeSet<Post> set = new TreeSet<>();
        set.add(new Post(1,"1"));
        
        
        Boolean.valueOf("true");
        Boolean.parseBoolean("true");
        
    }
}
