package com.example.rbac;

public final class Main {
    public static void main(String[] args) {
        AuditLogger audit = new AuditLogger();
        RBACManager manager = new RBACManager(audit);
        User reader = new User(System.getenv().getOrDefault("RBAC_DEMO_USER", "demo-user"), Role.USER);
        manager.checkPermission(reader, Permission.READ);
        manager.checkPermission(reader, Permission.DELETE);
        manager.checkPermission(new User("demo-manager", Role.MANAGER), Permission.READ);
        manager.checkPermission(new User("demo-admin", Role.ADMIN), Permission.DELETE);

        for (AuditLogger.Entry entry : audit.getLogs()) {
            System.out.printf("%s | %s | %s | %s | %s%n", entry.time(), entry.username(),
                    entry.role(), entry.permission(), entry.result());
        }
    }
}
