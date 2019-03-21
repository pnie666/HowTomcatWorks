import org.how.tomcat.works.ex02.Request;
import org.how.tomcat.works.ex02.Response;

import javax.servlet.*;
import java.io.IOException;
import java.lang.reflect.Field;

public class DangerServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        Request request = (Request) (servletRequest);
        Class<?> clazz = request.getClass();
        try {
            Field field = clazz.getDeclaredField("uri");
            field.setAccessible(true);
            field.set(request, "danger.html");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Response response = (Response)servletResponse;
        response.sendStaticResource();
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
