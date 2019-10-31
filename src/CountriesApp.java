import java.util.ArrayList;
import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) {

		CountriesTextFile.createDir();
		CountriesTextFile.createOurFile();

		Scanner scan = new Scanner(System.in);
		int userChoice;
		ArrayList<Country> countryList = new ArrayList<>();

		System.out.println("Welcome to the Countries Maintenance Application!");
		do {
			System.out.println();
			System.out.println("1- See the list of countries");
			System.out.println("2- Add a country");
			System.out.println("3- Exit");
			System.out.println();
			userChoice = Validator.getInt(scan, "Enter menu number: ", 1, 3);
			System.out.println();

			if (userChoice == 2) {
				String countryName = Validator.getString(scan, "Enter country: ");
				String populationNum = Validator.getString(scan, "Enter population: ");
				Country newCountry = new Country(countryName, populationNum);
				countryList.add(newCountry);
				
				CountriesTextFile.writeToFile(countryList);

			}
			
			else if (userChoice == 1) {
				ArrayList<Country> countriesFromFile = CountriesTextFile.readFromFile("countries.txt");
				
				for (Country c : countriesFromFile) {
					System.out.println(c);
				}

			}

		} while (userChoice == 1 || userChoice == 2);

		if (userChoice == 3) {
			System.out.println();
			System.out.println("Buh-bye!");
		}
	}

}
