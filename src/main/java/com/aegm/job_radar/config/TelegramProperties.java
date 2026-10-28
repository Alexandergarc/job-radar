package com.aegm.job_radar.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotBlank;

@Validated 
@ConfigurationProperties(prefix = "telegram")
public record TelegramProperties(@NotBlank String botToken) {}
