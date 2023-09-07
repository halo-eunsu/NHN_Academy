

<build>

    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-shade-plugin</artifactId>
            <executions>
            <execution>
                <goals>
                <goal>shade</goal>
                </goals>
                <configuration>
                <shadedArtifactAttached>true</shadedArtifactAttached>
                <transformers>
                    <transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                    <mainClass>com.nhnacademy.app.ApacheCommonsRandom</mainClass>
                    </transformer>
                </transformers>
                </configuration>
            </execution>
            </executions>
        </plugin>


    </plugins>

    이렇게 넣어야 한다.