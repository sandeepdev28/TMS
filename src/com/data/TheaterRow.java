package com.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing the theater row
 */
public class TheaterRow {

    List<TheaterSection> sections;
    private Integer rowNumber;

    public TheaterRow(Integer rowNumber) {
        this.rowNumber = rowNumber;
        this.sections = new ArrayList<>();
    }

    public void addSection(TheaterSection section) {
        sections.add(section);
    }

    public List<TheaterSection> getSections() {
        return sections;
    }

    public Integer getRowNumber() {
        return rowNumber;
    }
}
