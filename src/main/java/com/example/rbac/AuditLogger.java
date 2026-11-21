package com.example.rbac;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public final class AuditLogger {
    public record Entry(Instant time, String username, Role role, Permission permission, boolean allowed) {
        public String result() {
            return allowed ? "ALLOWED" : "DENIED";
        }
    }

    private final List<Entry> entries = new ArrayList<>();

    synchronized void logAccess(User user, Permission permission, boolean allowed) {
        entries.add(new Entry(Instant.now(), user.getUsername(), user.getRole(), permission, allowed));
    }

    public synchronized List<Entry> getLogs() {
        return List.copyOf(entries);
    }
}
