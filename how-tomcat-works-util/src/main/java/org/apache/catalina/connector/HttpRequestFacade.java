package org.apache.catalina.connector;


import org.apache.catalina.HttpRequest;
import org.apache.catalina.session.StandardSessionFacade;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;


/**
 * Facade class that wraps a Catalina-internal <b>HttpRequest</b>
 * object.  All methods are delegated to the wrapped request.
 *
 * @author Remy Maucherat
 * @version $Revision: 1.2 $ $Date: 2001/07/22 20:25:06 $
 */

public final class HttpRequestFacade
        extends RequestFacade
        implements HttpServletRequest {


    // ----------------------------------------------------------- Constructors


    /**
     * Construct a wrapper for the specified request.
     *
     * @param request The request to be wrapped
     */
    public HttpRequestFacade(HttpRequest request) {
        super(request);
    }


    // --------------------------------------------- HttpServletRequest Methods


    @Override
    public String getAuthType() {
        return ((HttpServletRequest) request).getAuthType();
    }


    @Override
    public Cookie[] getCookies() {
        return ((HttpServletRequest) request).getCookies();
    }


    @Override
    public long getDateHeader(String name) {
        return ((HttpServletRequest) request).getDateHeader(name);
    }


    @Override
    public String getHeader(String name) {
        return ((HttpServletRequest) request).getHeader(name);
    }


    @Override
    public Enumeration getHeaders(String name) {
        return ((HttpServletRequest) request).getHeaders(name);
    }


    @Override
    public Enumeration getHeaderNames() {
        return ((HttpServletRequest) request).getHeaderNames();
    }


    @Override
    public int getIntHeader(String name) {
        return ((HttpServletRequest) request).getIntHeader(name);
    }


    @Override
    public String getMethod() {
        return ((HttpServletRequest) request).getMethod();
    }


    @Override
    public String getPathInfo() {
        return ((HttpServletRequest) request).getPathInfo();
    }


    @Override
    public String getPathTranslated() {
        return ((HttpServletRequest) request).getPathTranslated();
    }


    @Override
    public String getContextPath() {
        return ((HttpServletRequest) request).getContextPath();
    }


    @Override
    public String getQueryString() {
        return ((HttpServletRequest) request).getQueryString();
    }


    @Override
    public String getRemoteUser() {
        return ((HttpServletRequest) request).getRemoteUser();
    }


    @Override
    public boolean isUserInRole(String role) {
        return ((HttpServletRequest) request).isUserInRole(role);
    }


    @Override
    public java.security.Principal getUserPrincipal() {
        return ((HttpServletRequest) request).getUserPrincipal();
    }


    @Override
    public String getRequestedSessionId() {
        return ((HttpServletRequest) request).getRequestedSessionId();
    }


    @Override
    public String getRequestURI() {
        return ((HttpServletRequest) request).getRequestURI();
    }


    @Override
    public StringBuffer getRequestURL() {
        return ((HttpServletRequest) request).getRequestURL();
    }


    @Override
    public String getServletPath() {
        return ((HttpServletRequest) request).getServletPath();
    }


    @Override
    public HttpSession getSession(boolean create) {
        HttpSession session =
                ((HttpServletRequest) request).getSession(create);
        if (session == null) {
            return null;
        } else {
            return new StandardSessionFacade(session);
        }
    }


    @Override
    public HttpSession getSession() {
        return getSession(true);
    }


    @Override
    public boolean isRequestedSessionIdValid() {
        return ((HttpServletRequest) request).isRequestedSessionIdValid();
    }


    @Override
    public boolean isRequestedSessionIdFromCookie() {
        return ((HttpServletRequest) request).isRequestedSessionIdFromCookie();
    }


    @Override
    public boolean isRequestedSessionIdFromURL() {
        return ((HttpServletRequest) request).isRequestedSessionIdFromURL();
    }


    @Override
    public boolean isRequestedSessionIdFromUrl() {
        return ((HttpServletRequest) request).isRequestedSessionIdFromURL();
    }


}
