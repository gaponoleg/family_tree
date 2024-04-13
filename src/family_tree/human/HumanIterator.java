package family_tree.human;

import family_tree.family_tree.FamilyItem;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<E extends FamilyItem<E>> implements Iterator<E> {
    private int index;
    private final List<E> humanList;

    public HumanIterator(List<E> humanList){
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public E next() {
        return humanList.get(index++);
    }
}
