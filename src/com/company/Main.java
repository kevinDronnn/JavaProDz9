package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt"))) {
            writer.write("INFO: Starting JuniorCrudServiceApplication using Java 17.0.7 \n");
            writer.write("DEBUG: User admin created \n");
            writer.write("UPDATE: User2 info is updated \n");
            writer.write("DELETE: User3 was deleted \n");
            writer.write("DEBUG: User15 created \n");
            writer.write("INFO: Starting Application using Java 8 \n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader("C:\\Users\\voros\\IdeaProjects\\JavaProDz9\\log.txt"))) {
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("--------------------------------");
        logLevelMethod("INFO");
    }

    public static void logLevelMethod(String logLevel) {
        System.out.println("Searching by " + logLevel);

        try (BufferedReader reader =
                     new BufferedReader(new FileReader("C:\\Users\\voros\\IdeaProjects\\JavaProDz9\\log.txt"))) {
            String currentLine = reader.readLine();
            while (currentLine != null) {
                if (logLevel.equals("INFO") && currentLine.startsWith("INFO")) {
                    System.out.println(currentLine);
                } else if (logLevel.equals("DEBUG") && currentLine.startsWith("DEBUG")) {
                    System.out.println(currentLine);
                }
                currentLine = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
