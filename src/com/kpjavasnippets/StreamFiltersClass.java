package com.kpjavasnippets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//KP : NowJava8
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFiltersClass {
	
	public StreamFiltersClass() {
		// TODO Auto-generated constructor stub
	}

    public static void main(String[] args) {

        List<String> lines = Arrays.asList("spring", "node", "myKailash");
        
        //KP : B4Java8 GetFilter Output
        System.out.println("KP : KPJavaSnippets : StreamFiltersClass : main() : B4Java8 GetFilter Output");
        List<String> result = getFilterOutput(lines, "myKailash");
        for (String temp : result) {
            System.out.println(temp);    //output : spring, node
        }

        //KP : NowJava8 GetFilter Output
        System.out.println("KP : KPJavaSnippets : StreamFiltersClass : main() : NowJava8 Stream Output");
        nowJava8Stream(lines);
               
    }

	/**
	 * @implNote : Before Java8 Implementation Note
	 * @param args
	 */
    private static List<String> getFilterOutput(List<String> lines, String filter) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (!"myKailash".equals(line)) { // we dont like myKailash
                result.add(line);
            }
        }
        return result;
    }
      
	/**
	 * @implNote : Now Java8 Implementation Note
	 * @param args
	 */    
    public static void nowJava8Stream(List<String> lines) {

        //List<String> lines = Arrays.asList("spring", "node", "mkyong");

        List<String> result = lines.stream()                // convert list to stream
                .filter(line -> !"myKailash".equals(line))     // we dont like myKailash
                .collect(Collectors.toList());              // collect the output and convert streams to a List

        result.forEach(System.out::println);                //output : spring, node

    }

}