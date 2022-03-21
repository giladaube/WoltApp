package com.company.Command;

import static java.lang.System.exit;

public class ExitCommand implements ICommand {
    @Override
    public void execute() {
        exit(1);
    }
}