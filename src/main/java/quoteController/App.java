package quoteController;

import io.javalin.Javalin;

public class App {
    public static void main(String[] args){
        Javalin app = Javalin.create(config -> {
            config.enableCorsForAllOrigins();
        });
        establishRoutes(app);
        app.start(8080);
    }



    private static void establishRoutes(Javalin app){
        QuoteController quoteController = new QuoteController();

        app.get("/testing", context -> {context.result("Testing");});

        //endpoints
        app.get("/quote", quoteController.readQuote);
        app.post("/quote", quoteController.createQuote);
        app.post("/quote/:quoteNumber", quoteController.updateQuote);
        app.delete("/quote/:quoteNumber", quoteController.deleteQuote);
    }

}
