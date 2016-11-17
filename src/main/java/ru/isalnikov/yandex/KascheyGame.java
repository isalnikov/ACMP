package ru.isalnikov.yandex;

public class KascheyGame {

    /*	
    
     http://dimakornilov.ru/blog/?p=1961
     Задача: 

     Дано: Кащей Бессмертный, который украл принцессу у Ивана Царевича. И собственно, Иван Царевич, который невесту хочет вернуть. 
     Кащея убить можно. Есть 10 колодцев с ядом, сила яда от колодцу к колодцу постепенно нарастает. Более сильный яд является противоядием для более слабого (если выпить сначала из 2 колодца, а потом из 3 – отравления не будет). Если смешать два яда, то смесь приобретет свойства сильнейшего. 

     Сама битва: соперники приходят на ристалище с одним кубком в руках. Отдают кубок противнику, который выпивает содержимое. Но подлец Кащей построил вокруг последнего 10 колодца крепость, которая неприступна для Ивана. Таким образом, у Кащея есть доступ к сильнейшему яду, а у Ивана нет. 

     Цель: победить Кащея и выжить самому.*/
	// Пришел на ристалище
    private enum Move {

        GIVE_WATER,
        GIVE_1,
        GIVE_2,
        GIVE_3,
        GIVE_4,
        GIVE_5,
        GIVE_6,
        GIVE_7,
        GIVE_8,
        GIVE_9,
        GIVE_10,
    }

    private enum Before_Drinking {

        NOTHING, // Ничего не делаем перед питьем
        DRINK_1,
        DRINK_2,
        DRINK_3,
        DRINK_4,
        DRINK_5,
        DRINK_6,
        DRINK_7,
        DRINK_8,
        DRINK_9,
        DRINK_10,
    }

    private enum Mix {

        NOTHING,
        MIX_1,
        MIX_2,
        MIX_3,
        MIX_4,
        MIX_5,
        MIX_6,
        MIX_7,
        MIX_8,
        MIX_9,
        MIX_10,
    }

	// Дальше пьем!
    private enum After_Drinking {

        NOTHING, // Больше не пить
        DRINK_1,
        DRINK_2,
        DRINK_3,
        DRINK_4,
        DRINK_5,
        DRINK_6,
        DRINK_7,
        DRINK_8,
        DRINK_9,
        DRINK_10
    }

    private static class Action {

        public Action(Move ivanMove, Before_Drinking ivanBefore, Mix ivanMix,
                After_Drinking ivanAfter) {
            _move = ivanMove;
            _before = ivanBefore;
            _mix = ivanMix;
            _after = ivanAfter;
        }

        Move _move;
        Before_Drinking _before;
        Mix _mix;
        After_Drinking _after;
    }

	// Проверяем, живы ли
    public static boolean isDead(Move opponentMove, Before_Drinking before, Mix mix, After_Drinking after) {
        int poisonLevel = 0;
        // Сначала пьем яд или воду
        if (before != Before_Drinking.NOTHING) {
            poisonLevel = before.ordinal();
        }
        // Смешиваем и выпиваем
        int mixedPoisonLevel = Math.max(opponentMove.ordinal(), mix.ordinal());
        if (mixedPoisonLevel > poisonLevel && poisonLevel > 0) {
            poisonLevel = 0; // Противоядие
        } else {
            poisonLevel = Math.max(mixedPoisonLevel, poisonLevel);
        }
        // Выпиваем последнюю дозу
        if (after.ordinal() > poisonLevel && poisonLevel > 0) {
            poisonLevel = 0; // Противоядие
        } else {
            poisonLevel = Math.max(after.ordinal(), poisonLevel);
        }

        return poisonLevel > 0;
    }

    public static boolean isDead(Action myAction, Action opponentAction) {
        return isDead(opponentAction._move, myAction._before, myAction._mix, myAction._after);
    }

    public static boolean isDead(Action myAction, Action[] opponentActions) {
        for (Action opponentAction : opponentActions) {
            if (isDead(opponentAction._move, myAction._before, myAction._mix, myAction._after)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Validate all possibilities

        Action[] ivan = new Action[10000];
        Action[] kaschey = new Action[14641];

        int ivanIndex = 0, kascheyIndex = 0;
        for (Move move : Move.values()) {
            for (Before_Drinking before : Before_Drinking.values()) {
                for (Mix mix : Mix.values()) {
                    for (After_Drinking after : After_Drinking.values()) {
                        // Запрещаем Ивану доступ к 10-му колодцу
                        if (move != Move.GIVE_10 && before != Before_Drinking.DRINK_10 && mix != Mix.MIX_10 && after != After_Drinking.DRINK_10) {
                            ivan[ivanIndex] = new Action(move, before, mix, after);
                            ivanIndex++;
                        }
                        kaschey[kascheyIndex] = new Action(move, before, mix, after);
                        kascheyIndex++;
                    }
                }
            }
        }

        System.out.println("В игре у Ивана " + ivanIndex + " возможностей, у Кащея " + kascheyIndex);

        byte[][] game = new byte[ivan.length][kaschey.length];
        int[] ivanWins = new int[ivan.length];
        int[] kascheyWins = new int[kaschey.length];

        System.out.println("Составляем таблицу минимакса...");

        for (int ivanI = 0; ivanI < ivan.length; ivanI++) {
            for (int kascheyI = 0; kascheyI < kaschey.length; kascheyI++) {
                Action ivanAction = ivan[ivanI];
                Action kascheyAction = kaschey[kascheyI];
                boolean ivanDead = isDead(ivanAction, kascheyAction);
                boolean kascheyDead = isDead(kascheyAction, ivanAction);
                if (ivanDead && kascheyDead) { // Иван умер, Кащей умер - лишь одна задача выполнена
                    game[ivanI][kascheyI] = 1;
                } else if (!ivanDead && kascheyDead) { // Иван выжил, Кащей умер - два дела сделано
                    game[ivanI][kascheyI] = 2;
                } else if (ivanDead && !kascheyDead) { // Кащей выжил, Иван умер - все плохо
                    game[ivanI][kascheyI] = 0;
                } else { // Оба выжили - лишь одна задача выполнена
                    game[ivanI][kascheyI] = 1;
                }
                ivanWins[ivanI] += game[ivanI][kascheyI];
                kascheyWins[kascheyI] += game[ivanI][kascheyI];
            }
        }

        // Находим максимальный выигрыш у Ивана
        int ivanBest = -1;
        Action ivanBestAction = null;
        for (int i = 0; i < ivanWins.length; i++) {
            if (ivanWins[i] > ivanBest) {
                ivanBest = ivanWins[i];
                ivanBestAction = ivan[i];
            }
        }

        // Находим минимальный проигрыш у Кащея
        int kascheyBest = Integer.MAX_VALUE;
        Action kascheyBestAction = null;
        for (int i = 0; i < kascheyWins.length; i++) {
            if (kascheyWins[i] < kascheyBest) {
                kascheyBest = kascheyWins[i];
                kascheyBestAction = kaschey[i];
            }
        }

        System.out.println("Решение");
        printlnAction("Иван", ivanBestAction);
        printlnAction("Кащей", kascheyBestAction);

        System.out.println("Шансы Ивана на выживание при разумном действии Кащея: " + (isDead(ivanBestAction, kascheyBestAction) ? "умер" : "выжил"));
        System.out.println("Шансы Кащея на выживание при разумном действии Ивана: " + (isDead(kascheyBestAction, ivanBestAction) ? "умер" : "выжил"));
        System.out.println();

        System.out.println("Умрет ли Иван, если Кащей изберет любой другой вариант действий, а сам будет придерживаться разумной стратегии: " + (isDead(ivanBestAction, kaschey) ? "да" : "нет"));
        System.out.println("Умрет ли Кащей, если Иван изберет любой другой вариант действий, а сам будет придерживаться разумной стратегии: " + (isDead(kascheyBestAction, ivan) ? "да" : "нет"));
    }

    private static void printlnAction(String string, Action ivanBestAction) {
        System.out.print(string);
        System.out.print("\nперед ристалищем выпить яд " + ivanBestAction._before + ",");
        System.out.print("\nдать сопернику кубок с ядом " + ivanBestAction._move + ",");
        System.out.print("\nсамому смешать данный сопернику кубок с ядом " + ivanBestAction._mix + ",");
        System.out.println("\nа потом запить ядом " + ivanBestAction._after);
        System.out.println();
    }
}
