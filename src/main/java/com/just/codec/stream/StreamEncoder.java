package com.just.codec.stream;

import com.just.codec.stream.schema.StreamCodecSchema;
import org.jetbrains.annotations.NotNull;

public interface StreamEncoder<A> {

    <T> void encode(@NotNull StreamCodecSchema<T> streamCodecSchema, @NotNull T input, @NotNull A value);
}
