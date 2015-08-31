# CS 1331 - Introduction to Object-Oriented Programming

This repository contains the [Jekyll](http://jekyllrb.com/) source of the public web site for [Chris Simpkins](https://github.com/csimpkins)'s sections of CS 1331 at Georgia Tech.

# Slides

Slide source is in Markdown. We use [Pandoc](http://pandoc.org/) to  [produce the slides](http://pandoc.org/README.html#producing-slide-shows-with-pandoc)

```sh
$ cd slides
$ pandoc -s --mathjax -t revealjs slides.md -o slides.html -V theme=white
```
