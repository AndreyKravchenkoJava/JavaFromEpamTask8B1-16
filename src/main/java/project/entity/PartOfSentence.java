package project.entity;

import java.util.ArrayList;
import java.util.List;

public class PartOfSentence {
    private List<Symbol> symbolList = new ArrayList<>();

    public PartOfSentence(String charList) {
        parseForSymbols(charList);
    }

    private void parseForSymbols(String charList) {
        for (char ch : charList.toCharArray()) {
            symbolList.add(new Symbol(ch));
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Symbol symbol : symbolList) {
            result.append(symbol.toString());
        }
        return result.toString();
    }
}
