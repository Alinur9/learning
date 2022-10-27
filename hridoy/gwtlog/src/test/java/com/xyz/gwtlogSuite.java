package com.xyz;

import com.xyz.client.gwtlogTest;
import com.google.gwt.junit.tools.GWTTestSuite;
import junit.framework.Test;
import junit.framework.TestSuite;

public class gwtlogSuite extends GWTTestSuite {
  public static Test suite() {
    TestSuite suite = new TestSuite("Tests for gwtlog");
    suite.addTestSuite(gwtlogTest.class);
    return suite;
  }
}
