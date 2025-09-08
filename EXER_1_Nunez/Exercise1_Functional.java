// **************************************************************
// File Name: Exercise1_Functional.java
// Author: Antonio S. Nuñez
// Date: September 05 2025
// Description: Nagpakita og Functional Programming sa Java
//              gamit ang lambda expressions ug Stream API.
// **************************************************************

import java.util.Arrays;    // Para sa Arrays.asList()
import java.util.List;      // Gigamit para sa List interface
import java.util.stream.Collectors;  // Gamit para sa collect() method

public class Exercise1_Functional {
    public static void main(String[] args) {
        // Dataset nga listahan sa mga numero
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // Functional nga pamaagi:
        // I-deklara lang ang buhaton → kuhaon ang mga even numbers ug i-square
        List<Integer> squaresOfEven = numbers.stream()
                .filter(n -> n % 2 == 0)      // pili-a lang ang even numbers
                .map(n -> n * n)              // kuhaa ang square sa matag usa
                .collect(Collectors.toList()); // ibutang sa bag-ong list

        // Ipakita ang resulta
        System.out.println("Mga square sa even numbers (Functional): " + squaresOfEven);
    }
}

// ----------------------------
// SAMPLE OUTPUT:
// ----------------------------
// Mga square sa even numbers (Functional): [4, 16, 36, 64, 100]
//
// GENERAL COMMENT:
// Ang functional nga pamaagi mas klaro ug mas mubo ang code.
// Dili na kinahanglan maghimo og explicit loop, kay ang Stream()
// maoy mo-handle sa pag-process sa data.
// ----------------------------