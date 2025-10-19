package calculator.domain;

public class Validator {
    private Validator() {}

    public static void validateFullInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력 문자열이 비어있거나 올바르지 않은 형식입니다.");
        }
    }

    public static int parseAndValidateNumber(String numberText) {

        if (numberText == null || numberText.isBlank()) {
            throw new IllegalArgumentException("연속된 구분자 또는 잘못된 입력 형식으로 인해 빈 값이 발생했습니다.");
        }

        int number;
        try {

            number = Integer.parseInt(numberText);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자 형식입니다: " + numberText);
        }


        if (number < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + number);
        }

        return number;
    }
}
