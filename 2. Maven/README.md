
## Spring Boot Dependency Management:

Advantages of Dependency Management
- It provides the centralization of dependency information by specifying the Spring Boot version in one place. It helps when we switch from one version to another.
- It avoids mismatch of different versions of Spring Boot libraries.
- We only need to write a library name with specifying the version. It is helpful in multi-module projects.


### Maven Dependency Management System
Dự án Maven kế thừa các tính năng sau từ spring-boot-starter-parent:

- The default Java compiler version
- UTF-8 source encoding
- It inherits a Dependency Section from the spring-boot-dependency-pom. It manages the version of common dependencies. It ignores the <version> tag for that dependencies.
- Dependencies, inherited from the spring-boot-dependencies POM
- Sensible resource filtering
- Sensible plugin configuration


### Inheriting Starter Parent:
The following spring-boot-starter-parent inherits automatically when we configure the project.
```Maven
<parent>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-parent</artifactId>
<version>2.2.2.BUILD-SNAPSHOT</version>      <!-- lookup parent from repository -->
<relativePath/>
</parent>  
```


### Changing the Java version
We can also change the Java version by using the <java.version> tag.
```java
<properties>    
<java.version>1.8</java.version>    
</properties>  
```


### Adding Spring Boot Maven Plugin
We can also add Maven plugin in our pom.xml file. It wraps the project into an executable jar file.
```java
<build>    
<plugins>    
<plugin>    
<groupId>org.springframework.boot</groupId>    
<artifactId>spring-boot-maven-plugin</artifactId>    
</plugin>    
</plugins>    
</build>  
```


### Spring Boot without Parent POM

- If we don't want to use spring-boot starter-parent dependency, but still want to take the advantage of the dependency management, we can use <scope> tag, as follows:
```java
<dependencyManagement>  
<dependencies>  
<dependency><!-- Import dependency management from Spring Boot -->  
<groupId>org.springframework.boot</groupId>  
<artifactId>spring-boot-dependencies</artifactId>  
<version>2.2.2.RELEASE</version>  
<type>pom</type>  
<scope>import</scope>  
</dependency>  
</dependencies>  
</dependencyManagement>  
```

- The above dependency does not allow overriding. To achieve the overriding, we need to add an entry inside the <dependencyManagement> tag of our project before the spring-boot-dependencies entry.
```java
<dependencyManagement>  
<dependencies>  
<!--Override Spring Data release train-->  
<dependency>  
<groupId>org.springframework.data</groupId>  
<artifactId>spring-data-releasetrain</artifactId>  
<version>Fowler-SR2</version>  
<type>pom</type>  
<scope>import</scope>  
</dependency>  
<dependency>  
<groupId>org.springframework.boot</groupId>  
<artifactId>spring-boot-dependencies</artifactId>  
<version>2.2.2.RELEASE</version>  
<type>pom</type>  
<scope>import</scope>  
</dependency>  
</dependencies>  
</dependencyManagement>  
```





















