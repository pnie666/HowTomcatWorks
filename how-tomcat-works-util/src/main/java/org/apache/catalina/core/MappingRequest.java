/*
 * $Header: /home/cvs/jakarta-tomcat-4.0/catalina/src/share/org/apache/catalina/core/MappingRequest.java,v 1.1 2002/06/28 01:35:34 remm Exp $
 * $Revision: 1.1 $
 * $Date: 2002/06/28 01:35:34 $
 *
 * ====================================================================
 *
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 1999 The Apache Software Foundation.  All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "The Jakarta Project", "Tomcat", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 * [Additional notices, if required by prior licensing conditions]
 *
 */


package org.apache.catalina.core;


import org.apache.catalina.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.security.Principal;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/**
 * @author Remy Maucherat
 * @version $Revision: 1.1 $ $Date: 2002/06/28 01:35:34 $
 */

public class MappingRequest
        implements HttpRequest, HttpServletRequest {

    public MappingRequest(String contextPath, String decodedURI,
                          String queryString) {
        this.contextPath = contextPath;
        this.decodedURI = decodedURI;
        this.queryString = queryString;
    }

    protected String contextPath = null;
    protected String decodedURI = null;
    protected String queryString = null;

    protected String pathInfo = null;
    protected String servletPath = null;
    protected Wrapper wrapper = null;

    @Override
    public String getContextPath() {
        return (contextPath);
    }

    @Override
    public ServletRequest getRequest() {
        return (this);
    }

    @Override
    public String getDecodedRequestURI() {
        return decodedURI;
    }

    @Override
    public String getQueryString() {
        return queryString;
    }

    @Override
    public void setQueryString(String query) {
        queryString = query;
    }

    @Override
    public String getPathInfo() {
        return pathInfo;
    }

    @Override
    public void setPathInfo(String path) {
        pathInfo = path;
    }

    @Override
    public String getServletPath() {
        return servletPath;
    }

    @Override
    public void setServletPath(String path) {
        servletPath = path;
    }

    @Override
    public Wrapper getWrapper() {
        return (this.wrapper);
    }

    @Override
    public void setWrapper(Wrapper wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public String getAuthorization() {
        return null;
    }

    @Override
    public void setAuthorization(String authorization) {
    }

    @Override
    public Connector getConnector() {
        return null;
    }

    @Override
    public void setConnector(Connector connector) {
    }

    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public void setContext(Context context) {
    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public Response getResponse() {
        return null;
    }

    @Override
    public void setResponse(Response response) {
    }

    @Override
    public Socket getSocket() {
        return null;
    }

    @Override
    public void setSocket(Socket socket) {
    }

    @Override
    public InputStream getStream() {
        return null;
    }

    @Override
    public void setStream(InputStream input) {
    }

    @Override
    public void addLocale(Locale locale) {
    }

    @Override
    public ServletInputStream createInputStream() throws IOException {
        return null;
    }

    @Override
    public void finishRequest() throws IOException {
    }

    @Override
    public Object getNote(String name) {
        return null;
    }

    @Override
    public Iterator getNoteNames() {
        return null;
    }

    @Override
    public void removeNote(String name) {
    }

    @Override
    public void setContentType(String type) {
    }

    @Override
    public void setNote(String name, Object value) {
    }

    @Override
    public void setProtocol(String protocol) {
    }

    @Override
    public void setRemoteAddr(String remoteAddr) {
    }

    public void setRemoteHost(String remoteHost) {
    }

    @Override
    public void setScheme(String scheme) {
    }

    @Override
    public void setServerName(String name) {
    }

    @Override
    public void setServerPort(int port) {
    }

    @Override
    public Object getAttribute(String name) {
        return null;
    }

    @Override
    public Enumeration getAttributeNames() {
        return null;
    }

    @Override
    public String getCharacterEncoding() {
        return null;
    }

    @Override
    public int getContentLength() {
        return -1;
    }

    @Override
    public void setContentLength(int length) {
    }

    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        return null;
    }

    @Override
    public Locale getLocale() {
        return null;
    }

    @Override
    public Enumeration getLocales() {
        return null;
    }

    @Override
    public String getProtocol() {
        return null;
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return null;
    }

    @Override
    public String getRealPath(String path) {
        return null;
    }

    @Override
    public String getRemoteAddr() {
        return null;
    }

    @Override
    public String getRemoteHost() {
        return null;
    }

    @Override
    public String getScheme() {
        return null;
    }

    @Override
    public String getServerName() {
        return null;
    }

    @Override
    public int getServerPort() {
        return -1;
    }

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public void removeAttribute(String name) {
    }

    @Override
    public void setAttribute(String name, Object value) {
    }

    @Override
    public void setCharacterEncoding(String enc)
            throws UnsupportedEncodingException {
    }

    @Override
    public void addCookie(Cookie cookie) {
    }

    @Override
    public void addHeader(String name, String value) {
    }

    @Override
    public void addParameter(String name, String values[]) {
    }

    @Override
    public void clearCookies() {
    }

    @Override
    public void clearHeaders() {
    }

    @Override
    public void clearLocales() {
    }

    @Override
    public void clearParameters() {
    }

    @Override
    public void recycle() {
    }

    @Override
    public void setAuthType(String authType) {
    }

    @Override
    public void setContextPath(String path) {
    }

    @Override
    public void setMethod(String method) {
    }

    @Override
    public void setRequestedSessionCookie(boolean flag) {
    }

    @Override
    public void setRequestedSessionId(String id) {
    }

    @Override
    public void setRequestedSessionURL(boolean flag) {
    }

    @Override
    public void setRequestURI(String uri) {
    }

    @Override
    public void setSecure(boolean secure) {
    }

    @Override
    public void setUserPrincipal(Principal principal) {
    }

    @Override
    public String getParameter(String name) {
        return null;
    }

    @Override
    public Map getParameterMap() {
        return null;
    }

    @Override
    public Enumeration getParameterNames() {
        return null;
    }

    @Override
    public String[] getParameterValues(String name) {
        return null;
    }

    @Override
    public RequestDispatcher getRequestDispatcher(String path) {
        return null;
    }

    @Override
    public String getAuthType() {
        return null;
    }

    @Override
    public Cookie[] getCookies() {
        return null;
    }

    @Override
    public long getDateHeader(String name) {
        return -1;
    }

    @Override
    public String getHeader(String name) {
        return null;
    }

    @Override
    public Enumeration getHeaders(String name) {
        return null;
    }

    @Override
    public Enumeration getHeaderNames() {
        return null;
    }

    @Override
    public int getIntHeader(String name) {
        return -1;
    }

    @Override
    public String getMethod() {
        return null;
    }

    @Override
    public String getPathTranslated() {
        return null;
    }

    @Override
    public String getRemoteUser() {
        return null;
    }

    @Override
    public String getRequestedSessionId() {
        return null;
    }

    @Override
    public String getRequestURI() {
        return null;
    }

    @Override
    public void setDecodedRequestURI(String uri) {
    }

    @Override
    public StringBuffer getRequestURL() {
        return null;
    }

    @Override
    public HttpSession getSession() {
        return null;
    }

    @Override
    public HttpSession getSession(boolean create) {
        return null;
    }

    @Override
    public boolean isRequestedSessionIdFromCookie() {
        return false;
    }

    @Override
    public boolean isRequestedSessionIdFromURL() {
        return false;
    }

    @Override
    public boolean isRequestedSessionIdFromUrl() {
        return false;
    }

    @Override
    public boolean isRequestedSessionIdValid() {
        return false;
    }

    @Override
    public boolean isUserInRole(String role) {
        return false;
    }

    @Override
    public Principal getUserPrincipal() {
        return null;
    }


}

