package com.company.Command;

import com.company.GUI;
import com.company.pages.Pages;
import com.company.pages.abstractPages.AFactoryPage;
import com.company.sessions.Session;

import java.util.Map;

import static java.lang.System.exit;

public class ExitCommand implements ICommand {
    @Override
    public void execute() {
        exit(1);
    }
}