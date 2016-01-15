# CS 1331 - Introduction to Object-Oriented Programming

This repository contains the [Jekyll](http://jekyllrb.com/) source of the public web site for [Chris Simpkins](https://github.com/csimpkins)'s sections of CS 1331 at Georgia Tech.

# Slides

We're slowly migrating to producing Reveal.js slides with Markdown sources. We use [Pandoc](http://pandoc.org/) to  [produce the slides](http://pandoc.org/README.html#producing-slide-shows-with-pandoc)

```sh
$ cd slides
$ pandoc -s --mathjax -t revealjs -V theme=gt -V slideNumber=true -V progress=true -o values-variables.html values-variables.md

```
