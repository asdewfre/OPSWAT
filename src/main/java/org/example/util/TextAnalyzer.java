package org.example.util;

import org.example.dto.ReportDto;
import org.example.dto.WordStatistic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextAnalyzer {
    public ReportDto analyze(List<String> lines, Integer topX,Boolean isCaseSensitive) {

        ReportDto result = new ReportDto();
        Map<String, Integer> allWorlds = new HashMap<>();
        int uniqueWorlds;
        int wordCount = 0;
        for (String origLine : lines) {
            String line = origLine.replaceAll("[^a-zA-Z\\s]", "");
            if(isCaseSensitive != null && !isCaseSensitive ) {
                line = line.toLowerCase();
            }
            System.out.println(line);
            String [] words= line.split("\\s+");
            for (String word : words) {
                wordCount++;
                if (!word.isEmpty()) {
                    allWorlds.put(word, allWorlds.getOrDefault(word, 0) + 1);
                }
            }
        }
        if (allWorlds.isEmpty()){
            uniqueWorlds = 0;
        }else {
            uniqueWorlds = allWorlds.size();
        }

        // get top x words
        List<Map.Entry<String, Integer>> top = allWorlds.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(topX)
                .toList();
        //creating response for generator
        List<WordStatistic> wordStatistics = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : top) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            WordStatistic wordStatistic = new WordStatistic();
            wordStatistic.setWord(key);
            wordStatistic.setOccurence(value);
            wordStatistic.setPercent(value.floatValue()/wordCount*100);
            wordStatistics.add(wordStatistic);

        }
        result.setUniqueWords(uniqueWorlds);
        result.setWordCount(wordCount);
        result.setTopWordStatistic(wordStatistics);
        return result;
    }
}

