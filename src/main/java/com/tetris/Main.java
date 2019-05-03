package com.tetris;

import jline.console.ConsoleReader;
import jline.console.KeyMap;

import java.io.IOException;

public class Main {

    private static final String HIDE_CURSOR = "\u001B[?25l";
    private static final String KEY_UP = "\u001B[A";
    private static final String KEY_DOWN = "\u001B[B";
    private static final String KEY_LEFT = "\u001B[D";
    private static final String KEY_RIGHT = "\u001B[C";

    public static void main(String[] args) throws IOException {

        ConsoleReader console = new ConsoleReader();
        Field field = new Field(20, 10);
        ДобавлениеФигур добавлениеФигур = new ДобавлениеФигур();
        Фигура фигура = добавлениеФигур.создатьФигуру(field);

        hideCursor(console);
        clearConsole(console);

        printBattleField(console, field);

        while (true) {

            Action action = readKeyboard(console);

            clearConsole(console);

            if (action == Action.Right) {

                фигура.двигатьсяВправо();

            } else if (action == Action.Left) {


                фигура.перевернутьВлево();

            } else if (action == Action.Up) {


                фигура.перевернуть180();

            } else if (action == Action.Down) {

                фигура.двигатьсяВниз();
            }

            printBattleField(console, field);
            Координата[] координаты = фигура.взятьКоординаты();
            if (field.находитьсяЛиВнизуПоляФигура(координаты)){
                фигура = добавлениеФигур.создатьФигуру(field);
            }
        }
    }

    private static void hideCursor(ConsoleReader console) throws IOException {
        console.print(HIDE_CURSOR);
        console.flush();
    }

    private static Action readKeyboard(ConsoleReader console) throws IOException {
        KeyMap map = new KeyMap("");
        map.bind(KEY_UP, Action.Up);
        map.bind(KEY_DOWN, Action.Down);
        map.bind(KEY_LEFT, Action.Left);
        map.bind(KEY_RIGHT, Action.Right);
        return (Action) console.readBinding(map);
    }

    private static void clearConsole(ConsoleReader console) throws IOException {
        console.clearScreen();
        console.flush();
    }

    private static void printBattleField(ConsoleReader console,
                                         Field field) throws IOException {
        console.print(field.toString());
        console.flush();
    }
}
