package com.azurealstn.blogproject.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass /* BaseEntity */
@EntityListeners(AuditingEntityListener.class) /* JpaConfig -> @EnableJpaAuditing 현재 클래스 스캔 */
public abstract class BaseTimeEntity {
    /* 직접적인 Entity 가 아니고 자식 클래스의 매핑 정보만 제공하기 때문에 추상 클래스 권장 */

    @CreatedDate // 생성 날짜
    private LocalDateTime createdDate;

    @LastModifiedDate // 수정 날짜
    private LocalDateTime modifiedDate;

}
