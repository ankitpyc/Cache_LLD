package src.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import src.rest.service.CacheService;

@RestController("/cache")
public class CacheController {

    @Autowired
    CacheService cacheService;

    @PostMapping
    public ResponseEntity putToCache() {

        return null;
    }

    @PostMapping
    public ResponseEntity<String> getKeyFromCache() {

        return null;
    }


}
