package app;

import io.javalin.http.Handler;

import java.io.FileNotFoundException;
import java.io.IOException;


public class QuoteController {

    public Handler readRandomQuote = context -> {
        try {
            int numOfLines = QuoteUtilities.numOfQuotes();
            String quote = QuoteUtilities.getQuote((int) (Math.random() * numOfLines) + 1);
            context.result(quote);
            context.status(200);
        } catch (FileNotFoundException e) {
            context.result(e.toString());
            context.status(200);
        }
    };

    public Handler readSpecificQuote = context -> {
        int lineNumber = Integer.parseInt(context.pathParam("quoteNumber"));
        try{
            String quote = QuoteUtilities.getQuote(lineNumber);
            context.result(quote);
            context.status(200);
        } catch(FileNotFoundException e){
            context.result(e.toString());
            context.status(401);
        }

    };

    public Handler createQuote = context -> {
        try{
            QuoteUtilities.addQuote(context.body());
            context.result("Added Successfully");
            context.status(201);
        }catch (IOException e){
            context.result(e.toString());
            context.status(401);
        }

    };

    public Handler updateQuote = context -> {
        int lineNumber = Integer.parseInt(context.pathParam("quoteNumber"));
        try {
            QuoteUtilities.editQuote(context.body(), lineNumber);
            context.result("Edited successfully");
            context.status(200);
        }catch (IOException e){
            context.result(e.toString());
            context.status(401);
        }
    };

    public Handler deleteQuote = context -> {
        int lineNumber = Integer.parseInt(context.pathParam("quoteNumber"));
        try{
            QuoteUtilities.removeQuote(lineNumber);
            context.result("Removed Successfully");
            context.status(202);
        }catch (IOException e){
            context.result(e.toString());
            context.status(401);
        }
    };



}
