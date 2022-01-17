package project.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Text {
    private String text;
    private List<Sentence> sentenceList = new ArrayList<>();
    private final static String WHITESPACE = " ";
    public static final String SPLITTER_OF_SENTENCE = "(?<=[A-Za-z0-9А-Яа-я](\\.|\\?|\\!|\\.\\.\\.))\\s+(?=[A-ZА-Я])";

    public Text(Book book) {
        this.text = removeDuplicateSpace(book.getText());
        parseForSentence(text);
    }

    private void parseForSentence(String text) {
        for (String s : text.split(SPLITTER_OF_SENTENCE)) {
            this.sentenceList.add(new Sentence(s));
        }
    }

    private String removeDuplicateSpace(String text) {
        return text.replaceAll("\\s+", WHITESPACE);
    }

    public void sort() {
        Collections.sort(sentenceList);
    }

    public void sortByAlphabet() {
        String[] words = text.split("\\s+");
        Arrays.sort(words);
        for (String word : words) {
            System.out.print(word + ", ");
        }
    }

    public void deleteWord() {
        String text2 = text.replaceAll("\\b\\w{5,5}\\b", "");
        System.out.println(text2);
    }

    public void replaceWord() {
        String text2 = String.valueOf(sentenceList.get(6));
        System.out.println(text2.replaceAll("\\b\\w{5,5}\\b", "Мечтатель"));
    }

    public void replaceFirstWordLastWord() {
        String[] sentence = text.split("[\\\\!|\\\\.|\\\\?]\\\\s?");
        String[] sentenceResult = new String[sentence.length];

        for (int i = 0; i < sentence.length; i++) {
            sentenceResult[i] = sentence[i].trim().replaceAll("(?U)^(\\w+)(.*)(\\b\\w+)([.?!]?$)", "$3$2$1$4");
        }

        for (String s : sentenceResult) {
            System.out.println(s);
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Sentence sentence : sentenceList) {
            result.append(sentence).append(WHITESPACE);
        }
        return result.toString();
    }
}
