package com.SearchEngine;

import java.util.ArrayList;
import java.util.List;

public class SearchManager implements ISearchManager{

    public List<String> search(String fileName, List<String> drives) {
       
        List<String> searchResults = new ArrayList<String>();
        FileSearcher[] searchers = new FileSearcher[drives.size()];
        Thread[] threads = new Thread[drives.size()];

        
        for(int i =0; i < drives.size(); i++){
   
            FileSearcher searcher = new FileSearcher(fileName, drives.get(i));
            searchers[i] = searcher;

           
            Thread thread = new Thread(searcher);
            threads[i] = thread;
            thread.start();
  
        }

        for(int i=0;i <threads.length; i++){
            try{
                threads[i].join();}
            catch (InterruptedException ex){

            }
        }

        for(int i = 0; i < searchers.length; i++){
            for(String path : searchers[i].getPathsFound()){
                searchResults.add(path);
            }
        }

        SearchHistoryManager historyManager = new SearchHistoryManager();
        historyManager.storeSearch(fileName, searchResults);

        return searchResults;
    }
}
