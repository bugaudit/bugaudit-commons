package me.shib.bugaudit.commons;

public class Test {

    public static void main(String[] args) {
        CommandExecutor ce = new CommandExecutor();
        ce.enableConsoleOutput(true);
        ce.runCommand("find -f / dude");
    }

}
