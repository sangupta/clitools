package com.sangupta.clitools.file;

import io.airlift.airline.Arguments;
import io.airlift.airline.Command;
import io.airlift.airline.HelpOption;
import io.airlift.airline.Option;
import io.airlift.airline.SingleCommand;

import javax.inject.Inject;

import com.sangupta.clitools.CliTool;
import com.sangupta.jerry.util.AssertUtils;

@Command(name = "randfile", description = "Generate a random file of given length")
public class RandomFile implements CliTool {

	@Inject
	private HelpOption helpOption;
	
	@Option(name = { "--size", "-s" }, description = "The size of the file to generate")
	private String size;
	
	@Arguments
	private String fileName;
	
	public static void main(String[] args) {
		if(AssertUtils.isEmpty(args)) {
			args = new String[] { "--help" };
		}
		
		// parse and show help if needed
		RandomFile randomFile = SingleCommand.singleCommand(RandomFile.class).parse(args);
		if(randomFile.helpOption.showHelpIfRequested()) {
			return;
		}
		
		// run the command
		randomFile.generate();
	}
	
	public void generate() {
		if(AssertUtils.isEmpty(size)) {
			System.out.println("Size of file to be generated must be specified.");
			return;
		}
		
		if(AssertUtils.isEmpty(this.fileName)) {
			System.out.println("Filename of file to be generated must be specified.");
			return;
		}
		
		
	}
}
