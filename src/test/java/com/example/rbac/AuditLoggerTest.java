package com.example.rbac;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;

class AuditLoggerTest {
    @Test
    void capturesBothDecisionsInOrder() {
        AuditLogger audit = new AuditLogger();
        RBACManager manager = new RBACManager(audit);
        User user = new User("tester", Role.USER);
        manager.checkPermission(user, Permission.READ);
        manager.checkPermission(user, Permission.DELETE);
        List<AuditLogger.Entry> logs = audit.getLogs();
        assertEquals(2, logs.size());
        assertEquals("tester", logs.get(0).username());
        assertEquals(Role.USER, logs.get(0).role());
        assertNotNull(logs.get(0).time());
        assertEquals(Permission.READ, logs.get(0).permission());
        assertEquals("ALLOWED", logs.get(0).result());
        assertEquals(Permission.DELETE, logs.get(1).permission());
        assertEquals("DENIED", logs.get(1).result());
    }
}
