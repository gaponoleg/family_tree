package family_tree;

import family_tree.model.family_tree.family_tree.FamilyTree;
import family_tree.model.family_tree.human.Gender;
import family_tree.model.family_tree.human.Human;
import family_tree.model.family_tree.reader_writer.WriteReadFile;
import family_tree.view.ConsoleUI;
import family_tree.view.MainMenu;
import family_tree.view.View;

import java.io.Serializable;
import java.time.LocalDate;

public class Main {
    public static  void main(String[] args) {
        FamilyTree familyTree = testTree();

        View view = new ConsoleUI();
        view.start();
    }

    static FamilyTree testTree(){

        FamilyTree tree = new FamilyTree();

        Human oleg = new Human("Олег", Gender.Male, LocalDate.of(2008, 6, 25));
        Human diana = new Human("Диана", Gender.Female, LocalDate.of(2006, 9, 15));
        tree.add(oleg);
        tree.add(diana);
        tree.setWedding(oleg, diana);

        Human alena = new Human("Алёна", Gender.Female, LocalDate.of(2011, 7, 5),
                oleg, diana);
        Human ramil = new Human("Рамиль", Gender.Male, LocalDate.of(2012, 1, 25),
                oleg, diana);
        tree.add(alena);
        tree.add(ramil);

        Human grandMother = new Human("Ирина", Gender.Female, LocalDate.of(1978, 9, 1));

        grandMother.addChild(oleg);
        tree.add(grandMother);

        return tree;
    }


}