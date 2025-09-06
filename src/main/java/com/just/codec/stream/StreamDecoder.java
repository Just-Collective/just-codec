package com.just.codec.stream;

import com.just.codec.stream.schema.StreamCodecSchema;
import org.jetbrains.annotations.NotNull;

public interface StreamDecoder<A> {

    @NotNull
    <T> A decode(@NotNull StreamCodecSchema<T> streamCodecSchema, @NotNull T input);
}
