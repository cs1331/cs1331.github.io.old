---
layout: default
title: CS 1331 - Text Editors
---

#Introduction to Text Editors for Young Programmers

![http://xkcd.com/208/](http://imgs.xkcd.com/comics/regular_expressions.png)

Text is the raw material of the craft of programming.  You should become good at manipulating text.  The first thing you should do is pick a good cross-platform text editor and learn it well.  If you haven't already done so, this guide will help you choose one.  The next thing you should do is learn regular expressions, and the next thing after that is learn UNIX and one of its command shells, probably bash.</p>

#Choosing a text editor

![http://xkcd.com/378/](http://imgs.xkcd.com/comics/real_programmers.png)


I used [Emacs](http://www.gnu.org/software/emacs/) for years, then tried [Atom](https://atom.io/), then switched back to Emacs.  I've also tried [Vim](http://www.vim.org/) and know basic vi, but nothing beats Emacs.  If you can't get used to Emacs or Vim, Atom or SublimeText are good choices. [Atom](https://atom.io/)'s user interface is almost a complete clone of [Sublime Text](http://www.sublimetext.com/), which is a good thing, but [Atom](https://atom.io/) uses much different technology, and is free and open source.

Many people who insist on using Windows like [Notepad++](http://notepad-plus-plus.org/), but [Atom](https://atom.io/) or [Sublime Text](http://www.sublimetext.com/) are much better. As a computer science major you will use Unix during your studies, and if you're currently a Windows user you will almost certainly switch to a Unix (like Linux or Mac OS X) for your personal computing after learning more about computing.  So get in the habit of strongly preferring cross-platform software (yeah, I know, games -- that's what dual-booting is for).

If you're going to get a computer science or engineering degree, I recommend that you learn [Emacs](http://www.gnu.org/software/emacs/) or [Vim](http://www.vim.org/), because they can be used in a terminal window and are available on every UNIX platform, Windows, and Mac.

#Customizing your text editor
Having a go-to text editor improves your productivity in part because it will be set up with your preferred defaults.  Customization is important because many text editors and IDEs are configured with bad defaults.  Good programmers insist on writing code that is clear and consistently formatted.  Having a well-configured text editor helps you do that.

If you're running Mac OS X, my [dotfiles](https://github.com/csimpkins/dotfiles) will give you a big head start on your Emacs configuration and your general configuration.

##TABS Versus Spaces

Never use TABs in source code.  Always indent with spaces.  The traditional meaning of TAB is to move the cursor to the next multiple of tab width (8 by the Java spec).  If you adopt, as most programming teams do, the convention of using spaces for all indentation and alignment (no TAB characters anywhere), then "tabbing" means inserting the required number of spaces to get to a multiple of tab width.  Since the Java code convention doesn't specify whether TAB characters or spaces are used for indentation, and that indentation should be 4 spaces, and that tabs be set every 8 spaces, it allows for an absurd case where a programmer using a feature-poor editor would be forced to hit the space bar 4 times when indenting to the first level of indentation.  Of course modern editors take care of these sorts of details, but most programmers completely eschew TAB characters to avoid such issues and to ensure that code looks consistent in any editor or display no matter how the tabs are set.  And most programmers set their editors to insert spaces for tabs.  Jamie Zawinski, a famous Emacs, Mozilla and Netscape hacker, has an informative write-up here: [http://www.jwz.org/doc/tabs-vs-spaces.html](http://www.jwz.org/doc/tabs-vs-spaces.html)
