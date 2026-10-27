# RBAC Library and Audit Log

## 1. Project Description

RBAC Library and Audit Log is a Java-based project that implements
Role-Based Access Control (RBAC).

The main purpose of this project is to manage user permissions
through roles, implement role hierarchy, and record every
permission check in an audit log.

## 2. Project Objectives

- Create a role-based access control system.
- Define users, roles, and permissions.
- Implement role hierarchy.
- Check user permissions.
- Record every permission check.
- Test the system using JUnit 5.

## 3. Technologies Used

- Java 17
- Apache Maven
- JUnit 5
- Git and GitHub

## 4. Main Features

### Role Management
The system supports three roles:
- USER
- MANAGER
- ADMIN

### Permission Management
Available permissions:
- READ
- WRITE
- UPDATE
- DELETE
- MANAGE_USERS

### Role Hierarchy
Roles inherit permissions from parent roles.

ADMIN inherits MANAGER permissions.
MANAGER inherits USER permissions.

### Permission Checking
The RBACManager checks whether a user has permission
to perform a specific action.

### Audit Log
Every permission check is recorded with:
- Date and time
- Username
- User role
- Requested permission
- Result (ALLOWED or DENIED)

## 5. Project Structure

```text
RBAC-Library/
├── pom.xml
├── README.md
└── src/
    ├── main/
    │   └── java/
    │       └── com/example/rbac/
    │           ├── Permission.java
    │           ├── Role.java
    │           ├── User.java
    │           ├── AuditLogger.java
    │           ├── RBACManager.java
    │           └── Main.java
    └── test/
        └── java/
            └── com/example/rbac/
                └── RBACManagerTest.java
```

## 6. How to Run

1. Clone the repository.
2. Open the project in IntelliJ IDEA or VS Code.
3. Make sure Java 17 and Maven are installed.
4. Open the terminal.
5. Run the application.

```bash
mvn compile
```

To run tests:

```bash
mvn test
```

## 7. Testing

JUnit 5 is used to test the following features:

- ADMIN has DELETE permission.
- USER does not have DELETE permission.
- MANAGER inherits READ permission.
- Every permission check is recorded in the audit log.

## 8. Expected Results

The application should:

- Identify user roles.
- Check permissions correctly.
- Support role hierarchy.
- Deny unauthorized actions.
- Record permission checks in the audit log.
- Pass all JUnit 5 tests.

## 9. Conclusion

This project demonstrates the basic principles of
Role-Based Access Control in Java.

It provides a simple way to manage user permissions,
implement role hierarchy, and record authorization events.

The project can be extended with database integration,
file-based logging, additional roles, and advanced security features.

## 10. References

- NIST - Role-Based Access Control:
  https://csrc.nist.gov/Projects/Role-Based-Access-Control

- OWASP - Authorization Cheat Sheet:
  https://cheatsheetseries.owasp.org/cheatsheets/Authorization_Cheat_Sheet.html

- Apache Maven:
  https://maven.apache.org/

- JUnit 5:
  https://junit.org/junit5/
