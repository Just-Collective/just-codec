package com.just.codec;

import com.just.codec.schema.CodecSchema;

import java.util.function.Function;

public interface Encoder<A> {

    <T> T encode(CodecSchema<T> codecSchema, A value);

    default <B> Encoder<B> contraMap(Function<? super B, ? extends A> function) {
        return new Encoder<>() {

            @Override
            public <T> T encode(CodecSchema<T> codecSchema, B input) {
                return Encoder.this.encode(codecSchema, function.apply(input));
            }

            @Override
            public String toString() {
                return Encoder.this + "[contraMapped]";
            }
        };
    }
}
