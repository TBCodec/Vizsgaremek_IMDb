package utils;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FileUtils {

    private WebDriver driver;

    public FileUtils(WebDriver driver){
        this.driver = driver;
    }

    public void createFile(String fileName){

        try {
            File myObj = new File(fileName);
            if (myObj.createNewFile()){
                System.out.println("File created: " + myObj.getName());
            }
            else System.out.println("File already exists.");
        }
        catch (IOException e){
            System.out.println("An error occured.");
            e.printStackTrace();
        }

    }

    public void writeToFile(String filename, String line){
        try {
            FileWriter myWriter = new FileWriter(filename);
            myWriter.write(line);
            myWriter.close();
            System.out.println("Successfully wrote to file:");
            System.out.println(line);
        }
        catch (IOException e){
            System.out.println("An error occured.");
            e.printStackTrace();
        }

    }

    public void readFromFileAndAddToList(List<String> listToFileLines){
        try {
            File myObj = new File("Files/searchFilm.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                listToFileLines.add(data);
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}
