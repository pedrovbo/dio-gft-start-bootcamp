package com.pedrovbo.emprestimolivros.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "LOANS")
public class Loan implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private int deadline;
    private LocalDate startdate;
    private LocalDate enddate;
    private static List<Book> bookOnLoan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public LocalDate getStartdate() {
        return startdate;
    }

    public void setStartdate(LocalDate startdate) {
        this.startdate = startdate;
    }

    public LocalDate getEnddate() {
        return enddate;
    }

    public void setEnddate(LocalDate enddate) {
        this.enddate = enddate;
    }

    public static List<Book> getBookOnLoan() {
        return bookOnLoan;
    }

    public static void setBookOnLoan(List<Book> bookOnLoan) {
        Loan.bookOnLoan = bookOnLoan;
    }
}
