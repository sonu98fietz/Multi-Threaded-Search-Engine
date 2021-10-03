package com.SearchEngine;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AllRootFinder implements IDriveFinder {

    public List<String> getDrives(){
       
        List<String> drives = new ArrayList<String>();

       
        File[] roots = File.listRoots();
//        for(File f : roots){
//            drives.add(f.getAbsolutePath());
//        }

        drives.add("E:\\PROJECT MAIN\\");
        
        return drives;

    }
}
