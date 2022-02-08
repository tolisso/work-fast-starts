package ru.diasoft;


import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

  public static void main(String[] args) throws IOException {
    Reader r = null;
    try {
      r = Files.newBufferedReader(Paths.get("aba"));
    } catch (IOException exc) {
      System.out.println("IOException: " + exc.getMessage());
    } finally {
      // r.close() throws IOException, main can do so
      r.close();
    }
  }
}
