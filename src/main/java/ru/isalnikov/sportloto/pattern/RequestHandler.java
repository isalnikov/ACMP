package ru.isalnikov.sportloto.pattern;

/**
 *
 * @author Igor Salnikov  <igor.salnikov@stoloto.ru>
 * @param <Request>
 * @param <Response>
 */
public interface RequestHandler<Request, Response> {

    public Response handleRequest(Request request, Context context);
}
