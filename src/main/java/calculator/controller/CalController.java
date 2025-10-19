package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.IOView;

public class CalController {

    private final IOView view;
    private final Calculator calculator;

    public CalController(IOView view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }

    public void run() {

        String input = view.Input();
        int result = calculator.sum(input);
        view.Output(result);

    }
}
