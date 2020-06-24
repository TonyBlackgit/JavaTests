//: io/MemoryInput.java
package com.IDEA.example; /* Added by Eclipse.py */

import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {
  public static void main(String[] args)
  throws IOException {
    StringReader in = new StringReader(
      BufferedInputFile.read("F:\\IdeaProjects\\HelloWorld\\src\\com\\IDEA\\example\\MemoryInput.java"));
    int c;
    while((c = in.read()) != -1)
      System.out.print((char)c);

  }
} /* (Execute to see output) *///:~
