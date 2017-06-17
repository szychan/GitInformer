# GitInformer
Git Utill Application creates a pdf with github repositories of specified user.

## Getting Started

Firstly clone project to Your directory by using 
```
git clone https://github.com/szychan/GitInformer.git
```

build it with
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
Where username is name of GitHub user.

## Authors

* **Sebastian Ceronik** 

