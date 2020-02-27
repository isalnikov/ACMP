package ru.isalnikov.sportloto.streamapi;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

/**
 *
 * @author Igor Salnikov isalnikov.com
 */
public class SupplierTest 

{
    
    
    
    public static void main(String[] args) {
        Set<Supplier<Number>> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            final int n = i;
            
            set.add(()->0);
            set.add(()->n);
            set.add(Math::random);
            
            
            
            
        }
        
        
        
    }
}
