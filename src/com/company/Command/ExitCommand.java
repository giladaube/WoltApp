package com.company.Command;

import com.company.GUI;
import com.company.pages.Pages;
import com.company.pages.abstractPages.AFactoryPage;
import com.company.sessions.Session;

import java.util.Map;

import static java.lang.System.exit;

public class ExitCommand implements ICommand {
    private GUI gui;
    private Session session;
    private AFactoryPage factoryPage;
    private Map<Pages, ICommand> commands;
    public ExitCommand(GUI g, Session s, AFactoryPage f, Map<Pages, ICommand> c) {
        gui = g;
        session = s;
        factoryPage = f;
        commands = c;
    }
    @Override
    public void execute() {
        exit(1);
    }
}