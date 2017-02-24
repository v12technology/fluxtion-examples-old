# README #

### This repository holds code examples for use with the Fluxtion framework ###

* Building and running the projects in this repository will teach a developer how to understand and exploit the capabilities of the Fluxtion toolset. The examples should be read in conjunction with the reference and tutorial documentation on the Fluxtion website.
* Version 0.1

### How do I get set up? ###

* Install Fluxtion:
    * Either register on the Fluxtion website to download a trial version or purchase a commercial version. A license key and instructions will be given after the registration process describing how to install Fluxtion toolset.
    * The download will be either an installation package or an archive for the developer to unpack on the local machine.
    * Before running any examples the **Fluxtion license must be activated** with the installed executable, locate the install directory and run fluxtion.exe activate (LICENSE KEY) 
* Maven Integration:
    * To help use Fluxtion within the normal development-build process, a custom fluxtion plugin is provided.
    * set the path to fluxtion executable in the maven pom.xml of a module, the poms are set up to use a property substitution from ~/.m2/settings.xml 
 

```xml

    <profile>
    	<id>fluxtion-exe-config</id>
    	<activation>
    		<property>
    			<name>!overrideFluxtionConfig</name>
    		</property>
    	</activation>
    	<properties>
    		<fluxtion.trial>c:\fluxtion.exe</fluxtion.trial>
    	</properties>
    </profile>
```
- 
    * If preferred the path can be hardcoded in the pom.xml for the plugin

### Running the examples ###

* Dependencies - none
* Database configuration - none
* How to run tests - 
```bash

mvn clean install 

```


### Who do I talk to? ###

* For any questions please send mails to info@v12technology.com
* A google group is available at:
