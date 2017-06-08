package org.eclipse.persistence.platform.server.tomcat;

import org.eclipse.persistence.internal.sessions.AbstractSession;
import org.eclipse.persistence.services.RuntimeServices;

import java.util.Locale;

public class TomcatRuntimeServices extends RuntimeServices {
    static {
        PLATFORM_NAME = "Tomcat";
    }

    public TomcatRuntimeServices() {
    }

    public TomcatRuntimeServices(AbstractSession session) {
        super();
        this.session = session;
        this.updateDeploymentTimeData();
    }

    public TomcatRuntimeServices(final Locale locale) {
    }
}

