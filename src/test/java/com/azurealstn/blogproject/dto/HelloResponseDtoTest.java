package com.azurealstn.blogproject.dto;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class HelloResponseDtoTest {

    @Test
    void 롬복_기능_테스트() {
        //given
        String name = "minjun";
        String nickname = "minpark";

        //when
        HelloResponseDto helloResponseDto = new HelloResponseDto(name, nickname);

        //then
        assertThat(helloResponseDto.getName()).isEqualTo(name);
        assertThat(helloResponseDto.getNickname()).isEqualTo(nickname);
    }
}