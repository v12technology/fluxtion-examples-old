# README #

### This repository holds code examples for use with the Fluxtion framework ###

* Building and running the projects in this repository will teach a developer how to understand and exploit the capabilities of the Fluxtion toolset. The examples should be read in conjunction with the [reference](http://fluxtion.wpengine.com/documents/reference/) and tutorial documentation on the Fluxtion website. 
* Version 1.0.2
* Fluxtion has several versions the examples demonstrate capabilities and functionality for each version:
    * fluxtion - The core fluxtion tool that generates static event procssors(SEP).
    * fluxtion-declarative - Adds declarative functionality for constructing SEP's, supports aggregation, functional idioms, windowing, logging, filtering
    * fluxtion-decalrative-extended - Adds bespoke text processing, math functions, logical operators
    * fluxtion-statemachine - a statemachine generator powered by fluxtion core, leveraging Fluxtions's annotations.

### How do I get set up? ###

* Install Fluxtion Core Trial:
    * Download the latest trial version version for you platform from [dropbox](https://www.dropbox.com/sh/p8g5iqxbedzgcur/AAA01xw4EDZcYW0elHxkKoM1a?dl=0), the follwoing versions are available: 
        * [Windows installer](https://www.dropbox.com/sh/p8g5iqxbedzgcur/AAD6vSalNq4j2D6JGKeHBfIVa/fluxtion-core-trial.exe?dl=0)
        * [windows zip file](https://www.dropbox.com/sh/p8g5iqxbedzgcur/AAD_i_lBRksoynyG67DYRL6Sa/fluxtion-core-trial.zip?dl=0) 
        * [linux self extracting archive](https://www.dropbox.com/sh/p8g5iqxbedzgcur/AACdzgBWQ3aclYbr6maileY5a/fluxtion-core-trial-0.1.5.sh?dl=0).
    * The download will be either an installation package or an archive unpack/install on the local machine.
* Activating LIcense
    * Fluxtion is a license based product Before running any examples the **Fluxtion license must be activated**.
    * Locate the install directory and run **fluxtion.exe activate Q3WWS-QBQAY-75JEY-GG7UK-FPKI** for windows:
    
```bash

c:\Program Files (x86)\V12 Technology\fluxtion-core-trial 0.1.4>fluxtion.exe activate Q3WWS-QBQAY-75JEY-GG7UK-FPKIH
attempting to activate license
08:47:11.903 license valid
License:C:\Users\myuser_name\.v12-fluxtion\trial-fluxtion-core.lic
        Validation status : LICENSE_VALID
        Activation status : ACTIVATION_COMPLETED
        Expiry date       : 18-Apr-2017
        Product name      : fluxtion
        Product edition   : core
        Product version   : trial
        Product ID        : fluxtion-core

```

* Maven Integration:
    * To help use Fluxtion within the normal development-build process, a custom fluxtion plugin is provided.
    * set the path to fluxtion executable in the maven pom.xml of a module, the poms are set up to use a property substitution from ~/.m2/settings.xml 
 

```xml

<?xml version="1.0" encoding="UTF-8"?>
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">
    
    <profiles>
        <profile>
            <id>fluxtion</id>
            <activation>
                <activeByDefault>true</activeByDefault>
            </activation>
            <properties>
                <fluxtion.trial>C:\Program Files (x86)\V12 Technology\fluxtion-core-trial 0.1.4\fluxtion.exe</fluxtion.trial>
                <fluxtion.declarative.ext.trial>C:\Program Files (x86)\V12 Technology\fluxtion-core-trial 0.1.4\fluxtion.exe</fluxtion.declarative.ext.trial>
                <fluxtion.declarative.trial>C:\Program Files (x86)\V12 Technology\fluxtion-core-trial 0.1.4\fluxtion.exe</fluxtion.declarative.trial>
                <fluxtion.statemachine.trial>C:\Program Files (x86)\V12 Technology\fluxtion-core-trial 0.1.4\fluxtion.exe</fluxtion.statemachine.trial>
            </properties>
        </profile>
    </profiles>
    

</settings>
```
- 
    * If preferred the path can be hardcoded in the pom.xml for the plugin

### Running the core examples ###

* Dependencies - none
* Database configuration - none
* How to run tests - 
```bash

mvn clean install 

cd G:\my_projects\fluxtion-master\fluxtion-opensource\examples\reference-core; "JAVA_HOME=C:\\Program Files\\Java\\jdk1.8.0_101" M2_HOME=G:\\tools\\mvn\\apache-maven-3.3.9 cmd /c "\"\"G:\\tools\\mvn\\apache-maven-3.3.9\\bin\\mvn.cmd\" -Dmaven.ext.class.path=\"C:\\Program Files\\NetBeans 8.2\\java\\maven-nblib\\netbeans-eventspy.jar\" -Pbuild-all-examples install\""
Scanning for projects...
Downloading: https://mymavenrepo.com/repo/a6PnK93U9WA0ChAw8D8u/com/fluxtion/fluxtion-bom/0.1.22/fluxtion-bom-0.1.22.pom
         
Downloaded: https://mymavenrepo.com/repo/a6PnK93U9WA0ChAw8D8u/com/fluxtion/fluxtion-bom/0.1.22/fluxtion-bom-0.1.22.pom (5 KB at 0.9 KB/sec)
                                                                        
------------------------------------------------------------------------
Building fluxtion.example :: ref.core 1.0.3-SNAPSHOT
------------------------------------------------------------------------
Downloading: https://mymavenrepo.com/repo/a6PnK93U9WA0ChAw8D8u/com/fluxtion/fluxtion-maven-plugin/1.0.4/fluxtion-maven-plugin-1.0.4.pom
         
Downloaded: https://mymavenrepo.com/repo/a6PnK93U9WA0ChAw8D8u/com/fluxtion/fluxtion-maven-plugin/1.0.4/fluxtion-maven-plugin-1.0.4.pom (7 KB at 2.2 KB/sec)
Downloading: https://mymavenrepo.com/repo/a6PnK93U9WA0ChAw8D8u/com/fluxtion/fluxtion-maven-plugin/1.0.4/fluxtion-maven-plugin-1.0.4.jar
           
Downloaded: https://mymavenrepo.com/repo/a6PnK93U9WA0ChAw8D8u/com/fluxtion/fluxtion-maven-plugin/1.0.4/fluxtion-maven-plugin-1.0.4.jar (13 KB at 11.1 KB/sec)
Downloading: https://mymavenrepo.com/repo/a6PnK93U9WA0ChAw8D8u/com/fluxtion/fluxtion-api/0.1.22/fluxtion-api-0.1.22.pom
         
Downloaded: https://mymavenrepo.com/repo/a6PnK93U9WA0ChAw8D8u/com/fluxtion/fluxtion-api/0.1.22/fluxtion-api-0.1.22.pom (3 KB at 2.6 KB/sec)
Downloading: https://mymavenrepo.com/repo/a6PnK93U9WA0ChAw8D8u/com/fluxtion/core-parent/0.1.22/core-parent-0.1.22.pom
         
Downloaded: https://mymavenrepo.com/repo/a6PnK93U9WA0ChAw8D8u/com/fluxtion/core-parent/0.1.22/core-parent-0.1.22.pom (2 KB at 4.6 KB/sec)
Downloading: https://mymavenrepo.com/repo/a6PnK93U9WA0ChAw8D8u/com/fluxtion/build-parent-root/0.1.22/build-parent-root-0.1.22.pom
         
Downloaded: https://mymavenrepo.com/repo/a6PnK93U9WA0ChAw8D8u/com/fluxtion/build-parent-root/0.1.22/build-parent-root-0.1.22.pom (6 KB at 5.5 KB/sec)
Downloading: https://mymavenrepo.com/repo/a6PnK93U9WA0ChAw8D8u/com/fluxtion/fluxtion-builder/0.1.22/fluxtion-builder-0.1.22.pom
         
Downloaded: https://mymavenrepo.com/repo/a6PnK93U9WA0ChAw8D8u/com/fluxtion/fluxtion-builder/0.1.22/fluxtion-builder-0.1.22.pom (2 KB at 0.8 KB/sec)
Downloading: https://mymavenrepo.com/repo/a6PnK93U9WA0ChAw8D8u/com/fluxtion/fluxtion-api/0.1.22/fluxtion-api-0.1.22.jar
Downloading: https://mymavenrepo.com/repo/a6PnK93U9WA0ChAw8D8u/com/fluxtion/fluxtion-builder/0.1.22/fluxtion-builder-0.1.22.jar
         
Downloaded: https://mymavenrepo.com/repo/a6PnK93U9WA0ChAw8D8u/com/fluxtion/fluxtion-api/0.1.22/fluxtion-api-0.1.22.jar (9 KB at 2.1 KB/sec)
           
Downloaded: https://mymavenrepo.com/repo/a6PnK93U9WA0ChAw8D8u/com/fluxtion/fluxtion-builder/0.1.22/fluxtion-builder-0.1.22.jar (26 KB at 0.6 KB/sec)

--- maven-resources-plugin:2.6:resources (default-resources) @ learning ---
Using 'UTF-8' encoding to copy filtered resources.
Copying 2 resources

--- maven-compiler-plugin:3.1:compile (default-compile) @ learning ---
Nothing to compile - all classes are up to date

--- fluxtion-maven-plugin:1.0.4:generate (example1) @ learning ---
C:\Program Files (x86)\V12 Technology\fluxtion-core-trial 0.1.4\fluxtion.exe -outDirectory G:\my_projects\fluxtion-master\fluxtion-opensource\examples\reference-core/src/main/java -buildDirectory G:\my_projects\fluxtion-master\fluxtion-opensource\examples\reference-core/target/classes -outResDirectory G:\my_projects\fluxtion-master\fluxtion-opensource\examples\reference-core/target/generated-sources/sep -outPackage com.fluxtion.learning.example1.generated -configClass com.fluxtion.learning.example1.TemperatureHandler$Builder -outClass TemperatureProcessor -buildClasses true -formatSource true -supportDirtyFiltering true -generateDebugPrep false -assignPrivate false -cp G:\my_projects\fluxtion-master\fluxtion-opensource\examples\reference-core\target\classes;C:\Users\pappabear\.m2\repository\com\fluxtion\fluxtion-api\0.1.22\fluxtion-api-0.1.22.jar;C:\Users\pappabear\.m2\repository\it\unimi\dsi\fastutil\7.0.7\fastutil-7.0.7.jar;C:\Users\pappabear\.m2\repository\net\vidageek\mirror\1.6.1\mirror-1.6.1.jar
09:03:35.126 license valid
running trial version of fluxtion
09:03:37.022 Reflections took 1800 ms to scan 5 urls, producing 318 keys and 1582 values 
09:03:39.696 Updated com.fluxtion.learning.example1.generated.TemperatureProcessor in G:\my_projects\fluxtion-master\fluxtion-opensource\examples\reference-core\target\classes
...
...
...
------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time: 13.003 s
Finished at: 2017-03-19T09:09:12+00:00
Final Memory: 11M/276M
------------------------------------------------------------------------


```


### Who do I talk to? ###

* For any questions please send mails to info@v12technology.com
* A google group is available at:
