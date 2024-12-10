package utilitaires;

import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class PatternGestion {
    public static final Pattern PATTERN_CODEPOSTAL = Pattern.compile("^[0-9]{5}$");
    public static final Pattern PATTERN_TELEPHONE = Pattern.compile("^[0-9]{10}$");
    public static final Pattern PATTERN_MAIL = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
    public static final DateTimeFormatter PATTERN_DATE = DateTimeFormatter.ofPattern("dd/MM/yyyy");

}
