# StringManager类

## 两个属性

`private ResourceBundle bundle;`
`private static Hashtable managers = new Hashtable();`

## 单例实现

```java
/*
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

package org.apache.catalina.util;

import java.text.MessageFormat;
import java.util.Hashtable;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
public class StringManager {
    private ResourceBundle bundle;
    private StringManager(String packageName) {
        String bundleName = packageName + ".LocalStrings";
        bundle = ResourceBundle.getBundle(bundleName);
    }

    /**
     * Get a string from the underlying resource bundle.
     *
     * @param key
     */
    public String getString(String key) {
        if (key == null) {
            String msg = "key is null";

            throw new NullPointerException(msg);
        }

        String str = null;

        try {
            str = bundle.getString(key);
        } catch (MissingResourceException mre) {
            str = "Cannot find message associated with key '" + key + "'";
        }

        return str;
    }

    /**
     * Get a string from the underlying resource bundle and format
     * it with the given set of arguments.
     *
     * @param key
     * @param args
     */
    public String getString(String key, Object[] args) {
        String iString = null;
        String value = getString(key);

        // this check for the runtime exception is some pre 1.1.6
        // VM's don't do an automatic toString() on the passed in
        // objects and barf out

        try {
            // ensure the arguments are not null so pre 1.2 VM's don't barf
            Object nonNullArgs[] = args;
            for (int i = 0; i < args.length; i++) {
                if (args[i] == null) {
                    if (nonNullArgs == args) {
                        nonNullArgs = (Object[]) args.clone();
                    }
                    nonNullArgs[i] = "null";
                }
            }
            iString = MessageFormat.format(value, nonNullArgs);
        } catch (IllegalArgumentException iae) {
            StringBuffer buf = new StringBuffer();
            buf.append(value);
            for (int i = 0; i < args.length; i++) {
                buf.append(" arg[" + i + "]=" + args[i]);
            }
            iString = buf.toString();
        }
        return iString;
    }
    public String getString(String key, Object arg) { //...
    }
    public String getString(String key, Object arg1, Object arg2) { //...
    }
    public String getString(String key, Object arg1, Object arg2,Object arg3) {//...
    }
    public String getString(String key, Object arg1, Object arg2,Object arg3, Object arg4) {//...
    }
    // --------------------------------------------------------------
    // STATIC SUPPORT METHODS
    // --------------------------------------------------------------

    private static Hashtable managers = new Hashtable();

    /**
     * Get the StringManager for a particular package. If a manager for
     * a package already exists, it will be reused, else a new
     * StringManager will be created and returned.
     *
     * @param packageName
     */
    //此方法为同步方法，单例
    public synchronized static StringManager getManager(String packageName) {
        StringManager mgr = (StringManager) managers.get(packageName);
        if (mgr == null) {
            mgr = new StringManager(packageName);
            managers.put(packageName, mgr);
        }
        return mgr;
    }
}
```

## 加载properties文件内容

其中带{0}是使用`public String getString(String key, Object arg)`加载的
不带{0}是使用`public String getString(String key)`加载的
```properties
# $Id: LocalStrings_es.properties,v 1.1 2000/12/31 16:35:16 nacho Exp $
# language es
# package org.apache.catalina.connector.http
httpConnector.alreadyStarted=Conector HTTP ha sido ya iniciado
httpConnector.allAddresses=Abriendo sockets de servidor en todas las direcciones IP disponibles
httpConnector.failedSocketFactoryLoading=Problemas para cargar la factoria de sockets
httpConnector.failedToCreateSocket=La factoria de sockets a fallado al crear un socket
httpConnector.anAddress=Abriendo sockets en las direccion IP {0}
httpConnector.noAddress=No existe la direccionb IP {0}, abriendo todas las disponibles
httpConnector.noProcessor=No hay procesador disponible, rechazando esta conexion
httpConnector.notStarted=Conector HTTP no ha sido iniciado todavia
httpConnector.starting=Iniciando thread de posterior
httpConnector.stopping=Parando  thread posterior
httpProcessor.alreadyStarted=Procesador HTTP ha sido ya iniciado
httpProcessor.notStarted=Procesador HTTP no ha sido iniciado todavia
httpProcessor.parseHeaders.contentLength=Cabecera 'Content-Lenght' no valida
httpProcessor.parseHeaders.colon=Cabecera HTTP no valida
httpProcessor.parseHeaders.portNumber=Numero de puerto TCP/IP no  valido en la cabecera 'Host'
httpProcessor.parseRequest.decode=No se puede decodificar el URI de la peticion HTTP
httpProcessor.parseRequest.method=Metodo de la peticion HTTP inexistente
httpProcessor.parseRequest.read=Linea de la peticion HTTP inexistente
httpProcessor.parseRequest.uri=El URI peticion HTTP inexistente
httpProcessor.parseHeaders.unknownExpectation=Campo de cabecera Expect desconocido
httpProcessor.start=Procesador HTTP ha sido ya iniciado
httpProcessor.starting=Iniciando thread de posterior
httpProcessor.stopping=Parando  thread posterior
requestStream.close.closed=El flujo de la peticion ha sido cerrado ya
requestStream.read.closed=No se puede leer de un flujo cerrado
requestStream.read.error=Final de flujo inesperado
requestStream.readline.error=No puede leer la linea
requestStream.readline.toolong=Linea demasiado larga
```