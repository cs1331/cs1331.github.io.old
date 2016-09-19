---
layout: default
title: CS 1331 - Customization Tips
---

# Customization Tips

Professor Simpkins keeps his [dotfiles on GitHub](https://github.com/csimpkins/dotfiles)

## bash

These go in your `~/.bash_profile`.

        # My prompt string, which you see when I demonstrate in the terminal
        export PS1="\[\033[32;1m\][\u@\h \w]\n$ \[\033[0m\]"

        # Aliases to save some typing
        alias ll='ls -la'

        # A personal bin directory
        export PATH=~/bin:$PATH

## Checkstyle Script

Download [checkstyle-6.2.2.jar](resources/checkstyle-6.2.2.jar) to your `~/bin` directory. Create a file named `checkstyle` in your `~/bin` directory with the following contents:

        #!/usr/bin/env bash

        java -jar ~/bin/checkstyle-6.2.2.jar "$@"

Then make it executable:

        $ cd bin
        $ chmod +x checkstyle

Now you can run checkstyle on any Java file like this:

        $ checkstyle Foo.java
        Audit done. Errors (potential points off):
        0

## Atom

First, be sure to familiarize yourself with basic Atom usage.  The [Getting Started](https://atom.io/docs/v0.124.0/getting-started) guide is enough to make you quite proficient.
In Atom Preferences, make sure the following are checked:

  - _Show Indent Guide_ draws a vertical line at your preferred line length column in editors.  Preferred line length should be set to 80.
  - _Show Invisibles_ draws greyed-out characters for spaces, TABs, hard returns.
  - _Show Line Numbers_ displays line numbers in the left gutter in editors.  Personal preference, but I find it useful.
  - _Soft Tabs_ causes the editor to insert spaces instead of TAB characters when you hit the TAB key.
  - _Soft Wrap_ wraps lines visually on word boundaries.  Together with _Show Line Numbers_ you get readable text and can still easily tell long single lines.
  - _Soft Wrap at Preferred Line Length_ wraps lines visually on word boundaries at your preferred line length.

## Sublime Text

To make Sublime Text always use spaces instead of tabs, add the following lines to your user settings under preferences:

        {
            "tab_size": 4,
            "translate_tabs_to_spaces": true,
            "rulers": [80],
            "trim_trailing_white_space_on_save": true
        }
