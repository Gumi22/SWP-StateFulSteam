import javafx.util.Pair;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Stack;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class CommandController {

    private String commandPath = "";
    private ArrayList<Pair<String, Command>> myCommandList = new ArrayList<>();
    private Stack<Command> myHistory = new Stack<>();


    public CommandController(){
        ClassLoader loader = CommandController.class.getClassLoader();
        commandPath = loader.getResource("CommandController.class").toString().substring(6, loader.getResource("CommandController.class").toString().indexOf("/CommandController.class"));
        loadCommands(commandPath);
    }


    public boolean executeCommand(String input, Game target){
        boolean foundCommand = false;
        for (Pair<String, Command> p: myCommandList) {
            if(input.equals(p.getKey())){
                foundCommand = true;
                myHistory.push(p.getValue().execute(target));
            }
        }
        return foundCommand;
    }

    public void undoCommand(){
        try{
            myHistory.pop().undo();
        }catch (Exception e){
            //e.printStackTrace();
            System.out.println("Not Possible");
        }
    }

    public void printCommands(){
        for (Pair<String, Command> P: myCommandList
             ) {
            System.out.println(P.getKey());
        }
    }

    public void loadCommands(String path){
        myCommandList.clear();

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();


        for (int i = 0; i < (listOfFiles != null ? listOfFiles.length : 0); i++) {
            if (listOfFiles[i].isFile()) {
                if(listOfFiles[i].getName().endsWith(".jar")){
                    addJarFile(path + "/" + listOfFiles[i].getName());
                }else if (listOfFiles[i].getName().endsWith(".java")){
                    addJavaFile(path + "/" + listOfFiles[i].getName());
                }else if (listOfFiles[i].getName().endsWith(".class")){
                    addClassFile(path + "/" + listOfFiles[i].getName());
                }
            } else if (listOfFiles[i].isDirectory()) {
                loadCommands(path + "/" + listOfFiles[i].getName()); //rekursive adding
            }
        }

    }

    public void add(String name, Command command) {
        myCommandList.add(new Pair<>(name.toLowerCase(), command));
    }

    private void addJavaFile(String s){

        ClassLoader classLoader = CommandController.class.getClassLoader();

        Class commandClass = null;
        try {
            s = s.substring(s.indexOf("Commands")+9, s.indexOf(".java"));
            commandClass = classLoader.loadClass(s);

            if(isClassAValidCommand(commandClass)){
                Object myCommandClass = commandClass.newInstance();
                add(s, (Command)myCommandClass);
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

    }

    private void addJarFile(String s){
        try{
            JarFile jarFile = new JarFile(s);

            Enumeration<JarEntry> e = jarFile.entries();

            URL[] urls = { new URL("jar:file:" + s+"!/") };
            URLClassLoader cl = URLClassLoader.newInstance(urls);

            while (e.hasMoreElements()) {
                JarEntry je = e.nextElement();
                if(je.isDirectory() || !je.getName().endsWith(".class")){
                    continue;
                }
                // -6 because of .class
                String className = je.getName().substring(0,je.getName().length()-6);
                className = className.replace('/', '.');
                addClassFile(cl, className);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void addClassFile(String s){
        try {
            if(!s.substring(s.lastIndexOf("/") +1, s.indexOf(".class")).equals("Command") && !s.substring(s.lastIndexOf("/") +1, s.indexOf(".class")).equals("Makro")){
                addClassFile(URLClassLoader.newInstance(new URL[]{new URL("file:" + s)}), s.substring(s.lastIndexOf("/") +1, s.indexOf(".class")));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private void addClassFile(URLClassLoader cl, String className){
        try{
            Class commandClass = cl.loadClass(className);
            if(isClassAValidCommand(commandClass)){
                Object myCommandClass = commandClass.newInstance();
                add(className, (Command)myCommandClass);
            }
        }catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private boolean isClassAValidCommand(Class commandContestor){
        return Command.class.isAssignableFrom(commandContestor);
    }

}
