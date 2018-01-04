/*
 Copyright IBM Corp. All Rights Reserved.

 SPDX-License-Identifier: Apache-2.0
*/
package com.gmou.api.src.test.java.org.hyperledger.fabric.sdkintegration;

//import org.hyperledger.fabric_ca.sdkintegration.HFCAClientIT;
import com.gmou.api.src.test.java.org.hyperledger.fabric_ca.sdkintegration.HFCAClientIT;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith (Suite.class)

@Suite.SuiteClasses({
        End2endIT.class,
        End2endAndBackAgainIT.class,
        UpdateChannelIT.class,
        HFCAClientIT.class
})
public class IntegrationSuite {

}
