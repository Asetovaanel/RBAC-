package com.example.rbac;

import java.util.Objects;

public final class RBACManager {
    private final AuditLogger audit;

    public RBACManager(AuditLogger audit) {
        this.audit = Objects.requireNonNull(audit, "audit");
    }

    public boolean checkPermission(User user, Permission permission) {
        Objects.requireNonNull(user, "user");
        Objects.requireNonNull(permission, "permission");
        boolean allowed = user.getRole().allows(permission);
        audit.logAccess(user, permission, allowed);
        return allowed;
    }
}
