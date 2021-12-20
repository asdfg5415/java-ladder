package ladder.view;

import java.util.Scanner;

public class InputView {
    private static final String PLAYERS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String players() {
        return nextLine(PLAYERS);
    }

    public int height() {
        return nextInt(HEIGHT);
    }

    public void close() {
        scanner.close();
    }

    private String nextLine(String message) {
        System.out.println();
        System.out.println(message);
        return scanner.nextLine();
    }

    private int nextInt(String message) {
        System.out.println();
        System.out.println(message);
        return Integer.parseInt(scanner.nextLine());
    }

}
