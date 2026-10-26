package hu.bme.mit.spaceship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TorpedoStoreTest {
    @Test
    void EmptyBays_Test() {
        GT4500 ship = new GT4500(0, 0, 0, 0);

        boolean single = ship.fireTorpedo(FiringMode.SINGLE);
        boolean all = ship.fireTorpedo(FiringMode.ALL);

        assertFalse(single);
        assertFalse(all);
    }

    @Test
    void AlternateBays_Test() {
        GT4500 ship = new GT4500(3, 0, 1, 0);

        boolean fire1 = ship.fireTorpedo(FiringMode.SINGLE);
        boolean fire2 = ship.fireTorpedo(FiringMode.SINGLE);
        boolean fire3 = ship.fireTorpedo(FiringMode.SINGLE);
        boolean fire4 = ship.fireTorpedo(FiringMode.SINGLE);
        boolean fire5 = ship.fireTorpedo(FiringMode.SINGLE);

        assertTrue(fire1);
        assertTrue(fire2);
        assertTrue(fire3);
        assertTrue(fire4);
        assertFalse(fire5);
    }

    @Test
    void AllMode_BothLoaded_Test() {
        GT4500 ship = new GT4500(1, 0, 1, 0);

        boolean fire = ship.fireTorpedo(FiringMode.ALL);

        assertTrue(fire);
    }

    @Test
    void AllMode_PrimaryLoaded_Test() {
        GT4500 ship = new GT4500(1, 0, 0, 0);

        boolean fire = ship.fireTorpedo(FiringMode.ALL);

        assertTrue(fire);
    }

    @Test
    void AllMode_SecondaryLoaded_Test() {
        GT4500 ship = new GT4500(0, 0, 1, 0);

        boolean fire = ship.fireTorpedo(FiringMode.ALL);

        assertTrue(fire);
    }

    @Test
    void Fail_BothLoaded_Test() {
        GT4500 ship = new GT4500(1, 1, 1, 1);

        boolean fire = ship.fireTorpedo(FiringMode.ALL);

        assertFalse(fire);
    }

    @Test
    void Fail_PrimaryLoaded_Test() {
        GT4500 ship = new GT4500(1, 1, 0, 0);

        boolean fire = ship.fireTorpedo(FiringMode.ALL);

        assertFalse(fire);
    }

    @Test
    void Fail_SecondaryLoaded_Test() {
        GT4500 ship = new GT4500(0, 0, 1, 1);

        boolean fire = ship.fireTorpedo(FiringMode.ALL);

        assertFalse(fire);
    }
}
