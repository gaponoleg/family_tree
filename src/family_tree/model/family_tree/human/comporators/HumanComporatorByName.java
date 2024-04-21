package family_tree.model.family_tree.human.comporators;

import family_tree.model.family_tree.family_tree.FamilyItem;

import java.util.Comparator;

public class HumanComporatorByName<E extends FamilyItem<E>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
