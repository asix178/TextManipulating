package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortingMethods {
    //liczenie za pomoca hashmapy
    public static HashMap<String,Integer> CountFoursWithHashMap(String Text){
        int BeginIndex = 0;//poczatek czworki
        int EndIndex = 4;//koniec czworki
        int EndText = Text.length();
        HashMap<String,Integer> Fours = new HashMap<>();
        while (EndIndex != EndText){
            String Four = Text.substring(BeginIndex,EndIndex);
            if(Fours.containsKey(Four)){//jesli w hashmapie mamy juz klucz
                Fours.put(Four,Fours.get(Four)+1); //wyciagamy wartosc z uzyciem klucza Four i zwiekszamy o jeden
            }
            else{
                Fours.put(Four,1);//jesli wystepuje pierwszy raz dodajemy do hashmapy
            }
            BeginIndex++;
            EndIndex++;
        }
        return Fours;
    }

    //liczenie za pomoca listy - wyniki w formie hashmapy (ponizej)
    public static  HashMap<String,Integer> CountFoursWithArrayList(String Text){
        int BeginIndex = 0;//poczatek czworki
        int EndIndex = 4;//koniec czworki
        int EndText = Text.length();
        ArrayList<String> Fours = new ArrayList<>();
        ArrayList<Integer> FoursNumber = new ArrayList<>();
        while (EndIndex != EndText){
            String Four = Text.substring(BeginIndex,EndIndex);
            Fours.add(Four);
            BeginIndex++;
            EndIndex++;
        }
        Collections.sort(Fours);//alfabetyczne sortowanie listy
        HashMap<String,Integer> FoursOccurences = new HashMap<>(); //mapa do przechowania ilosci wystapien czworki
        for(String Walker: Fours){
            if(FoursOccurences.containsKey(Walker)){
                FoursOccurences.put(Walker,FoursOccurences.get(Walker)+1);
            }
            else{
                FoursOccurences.put(Walker,1);
            }
        }
        return FoursOccurences;
    }

    //liczenie za pomoca strumieni(zapisywanie czworek lista)
    public static Map<String,Long> CountFoursWithStreams(String Text){
        int BeginIndex = 0;//poczatek czworki
        int EndIndex = 4;//koniec czworki
        int EndText = Text.length();
        ArrayList<String> Fours = new ArrayList<>();
        while (EndIndex != EndText){
            String Four = Text.substring(BeginIndex,EndIndex);
            Fours.add(Four);
            BeginIndex++;
            EndIndex++;
        }
        return Fours.stream()
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));
    }
}
