package com.SearchEngine;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchMain {

    public static void main(String[] args) {
	
        List<String> drives = new ArrayList<String>();
        System.out.println("1). Active Drives");
        System.out.println("2). All Drives");
        System.out.println("Enter your choice for Drives  : ");
        Scanner scan = new Scanner(System.in);
        String option = scan.nextLine();

        try{
           
        	IDriveFinder finder = RootFinderFactory.create(option);
            drives = finder.getDrives();
        }
        catch(InvalidChoiceException ex){
            System.out.println("Invalid");
            System.exit(0);
        }
    
        if(drives!=null){

            for(String drive : drives){
                System.out.println(drive);
            }
            
            System.out.println("Enter the File Name to Search:");
            String fileName = scan.nextLine();
            
            SearchHistoryManager historyManager = new SearchHistoryManager();
            List<String> results = historyManager.getSearchResults(fileName);

            System.out.println("Searching in History.....");
            if(results == null) {
            	System.out.println("Not found in History !");
                ISearchManager manager = SearchManagerFactory.create();
                results = manager.search(fileName, drives);
            }

            for(String result : results){
                System.out.println(result);
            }
        }
    }
}
