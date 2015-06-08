# Embedded TomEE
This is a simple and small example how to use an embedded TomEE.
This could be used to start building MicroServices..

##pom.xml
The needed dependencies are only the following.

```xml
       <dependency>
            <groupId>org.apache.openejb</groupId>
            <artifactId>javaee-api</artifactId>
            <version>7.0-SNAPSHOT</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>org.apache.openejb</groupId>
            <artifactId>tomee-embedded</artifactId>
            <version>2.0.0-SNAPSHOT</version>
        </dependency>
 
```

To build an embedded TomEE (fat jar) you could use the maven shade plugin. The importand part is the definition of the main class.

```xml
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-shade-plugin</artifactId>
        <version>2.3</version>
        <executions>
          <execution>
            <phase>package</phase>
            <goals>
              <goal>shade</goal>
            </goals>
            <configuration>
              <dependencyReducedPomLocation>${project.build.directory}/reduced-pom.xml</dependencyReducedPomLocation>
              <transformers>
                <transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                  <!--<mainClass>org.apache.tomee.embedded.Main</mainClass>-->
                  <mainClass>org.rapidpm.demo.embedded.tomee.MyApp</mainClass>
                </transformer>
                <transformer implementation="org.apache.maven.plugins.shade.resource.AppendingTransformer">
                  <resource>META-INF/cxf/bus-extensions.txt</resource>
                </transformer>
                <transformer implementation="org.apache.maven.plugins.shade.resource.AppendingTransformer">
                  <resource>META-INF/openwebbeans/openwebbeans.properties</resource>
                </transformer>
              </transformers>
              <filters>
                <filter> <!-- we don't want JSF to be activated -->
                  <artifact>*:*</artifact>
                  <excludes>
                    <exclude>META-INF/faces-config.xml</exclude>
                  </excludes>
                </filter>
              </filters>
            </configuration>
          </execution>
        </executions>
      </plugin>
```

##CDI
There is a Service, that will be injected into the REST and SOAP Service.
The Sevice itself is doing nothing usefull.

```java
@Default
public class Service {

  public Service() {
    System.out.println("Service created = " 
           + LocalDateTime.now().toString());
  }

  public String doWork(){ return "Service used";}

}
```

##REST

