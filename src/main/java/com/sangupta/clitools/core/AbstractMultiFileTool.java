package com.sangupta.clitools.core;

import java.io.File;
import java.io.IOException;

public abstract class AbstractMultiFileTool {

	public void execute(String[] args) {
		preProcess();
		
		if(args.length == 0) {
			System.out.println("Provide the name(s) of files");
			return;
		}
		
		// read a list of all files that need to be worked upon
		for(String arg : args) {
			File[] files = CliToolsUtils.resolveFiles(new File(".").getAbsoluteFile(), arg);
		
			if(files == null) {
				System.out.println("No file found");
				return;
			}
			
			if(files.length == 1) {
				File file = files[0];
				if(!file.exists()) {
					System.out.println("No file found");
					return;
				}
				
				if(file.isDirectory()) {
					System.out.println("File is a folder");
					return;
				}
			}
			
			boolean cont = true;
			for(File file : files) {
				
				try {
					cont = processFile(file);
				} catch(IOException e) {
					// unable to process file
					e.printStackTrace();
				}
				
				if(!cont) {
					break;
				}
			}
		}
		
		postProcess();
	}
	
	/**
	 * The worker method that processes the file from the list of arguments. Must return <code>true</code>
	 * if the next file needs to be processed, or <code>false</code> if execution needs to break right away.
	 * 
	 * @param file
	 * @return
	 */
	protected abstract boolean processFile(File file) throws IOException;
	
	/**
	 * Method that is invoked before any file starts getting processed.
	 * 
	 */
	protected void preProcess() {
		
	}
	
	/**
	 * Method that is invoked once all the files have been processed.
	 * 
	 */
	protected void postProcess() {
		
	}
}
