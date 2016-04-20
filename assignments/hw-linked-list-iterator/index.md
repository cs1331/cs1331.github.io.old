---
title: hw-linked-list-iterator
---

# MyLinkedList
<hr>
<br>
[Download Zip](...)
<br>
## Problem Description
Add an Iterator to the given class `MyLinkedList` and implement the `iterator()` method in that class. For reference, a linked list is a list that consists of nodes that contain data and a reference to the next node in a list. Since each node points to a specific following node, a linked list maintains order. For a more detailed description of linked lists, [see this page](https://en.wikipedia.org/wiki/Linked_list).


## Solution Description

### MyLinkedList
- The MyLinkedList.java file is a class where everything has been provided to you apart from an Iterator and the implementation of the `iterator()` method. It contains everything that should be completed to finish this assignment.
- All methods apart from `iterator()` should *not* be modified.
- You should implment the following:
    - Add an inner class (or anonymous inner class) to `MyLinkedList` that implements the `Iterator<T>` interface.
    - Modify the `iterator()` method in `MyLinkedList` to return a new instance of your Iterator.
    - Your `Iterator` should at minimum implement the `hasNext()` and `next()` methods of the `Iterator<T>` interface.
    - Implementing the `remove()` method is optional, but worth extra points!

### Node
- This inner class should not be modified.
- An inner class for nodes, `Node<T>`, is also included in the MyLinkedList.java file.
- This class contains the following methods
   - `public Node(T data)` is the constructor for a Node given only a value.
   - `public Node(T data, Node next)` is a constructor for a Node given a value and a reference to the next node.
   - `public Node<T> getNext()` returns the node that the current Node points to.
   - `public void setNext(Node next)` sets the current node to point to the specified Node.
   - `public T getData()` returns the data stored in the current Node.
   - `public void setData(T data)` sets the data of the Node

### Tips

Here are some general tips for this assignment!
- Remember how anonymous inner classes can be used to implement interfaces.
- The Iterator interface requires you to implement `hasNext()` and `next()`. Think about how this applied to linked lists.

## Grading
- This homework differs from previous homeworks in that it has the command `gradle -q grade`.
- This command will run the given tests and show you how many points (out of 65) you've earned.
- If this command fails, you must make sure your code compile and if it does, you've managed to do something the tests didn't account for so look into what you're doing carefully.
- You can earn up to 65 points on this assignment.
- If you fail some tests and would like more detail, there should be a nice HTML report located in `hw-linked-list-iterator/build/reports/tests/index.html` if this is not there, rerun the `gradle -q grade` command and it should appear.
- The output of this command is how you will be graded! So make sure you are showing as having as many points as you can manage! Remember to run `gradle -q checkstyle`, becuase you will still lose points even if you pass all the tests but have checkstyle errors.


<hr>

## Submission

You will need to have [gradle version 2.10+](http://gradle.org/gradle-download/) installed to submit your homework. Once you have it installed, submit your assignment by running from the root of your homework directory:

```bash
gradle -q submit
```

Remember to check that your files were submitted successfully! They will be located in a repository on your github.gatech.edu account with the name hw-coin-collection after you have submitted them. You can submit as many times as you want, we will take your last submission prior to the time the assignment is due. Also note that java source files will appear inside `src/main` on GitHub - this is normal, just click on the folder name to be taken to your submitted java source files.


## Grading

###Files to Submit

This assignment will require that all files in your `src/main/java` directory are submitted. *If you have extra files that you don't use, but are submitted and do not compile, you will receive a zero!*

### Checkstyle
- Run checkstyle from the root directory of your homework using the following command:

```bash
gradle -q checkstyle
```

- Cap for this assignment:
    - **65** Points

### Remember!

**Submissions that do not compile will receive a zero!**

This means the entire submission. Make sure every Java file that is submitted compiles successfully!
