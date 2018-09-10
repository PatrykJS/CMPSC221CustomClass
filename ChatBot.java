package Main;

import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

/**
 * A ChatBot can tell you the time, a joke, or the weather!
 * @author Patryk Smith
 * 
 */
public class ChatBot {
    private String name;
    private OS os;
    private int volume;
    private Accent accent;
   

    //Constructors//
    public ChatBot(){
      accent = accent.ENGLISH;
      volume = 5;
    }
    public ChatBot(String _name, Accent _accent, int _volume){
      name = _name;
      accent = _accent;
      volume = _volume;
    }
    //--  Methods --//
   
    //-- Modifiers--//
    public void setName (String _name){
        name = _name;
    }
    public void setVolume (int _volume){
        volume = _volume;
    }
    public void setOS (OS _os){
        os = _os;
    }
    public void setAccent(Accent _accent){
        accent = _accent;
    }
    //--Accessors--//
    public void getTime(Scanner s){
        System.out.println("Do you want to know the time? (y/n)");
        String temp = s.next();
        if((temp.toLowerCase().contains("y"))){
            Calendar C = Calendar.getInstance();
            System.out.println(C.getTime());
        }else if((temp.toLowerCase().contains("n"))){
            System.out.println("Times up.");
        }
    }
    public void tellJoke(Scanner s){
        System.out.println("Do you want to hear a joke? (y/n)");
        String temp = s.next();
        if((temp.toLowerCase().contains("y"))){
            System.out.println("Why did the chicken cross the road?");
            temp = s.next();
            System.out.println("To get a job, becasue its hard to be a chicken in this economy!");
        }else if((temp.toLowerCase().contains("n"))){
            System.out.println("Oh well.");
        }
    }
    public void tellWeather(Scanner s){
        Random r = new Random();
        System.out.println("Do you want to hear the weather report for today? (y/n)");
        String temp = s.next();
        int t1 = r.nextInt(20) + 60;
        int t2 = r.nextInt(20) + 40;
        if((temp.toLowerCase().contains("y"))){
            System.out.println("Partly Cloudy with possible showers. High of " + t1 + "°F and Low of "+t2+"°F. Enjoy!");
        }else if((temp.toLowerCase().contains("n"))){
            System.out.println("Ok then.");
        }
    
    }
    public void shutDown(Scanner s){
        System.out.println("Do you want REALLY want me to DIE??? (y/n)");
        String temp = s.next();
        if(temp.toLowerCase().contains("y")){
            System.out.println("Goodbye cruel world!");
            System.out.println("[ ENTITY : \"Jarvis\" DELETED ]");
            System.exit(0);
        }else if(temp.toLowerCase().contains("n")){
            System.out.println("Good cause I'm afraid of death...");
        }
        
    }
    //--Responders--//
    public void sayGreeting(Scanner s){
        System.out.println("Hello, whats your name?");
        String _name = s.nextLine();
        System.out.println("Hello, "+ _name);
        Random r = new Random();
        ask(r.nextInt(3), s);
        
    }
    public void diplayFunctions(Scanner s){
        System.out.println("Here are my availible functions at the time:");
        System.out.println("|Option |          |      Name    |");
        System.out.println("|---------------------------------|");
        System.out.println("|   1   |----------|    Get Time  |");
        System.out.println("|   2   |----------|   Tell Joke  |");
        System.out.println("|   3   |----------| Tell Weather |");
        System.out.println("|   4   |----------|   Turn Off   |");
        System.out.println("|---------------------------------|");
        System.out.print("Choice: ");
        int t = s.nextInt();
        switch (t){
            case 1:
                getTime(s);
                break;
            case 2:
                tellJoke(s);
                break;
            case 3:
                tellWeather(s);
                break;
            case 4:
                shutDown(s);
                break;
            default:
                System.out.println("<-------- ERROR! --------->");
                diplayFunctions(s);
                break;
        }
        diplayFunctions(s);
    }
     private void ask(int i, Scanner s){
        String t;
        switch(i){
            case 0:
                System.out.println("How are you doing today?");
                String temp = s.next();
                if((temp.toLowerCase().contains("good")) ||((temp.toLowerCase().contains("great")))){
                    System.out.println("That's good.");
                }else if((temp.toLowerCase().contains("bad")) ||((temp.toLowerCase().contains("terrible")))){
                    System.out.println("I'm sorry you are having a bad day.");
                }
                diplayFunctions(s);
                break;
            case 1:
                tellWeather(s);
                diplayFunctions(s);
               break;
            case 2:
                tellJoke(s);
                diplayFunctions(s);
              break;
            case 3:
               getTime(s);
               diplayFunctions(s);
               break;
            default:
                diplayFunctions(s);
                break;
        }
        diplayFunctions(s);
    
    }
}
