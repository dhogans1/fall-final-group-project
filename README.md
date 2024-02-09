# Personal Library

This Java program implements a simple Library Management System with a user interface for interacting with the library. Users can perform various actions such as adding items (Books, DVDs, CDs), searching for items, borrowing and returning items, and saving/loading the library to/from a file.

## Table of Contents
- [Project Title](#project-title)
- [Authors](#authors)
- [Version](#version)
- [Installation](#installation)
- [Usage](#usage)
- [Features](#features)
- [Exception Handling](#exception-handling)
- [Saving and Loading](#saving-and-loading)
- [Quitting the Program](#quitting-the-program)
- [Additional Notes](#additional-notes)
- [Contribution](#contribution)
- [License](#license)
- [Credits](#credits)

## Project Title
Personal Library

## Authors
Isha Sheth, Diamond Hogans, Allal Sayedzada

## Version
Version 2.0

## Installation
To start this project, execute the compiled program. Ensure Java is installed on your machine and follow any platform-specific instructions to run a Java program.

## Usage
Upon running the program, a menu will be displayed with options numbered from 1 to 7. Enter the corresponding number to choose an option. Follow the prompts to provide necessary information for the selected action.

## Features
- **Add Item**: Users can add new items to the library, including Books, DVDs, and CDs. The system prompts the user to choose the type of item and then collects relevant details for each item type.
- **Search Items**: Users can search for items in the library by providing a search term (e.g., ISBN, director, author, artist). The system displays matching items or notifies the user if no items are found.
- **Borrow an Item**: Users can borrow items by providing the item's unique identifier and their name and contact information. The system checks for item availability and updates the borrowing status accordingly.
- **Return an Item**: Users can return borrowed items by providing the item's unique identifier. The system updates the item's status to indicate its return.
- **Export/Import Library to/from File**: Users can export all library items to a file and load items from a file. The system prompts users for filenames during these operations.

## Exception Handling
The program includes exception handling to address potential errors, such as invalid input, empty fields, or unexpected errors. Proper error messages guide the user in case of input issues.

## Saving and Loading
Users can save the current state of the library to a file through exporting and loading a library from a file. Ensure to provide valid filenames, and the system will handle the rest.

## Quitting the Program
To exit the program, select option 7 from the menu. A farewell message will be displayed, indicating the program's termination.

## Additional Notes
The system uses a simple console-based user interface for ease of interaction. It relies on a Library class to manage the collection of items and perform operations.
