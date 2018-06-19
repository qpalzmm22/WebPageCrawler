package edu.handong.csee.java.bonus;

import java.io.BufferedReader;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class WebCrawlerDriver {

	private String inputURL;
	private	String outputDirectory;
	private boolean help;
	
	public static void main(String[] args) {
		WebCrawlerDriver main = new WebCrawlerDriver();
		main.run(args);
	}
		
	
	private void run(String[] args) {
		Options options = createOptions();
		if(parseOptions(options, args)) {
			if(help) {
				printHelp(options);
				return;
			}
			
			URLreader urlReader = new URLreader();
			try {
				BufferedReader in= urlReader.readURL(inputURL);
				URLexporter exporter = new URLexporter();
				exporter.exportURL(in, outputDirectory);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();

		try {

			CommandLine cmd = parser.parse(options, args);

			inputURL = cmd.getOptionValue("u");
			outputDirectory = cmd.getOptionValue("d");
			help = cmd.hasOption("h");

		} catch (Exception e) {
			printHelp(options);
			return false;
		}

		return true;
	}

	private Options createOptions() {
		Options options = new Options();

		options.addOption(Option.builder("u").longOpt("input-URL")
				.desc("Set a URL to save in HDD")
				.hasArg()
				.argName("Webpage to save")
				.required()
				.build());
		
		options.addOption(Option.builder("d").longOpt("dir")
				.desc("Set a path name for URL to be saved")
				.hasArg()
				.argName("Path name to save URL at")
				.required()
				.build());
		
		// add options by using OptionBuilder
		options.addOption(Option.builder("h").longOpt("help")
		        .desc("Help")
		        .build());

		return options;
	}
	
	private void printHelp(Options options) {
		// automatically generate the help statement
		HelpFormatter formatter = new HelpFormatter();
		String header = "CLI for Web Crawler program\n\n";
		String footer = "End of the help\n";
		formatter.printHelp("WebCrawler", header, options, footer, true);
	}

}
