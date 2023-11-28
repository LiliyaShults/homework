package validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {

    public boolean isValidate(String commandsStr, Enum[] commandsData) {
        for (Enum command : commandsData) {
            if (command.name().equals(commandsStr)) {
                return true;
            }
        }

        return false;
    }

   public boolean isDataByRegExp(String numberStr, Pattern pattern) {
       Matcher matcher = pattern.matcher(numberStr);
       return matcher.find();
    }
}
