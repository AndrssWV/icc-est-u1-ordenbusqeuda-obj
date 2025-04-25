package controllers;

import models.Direccion;
import models.Persona;

public class PersonaController {
    public void sortByDireccionCodigo(Persona[] personas) {
        for(int i = 0; i < personas.length -1; i++) {
            int iM = i;
            for(int j = i+1; j < personas.length; j++) {
                if  (personas[j].compareCode(personas[i])) {
                    iM = j;
                }
            }
            if (iM != i) {
                Persona aux = personas[i];
                personas[i] = personas[iM];
                personas[iM] = aux;
            }
        }
    }

    public Persona findByCodigo(Persona[] personas, int codigo) {
        int low = 0;
        int high = personas.length-1;
        while (high>=low) {
            int center = (high+low)/2;
            if (personas[center].equalCode(codigo)) return personas[center];
            if (personas[center].compareCode(codigo)) low = center+1;
            else high = center-1;
        }
        return null;
    }
}
