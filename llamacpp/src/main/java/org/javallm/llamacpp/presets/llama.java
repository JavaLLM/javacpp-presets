package org.javallm.llamacpp.presets;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.Properties;
import org.bytedeco.javacpp.tools.Info;
import org.bytedeco.javacpp.tools.InfoMap;
import org.bytedeco.javacpp.tools.InfoMapper;

@Properties(
        value = {
                @Platform(
                        value = {"macosx-arm64"},
                        include = {"ggml.h", "llama.h"},
                        link = {"llama@.1#"}
                )
        },
        target = "org.javallm.llamacpp",
        global = "org.javallm.llamacpp.global.llama"
)
public class llama implements InfoMapper {
    static {
        Loader.checkVersion("org.javallm", "llamacpp");
    }

    @Override
    public void map(InfoMap infoMap) {
        llama.mapping(infoMap);
    }

    public static void mapping(InfoMap infoMap) {
        // GGML
        infoMap
                .put(new Info("DEPRECATED").skip())
                .put(new Info("__ARM_NEON").define(false))
                .put(new Info("GGML_USE_K_QUANTS").define(true))
                .put(new Info("GGML_USE_METAL").define(true))
                .put(new Info("defined(GGML_USE_METAL)").define(true))
                .put(new Info("defined(__ARM_NEON)").define(false))
                .put(new Info("GGML_SHARED").define(false))
                .put(new Info("GGML_QKK_64").define(false))
                .put(new Info("GGML_CUDA_F16").define(false))
                .put(new Info("defined(__ARM_NEON) && defined(__CUDACC__)").define(false))
                .put(new Info("ggml_allocr").skip(true));

        // LLaMA.cpp
        infoMap
                .put(new Info("__cplusplus").define(true))
                .put(new Info("constexpr").skip(true))
                .put(new Info("LLAMA_SHARED").define(false))
                .put(new Info("LLAMA_API_INTERNAL").define(false))
                .put(new Info("_WIN32").define(false))
                .put(new Info("defined(_WIN32)").define(false))
                .put(new Info("GGML_USE_CUBLAS").define(false))
                .put(new Info("defined(GGML_USE_CUBLAS)").define(false))
                .put(new Info("GGML_USE_CLBLAS").define(false))
                .put(new Info("defined(GGML_USE_CLBLAS)").define(false))
                .put(new Info("llama_vocab_type").skip(true));
    }
}
