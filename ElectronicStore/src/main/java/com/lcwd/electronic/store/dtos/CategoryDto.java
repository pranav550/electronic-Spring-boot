package com.lcwd.electronic.store.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    private String categoryId;
    @NotBlank(message = "Title is required")
    @Size(min = 4, message = "title must be 4 characters !!")
    private String title;
    @NotBlank(message = "Description is required !!")
    private String description;

    @NotBlank(message = "Cover Image is required")
    private String coverImage;

}
