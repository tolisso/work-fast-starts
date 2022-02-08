package ru.diasoft;


import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedWriter r = Files.newBufferedWriter(Paths.get("output.txt"));
    try {
      r.write("1");
      r.write("2");
      r.write("3");
      throw new Exception();
    } catch (IOException exc) {
      System.out.println("IOException: " + exc.getMessage());
    } catch (Exception exc) {
      System.out.println("Exception: " + exc.getMessage());
    } finally {
      r.close();
    }
  }
}
