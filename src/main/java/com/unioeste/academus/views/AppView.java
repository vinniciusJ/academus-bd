package com.unioeste.academus.views;

import com.unioeste.academus.utils.ViewUtils;
import org.springframework.stereotype.Component;

@Component
public class AppView extends ViewUtils {
    public void showMenu(){
        super.showMenu(
                "[0] - Sair",
                "[1] - Listar cursos",
                "[2] - Listar disciplinas",
                "[3] - Listar anos letivos",
                "[4] - Listar turmas",
                "[5] - Listar professores",
                "[6] - Listar alunos",
                "[7] - Realizar matriculas"
        );
    }
}
