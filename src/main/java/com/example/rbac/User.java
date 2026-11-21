package com.example.rbac;

import java.util.Objects;

public final class User {
    private final String username;
    private final Role role;

    public User(String username, Role role) {
        Objects.requireNonNull(username, "username");
        if (username.isBlank() || username.length() > 64 ||
                !username.matches("[\\p{L}\\p{N}_.-]+")) {
            throw new IllegalArgumentException("Use 1 to 64 letters, digits, dots, underscores or hyphens");
        }
        this.username = username;
        this.role = Objects.requireNonNull(role, "role");
    }

    public String getUsername() {
        return username;
    }

    public Role getRole() {
        return role;
    }
}
