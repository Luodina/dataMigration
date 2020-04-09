package com.example.demo.controller;

// import com.example.demo.entity.Assessment;
// import com.example.demo.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/assessment")
public class AssessmentController {
    // @Autowired
    // AssessmentService assessmentService;

    // @RequestMapping(value = "/all", method = RequestMethod.GET)
    // public List<Assessment> getAllAssessments() {
    //     return this.assessmentService.xxx();
    // }

    // @RequestMapping(value = "/addassessment", method = RequestMethod.POST,
    //         consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    // public Assessment addAssessment(@RequestBody Assessment assessment) {
    //     return this.assessmentService.addAssessment(assessment);
    // }


    // @RequestMapping(value = "/updateassessment", method = RequestMethod.PUT,
    //         consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    // public Assessment updateAssessment(@RequestBody Assessment assessment) {
    //     return this.assessmentService.updateAssessment(assessment);
    // }

    // @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    // public Optional<Assessment> getAssessment(@PathVariable int id) {
    //     return this.assessmentService.getAssessmentById(id);
    // }

    // @RequestMapping(value = "/all", method = RequestMethod.DELETE)
    // public void deleteAllAssessments() {
    //     this.assessmentService.deleteAllAssessments();
    // }

    // @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    // public void deleteUser(@PathVariable int id) {
    //     this.assessmentService.deleteAssessmentById(id);
    // }

    // @Autowired
    // MessageSource messageSource;

    // @RequestMapping(value = "/get-greeting", method = RequestMethod.GET)
    // public String greeting() {
    //     /**
    //      *   @LocaleContextHolder.getLocale()
    //      *  Return the Locale associated with the given user context,if any, or the system default Locale otherwise.
    //      *  This is effectively a replacement for Locale.getDefault(), able to optionally respect a user-level Locale setting.
    //      */

    //     return messageSource.getMessage("good.morning", null, LocaleContextHolder.getLocale());
    // }


    // @RequestMapping(value = "/get-greeting-name", method = RequestMethod.GET)
    // public String greetingWithName() {
    //     String[] params = new String[]{"Ikhiloya", "today"};
    //     return messageSource.getMessage("good.morning.name", params, LocaleContextHolder.getLocale());
    // }


}