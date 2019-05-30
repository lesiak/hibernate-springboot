package org.h2.server.web;

import javax.servlet.ServletConfig;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Enumeration;

public class CustomH2WebServlet extends WebServlet {

    private final String dbUrl;

    public CustomH2WebServlet(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    @Override
    public void init() {
        ServletConfig config = getServletConfig();
        Enumeration<?> en = config.getInitParameterNames();
        ArrayList<String> list = new ArrayList<>();
        while (en.hasMoreElements()) {
            String name = en.nextElement().toString();
            String value = config.getInitParameter(name);
            if (!name.startsWith("-")) {
                name = "-" + name;
            }
            list.add(name);
            if (value.length() > 0) {
                list.add(value);
            }
        }
        String[] args = list.toArray(new String[0]);
        WebServer server = new CustomH2WebServer(dbUrl);
        server.setAllowChunked(false);
        server.init(args);
        setServerWithReflection(this, server);
    }

    private static void setServerWithReflection(final WebServlet classInstance, final WebServer newValue) {
        try {
            final Field field = WebServlet.class.getDeclaredField("server");
            field.setAccessible(true);
            field.set(classInstance, newValue);
        }
        catch (SecurityException|NoSuchFieldException|IllegalArgumentException|IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
    }
}
