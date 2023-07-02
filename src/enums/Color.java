package enums;

public enum Color {

    RED("\033[0;31m"),
    BLUE("\033[0;34m"),
    GREEN("\033[0;32m"),
    YELLOW("\033[0;33m"),
    CYAN("\033[0;36m"),
    PURPLE("\033[0;35m");

    public final String txtColor;

    Color(String txtColor) {
        this.txtColor = txtColor;
    }
}
