package org.eclipse.persistence.platform.server.tomcat;

import org.eclipse.persistence.platform.server.JMXEnabledPlatform;
import org.eclipse.persistence.platform.server.JMXServerPlatformBase;
import org.eclipse.persistence.sessions.DatabaseSession;

/**
 * JMX support for Tomcat server platform.
 *
 * @author Faqueer Tanvir Ahmed
 * @author Mauro Molinari
 *
 * @see org.eclipse.persistence.platform.server.jboss.JBossPlatform
 */
public class TomcatPlatform extends JMXServerPlatformBase implements JMXEnabledPlatform {
    static {
        APP_SERVER_CLASSLOADER_APPLICATION_PU_SEARCH_STRING_PREFIX = "  context: ";
        APP_SERVER_CLASSLOADER_APPLICATION_PU_SEARCH_STRING_POSTFIX = "\r\n  delegate: ";
        APP_SERVER_CLASSLOADER_MODULE_EJB_SEARCH_STRING_PREFIX = "/WEB-INF/lib/";
        APP_SERVER_CLASSLOADER_MODULE_WAR_SEARCH_STRING_PREFIX = "/WEB-INF/lib/";
        APP_SERVER_CLASSLOADER_MODULE_EJB_WAR_SEARCH_STRING_POSTFIX = ".jar_";
    }

    public TomcatPlatform(DatabaseSession newDatabaseSession) {
        super(newDatabaseSession);
        this.enableRuntimeServices();
        this.prepareServerSpecificServicesMBean();
    }

    public boolean isRuntimeServicesEnabledDefault() {
        return true;
    }

    public Class getExternalTransactionControllerClass() {
        return this.externalTransactionControllerClass;
    }

    public void prepareServerSpecificServicesMBean() {
        if (this.getDatabaseSession() != null && this.shouldRegisterRuntimeBean) {
            this.setRuntimeServicesMBean(new MBeanTomcatRuntimeServices(this.getDatabaseSession()));
        }

    }

    public void serverSpecificRegisterMBean() {
        super.serverSpecificRegisterMBean();
        this.initializeApplicationNameAndModuleName();
    }
}
