package ru.isalnikov.sportloto.pattern;

/**
 *
 * @author Igor Salnikov  <isalnikov.com>
 */
public class Request {
    
    
    String name;

    public Request() {
    }

    public Request(String name) {
        this.name = name;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
