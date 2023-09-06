package com.alura.hotelalura.utils;

public enum Nationalities {
	ARGENTINA("Argentina"),
    BOLIVIANA("Boliviana"),
    BRASILE�A("Brasile�a"),
    CANADIENSE("Canadiense"),
    CHILENA("Chilena"),
    COLOMBIANA("Colombiana"),
    COSTARRICENSE("Costarricense"),
    CUBANA("Cubana"),
    DOMINICANA("Dominicana"),
    ECUATORIANA("Ecuatoriana"),
    ESTADOUNIDENSE("Estadounidense"),
    GUATEMALTECA("Guatemalteca"),
    HONDURE�A("Hondure�a"),
    MEXICANA("Mexicana"),
    NICARAG�ENSE("Nicarag�ense"),
    PANAME�A("Paname�a"),
    PARAGUAYA("Paraguaya"),
    PERUANA("Peruana"),
    SALVADORE�A("Salvadore�a"),
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
