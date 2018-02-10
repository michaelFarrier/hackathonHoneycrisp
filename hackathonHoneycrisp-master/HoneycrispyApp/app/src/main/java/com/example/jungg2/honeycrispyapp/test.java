/**
 * Created by doanm3 on 2/10/18.
 */
public class main {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Building firstBuilding = new Building("first");
        for (int i = 0; i < 10; i++) {
            Fountain instance = new Fountain(i);
            firstBuilding.addToList(i, instance);
        }
        Fountain firstFountain = firstBuilding.getFountainByID(0);
        int id = firstFountain.getLocation();
        System.out.println(id);
    }
}
