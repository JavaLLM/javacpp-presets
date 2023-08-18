// Targeted by JavaCPP version 1.5.10-SNAPSHOT: DO NOT EDIT THIS FILE

package org.javallm.llamacpp;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.javallm.llamacpp.global.ggml.*;


// This is only used for intermediate quantization and dot products
@Properties(inherit = org.javallm.llamacpp.presets.ggml.class)
public class block_q8_K extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public block_q8_K() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public block_q8_K(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public block_q8_K(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public block_q8_K position(long position) {
        return (block_q8_K)super.position(position);
    }
    @Override public block_q8_K getPointer(long i) {
        return new block_q8_K((Pointer)this).offsetAddress(i);
    }

    public native float d(); public native block_q8_K d(float setter);              // delta
    public native byte qs(int i); public native block_q8_K qs(int i, byte setter);
    @MemberGetter public native BytePointer qs();       // quants
    public native short bsums(int i); public native block_q8_K bsums(int i, short setter);
    @MemberGetter public native ShortPointer bsums(); // sum of quants in groups of 16
}