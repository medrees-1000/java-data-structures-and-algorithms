/* * Copyright (c) 2025 Citytech and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * Developer: MOhammad , Bahar
 */

package edu.citytech.cst3650.s24405505.ds.bst;

/**
 * Thrown when an exceptional duplicate entry condition has occurred. For
 * example, entering the value 105 twice, in the append method of the 
 * BinarySearchTree
 * * @since 1.0
 */
public class DuplicateEntryException extends RuntimeException {

    @java.io.Serial
    private static final long serialVersionUID = 2256477558314496007L;

    /**
     * Constructs an {@code DuplicateEntryException} with the specified
     * detail message.
     * * @param s  the detail message.
     */
    public DuplicateEntryException(String s) {
        super(s);
    }
}
