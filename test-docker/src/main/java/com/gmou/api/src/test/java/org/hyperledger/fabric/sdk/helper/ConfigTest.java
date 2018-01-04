/*
 *  Copyright 2016 DTCC, Fujitsu Australia Software Technology, IBM - All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.gmou.api.src.test.java.org.hyperledger.fabric.sdk.helper;

import com.gmou.api.src.test.java.org.hyperledger.fabric.sdk.TestConfigHelper;
import org.apache.log4j.Level;

//import org.hyperledger.fabric.sdk.TestConfigHelper;
//import org.hyperledger.fabric.sdk.helper.CONDITIONSonfig;
//import org.hyperledger.fabric.sdk.helper.Config;
import org.hyperledger.fabric_ca.sdk.helper.Config;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConfigTest {

    private TestConfigHelper configHelper = new TestConfigHelper();
    // private String originalHashAlgorithm;

    @Before
    public void setUp() throws Exception {
        // reset Config before each test
        configHelper.clearConfig();
    }

    @After
    public void tearDown() throws Exception {
        // reset Config after each test. We do not want to interfere with the
        // next test or the next test suite
        configHelper.clearConfig();
    }

    // Tests that Config.getConfig properly loads a value from a system property
    @Test
    public void testGetConfigSystemProperty() throws Exception {

        final String propName = Config.HASH_ALGORITHM;

        // Get the original value of the property so that we can restore it later
        final String originalValue = System.getProperty(propName);

        try {

            // Configure the system property with the value to be tested
            final String newVal = "XXX";
            System.setProperty(propName, newVal);

            // getConfig should load the property from System
            Config config = Config.getConfig();
            Assert.assertEquals(config.getHashAlgorithm(), newVal);
        } finally {
            // Restore the system property
            setSystemProperty(propName, originalValue);
        }

    }

    // Note: This unit test is of questionable value
    // It may be better to actually set the individual values (via a system property)
    // and make sure they come back again!
    @Test
    public void testGetters() {
        Config config = Config.getConfig();

        // Numeric params
        Assert.assertTrue(config.getSecurityLevel() > 0);
        Assert.assertTrue(config.getProposalWaitTime() > 0);
//        Assert.assertTrue(config.getGenesisBlockWaitTime() > 0);
        Assert.assertTrue(config.getSymmetricKeyByteCount() > 0);
        Assert.assertTrue(config.getMACKeyByteCount() > 0);

        Assert.assertTrue(config.maxLogStringLength() > 0);

        // Boolean params
        // Not sure how best to deal with these, as they will always return either true or false
        // So, for coverage, let's simply call the method to ensure they don't throw exceptions...
//        config.getProposalConsistencyValidation();

        // String params
        Assert.assertNotNull(config.getHashAlgorithm());
        Assert.assertNotNull(config.getAsymmetricKeyType());
        Assert.assertNotNull(config.getSymmetricKeyType());
        Assert.assertNotNull(config.getKeyAgreementAlgorithm());
        Assert.assertNotNull(config.getSymmetricAlgorithm());
        Assert.assertNotNull(config.getSignatureAlgorithm());
        Assert.assertNotNull(config.getCertificateFormat());

        // Arrays
        Assert.assertNotNull(config.getPeerCACerts());
    }

    @Test
    public void testExtraLogLevel() {
        Config config = Config.getConfig();
//        Assert.assertTrue(config.extraLogLevel(-99));
//        Assert.assertFalse(config.extraLogLevel(99));
    }

    @Test
    public void testLogLevelTrace() {
        testLogLevelAny("TRACE", Level.TRACE);
    }

    @Test
    public void testLogLevelDebug() {
        testLogLevelAny("DEBUG", Level.DEBUG);
    }

    @Test
    public void testLogLevelInfo() {
        testLogLevelAny("INFO", Level.INFO);
    }

    @Test
    public void testLogLevelWarn() {
        testLogLevelAny("WARN", Level.WARN);
    }

    @Test
    public void testLogLevelError() {
        testLogLevelAny("ERROR", Level.ERROR);
    }

    // ==========================================================================================
    // Helper methods
    // ==========================================================================================

    // Helper method to set the value of a system property
    private Object setSystemProperty(String propName, String propValue) {
        if (propValue == null) {
            System.clearProperty(propName);
        } else {
            System.setProperty(propName, propValue);
        }
        return propValue;
    }

    // Helper function to test one of the possible log levels
    private void testLogLevelAny(String levelString, Level level) {
        String originalValue = System.setProperty(Config.LOGGERLEVEL, levelString);
        try {
            // Dummy call to ensure that a config instance is created and the
            // underlying logging level is set...
            Config.getConfig();
            Assert.assertEquals(level, org.apache.log4j.Logger.getLogger("org.hyperledger.fabric").getLevel());
        } finally {
            // Restore the original value so that other tests run consistently
            setSystemProperty(Config.LOGGERLEVEL, originalValue);
        }
    }

}