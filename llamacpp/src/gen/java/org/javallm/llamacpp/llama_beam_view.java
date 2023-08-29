// Targeted by JavaCPP version 1.5.10-SNAPSHOT: DO NOT EDIT THIS FILE

package org.javallm.llamacpp;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.javallm.llamacpp.global.llama.*;


    //
    // Beam search
    //

    @Properties(inherit = org.javallm.llamacpp.presets.llama.class)
public class llama_beam_view extends Pointer {
        static { Loader.load(); }
        /** Default native constructor. */
        public llama_beam_view() { super((Pointer)null); allocate(); }
        /** Native array allocator. Access with {@link Pointer#position(long)}. */
        public llama_beam_view(long size) { super((Pointer)null); allocateArray(size); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public llama_beam_view(Pointer p) { super(p); }
        private native void allocate();
        private native void allocateArray(long size);
        @Override public llama_beam_view position(long position) {
            return (llama_beam_view)super.position(position);
        }
        @Override public llama_beam_view getPointer(long i) {
            return new llama_beam_view((Pointer)this).offsetAddress(i);
        }
    
        public native @Cast("const llama_token*") IntPointer tokens(); public native llama_beam_view tokens(IntPointer setter);
        public native @Cast("size_t") long n_tokens(); public native llama_beam_view n_tokens(long setter);
        public native float p(); public native llama_beam_view p(float setter);   // Cumulative beam probability (renormalized relative to all beams)
        public native @Cast("bool") boolean eob(); public native llama_beam_view eob(boolean setter);  // Callback should set this to true when a beam is at end-of-beam.
    }