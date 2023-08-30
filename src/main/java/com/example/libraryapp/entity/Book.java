package com.example.libraryapp.entity;

import lombok.*;


import javax.persistence.*;
@Data
@Entity
@Table(name = "book")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {
 @Id
 String isbn;
 String title;
 String author;
 String type;
 int rating;
 int copies;
 String coverImage;

}
