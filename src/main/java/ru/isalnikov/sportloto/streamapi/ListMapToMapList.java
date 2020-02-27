/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.sportloto.streamapi;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Igor Salnikov  <isalnikov.com>
 */
public class ListMapToMapList {
    public static void main(String[] args) {
        
        
        //List<Map<K, V>> - >  Map<K,List<V>>
        //List<Map<String, String>> - >  Map<String,List<String>>
       List<Map<String, String>> input = null;
       input.stream()
              .flatMap(map -> map.entrySet().stream())
               .collect(Collectors.groupingBy(Map.Entry::getKey,
                       Collectors.mapping(Map.Entry::getValue,
                               Collectors.toList())));
        
        
    }
}
