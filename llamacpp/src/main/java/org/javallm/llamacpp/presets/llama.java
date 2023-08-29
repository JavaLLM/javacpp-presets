package org.javallm.llamacpp.presets;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.Properties;
import org.bytedeco.javacpp.tools.Info;
import org.bytedeco.javacpp.tools.InfoMap;
import org.bytedeco.javacpp.tools.InfoMapper;

@Properties(
        value = {
                @Platform(include = {"ggml.h", "k_quants.h", "ggml-alloc.h", "llama.h"}, link = "llama@.1#")
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
        ggml.mapping(infoMap);

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
                .put(new Info("GGML_USE_METAL").define(false))
                .put(new Info("defined(GGML_USE_METAL)").define(false))
                .put(new Info("llama_vocab_type").skip(true));
    }
}
