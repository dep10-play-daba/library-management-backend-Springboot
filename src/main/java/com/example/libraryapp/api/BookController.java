package com.example.libraryapp.api;

import com.example.libraryapp.AppConfiguration;
import com.example.libraryapp.business.BookBAO;
import com.example.libraryapp.business.custom.BookBO;
import com.example.libraryapp.business.util.Transformer;
import com.example.libraryapp.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/library")
public class BookController {

    @Value("${upload.images.directory}")
    private Resource uploadImagesDirectory;
    private final ResourcePatternResolver resourcePatternResolver;
    private final BookBAO bookBAO;

    public BookController( ResourcePatternResolver resourcePatternResolver, BookBAO bookBAO) {
        this.resourcePatternResolver = resourcePatternResolver;
        this.bookBAO = bookBAO;
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping
    public List<BookDTO> getAllBooks(@RequestParam(value = "q",required = false) String query) throws Exception {
        if(query==null)query="";
       return bookBAO.getAllBooks(query);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/save",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void SaveBook(@RequestPart("image") MultipartFile imageFile, @RequestPart("Book") BookDTO book, UriComponentsBuilder urlBuilder) throws Exception {
        BookDTO myBook=book;
        System.out.println(myBook.getIsbn());
        System.out.println(imageFile.toString()+book);

        String originalFilename = imageFile.getOriginalFilename();
        String uniqueFileName = generateUniqueFileName(originalFilename);

        Path destinationPath = Paths.get(uploadImagesDirectory.getURI()).resolve(uniqueFileName);
        Files.copy(imageFile.getInputStream(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
        UriComponentsBuilder cloneBuilder=urlBuilder.cloneBuilder();
        String imageUrl=cloneBuilder.pathSegment("images",imageFile.getOriginalFilename()).toUriString();
        System.out.println(imageUrl);
        myBook.setCoverImage(imageUrl);
        System.out.println(myBook);
        BookDTO bookDTO = bookBAO.saveBook(myBook);

    }

    private String generateUniqueFileName(String originalFilename) {
        String timestamp = String.valueOf(System.currentTimeMillis());
        return originalFilename;
    }
}
