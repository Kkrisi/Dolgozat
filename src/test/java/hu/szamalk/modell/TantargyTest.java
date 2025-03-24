package hu.szamalk.modell;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TantargyTest {
    Tantargy tantargy;

    @Test
    void testKreditErtekIntervallum() {
        List<Tantargy> tantargyak = List.of();
        tantargyak.add(tantargyak.get(1));
        tantargyak.add(tantargyak.get(2));
        Tantargy tantargy1 = new Tantargy("Informatika", 5, "Prof László", 1, true);
        assertTrue(tantargy1.getKredit() > 0 && tantargy1.getKredit() < 6);
    }

    
}