package com.just.codec;

import com.just.codec.schema.CodecSchema;
import com.just.core.functional.result.Result;

import java.util.function.Function;

public interface Decoder<A> {

    <T> Result<A, T> decode(CodecSchema<T> codecSchema, T input);

    default <B> Decoder<B> map(Function<? super A, ? extends B> function) {
        return new Decoder<>() {

            @Override
            public <T> Result<B, T> decode(CodecSchema<T> codecSchema, T input) {
                return Decoder.this.decode(codecSchema, input).map(function);
            }

            @Override
            public String toString() {
                return Decoder.this + "[mapped]";
            }
        };
    }

    default <B> Decoder<B> flatMap(Function<? super A, ? extends B> function) {
        return new Decoder<>() {

            @Override
            public <T> Result<B, T> decode(CodecSchema<T> codecSchema, T input) {
                return Decoder.this.decode(codecSchema, input)
                    .andThen(a -> Result.ok(function.apply(a)));
            }

            @Override
            public String toString() {
                return Decoder.this + "[flatMapped]";
            }
        };
    }
}
