package com.example.rbac;

import java.util.Set;

public enum Role {
    USER(null, Permission.READ),
    MANAGER(USER, Permission.WRITE, Permission.UPDATE),
    ADMIN(MANAGER, Permission.DELETE, Permission.MANAGE_USERS);

    private final Role parent;
    private final Set<Permission> directPermissions;

    Role(Role parent, Permission... permissions) {
        this.parent = parent;
        this.directPermissions = Set.of(permissions);
    }

    boolean allows(Permission permission) {
        return directPermissions.contains(permission) || (parent != null && parent.allows(permission));
    }
}
