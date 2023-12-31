// Targeted by JavaCPP version 1.5.10-SNAPSHOT: DO NOT EDIT THIS FILE

package org.javallm.llamacpp;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.javallm.llamacpp.global.llama.*;


    // Signature for logging events
    // Note that text includes the new line character at the end for most events.
    // If your logging mechanism cannot handle that, check if the last character is '\n' and strip it
    // if it exists.
    // It might not exist for progress report where '.' is output repeatedly.
    @Properties(inherit = org.javallm.llamacpp.presets.llama.class)
public class llama_log_callback extends FunctionPointer {
        static { Loader.load(); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public    llama_log_callback(Pointer p) { super(p); }
        protected llama_log_callback() { allocate(); }
        private native void allocate();
        public native void call(@Cast("llama_log_level") int level, @Cast("const char*") BytePointer text, Pointer user_data);
    }
