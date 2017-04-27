# README #

### This repository holds code examples for use with the Fluxtion framework ###

* Building and running the projects in this repository will help a developer understand and exploit the capabilities of the Fluxtion toolset. The examples should be read in conjunction with the [reference](http://fluxtion.wpengine.com/documents/reference/) and tutorial documentation on the [Fluxtion website](http://fluxtion.wpengine.com/). 
* Current example release version 1.0.10
* Current Fluxtion api release version 1.0.28
* Current Fluxtion exectuable release version 1.0.19
* Fluxtion has several applications: the examples demonstrate capabilities and functionality of each one:
    * fluxtion - The core fluxtion tool that generates a static event procssor(SEP).
    * fluxtion-declarative - Adds declarative functionality for constructing SEP's, supports aggregation, functional idioms, windowing, logging and filtering.
    * fluxtion-declarative-extended - Adds bespoke text processing, math functions, logical operators and utilities.
    * fluxtion-statemachine - a statemachine generator powered by fluxtion core, leveraging Fluxtions's annotations.

### How do I get set up? ###
This guide will step you through the process of running the reference-core example project. At the [end of the guide](#configuartion-for-all-examples) is configuration information to run all the examples in this project.

* Install Fluxtion Core Trial:
    * Download the latest trial version for you platform from [dropbox](https://www.dropbox.com/sh/p8g5iqxbedzgcur/AAA01xw4EDZcYW0elHxkKoM1a?dl=0), the following versions are available: 
        * [Windows installer](https://www.dropbox.com/s/a2hl8n6h0sz6hhd/fluxtion-core-trial-0.1.9.exe?dl=0)
        * windows zip file - TBD
        * [linux self extracting archive](https://www.dropbox.com/s/luhdl6drkrehigo/fluxtion-core-trial-0.1.9.sh?dl=0).
    * The download will be either an installation package or an archive, unpack/install as ncessary on the local machine.
* Activating License
    * Fluxtion is a license based product so before running any examples the **Fluxtion license must be activated**.
    * Locate the install directory and run **fluxtion.exe activate Q3WWS-QBQAY-75JEY-GG7UK-FPKIH**, e.g. for windows:
    
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
    * Set the path to fluxtion executable in the maven pom.xml of a module, the poms are set up to use a property substitution from ~/.m2/settings.xml, an example settings.xml: 
 

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
    * If preferred the path to fluxtion executable can be hardcoded in the pom.xml for the example.

### Running the core examples ###

* Dependencies - none
* Database configuration - none
* Clone the [examples](https://github.com/v12technology/fluxtion-examples.git) and cd into the reference-core directory
* To run tests execute  **mvn install**, by default only one example generates, to generate all examples use mvn -Pbuild-all-examples
* The default build generates debug output, set **&lt;logDebug&gt;true&lt;/logDebug&gt;** to false to reduce logging noise:

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
... **DEBUG OUTPUT REMOVED**
...
------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time: 13.003 s
Finished at: 2017-03-19T09:09:12+00:00
Final Memory: 11M/276M
------------------------------------------------------------------------


```

### Configuartion for all examples ###

Running the other examples for different versions of fluxtion follows the same process: download the installer, activate license, run mvn install. The table below sets out the bindings between trial keys and executables:

example|windows executable|key
-------|----------|---
reference-core| fluxtion-core-trial.exe | Q3WWS-QBQAY-75JEY-GG7UK-FPKIH
reference-declarative| fluxtion-declarative-trial.exe | XELFA-4HGBI-GMDXZ-3SFIG-XV63C
reference-declarative-extended| fluxtion-declarative-extended-trial.exe | T5YQN-GHSH4-P5BG9-RZLR9-QSFKX
reference-statemachine| fluxtion-statemachine-trial.exe | 93DS4-4XNKB-YY7SM-7V2P9-BGVQR
reference-fx| fluxtion-fx-trial-0.1.8.exe | 7DSBB-PBQFW-II7YM-R54YP-9IIBW

example|64 bit Linux installer|key
-------|----------|---
reference-core| fluxtion-core-trial-0.1.5.sh | Q3WWS-QBQAY-75JEY-GG7UK-FPKIH
reference-declarative| fluxtion-declarative-trial-0.1.5.sh | XELFA-4HGBI-GMDXZ-3SFIG-XV63C
reference-declarative-extended| fluxtion-declarative-extended-trial-0.1.5.sh | T5YQN-GHSH4-P5BG9-RZLR9-QSFKX
reference-statemachine| fluxtion-statemachine-trial-0.1.5.sh | 93DS4-4XNKB-YY7SM-7V2P9-BGVQR






### Who do I talk to? ###

* For any questions please send mails to info@v12technology.com
* Ask questions on our [forum](https://groups.google.com/a/v12technology.com/forum/#!forum/fluxtion).
