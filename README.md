# CS 1331 - Introduction to Object-Oriented Programming

This repository contains the [Jekyll](http://jekyllrb.com/) source of the public web site for [Chris Simpkins](https://github.com/csimpkins)'s sections of CS 1331 at Georgia Tech.

To run this site locally you'll need to follow [GitHub's instructions](https://help.github.com/articles/setting-up-your-github-pages-site-locally-with-jekyll/), which is basically means installing ruby-bundler on your system since the Gemfile is already in this repository. Since some of the gems used by GitHub pages depend on nativce extensions you'll need to install several things on your system. On Ubuntu:

```
sudo apt-get install ruby-dev zlib1g-dev liblzma-dev
```

# Slides

Some slides are HTML Reveal.js slides produced from Markdown sources. Source files use a `.md` ending. We use [Pandoc](http://pandoc.org/) to  [produce the slides](http://pandoc.org/README.html#producing-slide-shows-with-pandoc)

To recompile all slides:

```sh
cd slides
for file in `ls *.md`; do pandoc -s --mathjax -t revealjs -V theme=gt -V "slideNumber='c/t'" -V progress=true -o $(basename $file .md).html $file; done
```

Some slides are PDFs produced from LaTeX Beamer sources. Source files use a `.tex` ending.

As of Fall 2016 I'm moving to PDF slides produced from org-mode sources (with a `.org` ending). Students seem to prefer having printable copies (and the print CSS from Reveal.js doesn't always produce nice results), I like not having upstream changes to Reveal.js and Mathjax suddenly break my slides, and using org-mode gives me succinct source syntax like Markdown with the power of LaTeX/Beamer. Go Emacs!