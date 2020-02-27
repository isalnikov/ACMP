package ru.isalnikov.sportloto.pattern;

/**
 *
 * @author Igor Salnikov  <isalnikov.com>
 */
public class Response {

    String body;

    public Response() {
    }

    public Response(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
