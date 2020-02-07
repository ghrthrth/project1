package com.multiplyservice.com.controller;

import com.multiplyservice.com.model.Response;
import com.multiplyservice.com.service.ResponseService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/responses/")
public class ResponseController {

    private final ResponseService responseService;

    public ResponseController(ResponseService responseService) {
        this.responseService = responseService;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Response> getResponse(@PathVariable("id") Long responseId) {
        if (responseId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Response response = this.responseService.getById(responseId);

        if (response == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Response> saveResponse(@RequestBody @Valid Response response) {
        HttpHeaders headers = new HttpHeaders();

        if (response == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.responseService.save(response);
        return new ResponseEntity<>(response, headers, HttpStatus.CREATED);


    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Response> deleteResponse(@PathVariable("id") Long id) {
        Response response = this.responseService.getById(id);

        if (response == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.responseService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/getall", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Response>> getAllResponses() {
        List<Response> responses = this.responseService.getAll();

        if (responses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(responses, HttpStatus.OK);
    }
}
