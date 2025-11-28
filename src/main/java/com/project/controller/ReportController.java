package com.project.controller;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.project.entity.Expense;
import com.project.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ExpenseService expenseService;

    // ✅ JSON Monthly Report
    @GetMapping("/monthly")
    public ResponseEntity<List<Expense>> getMonthlyReport() {
        LocalDate start = LocalDate.now().withDayOfMonth(1);
        LocalDate end = start.plusMonths(1).minusDays(1);
        List<Expense> monthlyExpenses = expenseService.getExpensesBetweenDates(start, end);
        return ResponseEntity.ok(monthlyExpenses);
    }

    // ✅ JSON Yearly Report
    @GetMapping("/yearly")
    public ResponseEntity<List<Expense>> getYearlyReport() {
        LocalDate start = LocalDate.now().withDayOfYear(1);
        LocalDate end = start.plusYears(1).minusDays(1);
        List<Expense> yearlyExpenses = expenseService.getExpensesBetweenDates(start, end);
        return ResponseEntity.ok(yearlyExpenses);
    }

    // ✅ PDF Download (Monthly)
    @GetMapping("/monthly/download/pdf")
    public void downloadMonthlyReportPdf(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=monthly_report.pdf");

        PdfWriter writer = new PdfWriter(response.getOutputStream());
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        document.add(new Paragraph("Monthly Expense Report"));
        document.add(new Paragraph("Generated on: " + LocalDate.now()));

        List<Expense> expenses = expenseService.getExpensesBetweenDates(
                LocalDate.now().withDayOfMonth(1),
                LocalDate.now().plusMonths(1).minusDays(1)
        );

        for (Expense expense : expenses) {
            document.add(new Paragraph(expense.toString()));  // Customize display here
        }

        document.close();
    }
}
