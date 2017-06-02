---
layout: homework
title: Homework 2
---

# CS1331 Homework 02 - Course Registrar

[HW2 Files](hw2.zip)
[Tester](Test.java)

## Introduction

This assignment will have you working with arrays, classes, getters, setters, and enums.

## Problem Description

Now that summer registration is finally over, you have been officially hired to create a new course registration system. The new system will be similar to the old system, but there are a few marked differences. For example, in your system there will be no restrictions on registration. However, most of the features such as adding classes, a maximum waitlist size, a class size, having no conflicting class times, and others will stay the same.

You will be given `Course.java`, `Department.java`, `LectureDays.java`, `LectureTime.java`, `Student.java`, and `Time.java`. Some of these files (`Time.java` and `LectureTime.java`) have already been completed and you don't need to make any changes to them. The rest are either partially complete or need to be completed entirely by you.

## Solution Description

### Time.java
This class has two instance variables:
- `private int hour`: the hour of the time
- `private int minute`: the minute of the time

Additionally it has the following methods:
- `public Time(int hour, int minute)`: the constructor for the Time class.
- `public int getHour()`: The getter method for `hour`
- `public int getMinute()`: The getter method for `minute`
-  `public String toString()`: toString method for time, returns string in the format of 24-Hour Time (HH:MM)
- `public boolean before(Time time)`: timeA.before(timeB) returns true if timeA occurs before or at the same time as timeB and false otherwise.
> **NOTE:** This class is provided for you and should not be modified.

### LectureTime.java
This class has three instance variables:
- `private LectureDays days`: Denotes the days of the class. Either `LectureDays.MWF` or `LectureDays.TTH`.
- `private Time startTime`: Denotes the time at which the lecture starts
- `private Time endTime`: Denotes the time at which the lecture ends.

The class also contains the following methods:
- `public LectureTime(LectureDays days, int startHour, int startMinute, int endHour, int endMinute)`: The constructor for LectureTime.
- `public LectureDays getDays()`: The getter method for `days`
- `public Time getStartTime()`: The getter method for `startTime`
- `public Time getEndTime()`: The getter method for `endTime`
- `public boolean overlap(LectureTime time)`: lectureTimeA.overlap(lectureTimeB) returns true if lectureTimeA and lectureTimeB overlap and false otherwise.
> **NOTE:** This class is provided for you and should not be modified.


### Department.java
This is an enum with the following constants:
* COMPUTERSCIENCE
* MATHEMATICS
* PHYSICS
* ELECTRICALENGINEERING
* LITERATUREMEDIAANDCOMMUNICATION

Additionally there should be a `public String toString()` method that returns the abbreviation for the constant. The abbreviations (listed in the same order as the Department constants above) are:
* CS
* MATH
* PHYS
* EE
* LMC

### LectureDays.java
This should be an enum with the following constants:
* MWF
* TTH

### Student.java
This class will be used to represent students. The constructor should take in only a String, denoting the students name. Additionally, each student needs the following instance data:
* `private Course[] courses`: an array of courses the the student is signed up to take. Should be initialized with size 5.
* `private Course[] waitlists`: an array of courses that the student is waitlisted in. Should be initialized with size 5.
* `private int numCoursesRegistered`: the number of courses that student is taking
* `private int numCoursesWaitlisted`: the number of courses that the student is waitlisted in
* `private int credits`: the number of credits the student is taking AND waitlisted for
* `private String name`: the name of the student
> **Note:** A student is taking a course if they are in the course i.e. registered for it and not waitlisted.

It is important to realize, in our system, that in our new registration system that if a student is taking four 3-credit classes and waitlisted in one 3 credit class, they are classified as taking 15 total credits.

Additionally the class should contain the following methods:
* `public String getName()`: A getter method for name
* `public int getCredits()`: A getter method for credits
* `public int getNumCoursesRegistered`: A getter method for numCoursesRegistered
* `public int getNumCoursesWaitlisted`: A getter method for numCoursesWaitlisted
* `public Course[] getCourses()`: A getter method for courses
* `public Course[] getWaitlists[]`: A getter method for waitlists
* `public boolean availableAt(LectureTime time)`: Takes in a LectureTime and returns `true` if the student does not have a class (both waitlisted and those he's successfully taking) at the same time as LectureTime, and `false` if they do.
* `protected void register(Course course)`: Adds `course` to `courses`. Note that if `courses` is full, then the size of `courses` should be doubled and `course` should then be added.
* `protected boolean waitlist(Course course)`: Returns false if the student is waitlisted for five or more courses, and true otherwise. If the student is waitlisted for fewer than 5 courses,  the method adds `course` to `waitlists`. (In our registration system, we do not allow a student to be waitlisted for more than five courses.)
* `public boolean registeredForCourse(Course course)`: Returns true if the student is either taking or waitlisted for a a course and false otherwise.
* `public String toString()`: toString method for the Student class. Should return the name of the student.
* `public boolean signUp(Course course)`: Calls and returns `course.addStudent(this)`. (If addStudent is implemented correctly, it should returns whether the student was successfully registered for the class). This method is provided for you, and should not be modified.
* `protected boolean promotedFromWaitlist(Course course)`: Promotes the student from the waitlist after they get into the class. This method has been provided for you and should not be modified.

### Course.java
Finally you will be creating the course class which will have the following instance data:
* `private static int numCoursesOffered`: A static variable counting the number of courses being offered by the university
* `private int courseNumber`: The course number of the course
* `private Department dept`: The department offering the class
* `private int credits`: The number of credits that the course is worth
* `private int classSize`: The maximum class size of the class; any students added after there are classSize students will be waitlisted
* `private int waitlistCap`: The maximum length of the waitlist.
* `private Student[] registeredStudents`: A list of students registered for the class. This includes both students signed up to take the class and waitlisted students. Note that the list should store the students in the order in which they were added. The array should be of size `classSize + waitlistCap` and should not change size unless `classSize` changes.
* `private int numStudentsRegistered`: The number of students that are registered for the class (both taking and waitlisted)
* `private LectureTime time`: The time that the course takes place;

Additionally the class should have the following methods:
* `public Course(Department dept, int courseNumber, int credits, int classSize, int waitlistCap, LectureTime time)`: The constructor for the Course class.
* `public static int getNumCoursesOffered()`: The getter method for `numCoursesOffered`.
* `public int getCredits()`: The getter method for `credits`
* `public Department getDept()`: The getter method for `dept`
* `public void setDept(Department department)`: The setter method for `dept`
* `public Student[] getRegisteredStudents()`: The getter method for `registeredStudents`
* `public int getNumStudentsRegistered()`: The getter method for `numStudentsRegistered`
* `public LectureTime getTime()`: The getter method for `time`
* `public int getClassSize()`: The getter method for classSize
* `public boolean setClassSize(int size)`: Returns `false` if size is less than or equal to classSize and `true` otherwise. If `false`, the operation failed and nothing should occur. If `true`, set `classSize` to `size`. You will also have to resize the `registeredStudents` array and use the `promotedFromWaitlist(Course course)` method in the Students class as some students will be bumped up from the waitlist as the class size is expanded.
* `public Student getRegisteredPosition(int i)`: returns the student at position `i` in the registeredStudents list. Returns `null` if there is no such student at the position or the position is bigger than the size of the array.
* `protected boolean addStudent(Student student)`: If successful, the method adds the student to the registeredStudents array and returns true. The operation fails and returns false: if the registeredStudents array is filled, if the student will be taking more than 18 credits after registering, if the student is already registered for the class, if the student is not availiable during the course time, or if the student is to be placed on the waitlist but is already waitlisted in five or more classes.
* `public String toString()`: Returns a string that is the Department abbreviation concatenated with the course number. Ex. if dept is COMPUTERSCIENCE and courseNumber is 1331, the method should return: "CS1331" (without quotes).

## Tips

You should not import any libraries or packages that trivialize the assignment. This includes data structures other than arrays (so no `List`, `Map`, `Set`, etc). If you are unsure of whether something is allowed, ask on Piazza. In general, if something does a large part of the assignment for you, it is probably not allowed. **Important:** `java.util.Arrays` is not allowed. However, that is different from a Java array (e.g `int[] nums = new int[10]`), which is necessary for this assignment.

- Try storing the abbreviation as instance data for the Department enum.
- You may assume that we will not pass in null Objects into to your methods. However, make sure you are not internally passing in any such null objects!
- You may also assume that arguments will be valid, unless specifically otherwise specified in the instructions.
- This assignment has many methods that are dependent on one another. It may help to test them individually, rather than all at once at the end.

## Compiling and Testing Your Code

To compile your code, you need to go to the root directory (the folder hw2) and run `javac registration/*.java utils/*.java`.

We have provided a tester file for hw2. To run the tests, move the [Test.java](Test.java) into the hw2 directory. To compile, open you command prompt and ensure that you are in the root directoy (the hw2 folder). Then, use the command javac registration/*.java utils/*.java *.java to compile your code. To run you code simply use the java Test command. Also, note that passing these test cases will not guarantee that you will get an 100 or not lose any points on the assignment. While this file should help you debug your code, we highly encourage you to look through your own code and do some of your owns tests to ensure it's bug free.

If you wish to test your code by creating a new java file put the test file in the root directory (hw2) and at the top of the test file (above the `public class ...`) include the lines following lines:

`import registration.Course;`
`import registration.Student;`
`import registration.Department;`
`import registration.LectureDays;`
`import registration.LectureTime;`
`import utils.Time;`


Afterwards, to compile this testing file with everything else use `javac registration/*.java utils/*.java *.java`. Afterwards run your test file by using `java testfilename` as you normally would.

## Javadocs

- Starting from this homework, you will need to write Javadoc comments along with checkstyling your submission.

    - Every class should have a class level Javadoc that includes `@author <GT Username>` and `@version <version #>`.

    - Every method should have a Javadoc explaining what the method does and includes any of the following tags if applicable.

        - `@param <parameter name> <brief description of parameter>`

        - `@returns <brief description of what is returned>`

        - `@throws <Exception> <brief explanation of when the given exception is thrown>`

- See the [CS 1331 Style Guide](http://cs1331.gatech.edu/cs1331-style-guide.html) section on Javadoc comments for examples.

## Checkstyle
You must run checkstyle on your submission. The checkstyle cap for this submission is 15 points. In future homeworks we will be increasing this cap, so get into the habit of fixing these style errors early!

A guide for setting up and running checkstyle can be found on [this page on the course website](http://cs1331.gatech.edu/cs1331-style-guide.html). Make sure you click "Save" when downloading the jar file, and not "Run". To run, copy the jar file into the registration folder. Run checkstyle for this assignment with `java -jar checkstyle-6.2.2.jar -a *.java`. This will check for both checkstyle errors and javadoc errors.

## Collaboration with other students
When completing homeworks for CS1331 you may talk with other students about:

- what general strategies or algorithms you used to solve problems in the homeworks
- parts of the homework you are unsure of and need more explanation
- online resources that helped you find a solution
- Key course concepts and Java language features used in your solution

You may **not** discuss, show, or share by other means the specifics of your code, including screenshots, file sharing, or showing someone else the code on your computer, or use code shared by others.

Examples of approved/disapproved collaboration:

- **approved**: "Hey, I'm really confused on how we are supposed to implement this part of the homework. What strategies/resources did you use to solve it?"
- **disapproved**: "Yo it's 10:40 on Thursday... can I see your code? I won't copy it directly I promise"

Collaborating with others in a way that violates the approved means is a Georgia Tech Honor Code violation, and you will also break your TAs hearts :broken_heart:

## Turn-in Procedure

Export the hw2 folder and its contents to a .zip file and submit the .zip file on T-Square as an attachment. Make sure the zip file contains `Course.java`, `Department.java`, `LectureDays.java`, `LectureTime.java`, `Student.java`, and `Time.java`.  When you're ready, double-check that you have submitted and not just saved a draft.

## Verify the Success of Your Submission to T-Square

Practice safe submission! Verify that your HW files were truly submitted correctly, the upload was successful, and that your program runs with no syntax or runtime errors. It is solely your responsibility to turn in your homework and practice this safe submission safeguard.

- After uploading the files to T-Square you should receive an email from T-Square listing the names of the files that were uploaded and received. If you do not get the confirmation email almost immediately, something is wrong with your HW submission and/or your email. Even receiving the email does not guarantee that you turned in exactly what you intended.
- After submitting the files to T-Square, return to the Assignment menu option and this homework. It should show the submitted files.
- Download copies of your submitted files from the T-Square Assignment page placing them in a new folder.
- Re-run and test the files you downloaded from T-Square to make sure it's what you expect.
- This procedure helps guard against a few things.

    - It helps insure that you turn in the correct files.
    - It helps you realize if you omit a file or files. Missing files will not be given any credit, and non-compiling/non-running homework solutions will receive few to zero points. Also recall that late homework will not be accepted regardless of excuse. Treat the due date with respect.  Do not wait until the last minute!
(If you do discover that you omitted a file, submit all of your files again, not just the missing one.)
    - Helps find syntax errors or runtime errors that you may have added after you last tested your code.
