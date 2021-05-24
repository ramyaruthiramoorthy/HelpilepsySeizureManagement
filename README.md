# HelpilepsySeizureManagement

## Introduction

 This document describes high level technical supporting details of **Hepilepsy Seizure Management** test automation project. Also, it explains project structure and frameworks used across the application. Test cases are implemented for **Login, Add, Edit Seizure Events and Logout** functionalities using Selenium TestNG framework. By default it executes on **Chrome** browser and if you want to execute it on **Firefox** Or **MS Chromium Edge** enable respective commented test block (code) in _helpilepsyTestSuite.xml_ under _src/test/resource_ folder.


## Technical Details

 Following frameworks and patterns are used to build this project

  * Selenium
  * Java
  * TestNG
  * Page Object Model(POM)
  * Page Factory
  * Maven build


## Project Structure
* Package Structure
  * Core
    * Defined base class for Test and Pages
  * Pages
    * Implemented all page functions
  * Test
    * Test cases and validations are implemented
  * Properties
    * Read property values from resource file

 * Resource
   * Credentials properties
   * Message properties
   * URL properties
   * TestSuit XML file (supports multi-browser testing however enabled only Chrome. Firefox and Edge are commented)


## Note

   * Included _sleep_ in few places for the users to observe the values which are entered or selected
   * Didn’t include _git ignore_ so you might see all the reports as well
