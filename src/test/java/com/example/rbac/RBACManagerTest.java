package com.example.rbac;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RBACManagerTest {
    static Stream<Arguments> cases() {
        return Stream.of(Role.values()).flatMap(role -> {
            Set<Permission> expected = switch (role) {
                case USER -> Set.of(Permission.READ);
                case MANAGER -> Set.of(Permission.READ, Permission.WRITE, Permission.UPDATE);
                case ADMIN -> Set.of(Permission.READ, Permission.WRITE, Permission.UPDATE,
                        Permission.DELETE, Permission.MANAGE_USERS);
            };
            return Stream.of(Permission.values()).map(p -> Arguments.of(role, p, expected.contains(p)));
        });
    }

    @ParameterizedTest(name = "{0} / {1} => {2}")
    @MethodSource("cases")
    void checksPermission(Role role, Permission permission, boolean expected) {
        RBACManager manager = new RBACManager(new AuditLogger());
        assertEquals(expected, manager.checkPermission(new User("tester", role), permission));
    }
}
