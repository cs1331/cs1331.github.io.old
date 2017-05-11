# CS 1331 - Introduction to Object-Oriented Programming

This repository contains the [Jekyll](http://jekyllrb.com/) source of the public web site for [Chris Simpkins](https://github.com/csimpkins)'s sections of CS 1331 at Georgia Tech.

To run this site locally you'll need to follow [GitHub's instructions](https://help.github.com/articles/setting-up-your-github-pages-site-locally-with-jekyll/), which is basically means installing ruby-bundler on your system since the Gemfile is already in this repository. Since some of the gems used by GitHub pages depend on nativce extensions you'll need to install several things on your system. On Ubuntu:

```
sudo apt-get install ruby-dev zlib1g-dev liblzma-dev
```

## Generating the Schedule

I use my own [course tools](https://github.com/csimpkins/course-tools) to generate the schedule each semester. At the beginning of the semester, create a file containing the breaks. For example, `summer2017-breaks.json` (note that all dates are in [ISO 8601](https://xkcd.com/1179/) format):

```js
{
    "2017-05-29": "Memorial Day",
    "2017-07-03": "Independence Day Break",
    "2017-07-04": "Independence Day Break"
}
```

Then run `make_schedule.py` to generate a starter schedule like this:

```sh
make_schedule.py -f 2017-05-15 -l 2017-07-25 -d TR -b summer2017-breaks.json -c cs1331.json -o cs1331.summer2017
```

This will create a file named `cs1331.summer2017` with contents like:

```
Week 1
2017-05-16;intro-cs1331
2017-05-18;intro-java
Week 2
2017-05-23;values-variables
2017-05-25;programs-methods
```

You'll need to customize this file, especially for summer semesters. For the rest of the semester, you'll update the schedule by modifying this file and running `render_schedule.py` like this:

```sh
render_schedule.py -s cs1331.summer2017 -c cs1331.json -t summer2017.html.jinja2 -o summer2017.html
```

Which creates the `summer2017.html` file. (Remember to update the redirect in [`schedule.html`](schedule.html) to point to the new file at the beginning of the semester.)

If you wish, you can use a custom course materials file instead of [`cs1331.json`](cs1331.json).

### Adding Materials and Reminders

To add materials, edit the schedule file, e.g., [`cs1331.summer2017`](cs1331.summer2017) and add text to the third field. For example (note that fields are separated with semicolons, items within fields are separated with commas):

```
Week 1
2017-05-16;intro-cs1331,intro-java, values-variables;[T-Square Site](https://t-square.gatech.edu/portal/site/gtc-b435-1ace-5039-bb99-451228e2b767)
2017-05-18;control-structures, programs-methods
```

To add reminders, such as homework links, add text to the fourth field. Note that if the third field is empty, you'll have what appears to be an extra `;`. For example (note the line for 2017-05-23):

```
Week 1
2017-05-16;intro-cs1331,intro-java, values-variables; [T-Square Site](https://t-square.gatech.edu/portal/site/gtc-b435-1ace-5039-bb99-451228e2b767);[HW0 Assigned](summer2017/hw0/hw0.html)
2017-05-18;control-structures, programs-methods
Week 2
2017-05-23;arrays;;[HW0 Due](summer2017/hw0/hw0.html)
2017-05-25;data-abstraction, classes
```

Note you can make links using the Markdown `[link text](link target)` syntax.

Be sure to commit any changes to the schedule file, schedule template, and schedule to the repo.

## Slides

Some slides are HTML Reveal.js slides produced from Markdown sources. Source files use a `.md` ending. We use [Pandoc](http://pandoc.org/) to  [produce the slides](http://pandoc.org/README.html#producing-slide-shows-with-pandoc)

To recompile all slides:

```sh
cd slides
for file in `ls *.md`; do pandoc -s --mathjax -t revealjs -V theme=gt -V "slideNumber='c/t'" -V progress=true -o $(basename $file .md).html $file; done
```

Some slides are PDFs produced from LaTeX Beamer sources. Source files use a `.tex` ending.

As of Fall 2016 I'm moving to PDF slides produced from org-mode sources (with a `.org` ending). Students seem to prefer having printable copies (and the print CSS from Reveal.js doesn't always produce nice results), I like not having upstream changes to Reveal.js and Mathjax suddenly break my slides, and using org-mode gives me succinct source syntax like Markdown with the power of LaTeX/Beamer. Go Emacs!