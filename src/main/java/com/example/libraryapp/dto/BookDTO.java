package com.example.libraryapp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
   @NotNull
   @Min(8)
   @Pattern(regexp = "^[0,9]{3}-[0,9]{2}-([0,9]|[0,9]{2})$")
   private String isbn;
   @NotNull
   @Min(5)
   private String title;
   @NotNull
   @Min(3)
   @Pattern(regexp = "^[A-Za-z]+[\\-]*[A-Za-z]+$")
   private String author;
   @NotNull
   @Min(3)
   private String type;
   @Min(0)
   @Max(10)
   private int rating;
   private int copies;
   private String coverImage;
}
