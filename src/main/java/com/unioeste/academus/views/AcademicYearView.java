package com.unioeste.academus.views;

import com.unioeste.academus.models.AcademicYear;
import com.unioeste.academus.utils.ViewUtils;
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

}
