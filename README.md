# GitInformer

Git Utill Application creates a pdf with github repositories of specified user.


## Prerequisites

Download and install following tools:

Git from [a link](https://git-scm.com/downloads)

Maven from [a link](https://maven.apache.org/download.cgi)

## Installation

Firstly clone project to Your directory by using 
```
git clone https://github.com/szychan/GitInformer.git
```

build it with:
```
mvn install
```
this will create GitInformer.jar file in project folder.

## Working with Application

To run the application type
```
java -jar GitInformer.jar
```
in command line.
Then Application will ask You to provide needed user name for further processing.
Generated PDF is located in the same directory as GitInformer.Jar .

It is also possible to run the application by calling jar with parameters.
```
java -jar GitInformer.jar user
```
Where user is name of GitHub user.

## Authors

* **Sebastian Ceronik** 

