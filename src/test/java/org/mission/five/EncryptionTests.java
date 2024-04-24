package org.mission.five;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class EncryptionTests {
    final static Logger log = (Logger) LoggerFactory.getLogger(EncryptionTests.class);
    Encryption encryption;

    @Before
    public void init() {
        encryption = new Encryption();
    }

    @Test
    public void encryptionTestone () {
        String s = "have a nice day";
        String result = encryption.solve(s);
        String expected = "hae and via ecy";
        assertThat(result, is(expected));
    }

    @Test
    public void encryptionTestTwo () {
        String s = "chillout";
        String result = encryption.solve(s);
        String expected = "clu hlt io";
        assertThat(result, is(expected));
    }

    @Test
    public void encryptionTestThree () {
        String s = "feedthedog";
        String result = encryption.solve(s);
        //String expected = "clu hlt io";
        //assertThat(result, is(expected));
    }
}
