% Java Projects
% CS 1331

# Java Projects

You know the basics of Java.  Today you'll learn a few basic properties of professional Java projects, including

- the classpath,
- separating source and compiler output,
- project directory layout,
- packages,
- jar files,
- compiling with Ant, and
- using an IDE.


<!--------------------------------Slide ------------------------------------->
# The Classpath

Just as your operating system shell looks in the `PATH` environment variable for executable files, JDK tools (such as `javac` and `java`) look in the `CLASSPATH` for Java classes. To specify a classpath:


- set an environment variable named `CLASSAPTH`, or
- specify a classpath on a per-application basis by using the `-cp` switch.  The classpath set with `-cp` overrides the `CLASSPATH` environment variable.

Don't use the `CLASSPATH` environment variable.  If it's already set, clear it with (on Windows):
```Java
C:> set CLASSPATH=
```
or (on Unix):
```Java
$ unset CLASSPATH
```


<!--------------------------------Slide ------------------------------------->
# Specifying a Classpath


A classpath specification is a list of places to find `.class` files and other resources.  Two kinds of elements in this list:


- directories in which to find `.class` files on the filesystem, or
- `.jar` files that contain archives of directory trees containing `.class` files and other files (more later).


To compile and run a program with compiler output (`.class` files) in the current directory and a library Jar file in the `lib` directory called `util.jar`, you'd specify the classpath like this:

```bash
$ ls -R # -R means recursive (show subdirectory listings)
MyProgram.java     AnotherClass.java

./lib:
util.jar
$ javac -cp .:lib/util.jar *.java # : separates classpath elements
$ java -cp .:lib/util.jar MyProgram # would be ; on Windows
```

Notice that you include the entire classpath in the `-cp`, which includes the current directory (`.` means ``current directory'').


<!--------------------------------Slide ------------------------------------->
# Separating Source and Compiler Output


To reduce clutter, you can compile classes to another directory with `-d` option to `javac`
```Java
$ mkdir classes
$ javac -d classes HelloWorld.java
$ ls classes/
HelloWorld.class
```
Specify classpath for an application with the `-cp` option to {\tt
  java}.
```Java
$ java -cp ./classes HelloWorld
Hello, world!
```

If you really want to keep your project's root directory clean (and you do), you can put your source code in another directory too, like `src`.
```Java
$ mkdir src
$ mv HelloWorld.java src/
$ javac -d ./classes src/HelloWorld.java
$ java -cp ./classes HelloWorld
Hello, world!
```


<!--------------------------------Slide ------------------------------------->
# Project Directory Layout


Source Directories

- `src/main/java` for Java source files
- `src/main/resources` for resources that will go on the classpath, like image files


Output Directories

- `target/classes` for compiled Java .class files and resources copied from `src/main/resources`


There's more, but this is enough for now.  More details on the de-facto standard Java project directory layout can be found at [Maven's directory layout guide](http://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html).


<!--------------------------------Slide ------------------------------------->
# Organizing your Code in Packages


All professional Java projects organize their code in packages.  The standard package naming scheme is to use reverse domain name, followed by project specific packages.  For our CompanyGUI application we could use the package name

```Java
package edu.gatech.cs1331.companygui;
```
and source files would be located in a directory under your `src/` directory as follows
```Java
src/edu/gatech/cs1331/companygui/
```

And if you tell `javac` to put compiler output in `target/classes` then the compiled `.class` file would end up in:
```Java
target/edu/gatech/cs1331/companygui
```

<!--------------------------------Slide ------------------------------------->
# Ant


[Ant](http://ant.apache.org/) is a build automation tool, like `make`.  Install it however you want (like with homebrew on a Mac), then put this in a file named `build.xml` in the root directory of your companygui project:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project name="companygui" default="default" basedir=".">
  <path id="classpath">
    <fileset dir="target" includes="**/*.class"/>
  </path>

  <target name="init" depends="clean">
    <mkdir dir="target"/>
  </target>

  <target name="compile" depends="init">
    <javac srcdir="src"
           destdir="target"
           classpathref="classpath"
           source="1.7"
           target="1.7" />
  </target>
</project>
```

<!--------------------------------Slide ------------------------------------->
# Compiling with Ant


Invoke the `compile` target to compile the project:
```Java
$ ant compile
Buildfile: /Users/chris/work/vcs/github/software-design-practice/code/blackjack/build.xml

init:
...
compile:
...
BUILD SUCCESSFUL
Total time: 0 seconds
```

This will produce class files in `target/classes`.  How would you run the `Blackjack` class?


<!--------------------------------Slide ------------------------------------->
# Jar Files

A jar archive, or jar file, is a Zip-formatted archive of a directory tree.
Java uses jar files as a distribution format for libraries.


- To create a JAR file: `jar cf jar-file input-file(s)`
- To view the contents of a JAR file `jar tf jar-file`
- To extract the contents of a JAR file: `jar xf jar-file` or `unzip jar-file`
- To extract specific files from a JAR file: `jar xf jar-file archived-file(s)`
- To run an application packaged as a JAR file (requires the Main-class manifest header): `java -jar app.jar`


See
[Oracle's Jar file guide](http://docs.oracle.com/javase/tutorial/deployment/jar/index.html) for more details.


<!--------------------------------Slide ------------------------------------->
# Runnable Jar Files

The hard way: [Oracel's Jar file guide](http://docs.oracle.com/javase/tutorial/deployment/jar/appman.html)

The easy way: add this to your `build.xml`:
```xml
  <target name="package" depends="compile">
    <jar destfile="target/blackjack.jar">
      <fileset dir="target/classes"/>
      <manifest>
        <attribute name="Main-class" value="Blackjack"/>
      </manifest>
    </jar>
  </target>
```

Then you can do:

```bash
$ ant package
...
BUILD SUCCESSFUL
Total time: 0 seconds
$ java -jar target/blackjack.jar
```

<!--------------------------------Slide ------------------------------------->
# Using an IDE


Here are a few basic things you need to configrue when using an IDE:

- Editor settings for non-awful source code
- Source Directory
- Classpath
- Libraries

The best approach to most of this is to generate an IDE project configuration from your build specification, e.g., `build.xml`.  Let's see how to do these things with Eclipse.
