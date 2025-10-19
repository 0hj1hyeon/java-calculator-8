package calculator.domain;

public class Calculator {

    private final DelimiterManager delimiterManager;

    public Calculator(DelimiterManager delimiterManager) {

        this.delimiterManager = delimiterManager;
    }

    public int sum(String input) {

        Validator.validateFullInput(input);

        String[] numberStrings = delimiterManager.split(input);

        int sum = 0;
        for (String numberString : numberStrings) {

            int number = Validator.parseAndValidateNumber(numberString);
            sum += number;
        }

        return sum;
    }
}