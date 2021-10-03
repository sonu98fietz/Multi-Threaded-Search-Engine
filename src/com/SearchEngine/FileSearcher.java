package com.SearchEngine;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileSearcher implements Runnable {
	 @Override
	    public void run() {
	        searchForFile(this.fileName, this.drive);
	    }
	
    private List<String> pathsFound;
    private String fileName;
    private String drive;

    public FileSearcher(String fileName, String drive){
        this.fileName = fileName;
        this.drive = drive;
        pathsFound = new ArrayList<String>();
    }

    public List<String> getPathsFound(){
        return pathsFound;
    }

    public void searchForFile(String fileName, String folder){
        File file = new File(folder);

        if(file.isDirectory()){
            File[] folders = file.listFiles();
            if(folders!=null)
            for(File f : folders){
                searchForFile(fileName, f.getAbsolutePath());
            }
        }
        else{
           
            if(file.getAbsolutePath().contains(fileName)){
                pathsFound.add(file.getAbsolutePath());
            }
        }
    }
}
