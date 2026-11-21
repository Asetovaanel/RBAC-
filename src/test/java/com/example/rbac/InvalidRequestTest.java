package com.example.rbac;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class InvalidRequestTest {
    private final RBACManager manager = new RBACManager(new AuditLogger());

    @Test
    void requiresAUser() {
        assertThrows(NullPointerException.class, () -> manager.checkPermission(null, Permission.READ));
    }

    @Test
    void requiresAPermission() {
        User user = new User("tester", Role.USER);
        assertThrows(NullPointerException.class, () -> manager.checkPermission(user, null));
    }
}
