package com.unioeste.academus.utils;

import de.vandermeer.asciitable.AsciiTable;

import java.io.Console;
import java.util.List;
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

    public <T> void showTable(List<String> headers, List<T> data, Function<T, List<String>> rowRenderer) {
        AsciiTable menu = new AsciiTable();

        menu.addRule();
        menu.addRow(headers.toArray());
        menu.addRule();

        for (T item : data) {
            List<String> row = (List<String>) rowRenderer.apply(item);

            menu.addRow(row.toArray());
            menu.addRule();
        }

        System.out.println(menu.render());
    }
}
