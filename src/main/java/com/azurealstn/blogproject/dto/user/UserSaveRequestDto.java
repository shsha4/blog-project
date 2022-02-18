package com.azurealstn.blogproject.dto.user;

import com.azurealstn.blogproject.domain.user.Role;
import com.azurealstn.blogproject.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserSaveRequestDto {
    private String username;
    private String password;
    private String email;
    private String nickname;
    private Role role;

    /**
     *  Dto 객체 -> Entity 변환
     * */
    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .nickname(nickname)
                .role(role)
                .build();
    }
}
