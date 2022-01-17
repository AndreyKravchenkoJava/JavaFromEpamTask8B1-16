package project.entity;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements Comparable<Sentence> {
    private static final String SPLITTER_OF_PART = "(?<!^)\\b";
    PunctuationMark punctuationMark;
    private List<PartOfSentence> partOfSentenceList = new ArrayList<>();

    public Sentence(String sentence) {
        parseForPartsOfSentence(sentence);
    }

    private void parseForPartsOfSentence(String sentence) {
        for (String str : sentence.split(SPLITTER_OF_PART)) {
            if (str.matches(String.valueOf(punctuationMark)) || str.isEmpty()) {
                partOfSentenceList.add(new PartOfSentence(str));
            } else {
                partOfSentenceList.add(new Word(str));
            }
        }
    }

    public int getNumberOfWord() {
        return partOfSentenceList.size();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (PartOfSentence part : partOfSentenceList) {
            result.append(part.toString());
        }
        return result.toString();
    }

    @Override
    public int compareTo(Sentence other) {
        return this.getNumberOfWord() - other.getNumberOfWord();
    }
}
