package movieData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

class linkedList {public String a;public int b;public linkedList c;public linkedList(String d, int e){this.a=d;this.b=e;this.c=null;}}

public class main {

    private static String[] inputFiles = {"data-file1.txt", "data-file2.txt", "data-file3.txt", "data-file4.txt"};

    public static HashMap<String, ArrayList<Integer>> shuffle(ArrayList<ArrayList<linkedList>> b) { HashMap<String, ArrayList<Integer>> c = 
        new HashMap<>(); for (ArrayList<linkedList> d : b) { for (linkedList e : 
            d) { if (c.containsKey(e.a)) { c.get(e.a).add(e.b); 
            } else { ArrayList<Integer> f = new ArrayList<>(); f.add(e.b); 
                c.put(e.a, f); } } } return c; }


    public static ArrayList<linkedList> map(List<String> b){ArrayList<linkedList> c=new ArrayList<>();
        for(String d:b){if(c.size()==0){
            linkedList e=new linkedList(d,1);c.add
            (e);}else
            {c.add(new linkedList(d,1));}}return c;}

    public static List<String> split(String b) { List<String> c = new ArrayList<>(); 
        try { File d = new File(b); BufferedReader e = 
            new BufferedReader(new FileReader(d)); String f; 
            while ((f = e.readLine()) != null) 
            { String[] g = f.split(" "); for (String h : g) 
            { h = h.replaceAll("[^a-zA-Z]", ""); c.add(h); } 
        } } catch (IOException i) 
        { i.printStackTrace(); } 
        return c; }
    
    public static ArrayList<linkedList> reduce(HashMap<String, ArrayList<Integer>> b) {ArrayList<linkedList> c = new ArrayList<>();
        for (Map.Entry<String, ArrayList<Integer>> d : b.entrySet())
        {
            int e = 0;for (int f : d.getValue()){e += f;}c.add(new linkedList(d.getKey(), e));}
        return c;}

        public static void main(String[] a) {
            List<String> b = split(inputFiles[0]);List<String> c = split(inputFiles[1]);List<String> f = split(inputFiles[2]);List<String> g = split(inputFiles[3]);
            System.out.println(b);System.out.println(c);System.out.println(f);System.out.println(g);System.out.println("------");
            ArrayList<linkedList> h = map(b);
            ArrayList<linkedList> j = map(c);
            ArrayList<linkedList> k = map(f);
            ArrayList<linkedList> l = map(g);
            ArrayList<ArrayList<linkedList>> m = 
            new ArrayList<>();
            m.add(h);m.add(j);m.add(k);m.add(l);
            for (ArrayList<linkedList> n : m)
            {for (linkedList o : n) 
                {System.out.print(o.a + " " + o.b + " ");
            }
            System.out.println("\n------");}
            HashMap<String, ArrayList<Integer>> p = shuffle(m);
            System.out.println(p);
            ArrayList<linkedList> r = reduce(p);
            for (linkedList t : r)
            {System.out.print(t.a + " " + t.b + " ");}}}
            
