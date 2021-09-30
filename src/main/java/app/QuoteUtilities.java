package app;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class QuoteUtilities {

    static File quotesFile = new File("/home/ec2-user/quotes.txt");

    public static String getQuote(int lineNumber) throws FileNotFoundException {
        int count = 0;
        Scanner quotes = new Scanner(quotesFile);
        while(quotes.hasNextLine()){
            if(count == lineNumber -1){String quote = quotes.nextLine(); quotes.close(); return quote;}
            else{ count+=1; quotes.nextLine();}
        }
        return "invalid quote number";
    }

    public static void addQuote(String quote) throws IOException {
        FileWriter fileWriter = new FileWriter(quotesFile, true);
        fileWriter.write("\n\""+quote+"\"");
        fileWriter.close();
        return;
    }

    public static int numOfQuotes() throws IOException {
        Scanner scanner = new Scanner(quotesFile);
        int count = 0;
        while(scanner.hasNextLine()){
            count +=1;
            scanner.nextLine();
        }
        return count;
    }

    public static void editQuote(String quote, int lineNumber) throws IOException{
        Scanner scanner = new Scanner(quotesFile);
        List<String> stringList = new LinkedList<>();
        while(scanner.hasNextLine()) stringList.add(scanner.nextLine());
        scanner.close();
        FileWriter fileWriter = new FileWriter(quotesFile);
        int count = 0;
        for(String line : stringList){
            if(lineNumber == 1  && count == 0){
                fileWriter.append(quote);
            }
            else if(lineNumber != 1 && count ==0){
                fileWriter.append(line);
            }    
            else if(count == lineNumber-1){
                fileWriter.append("\n"+quote);
            }
            else{
                fileWriter.append(line)   
            }
            count+=1;
        }
        fileWriter.close();
        return;
    }

    public static void removeQuote(int lineNumber) throws IOException{
        Scanner scanner = new Scanner(quotesFile);
        List<String> stringList = new LinkedList<>();
        while(scanner.hasNextLine()) stringList.add(scanner.nextLine());
        scanner.close();
        FileWriter fileWriter = new FileWriter(quotesFile);
        int count = 0;
        for(String line : stringList){
            if(lineNumber!=1 && count == 0){
                fileWriter.write(line);
            }
            if(lineNumber == 1 && count == 1){
                fileWriter.write(line);
            }
            if(count != lineNumber-1 && line!=""){
                fileWriter.write("\n"+line);
            }
            count+=1;
        }
        fileWriter.flush();
        fileWriter.close();
        return;
    }

    public static void main(String args[]){
        try {
            removeQuote(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
