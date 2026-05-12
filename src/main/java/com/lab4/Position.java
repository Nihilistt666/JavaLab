package com.lab4;

/**
 * Перерахування можливих посад працівника.
 */
public enum Position {
    MANAGER("Менеджер"),
    DEVELOPER("Розробник"),
    ANALYST("Аналітик"),
    HR("HR-спеціаліст"),
    ACCOUNTANT("Бухгалтер"),
    INTERN("Стажер");

    private final String displayName;

    Position(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
