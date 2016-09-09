# CS 1331 - Introduction to Object-Oriented Programming

This repository contains the [Jekyll](http://jekyllrb.com/) source of the public web site for [Chris Simpkins](https://github.com/csimpkins)'s sections of CS 1331 at Georgia Tech.

# Slides

We're slowly migrating to producing Reveal.js slides with Markdown sources. We use [Pandoc](http://pandoc.org/) to  [produce the slides](http://pandoc.org/README.html#producing-slide-shows-with-pandoc)

To recompile all slides:

```sh
cd slides
for file in `ls *.md`; do pandoc -s --mathjax -t revealjs -V theme=gt -V "slideNumber='c/t'" -V progress=true -o $(basename $file .md).html $file; done
```
