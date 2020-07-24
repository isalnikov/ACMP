package ru.isalnikov.iteco;

import java.util.Objects;


public class Person {
    String name;
    long  cent;

    public Person(String name, long cent) {
        this.name = name;
        this.cent = cent;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCent() {
        return cent;
    }

    public void setCent(long cent) {
        this.cent = cent;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", cent=" + cent + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + (int) (this.cent ^ (this.cent >>> 32));
        return hash;
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
        final Person other = (Person) obj;
        if (this.cent != other.cent) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
