
package org.core;

public class PrivacyEncoder {

    public static int anonymize(int node) {
        return Math.abs(("NODE_" + node).hashCode());
    }
}
