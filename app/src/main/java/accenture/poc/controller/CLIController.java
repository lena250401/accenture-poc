package accenture.poc.controller;
import java.io.IOException;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import accenture.poc.model.Country;
import accenture.poc.services.CountryService;

public class CLIController {
    private CountryService countryService;
    private Scanner scanner;
    private String choice; 

    public CLIController(){
        this.scanner = new Scanner(System.in);
        this.countryService = new CountryService();
    }

    /**
     * Method for controlling the flow of program
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    public void controller() throws JsonGenerationException, JsonMappingException, IOException{
        while(true){
            displyaMenu();
            this.choice = getUserInput();
            handleUserChoice();
        }
    }

    /**
     * Method calling the different services based on the user's choice
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    private void handleUserChoice() throws JsonGenerationException, JsonMappingException, IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        switch(choice){
            case "1":
                Country[] option1Result = countryService.getCountryByDescendingPopulationDensity();
                System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(option1Result));
                break;
            case "2":
                Country option2Result = countryService.getAsianCountryWithMostBorderingCountriesOfDifferentRegion();
                System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(option2Result));
                break;
            case "3":
                System.out.println("Thank you and goodbye!");
                scanner.close();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice, please enter a valid number");
        } 
    }

    /**
     * Method for retrieving the user's input
     * @return a String with the user's input
     */
    private String getUserInput(){
        System.out.println("Please enter the number of your selected choice:");
        String input = scanner.nextLine();
        return input;
    }

    /**
     * Method to display the menu in the terminal
     */
    private void displyaMenu(){
        System.out.println("Here are the choices you can select from: \n" + 
        "1 - Get the list of countries by population density in descending order \n" + 
        "2 - Get the country in Asia containing the most bordering countries of a different region \n" + 
        "3 - Exit the program"
        );
    } 
    
}
