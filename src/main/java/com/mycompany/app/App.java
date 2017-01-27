package com.mycompany.app;

import java.util.*;
import java.lang.Math;

public class App 
{
    public static List<Integer> findCommonElements(List<Integer> array1, List<Integer> array2, List<Integer> array3) {

    	if(array1 == null || array2 == null || array3 == null)
    		return null;

        HashMap<Integer,Integer> map1 = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        List<Integer> commons= new ArrayList<>();

        for(int element : array1)
            if(!map1.containsKey(element))
                map1.put(element, 1);
            else
                map1.put(element, map1.get(element) + 1);

        for(int element : array2) {
            if(map1.containsKey(element) && map1.get(element) > 0) {
                if (!map2.containsKey(element))
                    map2.put(element, 1);
                else
                    map2.put(element, map2.get(element) + 1);

                map1.put(element, map1.get(element) - 1);
            }
        }

        for(int element : array3) {
            if(map2.containsKey(element) && map2.get(element) > 0) {
                commons.add(element);
                map2.put(element, map2.get(element) - 1);
            }
        }

        return commons;
    }
}
