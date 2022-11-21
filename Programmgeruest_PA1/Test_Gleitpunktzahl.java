import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test_Gleitpunktzahl {
/**
 * Testklasse, ob alles funktioniert!
 */


    public static void main(String[] argv) {
        test_Gleitpunktzahl();
    }

    public static void test_Gleitpunktzahl() {

        /**********************************/
        /* Test der Klasse Gleitpunktzahl */
        /**********************************/

        System.out.println("-----------------------------------------");
        System.out.println("Test der Klasse Gleitpunktzahl");


        int numberOfFaults = 0;

        /*
         * Verglichen werden die BitFelder fuer Mantisse und Exponent und das
         * Vorzeichen
         */
        Gleitpunktzahl.setSizeMantisse(4);
        Gleitpunktzahl.setSizeExponent(2);

        Gleitpunktzahl x;
        Gleitpunktzahl y;
        Gleitpunktzahl gleitref = new Gleitpunktzahl();
        Gleitpunktzahl gleiterg;

        // Standardwerte to use
        Gleitpunktzahl negInf = new Gleitpunktzahl();
        negInf.setInfinite(true);
        Gleitpunktzahl posInf = new Gleitpunktzahl();
        posInf.setInfinite(false);
        Gleitpunktzahl nan = new Gleitpunktzahl();
        nan.setNaN();
        Gleitpunktzahl nullGleit = new Gleitpunktzahl();
        nullGleit.setNull();


        /* Test von setDouble */
        System.out.println("Test von setDouble");
        try {
            // Test: setDouble
            x = new Gleitpunktzahl(0.5);

            // Referenzwerte setzen
            gleitref = new Gleitpunktzahl(0.5);

            System.out.println("Expected: " + gleitref.toString() + " , Result: " + x.toString());

            // Test, ob Ergebnis korrekt
            if (x.compareAbsTo(gleitref) != 0
                    || x.vorzeichen != gleitref.vorzeichen) {
                printErg("" + x.toDouble(), "" + gleitref.toDouble());
            } else {
                System.out.println("    Richtiges Ergebnis\n");
            }

            /*************
             * Eigene Tests einfuegen
             */

            System.out.println("\n\nEIGENE TESTS EINFÜGEN!!!!!!!\n\n");
            
            // Input, Expected
            Map<Gleitpunktzahl, Gleitpunktzahl> inputAndExpected = new HashMap<>();
            // inputAndExpected.put(new Gleitpunktzahl(0.5), new Gleitpunktzahl(0.5));
            // inputAndExpected.put(new Gleitpunktzahl(3.9), nan);
            // inputAndExpected.put(new Gleitpunktzahl(1.0/0.0), posInf);
            // inputAndExpected.put(new Gleitpunktzahl(-4.0), nan);
            // inputAndExpected.put(new Gleitpunktzahl(1.5).add(new Gleitpunktzahl(-3.5)), new Gleitpunktzahl(-2.0));
            //inputAndExpected.put(posInf.add(negInf), nan);
            //inputAndExpected.put(posInf.sub(posInf), nan);
            // inputAndExpected.put(.add(negInf), nan);
            Gleitpunktzahl lowel =new Gleitpunktzahl(-0.375);
            Gleitpunktzahl theni =new Gleitpunktzahl(1.0625);
            Gleitpunktzahl expected =new Gleitpunktzahl(0.6875);

            /*(-90, 128, 38);
            new TestValues(-512,1024,512);
            new TestValues(-0.375, 1.0625, 0.6875);
            new TestValues(128, -128, 0);
            new TestValues(Double.POSITIVE_INFINITY, 0, Double.POSITIVE_INFINITY);
            new TestValues(-30, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
            new TestValues(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN);
            inputAndExpected.put(new Gleitpunktzahl( 0.0/0.0), nan);*/

            
            testSetDouble(inputAndExpected);



        } catch (Exception e) {
            System.out.print("Exception bei der Auswertung des Ergebnis!!\n");
        }

        /* Addition */
        System.out.println("Test der Addition mit Gleitpunktzahl");
        try {
            // Test: Addition
            System.out.println("Test: Addition  x + y");
            x = new Gleitpunktzahl(-0.375);
            y = new Gleitpunktzahl(1.0625);

            // Referenzwerte setzen
            gleitref = new Gleitpunktzahl( 0.6875);
            System.out.println(gleitref.toString());

            // Berechnung
            gleiterg = x.add(y);
            System.out.println(gleiterg.toString());

            // Test, ob Ergebnis korrekt
            if (gleiterg.compareAbsTo(gleitref) != 0
                    || gleiterg.vorzeichen != gleitref.vorzeichen) {
                printAdd(x.toString(), y.toString());
                printErg(gleiterg.toString(), gleitref.toString());
            } else {
                System.out.println("    Richtiges Ergebnis\n");
            }

            /*************
             * Eigene Tests einfuegen
             */

            System.out.println("\n\nEIGENE TESTS EINFÜGEN!!!!!!!\n\n");

        } catch (Exception e) {
            System.out.print("Exception bei der Auswertung des Ergebnis!!\n");
        }

        /* Subtraktion */
        try {
            System.out.println("Test der Subtraktion mit Gleitpunktzahl");

            // Test: Addition
            System.out.println("Test: Subtraktion  x - y");
            x = new Gleitpunktzahl(3.25);
            y = new Gleitpunktzahl(3.5);
            System.out.println("Test: Subtraktion " + x.toString() + " - " + y.toString());

            // Referenzwerte setzen
            gleitref = new Gleitpunktzahl((3.25 - 3.5));

            // Berechnung
            gleiterg = x.sub(y);

            // Test, ob Ergebnis korrekt
            if (gleiterg.compareAbsTo(gleitref) != 0
                    || gleiterg.vorzeichen != gleitref.vorzeichen) {
                printSub(x.toString(), y.toString());
                printErg(gleiterg.toString(), gleitref.toString());
            } else {
                System.out.println("    Richtiges Ergebnis\n");
            }

            /*************
             * Eigene Tests einfuegen
             */

            System.out.println("\n\nEIGENE TESTS EINFÜGEN!!!!!!!\n\n");

        } catch (Exception e) {
            System.out.print("Exception bei der Auswertung des Ergebnis!!\n");
        }

        /* Sonderfaelle */
        System.out.println("Test der Sonderfaelle mit Gleitpunktzahl");

        try {
            // Test: Sonderfaelle
            // 0 - inf
            System.out.println("Test: Sonderfaelle");
            x = new Gleitpunktzahl(0.0);
            y = new Gleitpunktzahl(1.0 / 0.0);
            System.out.println("Test: " + x.toString() + " - " + y.toString());

            // Referenzwerte setzen
            gleitref.setInfinite(true);

            // Berechnung mit der Methode des Studenten durchfuehren
            gleiterg = x.sub(y);

            // Test, ob Ergebnis korrekt
            if (gleiterg.compareAbsTo(gleitref) != 0
                    || gleiterg.vorzeichen != gleitref.vorzeichen) {
                printSub(x.toString(), y.toString());
                printErg(gleiterg.toString(), gleitref.toString());
            } else {
                System.out.println("    Richtiges Ergebnis\n");
            }

            /*************
             * Eigene Tests einfuegen
             */

            System.out.println("\n\nEIGENE TESTS EINFÜGEN!!!!!!!\n\n");


        } catch (Exception e) {
            System.out
                    .print("Exception bei der Auswertung des Ergebnis in der Klasse Gleitpunktzahl!!\n");
        }

    }


    private static void printAdd(String x, String y) {
        System.out.println("    Fehler!\n      Es wurde gerechnet:            "
                + x + " + " + y);
    }

    private static void printSub(String x, String y) {
        System.out.println("    Fehler!\n      Es wurde gerechnet:            "
                + x + " - " + y + " = \n");
    }

    private static void printErg(String erg, String checkref) {
        System.out.println("      Ihr Ergebnis lautet:           " + erg
                + "\n      Das Korrekte Ergebnis lautet:  " + checkref + "\n");
    }


    private static boolean compareResultAndExpected(Gleitpunktzahl result, Gleitpunktzahl expected) {
        if(expected.vorzeichen != result.vorzeichen) return false;
        if(expected.compareAbsTo(result) != 0) return false;
        else return true;
    }

    private static void testSetDouble(Map<Gleitpunktzahl, Gleitpunktzahl> map) {
        for (Map.Entry<Gleitpunktzahl, Gleitpunktzahl> entry : map.entrySet()) {
            String ergebnis = "";
            if(compareResultAndExpected(entry.getKey(), entry.getValue())) {
                ergebnis = "Richtig! ";
            } else {
                ergebnis = "Falsch! ";
            }

            System.out.println(ergebnis + "Expected: " + entry.getValue().toString() + " , Result: " + entry.getKey().toString());
        }
        System.out.println("\n\n");
    }
}
