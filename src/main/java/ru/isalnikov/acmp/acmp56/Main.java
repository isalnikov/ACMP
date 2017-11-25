package ru.isalnikov.acmp.acmp56;

/**
 * ЗАДАЧА №56 Jивой Jурнал
 *
 * (Время: 1 сек. Память: 16 Мб Сложность: 29%) Программист Саша участвует в
 * создании блог-сервиса Jивой Jурнал. Планируется, что этот сервис будет
 * предоставлять гораздо больше возможностей, чем известный всем LiveJournal. В
 * настоящее же время проблему составляет реализация всех базовых возможностей
 * LiveJournal'а. Одной из таких возможностей является поддержка списков друзей
 * для пользователей.
 *
 * Заданы: список пользователей, являющихся друзьями данного пользователя, и
 * список пользователей, у которых данный пользователь содержится в списке
 * друзей.
 *
 * Необходимо получить список друзей данного пользователя (Friends), список его
 * взаимных друзей (Mutual Friends), и список тех пользователей, у кого данный
 * пользователь содержится в списке друзей, но которые не являются его взаимными
 * друзьями (Also Friend of).
 *
 * Входные данные
 *
 * Первая строка входного файла INPUT.TXT содержит число n (0 ≤ n ≤ 200) друзей
 * данного пользователя. Последующие n строк содержат каждая по одному имени
 * пользователя, который является другом данного. (n + 2)-ая строка содержит
 * число m (0 ≤ m ≤ 200) пользователей, у которых данный содержится в списке
 * друзей. Далее заданы имена пользователей, у которых данный находится в списке
 * друзей. Эти пользователи заданы в том же формате, что и друзья данного.
 *
 * Имена пользователей - строки длиной от 1 до 20 символов, содержащие только
 * строчные буквы английского алфавита и символы тире ("-"). Каждый пользователь
 * указан не более одного раза в каждом из списков.
 *
 * Выходные данные
 *
 * В выходной файл OUTPUT.TXT следует вывести список друзей данного пользователя
 * (Friends), список его взаимных друзей (Mutual Friends), и список тех
 * пользователей, у кого данный пользователь содержится в списке друзей, но
 * которые не являются его взаимными друзьями (Also Friend of). В каждом списке
 * пользователи должны быть отсортированы по алфавиту. Следуйте формату,
 * приведенному в примерах.
 *
 * @author Igor Salnikov
 * <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

    private static final TreeSet<String> friends = new TreeSet<String>();
    private static final TreeSet<String> mutualFriends = new TreeSet<String>();
    private static final TreeSet<String> alsoFriendOf = new TreeSet<String>();

    private static void solve(Scanner in, PrintWriter out) {
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            friends.add(in.nextLine());
        }
        out.print(String.format("Friends: %s\n", friends.size() > 0 ? friends.stream().collect(Collectors.joining(", ", "", "")) : ""));

        int m = Integer.parseInt(in.nextLine());
        for (int i = 0; i < m; i++) {
            String friend = in.nextLine();
            if (friends.contains(friend)) {
                mutualFriends.add(friend);
            } else {
                alsoFriendOf.add(friend);
            }
        }
        out.print(String.format("Mutual Friends: %s\n", mutualFriends.size() > 0 ? mutualFriends.stream().collect(Collectors.joining(", ", "", "")) : ""));
        out.print(String.format("Also Friend of: %s", alsoFriendOf.size() > 0 ? alsoFriendOf.stream().collect(Collectors.joining(", ", "", "")) : ""));
        out.flush();
    }

}
