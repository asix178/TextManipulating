package org.example;

import org.apache.commons.lang3.time.StopWatch;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.example.SortingMethods.*;

public class Main {
    static String ChangeText(String InputFile, String OutputFile){
        Path InputFilePath = Path.of(InputFile);
        try {
            String Text = Files.readString(InputFilePath);
            Text = Text.replaceAll("\\p{Punct}",""); //usuwam znaki przestankowe
            Text = Text.replace("\n",""); //usuwam przejscia do nowej linii
            Text = Text.replace("\r","");
            Text = Text.replace("\t",""); //usuwam tab
            Text = Text.replace("’",""); //moj tekst ma bardzo dziwne znaki :c
            Text = Text.replace("“","");
            Text = Text.replace("”","");
            Text = Text.replace("‘","");
            Text = Text.replace("¬","");
            Text = Text.toLowerCase();
            Path OutputFilePath = Path.of(OutputFile);
            Files.writeString(OutputFilePath,Text, StandardCharsets.UTF_8);
            return Text;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        String Text = ChangeText("Murder_on_the_Orient_Express.txt", "Changed_Murder.txt");

        stopWatch.start();
        CountFoursWithHashTable(Text);
        stopWatch.stop();
        System.out.println("Elapsed time[ms]: " + stopWatch.getTime());
        stopWatch.reset();

        stopWatch.start();
        CountFoursWithHashMap (Text);
        stopWatch.stop();
        System.out.println("Elapsed time[ms]: " + stopWatch.getTime());
        stopWatch.reset();

        stopWatch.start();
        CountFoursWithArrayList(Text);
        stopWatch.stop();
        System.out.println("Elapsed time[ms]: " + stopWatch.getTime());
        stopWatch.reset();

        stopWatch.start();
        CountFoursWithStreams(Text);
        stopWatch.stop();
        System.out.println("Elapsed time[ms]: " + stopWatch.getTime());
        stopWatch.reset();
    }
}