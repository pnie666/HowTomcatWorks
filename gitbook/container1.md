# 第 5 章:容器

> `Valve.java`

```java
package org.apache.catalina;
import javax.servlet.ServletException;
import java.io.IOException;
public interface Valve {
    public String getInfo();
    public void invoke(Request request, Response response,
                       ValveContext context)
            throws IOException, ServletException;
}
```

> `ValveContext.java`
```java
package org.apache.catalina;
import javax.servlet.ServletException;
import java.io.IOException;
public interface ValveContext {
    public String getInfo();
    public void invokeNext(Request request, Response response)
            throws IOException, ServletException;
}
```

> `Contained.java`

```java
package org.apache.catalina;
public interface Contained {
    public Container getContainer();
    public void setContainer(Container container);
}
```


```java
package org.apache.catalina;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
public interface Wrapper extends Container {
    public void setAvailable(long available);
    public String getJspFile();
    public void setJspFile(String jspFile);
    public int getLoadOnStartup();
    public void setLoadOnStartup(int value);
    public String getRunAs();
    public void setRunAs(String runAs);
    public String getServletClass();
    public void setServletClass(String servletClass);
    public boolean isUnavailable();
    public void addInitParameter(String name, String value);
    public void addInstanceListener(InstanceListener listener);
    public void addSecurityReference(String name, String link);
    public Servlet allocate() throws ServletException;
    public void deallocate(Servlet servlet) throws ServletException;
    public String findInitParameter(String name);
    public String[] findInitParameters();
    public String findSecurityReference(String name);
    public String[] findSecurityReferences();
    public void load() throws ServletException;
    public void removeInitParameter(String name);
    public void removeInstanceListener(InstanceListener listener);
    public void removeSecurityReference(String name);
    public void unavailable(UnavailableException unavailable);
    public void unload() throws ServletException;
}
```

```java
package org.apache.catalina;
import javax.naming.directory.DirContext;
import javax.servlet.ServletException;
import java.beans.PropertyChangeListener;
import java.io.IOException;
public interface Container {
    public static final String ADD_CHILD_EVENT = "addChild";
    public static final String ADD_MAPPER_EVENT = "addMapper";
    public static final String ADD_VALVE_EVENT = "addValve";
    public static final String REMOVE_CHILD_EVENT = "removeChild";
    public static final String REMOVE_MAPPER_EVENT = "removeMapper";
    public static final String REMOVE_VALVE_EVENT = "removeValve";
    public String getInfo();
    public Loader getLoader();
    public void setLoader(Loader loader);
    public Logger getLogger();
    public void setLogger(Logger logger);
    public Manager getManager();
    public void setManager(Manager manager);
    public Cluster getCluster();
    public void setCluster(Cluster cluster);
    public String getName();
    public void setName(String name);
    public Container getParent();
    public void setParent(Container container);
    public ClassLoader getParentClassLoader();
    public void setParentClassLoader(ClassLoader parent);
    public Realm getRealm();
    public void setRealm(Realm realm);
    public DirContext getResources();
    public void setResources(DirContext resources);
    public void addChild(Container child);
    public void addContainerListener(ContainerListener listener);
    public void addMapper(Mapper mapper);
    public void addPropertyChangeListener(PropertyChangeListener listener);
    public Container findChild(String name);
    public Container[] findChildren();
    public ContainerListener[] findContainerListeners();
    public Mapper findMapper(String protocol);
    public Mapper[] findMappers();
    public void invoke(Request request, Response response)
            throws IOException, ServletException;
    public Container map(Request request, boolean update);
    public void removeChild(Container child);
    public void removeContainerListener(ContainerListener listener);
    public void removeMapper(Mapper mapper);
    public void removePropertyChangeListener(PropertyChangeListener listener);
}
```

```java
```
```java
```

```java
```

```java
```

```java
```

```java
```

```java
```
```java
```

```java
```

```java
```

```java
```

```java
```

```java
```
```java
```

```java
```

```java
```

```java
```

```java
```

```java
```
```java
```

```java
```

```java
```

```java
```

```java
```

```java
```
```java
```

```java
```

```java
```

```java
```

```java
```

```java
```
```java
```

```java
```

```java
```

```java
```

```java
```

```java
```
```java
```

```java
```

```java
```

```java
```

```java
```

```java
```
```java
```

```java
```

```java
```

```java
```

```java
```

```java
```
```java
```

```java
```

```java
```

```java
```

```java
```

```java
```
```java
```

```java
```

```java
```

```java
```

```java
```

```java
```
```java
```

```java
```

```java
```

```java
```

```java
```

```java
```
```java
```

```java
```

```java
```

```java
```

```java
```

```java
```
```java
```

```java
```

```java
```

```java
```

```java
```

```java
```
```java
```

```java
```

```java
```

```java
```

```java
```

```java
```
