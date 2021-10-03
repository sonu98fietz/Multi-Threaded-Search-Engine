package com.SearchEngine;

public class SearchManagerFactory {

    public static ISearchManager create(){
        return new SearchManager();
    }
}
