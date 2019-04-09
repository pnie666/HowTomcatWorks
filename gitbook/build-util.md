# 第 3 章:连接器

## how-tomcat-works-util打包本地安装

1.使用compile插件，指定本地依赖的jar包
```xml
 <build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.5.1</version>
            <configuration>
                <source>1.8</source>
                <target>1.8</target>
                <encoding>UTF-8</encoding>
                <compilerArguments>
                    <extdirs>D:/code/IdeaProjects/HowTomcatWorks/lib</extdirs>
                </compilerArguments>
            </configuration>
        </plugin>
    </plugins>
</build>
```
2.把properties
3.`mvn clean package`打包
4.`mvn install` 安装jar包到本地`maven库`

