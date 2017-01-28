package com.mycompany.app;

import static spark.Spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

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

    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");


        post("/compute", (req,res) -> {


            String input1 = req.queryParams("input1");
            java.util.Scanner scanner = new java.util.Scanner(input1);
            scanner.useDelimiter("[;\r\n]+");
            ArrayList<Integer> list1 = new ArrayList<>();
            while(scanner.hasNext()) {
                int value = Integer.parseInt(scanner.next().replaceAll("\\s",""));
                list1.add(value);
            }
            System.out.println(list1);

            String input2 = req.queryParams("input2");
            scanner = new java.util.Scanner(input2);
            scanner.useDelimiter("[;\r\n]+");
            ArrayList<Integer> list2 = new ArrayList<>();
            while(scanner.hasNext()) {
                int value = Integer.parseInt(scanner.next().replaceAll("\\s",""));
                list2.add(value);
            }
            System.out.println(list2);

            String input3 = req.queryParams("input3");
            scanner = new java.util.Scanner(input3);
            scanner.useDelimiter("[;\r\n]+");
            ArrayList<Integer> list3 = new ArrayList<>();
            while(scanner.hasNext()) {
                int value = Integer.parseInt(scanner.next().replaceAll("\\s",""));
                list3.add(value);
            }
            System.out.println(list3);

            ArrayList<Integer> result = (ArrayList<Integer>) findCommonElements(list1, list2, list3);

            Map map = new HashMap();
            map.put("result", result);
            return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());

        get("/compute", (rq, rs) -> {
                    Map map = new HashMap();
                    map.put("result", "not computed yet!");
                    return new ModelAndView(map, "compute.mustache");
                },
                new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
     }
}
