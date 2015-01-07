#!/usr/bin/env scala

import java.io.FileWriter
import scala.io.Source

/**
 * Reads the file named in the first command-line argument, assumed to be in
 * iTunes plain text playlist export format, and writes an output file named by
 * appending "-culled" to the basename of the input file. The ouput file
 * contains only the name, artist, album, and track number fields from the
 * input file.
 */

val basename = args(0).substring(0, args(0).lastIndexOf("."))
val extension = args(0).substring(args(0).lastIndexOf("."))
val out = basename + "-culled" + extension
val outFile = new FileWriter(out)
for { line <- Source.fromFile(args(0)).getLines
      fields = line.split("\t")
      // Include only name, artist, album, and track number fields in output
      outputFields = Array(fields(0), fields(1), fields(3), fields(10))
} outFile.write(outputFields.mkString("\t") + System.lineSeparator())
outFile.close()
