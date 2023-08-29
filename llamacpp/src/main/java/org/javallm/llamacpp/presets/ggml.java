package org.javallm.llamacpp.presets;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.Properties;
import org.bytedeco.javacpp.tools.Info;
import org.bytedeco.javacpp.tools.InfoMap;
import org.bytedeco.javacpp.tools.InfoMapper;

@Properties(
        value = {
                @Platform(include = {"ggml.h", "k_quants.h", "ggml-alloc.h"}, link = "ggml@.1#")
        },
        target = "org.javallm.llamacpp",
        global = "org.javallm.llamacpp.global.ggml"
)
public class ggml implements InfoMapper {
    static {
        Loader.checkVersion("org.javallm", "llamacpp");
    }

    @Override
    public void map(InfoMap infoMap) {
        ggml.mapping(infoMap);
    }

    public static void mapping(InfoMap infoMap) {
        infoMap
                .put(new Info("DEPRECATED").skip())
                .put(new Info("__ARM_NEON").define(false))
                .put(new Info("GGML_USE_K_QUANTS").define(true))
                .put(new Info("GGML_USE_METAL").define(false))
                .put(new Info("defined(__ARM_NEON)").define(false))
                .put(new Info("GGML_SHARED").define(false))
                .put(new Info("GGML_QKK_64").define(false))
                .put(new Info("GGML_CUDA_F16").define(false))
                .put(new Info("defined(__ARM_NEON) && defined(__CUDACC__)").define(false))
                .put(new Info("ggml_allocr").skip(true));
    }
}
