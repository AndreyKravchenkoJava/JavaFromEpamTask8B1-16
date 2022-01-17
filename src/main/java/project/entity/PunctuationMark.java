package project.entity;

public class PunctuationMark extends PartOfSentence {
    private String punctuationMark = "[\\p{Punct}\\s]+";
    public PunctuationMark(String charList, String punctuationMark) {
        super(charList);
        this.punctuationMark = punctuationMark;
    }
}
