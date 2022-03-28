package org.example.mvnexample;

import org.junit.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ContestKeepMulpTest {
    @Test
    public  void  findFinValue(){
        int exres= ContestKeepMultiplying.findFinalValue(new int[]{8,19,4,2,15,3},4);
        assertEquals(exres,exres);

    }

}
