package family_tree.family_tree;

import java.io.Serializable;

public interface FamilyItem<E> extends Serializable {
    String getName();
    int getAge();

    void setId(long l);

    E[] getParents();

    E[] getChildren();

    void addParent(E human);

    Object getSpouse();

    void setSpouse(E human2);

    long getId();
}
