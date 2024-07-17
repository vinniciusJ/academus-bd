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
    private CourseController courseController;

    public void startApp(){
        appView.showMenu();

        int option = appView.input("Escolha uma das opções acima: ", Integer::parseInt);

        switch (option){
            case 0 -> System.exit(0);
            case 1 -> courseController.startCourseMenu();
            case 2 -> System.out.println("Módulo adm");
            default -> startApp();
        }

        startApp();
    }
}
