package com.unioeste.academus.views;

import com.unioeste.academus.utils.ViewUtils;
import org.springframework.stereotype.Service;

@Service
public class AppView extends ViewUtils {
    public void showMenu(){
        super.showMenu(
                "[0] - Sair",
                "[1] - Módulo de cursos"
        );
    }
}
