package project;

import project.entity.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Run {
    private static Logger log = LogManager.getLogger(Run.class.getName());
    public static void main(String[] args) {
        log.info("App started");
        Text text = new Text(new Book("Text", "UTF8"));
        System.out.println(text);
        text.sort();
        System.out.println("---------------------------------------");
        System.out.println(text);
        System.out.println("----------------------------------------");
        text.sortByAlphabet();
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
        text.deleteWord();
        System.out.println("----------------------------------------");
        text.replaceWord();
        System.out.println("----------------------------------------");
        text.replaceFirstWordLastWord();
        log.info("App stopped");
    }
}
