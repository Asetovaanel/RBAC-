package com.example.rbac;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AuditSnapshotTest {
    @Test
    void holdsAnIndependentReadOnlySnapshot() {
        AuditLogger audit = new AuditLogger();
        RBACManager manager = new RBACManager(audit);
        User user = new User("tester", Role.USER);
        manager.checkPermission(user, Permission.READ);
        var snapshot = audit.getLogs();
        assertThrows(UnsupportedOperationException.class, snapshot::clear);
        manager.checkPermission(user, Permission.DELETE);
        assertEquals(1, snapshot.size());
        assertEquals(2, audit.getLogs().size());
    }
}
