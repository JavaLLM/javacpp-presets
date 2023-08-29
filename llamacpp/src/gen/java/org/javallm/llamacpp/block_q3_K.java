// Targeted by JavaCPP version 1.5.10-SNAPSHOT: DO NOT EDIT THIS FILE

package org.javallm.llamacpp;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.javallm.llamacpp.global.llama.*;


// 3-bit quantization
// weight is represented as x = a * q
// 16 blocks of 16 elemenets each
// Effectively 3.4375 bits per weight
// #ifdef GGML_QKK_64
// #else
@Properties(inherit = org.javallm.llamacpp.presets.llama.class)
public class block_q3_K extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public block_q3_K() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public block_q3_K(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public block_q3_K(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public block_q3_K position(long position) {
        return (block_q3_K)super.position(position);
    }
    @Override public block_q3_K getPointer(long i) {
        return new block_q3_K((Pointer)this).offsetAddress(i);
    }

    public native @Cast("uint8_t") byte hmask(int i); public native block_q3_K hmask(int i, byte setter);
    @MemberGetter public native @Cast("uint8_t*") BytePointer hmask();     // quants - high bit
    public native @Cast("uint8_t") byte qs(int i); public native block_q3_K qs(int i, byte setter);
    @MemberGetter public native @Cast("uint8_t*") BytePointer qs();        // quants - low 2 bits
    public native @Cast("uint8_t") byte scales(int i); public native block_q3_K scales(int i, byte setter);
    @MemberGetter public native @Cast("uint8_t*") BytePointer scales();        // scales, quantized with 6 bits
    public native @Cast("ggml_fp16_t") short d(); public native block_q3_K d(short setter);             // super-block scale
}
