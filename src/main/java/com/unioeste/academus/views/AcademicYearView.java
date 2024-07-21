package com.unioeste.academus.views;

import com.unioeste.academus.models.AcademicYear;
import com.unioeste.academus.utils.ViewUtils;
import de.vandermeer.asciitable.AsciiTable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class AcademicYearView extends ViewUtils {
    public void showAll(List<AcademicYear> academicYears){
        List<String> headers = List.of("Ano", "Data de início", "Data de fim");

        Function<AcademicYear, List<String>> renderAcademicYearRow = (academicYear) -> List.of(
                academicYear.getYear().toString(),
                academicYear.getStartDate().toString(),
                academicYear.getEndDate().toString()
        );

        showTable(headers, academicYears, renderAcademicYearRow);
    }

    public void showCurrentAcademicYear(AcademicYear academicYear){
        AsciiTable table = new AsciiTable();

        table.addRule();
        table.addRow("Ano letivo em vigência: ", academicYear.getYear());
        table.addRule();
        table.addRow("Data de início: ", academicYear.getStartDate());
        table.addRule();
        table.addRow("Data de fim: ", academicYear.getEndDate());
        table.addRule();


        System.out.println("O ano letivo vigente é: ");
        System.out.println(table.render());
    }
}
