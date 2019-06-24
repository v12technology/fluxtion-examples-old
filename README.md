# README #

### This repository holds code examples for use with the Fluxtion framework ###

* Building and running the projects in this repository will help a developer understand and exploit the capabilities of the Fluxtion toolset. The examples should be read in conjunction with the [reference](http://fluxtion.wpengine.com/documents/reference/) and tutorial documentation on the [Fluxtion website](http://fluxtion.wpengine.com/). 
* Current example release version 1.7
* Current Fluxtion api release version 1.0.28
* Current Fluxtion exectuable release version 1.0.19
* Fluxtion has several applications: the examples demonstrate capabilities and functionality of each one:
    * fluxtion - The core fluxtion tool that generates a static event procssor(SEP).
    * fluxtion-declarative - Adds declarative functionality for constructing SEP's, supports aggregation, functional idioms, windowing, logging and filtering.
    * fluxtion-declarative-extended - Adds bespoke text processing, math functions, logical operators and utilities.
    * fluxtion-statemachine - a statemachine generator powered by fluxtion core, leveraging Fluxtions's annotations.

### How do I get set up? ###


### Running the core examples ###

* Dependencies - none
* Database configuration - none
* Clone the [examples](https://github.com/v12technology/fluxtion-examples.git) and cd into the reference-core directory
* To run tests execute  **mvn install**, by default only one example generates, to generate all examples use mvn -Pbuild-all-examples
* The default build generates debug output, set **&lt;logDebug&gt;true&lt;/logDebug&gt;** to false to reduce logging noise:

```bash
mvn clean install 
```

### Who do I talk to? ###

* For any questions please send mails to info@v12technology.com
* Ask questions on our [forum](https://groups.google.com/a/v12technology.com/forum/#!forum/fluxtion).
