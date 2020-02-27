package ru.isalnikov.sportloto.pattern;

/**
 *
 * @author Igor Salnikov  <isalnikov.com>
 * @param <Request>
 * @param <Response>
 */
public interface RequestHandler<Request, Response> {

    public Response handleRequest(Request request, Context context);
}
