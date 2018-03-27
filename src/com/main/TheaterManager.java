package com.main;

import com.data.TheaterRow;
import com.data.TheaterSection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TheaterManager {

    private List<TheaterRow> rows;
    private Integer vacancies = 0;
    private List<String> rowStrings;

    public TheaterManager( List<String> rowStrings) {
        rows = new ArrayList<>();
        for (int i=0; i< rowStrings.size(); i++) {
            addRow(parseRow(rowStrings.get(i),i+1));
        }
    }

    private TheaterRow parseRow(String rowString, int rowNumber) {

        TheaterRow row = new TheaterRow(rowNumber);
        List<String> sectionList = Arrays.asList(rowString.split(" "));
        for(int i = 0; i < sectionList.size(); i++) {
            int sectionInt = Integer.parseInt(sectionList.get(i));
            row.addSection(new TheaterSection(i+1, sectionInt));
            this.vacancies = vacancies + sectionInt;
        }
        return row;
    }

    private void addRow(TheaterRow row) {
        this.rows.add(row);
    }

    public String reserve(Integer partySize) {

        for(TheaterRow row : rows) {
            for(TheaterSection section: row.getSections()) {
                if(section.canFit(partySize)) {
                    section.reserve(partySize);
                    vacancies = vacancies - partySize;
                    return "Row " + row.getRowNumber()+ " Section " + section.getSectionNum();
                }
            }
        }
        if (partySize < this.vacancies) {
            return "Call to Split party.";
        }
        return "Can't handle your party";
    }
}
