package pl.coderslab.dragondice.web;

public class ModifiersDefiner {

    public int strModifier(int strMod) {
        if (strMod == 8 || strMod == 9) {
            return -1;
        } else if (strMod == 10 || strMod == 11) {
            return 0;
        } else if (strMod == 12 || strMod == 13) {
            return 1;
        } else if (strMod == 14 || strMod == 15) {
            return 2;
        } else if (strMod == 16 || strMod == 17) {
            return 3;
        } else if (strMod == 18 || strMod == 19) {
            return 4;
        } else if (strMod == 20) {
            return 5;
        } else if (strMod > 21) {
            return 6;
        } else {
            return -2;
        }
    }

    public int dexModifier(int dexMod) {
        if (dexMod == 8 || dexMod == 9) {
            return -1;
        } else if (dexMod == 10 || dexMod == 11) {
            return 0;
        } else if (dexMod == 12 || dexMod == 13) {
            return 1;
        } else if (dexMod == 14 || dexMod == 15) {
            return 2;
        } else if (dexMod == 16 || dexMod == 17) {
            return 3;
        } else if (dexMod == 18 || dexMod == 19) {
            return 4;
        } else if (dexMod == 20) {
            return 5;
        } else if (dexMod > 21) {
            return 6;
        }else {
            return -2;
        }

    }

    public int conModifier(int conMod) {
        if (conMod == 8 || conMod == 9) {
            return -1;
        } else if (conMod == 10 || conMod == 11) {
            return 0;
        } else if (conMod == 12 || conMod == 13) {
            return 1;
        } else if (conMod == 14 || conMod == 15) {
            return 2;
        } else if (conMod == 16 || conMod == 17) {
            return 3;
        } else if (conMod == 18 || conMod == 19) {
            return 4;
        } else if (conMod == 20) {
            return 5;
        } else if (conMod > 21) {
            return 6;
        }else {
            return -2;
        }
    }

    public int intModifier(int intMod) {
        if (intMod == 8 || intMod == 9) {
            return -1;
        } else if (intMod == 10 || intMod == 11) {
            return 0;
        } else if (intMod == 12 || intMod == 13) {
            return 1;
        } else if (intMod == 14 || intMod == 15) {
            return 2;
        } else if (intMod == 16 || intMod == 17) {
            return 3;
        } else if (intMod == 18 || intMod == 19) {
            return 4;
        } else if (intMod == 20) {
            return 5;
        } else if (intMod > 21) {
            return 6;
        }else {
            return -2;
        }
    }

    public int wisModifier(int wisMod) {
        if (wisMod == 8 || wisMod == 9) {
            return -1;
        } else if (wisMod == 10 || wisMod == 11) {
            return 0;
        } else if (wisMod == 12 || wisMod == 13) {
            return 1;
        } else if (wisMod == 14 || wisMod == 15) {
            return 2;
        } else if (wisMod == 16 || wisMod == 17) {
            return 3;
        } else if (wisMod == 18 || wisMod == 19) {
            return 4;
        } else if (wisMod == 20) {
            return 5;
        } else if (wisMod > 21) {
            return 6;
        }else {
            return -2;
        }
    }

    public int chaModifier(int chaMod) {
        if (chaMod == 8 || chaMod == 9) {
            return -1;
        } else if (chaMod == 10 || chaMod == 11) {
            return 0;
        } else if (chaMod == 12 || chaMod == 13) {
            return 1;
        } else if (chaMod == 14 || chaMod == 15) {
            return 2;
        } else if (chaMod == 16 || chaMod == 17) {
            return 3;
        } else if (chaMod == 18 || chaMod == 19) {
            return 4;
        } else if (chaMod == 20) {
            return 5;
        } else if (chaMod > 21) {
            return 6;
        }else {
            return -2;
        }
    }

}
