package org.example.util;

import org.example.dto.ReportDto;
import org.example.dto.WordStatistic;

public class ReportGenerator {
    public void generateReport(ReportDto report) {
        for (WordStatistic wordStatistic : report.getTopWordStatistic()) {
            System.out.println(wordStatistic.getWord() + " - " + wordStatistic.getOccurence() + " (" + String.format("%.2f", wordStatistic.getPercent()) + (" %)"));
        }

        System.out.println("Egyedi szavak száma: " + report.getUniqueWords());
        System.out.println("Szavak száma: " + report.getWordCount());
    }
}

