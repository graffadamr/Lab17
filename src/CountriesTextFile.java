import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CountriesTextFile {

	public static void createDir() {

		String dirPath = "resources";
		Path folder = Paths.get(dirPath);
		if (Files.notExists(folder)) {
			try {
				Files.createDirectories(folder);
				System.out.println("Successful!");
			} catch (IOException e) {
				System.out.println("Not successful!");
			}
		} else {
			System.out.println("Already there.");
		}
	}

	public static void createOurFile() {
		String fileName = "countries.txt";
		Path path = Paths.get("resources", fileName);
		if (Files.notExists(path)) {
			try {
				Files.createFile(path);
				System.out.println("File created!");
			} catch (IOException e) {
				System.out.println("File not created!");
			}
		} else { 
			System.out.println("File already here.");

		}

	}
	
	public static void writeToFile (ArrayList<Country> countries) {

		String fileName = "countries.txt";
		Path path = Paths.get("resources", fileName);

		File file = path.toFile();
		PrintWriter output = null;
		
		try {
			output = new PrintWriter(new FileOutputStream(file, false));
			for (Country x : countries ) 
				output.println(x);
		} catch (FileNotFoundException e) {
			System.out.println("Please contact customer service.");
		
		} finally {	
			output.close();
		
		}

	}
	
	public static ArrayList<Country> readFromFile (String fileName) {
		
		ArrayList<Country> countries = new ArrayList<>();
		Path path = Paths.get("resources", fileName);
		
		File file = path.toFile();
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String line = br.readLine();
			

			while (line != null) {
			String[] countryValues = line.split(":");
			Country c = new Country(countryValues[0], (countryValues[1])); 
				countries.add(c);
				line = br.readLine();
				
			}
			br.close();

				
			
		} catch (FileNotFoundException e) {
			System.out.println("Something is wrong with the file.");
			
		} catch (IOException e) {
				System.out.println("Something is very wrong with the file!");;	
		}
		
		return countries;

	}

}
