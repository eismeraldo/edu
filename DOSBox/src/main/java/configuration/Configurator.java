/*
 * Course Agile Software Development
 */
package configuration;

import persistence.DaoFactory;
import persistence.DaoFactory.DaoType;
import filesystem.Drive;
import invoker.CommandInvoker;
import invokerService.CommandInvokerService;

import command.library.CommandFactory;

import console.Console;

/**
 * Configures the system. Contains the method main().
 */
public class Configurator {

    protected CommandInvoker invoker;
    protected Drive drive;
    protected CommandFactory factory;
    protected Console console;

    /**
     * Method main(). Called initially.
     */
    public static void main(String[] args) {
        Configurator config = new Configurator();
        config.startConsole();
    }

    public Configurator() {
        configureBaseSystem();
    }

    /**
     * Configurates the system for a console application.
     */
    public void configureBaseSystem() {

        // Create file system with initial root directory
        // and read any persistent information.
        this.drive = new Drive("C");
        this.drive.restore();

        // Create all commands and invoker
        this.factory = new CommandFactory(this.drive);
        this.invoker = new CommandInvoker(DaoFactory.createHistoryDao(DaoType.DERBY));
        this.invoker.setCommands(factory.getCommandList());

    }

    public void startConsole() {

        // Setup console for input and output
        this.console = new Console(this.invoker, this.drive);

        // Start console
        this.console.processInput();
    }

    public CommandInvokerService getInvoker() {
        return invoker;
    }

    public Drive getDrive() {
        return drive;
    }
}
