package com.SearchEngine;

public class RootFinderFactory {

    public static IDriveFinder create(String choice) throws InvalidChoiceException {
        
    	IDriveFinder finder = null;

        if(choice.equals("1"))
            finder = new ActiveRootFinder();
        else if(choice.equals("2"))
            finder = new AllRootFinder();
       

        return finder;
    }
}
