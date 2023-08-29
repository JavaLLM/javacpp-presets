// Targeted by JavaCPP version 1.5.10-SNAPSHOT: DO NOT EDIT THIS FILE

package org.javallm.llamacpp;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.javallm.llamacpp.global.llama.*;


    @Properties(inherit = org.javallm.llamacpp.presets.llama.class)
public class ggml_opt_callback extends FunctionPointer {
        static { Loader.load(); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public    ggml_opt_callback(Pointer p) { super(p); }
        protected ggml_opt_callback() { allocate(); }
        private native void allocate();
        public native void call(Pointer data, FloatPointer sched);
    }