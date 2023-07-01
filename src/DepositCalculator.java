//Проверил. Замчаний по коду нет.

import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return calculateRound(pay);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount + amount * yearRate * depositPeriod;
        return calculateRound(pay);
    }

    double calculateRound(double value) {
        double scale = Math.pow(10, 2);
        return Math.round(value * scale) / scale;
    }

    void chooseBankAccount() {
        int amount;
        int depositPeriod;
        int action;
        double pay;
        double yearRate;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt();
        System.out.println("Введите годовую ставку в процентах:");
        yearRate = scanner.nextInt() / 100.0;
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        if (action == 1) {
            pay = calculateSimplePercent(amount, yearRate, depositPeriod);
        } else if (action == 2) {
            pay = calculateComplexPercent(amount, yearRate, depositPeriod);
        } else {
            System.out.println("Вклада с таким идентификатором не существует");
            return;
        }

        System.out.println("Результат вклада: " + amount + " за " + depositPeriod + " лет превратятся в " + pay);
    }

    public static void main(String[] args) {
        new DepositCalculator().chooseBankAccount();
    }
}
