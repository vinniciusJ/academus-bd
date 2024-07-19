package com.unioeste.academus.controllers;

import com.unioeste.academus.views.AppView;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class AppController {
    @Autowired
    private AppView appView;

    @Autowired
    private AcademicYearController academicYearController;

    public void startApp(){
        appView.showMenu();

        int option = appView.input("Escolha uma das opções acima: ", Integer::parseInt);

        switch (option){
            case 0 -> System.exit(0);
            case 3 -> academicYearController.handleAcademicYearList();
            default -> startApp();
        }

        startApp();
    }
}
