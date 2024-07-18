package com.unioeste.academus.utils;

import de.vandermeer.asciitable.AsciiTable;

import java.io.Console;
import java.util.function.Function;


public class ViewUtils {
    private final Console console = System.console();
    
    public String input(String label){
        System.out.print(label);

        return console.readLine();
    }

    public <T> T input(String label, Function<String, T> parser){
        String input = input(label);

        try{
            return parser.apply(input);
        }
        catch (NumberFormatException e){
            System.out.println("Formato inválido. Por favor, tente novamente.");

            return input(label, parser);
        }
    }

    public void showMenu(String... options){
        AsciiTable menu = new AsciiTable();

        menu.addRule();

        for(String option : options){
            menu.addRow(option);
            menu.addRule();
        }

        System.out.println(menu.render());
    }

}
