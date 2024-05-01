Certainly! Here's the full README file with all the sections included:

---

# Country Information Retrieval Program

## Overview
This Java program is designed to retrieve specific information about countries using data from the [RestCountries API](https://gitlab.com/restcountries/restcountries). It provides functionality to sort countries by population density in descending order and find the country in Asia with the most bordering countries of a different region.

## Architecture
The program follows a model-controller-service architecture, which separates concerns and promotes code organization and maintainability.

### Model
The model layer contains classes that represent the data entities used in the program. These classes encapsulate the structure and attributes of the data retrieved from the API. The model classes used in this program include:
- `Country`: Represents a country with its attributes such as name, population, area, etc.
- `CountryName`: Represents the name of a country.
- `PopulationDensityComparator`: Implements the `Comparator` interface to compare countries based on their population density. This comparator is used to sort countries by population density in descending order.

### Controller
The controller layer acts as an interface between the user interface (UI) and the service layer. It handles user input, invokes service methods, and presents the results to the user. In this program, the controller is not explicitly defined since it may vary depending on the user interface (e.g., command-line interface, graphical user interface).

### Service
The service layer contains classes responsible for fetching and processing data from external sources, such as APIs. It encapsulates the business logic of the application. The service classes used in this program include:
- `CountryService`: Provides methods to retrieve country data from the RestCountries API, sort countries by population density, and find the country in Asia with the most bordering countries of a different region.


## Usage
There are two ways to run the program:
1. Clone the repository to your local machine:
   ```bash
   git clone https://github.com/lena250401/accenture-poc.git
   ```

2. Navigate to the project directory:
   ```bash
   cd accenture-poc
   ```
3. Run the jar file:
   ```bash
   java -jar .\app.jar
   ```
Or alternatively:

1. Clone the repository to your local machine:
   ```bash
   git clone https://github.com/lena250401/accenture-poc.git
   ```

2. Navigate to the project directory:
   ```bash
   cd accenture-poc
   ```

3. Run the ```App.java``` file in your favourite IDE


5. Follow the prompts to retrieve the desired information:
   - Choose option 1 to view a sorted list of countries by population density.
   - Choose option 2 to find the country in Asia with the most bordering countries of a different region.
   - Choose option 3 to exit the program

## Dependencies
This program uses Gradle as a build tool and relies on the following external libraries:
- Jackson Databind: For JSON data binding and processing.
- Mockito Core: For mocking objects during testing.