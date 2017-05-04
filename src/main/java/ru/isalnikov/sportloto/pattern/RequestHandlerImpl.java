package ru.isalnikov.sportloto.pattern;

public class RequestHandlerImpl implements RequestHandler<Request, Response> {

    @Override
    public Response handleRequest(Request request, Context context) { //Context - lambda
        String greeting = String.format("Hello %s", request.toString());
        return new Response(greeting);

    }
}
