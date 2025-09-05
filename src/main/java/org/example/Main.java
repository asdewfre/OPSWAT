package org.example;

import org.example.dto.ReportDto;
import org.example.util.TextAnalyzer;
import org.example.util.FileReader;
import org.example.util.ReportGenerator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String path = "src/main/resources/example.txt";

        FileReader fileReader= new FileReader();
        List<String> lines = fileReader.getLines(path);

        TextAnalyzer textAnalyzer = new TextAnalyzer();
        ReportDto analysisResult = textAnalyzer.analyze(lines,5, true);

        ReportGenerator reportGenerator = new ReportGenerator();
        reportGenerator.generateReport(analysisResult);
    }


}