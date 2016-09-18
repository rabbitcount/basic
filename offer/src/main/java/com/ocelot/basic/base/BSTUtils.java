package com.ocelot.basic.base;

import java.util.*;

public class BSTUtils {

    public static List<String> createBSTInp(int count) {
        List<String> ret = new LinkedList();
        if (count < 0) {
            return ret;
        }
        String k = null;
        for (int index = 0; index < count; index++) {
            k = Double.valueOf(StdRandom.uniform()).toString();
            ret.add(k);
        }
        return ret;
    }

    public static BST createBST(List<String> inp) {
        BST bst = new BST();
        if (Objects.isNull(inp)) {
            return bst;
        }
        for (String e : inp) {
            bst.put(e, e);
        }
        return bst;
    }
}
