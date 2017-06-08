package org.eclipse.persistence.platform.server.tomcat;

import org.eclipse.persistence.internal.sessions.AbstractSession;
import org.eclipse.persistence.sessions.Session;

public class MBeanTomcatRuntimeServices extends TomcatRuntimeServices
        implements MBeanTomcatRuntimeServicesMBean {
    public MBeanTomcatRuntimeServices(final Session session) {
        super((AbstractSession) session);
    }
}