// Targeted by JavaCPP version 1.5.10-SNAPSHOT: DO NOT EDIT THIS FILE

package org.javallm.llamacpp;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.javallm.llamacpp.global.llama.*;


    // grammar types
    @Opaque @Properties(inherit = org.javallm.llamacpp.presets.llama.class)
public class llama_grammar extends Pointer {
        /** Empty constructor. Calls {@code super((Pointer)null)}. */
        public llama_grammar() { super((Pointer)null); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public llama_grammar(Pointer p) { super(p); }
    }