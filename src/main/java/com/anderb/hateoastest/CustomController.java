package com.anderb.hateoastest;

import com.anderb.hateoastest.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class CustomController {

    @GetMapping(path = "api/str01")
    public ResponseEntity<Resource> getStr01(@RequestParam() String name) {
        Resource resource = new Resource(new Report(null, name, null));
        String uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
        resource.add(new Link(uri, "self"));

        log.info("URI: {}", uri);
        log.info("Name: {}", name);
        return ResponseEntity.ok(resource);
    }

    @GetMapping(path = "api/str02")
    public ResponseEntity<Resources<Resource>> getStr02() {
        String uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
        List<Resource> list = new ArrayList<>();
        Resource resource1 = new Resource(new Report(null, "name1", null));
        resource1.add(new Link(uri+"/name1?longitude,latitude", "report"));
        Resource resource2 = new Resource(new Report(null, "name2", null));
        resource2.add(new Link(uri+"/name2?longitude,latitude", "report"));
        Resource resource3 = new Resource(new Report(null, "name3", null));
        resource3.add(new Link(uri+"/name3?longitude,latitude", "report"));
        list.add(resource1);
        list.add(resource2);
        list.add(resource3);
        final Resources <Resource> reports = new Resources<>(list);

        log.info("URI: {}", uri);
        log.info("Report: {}", resource3.getLink("report"));
        log.info("Report links: {}", resource3.getLinks());
        ResponseEntity.ok();
        return ResponseEntity.ok(reports);
    }

//    @GetMapping(path = "api/str02")
//    public Resource02 getStr02() {
//        Resource02 resource02 = new Resource02();
//        resource02.setName02("Name02");
//        resource02.setUrl02("URL02");
//        return resource02;
//    }
//
//    @GetMapping(path = "api/str03")
//    public Resource03 getStr03() {
//        Resource03 resource03 = new Resource03();
//        resource03.setIdLong(2L);
//        return resource03;
//    }

    @GetMapping(path = "api/str04")
    public String getStr04() {
        return "str04";
    }

    @GetMapping(path = "api")
    public String get() {
        return "root";
    }
}