package com.SearchEngine;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchHistoryManager {

    public void storeSearch(String fileName, List<String> searchResults){

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("SearchResults.txt", true));

            System.out.println("Writing into History...");
            for(String result : searchResults){
                writer.append(fileName + "=" + result);
                writer.append("\n");
            }
        }
        catch(IOException ex){

        }
        finally {
            try {
                writer.close();
            }
            catch(IOException ex){

            }
        }
    }

    public List<String> getSearchResults(String fileName){

        List<String> results = null;

       File file  = new File("SearchResults.txt");
       try {
		Scanner scan = new Scanner(file);
		List<String> history =new ArrayList<String>();
		while(scan.hasNextLine()) {
			String[] split = scan.nextLine().split("=",2);
			if(fileName.equals(split[0]) ){
				history.add(split[1]);
		}}
		results=history;	
		if(results.isEmpty()) {
			results =null;
			return results;
		}

	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
       
        
        return results;
    }
}
