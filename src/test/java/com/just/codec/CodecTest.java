package com.just.codec;

import com.just.codec.impl.Codecs;
import com.just.codec.impl.ListCodec;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class CodecTest {

    @Test
    void asList_Success() {
        // Arrange
        var codec = Codecs.INT;

        // Act
        var resultListCodec = codec.asList();

        // Assert
        assertInstanceOf(ListCodec.class, resultListCodec);
    }
}
