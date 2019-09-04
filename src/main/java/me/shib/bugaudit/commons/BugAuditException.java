package me.shib.bugaudit.commons;

public final class BugAuditException extends Exception {
    public BugAuditException(String message) {
        super(message);
    }

    public BugAuditException(Exception e) {
        super(e.getMessage());
    }
}
