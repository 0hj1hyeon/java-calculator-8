package calculator.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DelimiterManager {

    private static final Set<String> BASIC_DELIMITERS = new HashSet<>(Arrays.asList(",", ":"));

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//([^\n]+)\n(.*)");

    private Set<String> currentDelimiters;

    public DelimiterManager() {
        this.currentDelimiters = new HashSet<>(BASIC_DELIMITERS);
    }


    private String extractAndSetCustomDelimiter(String input) {
        input = input.replace("\\n", "\n");
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            currentDelimiters.clear();

            for (char delimiterChar : customDelimiter.toCharArray()) {
                currentDelimiters.add(String.valueOf(delimiterChar));
            }

            return matcher.group(2);
        }
        return input;
    }

    public String[] split(String text) {
        String processedText = extractAndSetCustomDelimiter(text);

        if (processedText == null || processedText.isEmpty()) {
            return new String[0];
        }

        String regex = currentDelimiters.stream()
                .collect(Collectors.joining("|"));

        return processedText.split(regex, -1);
    }
}
