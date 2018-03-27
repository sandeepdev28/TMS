package com.data;

public class TheaterSection {

    private Integer sectionNum;
    private Integer vacancies;

    public TheaterSection(Integer sectionNum, Integer vacancies) {
        this.sectionNum = sectionNum;
        this.vacancies = vacancies;
    }

    public void reserve(Integer partySize) {
        vacancies = vacancies - partySize;
    }

    public boolean canFit(Integer partySize) {
        return vacancies > partySize ? true : false;
    }

    public Integer getVacancies() {
        return vacancies;
    }

    public Integer getSectionNum() {
        return sectionNum;
    }
}
