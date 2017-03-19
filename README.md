# README #

### This repository holds code examples for use with the Fluxtion framework ###

* Building and running the projects in this repository will teach a developer how to understand and exploit the capabilities of the Fluxtion toolset. The examples should be read in conjunction with the reference and tutorial documentation on the Fluxtion website. 
* Version 1.0.2
* Fluxtion has several version the examples demonstrate capabilities and functionality for each version, brief description of each version:
    * fluxtion - The core fluxtion tool that generates static event procssors(SEP).
    * fluxtion-declarative - Adds declarative functionality for constructing SEP's, supports aggregation, functional idioms, windowing, logging, filtering
    * fluxtion-decalrative-extended - Adds bespoke text processing, math functions, logical operators
    * fluxtion-statemachine - a statemachine generator powered by fluxtion core, leveraging it's annotations.

### How do I get set up? ###

* Install Fluxtion Core Trial:
    * Download the latest trial version version for you platform from [dropbox](https://www.dropbox.com/sh/p8g5iqxbedzgcur/AAA01xw4EDZcYW0elHxkKoM1a?dl=0), the follwoing versions are available: 
        * [Windows installer](https://www.dropbox.com/sh/p8g5iqxbedzgcur/AAD6vSalNq4j2D6JGKeHBfIVa/fluxtion-core-trial.exe?dl=0)
        * [windows zip file](https://www.dropbox.com/sh/p8g5iqxbedzgcur/AAD_i_lBRksoynyG67DYRL6Sa/fluxtion-core-trial.zip?dl=0) 
        * [linux self extracting archive](https://www.dropbox.com/sh/p8g5iqxbedzgcur/AACdzgBWQ3aclYbr6maileY5a/fluxtion-core-trial-0.1.5.sh?dl=0).
    * The download will be either an installation package or an archive unpack/install on the local machine.
* Activating LIcense
    * Fluxtion is a license based product Before running any examples the **Fluxtion license must be activated**.
    * Locate the install directory and run **fluxtion.exe activate Q3WWS-QBQAY-75JEY-GG7UK-FPKI** :
    
```bash

mvn clean install 

```

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
