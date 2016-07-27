import java.util.*;
import java.lang.*;
import java.io.*;

public class Git_createset {
    private static List<String> set = new LinkedList<String>();
    public static void main(String[] argv) {
	int count;
	Random rand = new Random();
	try {
	    count = Integer.parseInt(argv[0]);
	}
	catch (Exception e){
	    System.err.println("Usage: count");
	    return;
	}
	for(int i = 0; i < count; i++) {
	    int strlen = rand.nextInt(16) + 8;
	    String str = "";
	    for(int j = 0; j < strlen; j++)
		str += (char)(65 + rand.nextInt(26) + (rand.nextInt(2)*32));
	    set.add(str);
	}

	for(int i = 0; i < count; i++) {
	    System.out.println("Running " + i);
	    create_git(set.get(i));
	}
   
	print_list(set);
	print_to_file(count, set, "test.txt");
    }

    private static void print_to_file(int count, List<String> l, String file) {
	try {
	    for(int i = 0; i < count; i++)
		run("echo " + l.get(i) +" >> " + file);
	}
	catch (Exception e) {
	    System.err.println("Couldn't print to file");
	}
	    
    }
    private static void create_git(String path) {
	try {
	    run("mkdir " + path); 
	    run("cd " + path + " && git init && touch README.md && " + path + "README.md "
		+ "&& git commit -m \"init-"+path+"\"");
	}
	catch (Exception e) { System.err.println(e); }
    }

    static String[] arg_argv(String arg) {
	return new String[] {"/bin/bash", "-c", arg};
    }
    private Random rand = new Random();

    private static List<String> run(String arg) throws Exception {
	String[] argv = arg_argv(arg);
	Runtime rt = Runtime.getRuntime();	
	Process proc = rt.exec(argv);
	String ln;
	BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
	List<String> ls = new LinkedList<String>();
	
	while((ln = in.readLine()) != null)
	    ls.add(ln);
	return ls;
    }
    
    public static void print_list(List<String> strl) {
	for(int i = 0; i < strl.size(); i++) {
	    System.out.print(i + ":  ");
	    System.out.println(strl.get(i));
	}
    }    
}
