package com.sangupta.clitools.dir;

import java.io.File;
import java.util.List;

import io.airlift.airline.Arguments;
import io.airlift.airline.Command;
import io.airlift.airline.HelpOption;
import io.airlift.airline.Option;
import io.airlift.airline.SingleCommand;

import javax.inject.Inject;

import com.sangupta.jerry.util.AssertUtils;
import com.sangupta.jerry.util.FileUtils;

@Command(name = "findfile", description = "Find files in a directory")
public class FindFile implements Runnable {
	
	@Inject
	private HelpOption helpOption;

	@Option(name = { "--recursive", "-r" }, description = "Search recursively in sub-folders")
	private boolean recursive;
	
	@Arguments
	private String path;
	
	public static void main(String[] args) {
		FindFile findFile = SingleCommand.singleCommand(FindFile.class).parse(args);
		
		if(findFile.helpOption.showHelpIfRequested()) {
			return;
		}
		
		findFile.run();
	}
	
	@Override
	public void run() {
		List<File> files = FileUtils.listFiles(this.path, this.recursive);
		if(AssertUtils.isEmpty(files)) {
			System.out.println("No matching file found!");
			return;
		}
		
		for(File file : files) {
			System.out.println(file);
		}
	}
}
