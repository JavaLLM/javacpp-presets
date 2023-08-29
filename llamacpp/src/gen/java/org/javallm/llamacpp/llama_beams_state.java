// Targeted by JavaCPP version 1.5.10-SNAPSHOT: DO NOT EDIT THIS FILE

package org.javallm.llamacpp;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.javallm.llamacpp.global.llama.*;


    // Passed to beam_search_callback function.
    // Whenever 0 < common_prefix_length, this number of tokens should be copied from any of the beams
    // (e.g. beams[0]) as they will be removed (shifted) from all beams in all subsequent callbacks.
    // These pointers are valid only during the synchronous callback, so should not be saved.
    @Properties(inherit = org.javallm.llamacpp.presets.llama.class)
public class llama_beams_state extends Pointer {
        static { Loader.load(); }
        /** Default native constructor. */
        public llama_beams_state() { super((Pointer)null); allocate(); }
        /** Native array allocator. Access with {@link Pointer#position(long)}. */
        public llama_beams_state(long size) { super((Pointer)null); allocateArray(size); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public llama_beams_state(Pointer p) { super(p); }
        private native void allocate();
        private native void allocateArray(long size);
        @Override public llama_beams_state position(long position) {
            return (llama_beams_state)super.position(position);
        }
        @Override public llama_beams_state getPointer(long i) {
            return new llama_beams_state((Pointer)this).offsetAddress(i);
        }
    
        public native llama_beam_view beam_views(); public native llama_beams_state beam_views(llama_beam_view setter);
        public native @Cast("size_t") long n_beams(); public native llama_beams_state n_beams(long setter);               // Number of elements in beam_views[].
        public native @Cast("size_t") long common_prefix_length(); public native llama_beams_state common_prefix_length(long setter);  // Current max length of prefix tokens shared by all beams.
        public native @Cast("bool") boolean last_call(); public native llama_beams_state last_call(boolean setter);               // True iff this is the last callback invocation.
    }
