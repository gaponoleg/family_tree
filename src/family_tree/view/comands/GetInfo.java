package family_tree.view.comands;

import family_tree.view.ConsoleUI;

public class GetInfo extends Command{
    public GetInfo(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Получить список";
    }

    @Override
    public void execute() {
        consoleUI.getInfo();
    }
}
