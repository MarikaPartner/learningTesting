package java_core.lesson_3.houseAtTree;

public class HouseAtTree<T extends Animal & Flyable> {
    private T master;

    public static void main(String[] args) {
        HouseAtTree<Bird> house = new HouseAtTree<>(new Bird());
    }

    public HouseAtTree(T master) {
        this.master = master;
    }

    public T getMaster() {
        return master;
    }

    public void setMaster(T master) {
        this.master = master;
    }


}
