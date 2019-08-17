package io.thedocs.soyuz;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class isTest {

    @Test
    public void testIsBigDecimal() {
        assertTrue(is.t(new BigDecimal(1)));
        assertTrue(is.t(new BigDecimal(0.1)));
        assertFalse(is.t(new BigDecimal(0.0)));
        assertFalse(is.t(new BigDecimal(0)));
        assertFalse(is.t(new BigDecimal(-0.0)));
        assertFalse(is.t((BigDecimal) null));
    }

    @Test
    public void testIsDouble() {
        assertTrue(is.t(new Double(1)));
        assertTrue(is.t(new Double(0.1)));
        assertFalse(is.t(new Double(0.0)));
        assertFalse(is.t(new Double(0)));
        assertFalse(is.t(new Double(-0.0)));
        assertFalse(is.t((Double) null));
    }

    @Test
    public void testIsFloat() {
        assertTrue(is.t(new Float(1)));
        assertTrue(is.t(new Float(0.1)));
        assertFalse(is.t(new Float(0.0)));
        assertFalse(is.t(new Float(0)));
        assertFalse(is.t(new Float(-0.0)));
        assertFalse(is.t((Float) null));
    }

    @Test
    public void testTruthyCastable() {
        assertFalse(is.t((Project.Id) null));
        assertFalse(is.t(new Project.Id(null)));
        assertFalse(is.t(new Project.Id("")));
        assertTrue(is.t(new Project.Id("1")));
    }

    @AllArgsConstructor
    @Getter
    static class Project {
        private Id id;

        @AllArgsConstructor
        static class Id implements TruthyCastableI {
            private String value;

            @Override
            public boolean asTruthy() {
                return is.t(value);
            }
        }
    }
}
