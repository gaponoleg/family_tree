package family_tree.presenter;

import family_tree.model.family_tree.family_tree.FamilyTree;
import family_tree.model.family_tree.human.Gender;
import family_tree.model.family_tree.human.Human;
import family_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private FamilyTree familyTree;
    private View view;



    public Presenter(View view) {
        familyTree = new FamilyTree();
        this.view = view;
    }

    public void addToFamilyTree(Human human){
        familyTree.add(human);
    }

    public void getInfo(){
        String text = familyTree.getInfo();
        System.out.println(text);
    }
    public void sortByAge() {
        familyTree.sortByAge();
        getInfo();
    }

    public void sortByName() {
        familyTree.sortByName();
        getInfo();
    }
}
