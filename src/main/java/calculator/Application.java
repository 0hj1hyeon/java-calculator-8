package calculator;

import calculator.controller.CalController;
import calculator.domain.Calculator;
import calculator.domain.DelimiterManager;
import calculator.view.IOView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        DelimiterManager delimiterManager = new DelimiterManager();
        Calculator calculator = new Calculator(delimiterManager);

        IOView view = new IOView();

        CalController controller = new CalController(view, calculator);

        controller.run();
    }
}
