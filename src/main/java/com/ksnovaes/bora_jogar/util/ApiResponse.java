package com.ksnovaes.bora_jogar.util;

public record ApiResponse<T>(
        String message,
        T data
) {
}
