package com.bauzillab.library.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateBookRequest(
        @NotBlank @Size(max = 180) String title,
        @NotBlank @Size(max = 120) String author,
        @Size(max = 20) String isbn
) {
}
