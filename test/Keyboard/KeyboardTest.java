package Keyboard;


import TestUtil.RandomGenerator;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class KeyboardTest {

    @Test
    public void newBindSingle() {
        for(int count = 0; count < 100; count++) {
            int[] keys = new int[count];
            for(int i = 0; i < keys.length; i++) {
                keys[i] = i;
            }
            int[][] keyBinds = Keyboard.newBindSingle(keys);
            for(int i = 0; i < keys.length; i++) {
                assertEquals(keys[i],keyBinds[i][0]);
            }
        }
    }

    @Test
    public void newBindMeta() {
        for(int metaCount = 0; metaCount < 50; metaCount++) {
            for(int keyCount = 0; keyCount < 100; keyCount++) {
                int[] metas = new int[metaCount];
                for(int i = 0; i < metaCount; i++) {
                    metas[i] = i;
                }
                int[] keys = new int[keyCount];
                for(int i = 0; i < keyCount; i++) {
                    keys[i] = i + metaCount;
                }
                int[][] binds = Keyboard.newBindMetas(metas,keys);
                for(int i = 0; i < keyCount; i++) {
                    for(int j = 0; j < metaCount; j++) {
                        assertEquals(metas[j],binds[i][j]);
                        assertEquals(keys[i],binds[i][metaCount]);
                    }
                }
            }
        }
    }

}