package com.gmou.api.src.test.java.org.hyperledger.fabric_ca.sdk;

/**
 * Created by zerppen on 1/3/18.
 */
import java.io.Serializable;
import java.security.KeyPair;
import java.security.PrivateKey;
import org.hyperledger.fabric.sdk.Enrollment;

public class HFCAEnrollment implements Enrollment, Serializable {
    private static final long serialVersionUID = 550416591376968096L;
    private KeyPair key;
    private String cert;

    HFCAEnrollment(KeyPair signingKeyPair, String signedPem) {
        this.key = signingKeyPair;
        this.cert = signedPem;
    }

    public PrivateKey getKey() {
        return this.key.getPrivate();
    }

    public String getCert() {
        return this.cert;
    }
}
