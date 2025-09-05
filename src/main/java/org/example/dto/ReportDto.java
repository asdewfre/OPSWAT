package org.example.dto;

import java.util.List;

public class ReportDto {
    private Integer wordCount;
    private Integer uniqueWords;
    private List<WordStatistic> topWordStatistic;


    public Integer getWordCount() {
        return wordCount;
    }

    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
    }

    public Integer getUniqueWords() {
        return uniqueWords;
    }

    public void setUniqueWords(Integer uniqueWords) {
        this.uniqueWords = uniqueWords;
    }

    public List<WordStatistic> getTopWordStatistic() {
        return topWordStatistic;
    }

    public void setTopWordStatistic(List<WordStatistic> topWordStatistic) {
        this.topWordStatistic = topWordStatistic;
    }
}
