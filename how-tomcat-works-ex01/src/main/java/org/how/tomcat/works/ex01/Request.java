package org.how.tomcat.works.ex01;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author : Ares
 * @version : 1.0
 * @createTime : Aug 21, 2012 9:48:45 PM
 * @description :
 */
public class Request {
    private static final int BUFFER_SIZE = 2048;
    private InputStream input;
    private String uri;

    public Request(InputStream input) {
        this.input = input;
    }

    public void parse() {
        // Read a set of characters from the socket
        StringBuffer request = new StringBuffer(2048);
        int i;
        byte[] buffer = new byte[BUFFER_SIZE];
        try {
            i = input.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            i = -1;
        }
        if(i > 0){
            request.append(new String(buffer, 0, i));
        }
        System.out.print(request.toString());
        uri = parseUri(request.toString());
    }

    private String parseUri(String requestString) {
        int index1, index2;
        index1 = requestString.indexOf(' ');
        if (index1 != -1) {
            index2 = requestString.indexOf(' ', index1 + 1);
            if (index2 > index1) {
                return requestString.substring(index1 + 1, index2);
            }
        }
        return null;
    }

    public String getUri() {
        return uri;
    }
}
