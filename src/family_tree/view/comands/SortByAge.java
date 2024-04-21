package family_tree.view.comands;

import family_tree.view.ConsoleUI;

public class SortByAge extends Command{
    public SortByAge(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Отсортировать список по возрасту";
    }

    @Override
    public void execute() {
        consoleUI.sortByAge();
    }
}
