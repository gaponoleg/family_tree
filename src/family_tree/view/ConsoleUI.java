package family_tree.view;

import family_tree.model.family_tree.human.Human;
import family_tree.presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View{
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu mainMenu;

    public ConsoleUI(){
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    @Override
    public void start() {
        System.out.println("Здравствуйте");
        while (work){
            System.out.println(mainMenu.getMenu);
            String strChoice = scanner.nextLine();
            int choice = Integer.parseInt(strChoice);
            mainMenu.execute(choice);
        }
    }
    public void finish(){
        System.out.println("До скорых встреч");
        work = false;
    }

    public void sortByName(){
        presenter.sortByName();
    }

    public void sortByAge(){
        presenter.sortByAge();
    }

    public void getInfo(){
        presenter.getInfo();
    }




    public void printMenu(){
        System.out.println(mainMenu.getMenu());
    }

    private boolean checkCommand(int numCommand){
        if (numCommand < mainMenu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

    private void execute(){
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                mainMenu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }
}
