package com.SearchEngine;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ActiveRootFinder implements IDriveFinder {

    public List<String> getDrives(){
       
        List<String> drives = new ArrayList<String>();

       
        File[] roots = File.listRoots();

//        for(File f : roots){
//                      if(f.canRead())
//                drives.add(f.getAbsolutePath());
//        }

        drives.add("E:\\");
        return drives;

    }
}
