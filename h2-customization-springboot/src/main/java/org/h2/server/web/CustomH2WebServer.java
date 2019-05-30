package org.h2.server.web;

import java.util.ArrayList;
import java.util.Collections;

class CustomH2WebServer extends WebServer {

    private final String connectionInfo;

    CustomH2WebServer(String dbUrl) {

        this.connectionInfo = "Test H2 (Embedded)|org.h2.Driver|" +dbUrl+"|sa";
    }

    synchronized ArrayList<ConnectionInfo> getSettings() {
        ArrayList<ConnectionInfo> settings = new ArrayList<>();
        ConnectionInfo info = new ConnectionInfo(connectionInfo);
        settings.add(info);
        updateSetting(info);
        Collections.sort(settings);
        return settings;
    }

}
