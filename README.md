# EclipseLink JMX support for Tomcat server platform

Use the [```eclipselink.target-server```](https://www.eclipse.org/eclipselink/documentation/2.6/jpa/extensions/persistenceproperties_ref.htm#target-server) 
property to configure the ```ServerPlatform``` that will be used to enable 
integration with a host container. If this property is not specified, the 
runtime will attempt to detect which ```ServerPlatform``` should be used. 
If detection fails, **Default** (```TargetServer.None```) will be used.

## Example 1 
Using ```target-server``` in ```persistence.xml```

```
<property name="eclipselink.target-server" value="org.eclipse.persistence.platform.server.tomcat.TomcatPlatform"/>
```

## Example 2 
Using ```target-server``` in a Property Map

```
import org.eclipse.persistence.config.TargetServer;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.eclipse.persistence.platform.server.tomcat.TomcatPlatform;

propertiesMap.put(PersistenceUnitProperties.TARGET_SERVER, TomcatPlatform.class.getName());
```

# References
 * [Bug 457558 - Add support for Tomcat server platform (even better: introduce a generic server platform](https://bugs.eclipse.org/bugs/show_bug.cgi?id=457558)
 * [Re: [eclipselink-users] JMX under Tomcat: is it possible?](https://dev.eclipse.org/mhonarc/lists/eclipselink-users/msg08496.html)
