package family_tree.model.family_tree.family_tree;


import family_tree.model.family_tree.human.HumanIterator;
import family_tree.model.family_tree.human.comporators.HumanComparatorByAge;
import family_tree.model.family_tree.human.comporators.HumanComporatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyItem<E>> implements Serializable, Iterable<E> {
    private long countPeople;
    private List<E> humanList;

    public FamilyTree(List<E> humanList) {
        this.humanList = humanList;
    }

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public boolean add(E human){
        if (human == null){
            return false;
        }
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(countPeople++);

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }


    private void addToParents(E human){
        for (E parent: human.getParents()){
            parent.addChild(human);
        }
    }

    private void addToChildren(E human){
        for (E child: human.getChildren()){
            child.addParent(human);
        }
    }

    private boolean checkId(long id) {
        return id < countPeople && id >= 0;
    }

    public boolean setDivorce(E human1, E human2){
        if (human1.getSpouse() != null && human2.getSpouse() != null){
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        } else {
            return false;
        }
    }

    public boolean setWedding(E human1, E human2){
        if (human1.getSpouse() == null && human2.getSpouse() == null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        } else {
            return false;
        }
    }

    public E getById(long id){
        if(checkId(id)){
            for (E human: humanList){
                if (human.getId() == id){
                    return human;
                }
            }
        }
        return null;
    }
    @Override
    public String toString(){ return getInfo(); }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (E human: humanList){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortByName(){
        humanList.sort(new HumanComporatorByName());
    }

    public void sortByAge(){
        humanList.sort(new HumanComparatorByAge());
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator(humanList);
    }
}
