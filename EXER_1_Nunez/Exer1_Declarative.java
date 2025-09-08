// **************************************************************
// File Name: EXER1_DECLARATIVE.java
// Author: Antonio S. Nuñez
// Date: September 5 2025
// Description: Nagpakita og Declarative Programming sa Java
//              gamit ang stream() ug usa ka kondisyon.
// **************************************************************

import java.util.Arrays;  // Para makahimo og fixed array/list
import java.util.List;    // Para gamiton ang List nga koleksyon

public class Exer1_Declarative {
    public static void main(String[] args) {
        // Koleksyon sa mga ngalan
        List<String> names = Arrays.asList("lavacca", "Tralalelo", "Bombardilo", "Loscombi", "Balerina");

        // Declarative nga estilo:
        // "Unsay atong gustong i-check?" → tan-awon kung adunay ngalan nga ≤ 3 ka letra
        boolean hasShortName = names.stream().anyMatch(name -> name.length() <= 3);

        // Ipakita ang resulta
        System.out.println("Aduna bay ngalan nga mubo (<=3 chars)? " + hasShortName);
    }
}

// ----------------------------
// SAMPLE OUTPUT
// ----------------------------
// Aduna bay ngalan nga mubo (<=3 chars)? false
//
// GENERAL COMMENT:
// Ang declarative nga estilo nagtan-aw sa *unsay buhaton*
// ug dili sa detalyado nga paagi sa pag-loop. 
// Ang stream().anyMatch() awtomatik nga mo-traverse sa tanan entries.
// ----------------------------