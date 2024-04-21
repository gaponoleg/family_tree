package family_tree.view.comands;

import family_tree.view.ConsoleUI;

public class SortByName extends Command{
    public SortByName(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Отсортировать список по имени";
    }

    @Override
    public void execute() {
        consoleUI.sortByName();
    }
}
