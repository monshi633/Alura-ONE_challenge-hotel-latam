package com.alura.hotelalura.utils;

public enum Nationalities {
	ARGENTINA("Argentina"),
    BOLIVIANA("Boliviana"),
    BRASILEÑA("Brasileña"),
    CANADIENSE("Canadiense"),
    CHILENA("Chilena"),
    COLOMBIANA("Colombiana"),
    COSTARRICENSE("Costarricense"),
    CUBANA("Cubana"),
    DOMINICANA("Dominicana"),
    ECUATORIANA("Ecuatoriana"),
    ESTADOUNIDENSE("Estadounidense"),
    GUATEMALTECA("Guatemalteca"),
    HONDUREÑA("Hondureña"),
    MEXICANA("Mexicana"),
    NICARAGÜENSE("Nicaragüense"),
    PANAMEÑA("Panameña"),
    PARAGUAYA("Paraguaya"),
    PERUANA("Peruana"),
    SALVADOREÑA("Salvadoreña"),
    URUGUAYA("Uruguaya"),
    VENEZOLANA("Venezolana");

    private final String displayName;

    Nationalities(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    @Override
    public String toString() {
    	return displayName;
    }
}
