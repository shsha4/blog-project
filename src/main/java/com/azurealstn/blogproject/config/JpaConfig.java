package com.azurealstn.blogproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing /* BaseTimeEntity 읽기 위해 추가 */
public class JpaConfig {
}
