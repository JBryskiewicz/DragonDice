package pl.coderslab.dragondice.mechanics;

public class ModifiersDefiner {

    /** checks ability score and return modifier that will be added to "dice rolls" */
    public static int abilityModifier(int modifier) {
        if (modifier == 8 || modifier == 9) {
            return -1;
        } else if (modifier == 10 || modifier == 11) {
            return 0;
        } else if (modifier == 12 || modifier == 13) {
            return 1;
        } else if (modifier == 14 || modifier == 15) {
            return 2;
        } else if (modifier == 16 || modifier == 17) {
            return 3;
        } else if (modifier == 18 || modifier == 19) {
            return 4;
        } else if (modifier == 20 || modifier == 21) {
            return 5;
        } else if (modifier == 22 || modifier == 23) {
            return 6;
        } else if (modifier == 24 || modifier == 25) {
            return 7;
        } else if (modifier >= 26){
            return 8;
        } else {
            return -2;
        }
    }
}
