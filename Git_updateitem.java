import java.util.*;
import java.lang.*;
import java.io.*;

public class Git_updateitem {
    public static void main(String[] args) {


    }
    public static void update(String dir, String user, String password) {
	

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