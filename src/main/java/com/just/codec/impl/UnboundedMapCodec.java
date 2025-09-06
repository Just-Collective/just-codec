package com.just.codec.impl;

import org.jetbrains.annotations.NotNull;

import com.just.codec.BaseMapCodec;
import com.just.codec.Codec;

public record UnboundedMapCodec<K, V>(
    Codec<K> keyCodec,
    Codec<V> valueCodec
) implements BaseMapCodec<K, V> {

    @Override
    public @NotNull String toString() {
        return "UnboundedMapCodec[" + keyCodec + " -> " + valueCodec + ']';
    }
}
