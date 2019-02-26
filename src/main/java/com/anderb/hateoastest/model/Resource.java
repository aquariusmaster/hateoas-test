package com.anderb.hateoastest.model;

import com.anderb.hateoastest.CustomController;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Getter
public class Resource extends ResourceSupport {
    private Report report;

    public Resource(Report report) {
        this.report = report;
        final String id = report.getName();
//        add(linkTo(CustomController.class).withRel("report"));
//        add(linkTo(methodOn(CustomController.class).get(id)).withSelfRel());
    }
}
